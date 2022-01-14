package fr.ensimag.ima.pseudocode;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.PUSH;

/**
 * Register operand (including special registers like SP).
 * 
 * @author Ensimag
 * @date 01/01/2022
 */
public class Register extends DVal {
    private String name;
    private Boolean isFull = false;
    private int nbrPushed = 0;
    public static int regToPush = 2;

    protected Register(String name) {
        this.name = name;
    }

    public int getNbrPushed() {
        return nbrPushed;
    }

    public void setNbrPushed(int nbrPushed) {
        this.nbrPushed = nbrPushed;
    }



    @Override
    public String toString() {
        return name;
    }
    public Boolean getIsFull() {
        return isFull;
    }
    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }
    /**
     * Global Base register
     */
    public static final Register GB = new Register("GB");
    /**
     * Local Base register
     */
    public static final Register LB = new Register("LB");
    /**
     * Stack Pointer
     */
    public static final Register SP = new Register("SP");
    /**
     * General Purpose Registers. Array is private because Java arrays cannot be
     * made immutable, use getR(i) to access it.
     */
    private static final GPRegister[] R = initRegisters();
    /**
     * General Purpose Registers
     */
    public static GPRegister getR(int i) {
        return R[i];
    }
    /**
     * Convenience shortcut for R[0]
     */
    public static final GPRegister R0 = R[0];
    /**
     * Convenience shortcut for R[1]
     */
    public static final GPRegister R1 = R[1];
    static private GPRegister[] initRegisters() {
        GPRegister [] res = new GPRegister[16];
        for (int i = 0; i <= 15; i++) {
            res[i] = new GPRegister("R" + i, i);
        }
        return res;
    }
    public static int getEmptyReg(DecacCompiler compiler){
        for (int i = 2; i <= 5; i++) {
            if(!R[i].getIsFull()){
                return i;
            }
        }
        compiler.addInstruction(new PUSH(R[regToPush]));
        R[regToPush].setNbrPushed(R[regToPush].getNbrPushed()+1);
        int res  = regToPush;
        regToPush++;
        if (regToPush == 6){regToPush =2;}
        return res;   
    }
}
