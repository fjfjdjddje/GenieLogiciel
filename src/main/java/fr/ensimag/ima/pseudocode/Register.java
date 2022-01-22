package fr.ensimag.ima.pseudocode;

import java.util.ArrayList;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.POP;
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
    private Boolean isPushed = false;
    public static ArrayList<Integer> listPush= new ArrayList<Integer>();
    protected Register(String name) {
        this.name = name;
    }


    public static void pushAll(DecacCompiler compiler){
        int maxRegister = compiler.getCompilerOptions().getNombreRegisters() -1;
        for (int i = 2; i <= maxRegister; i++) {
            if(R[i].getIsFull()){
                compiler.addInstruction(new PUSH(R[i]));
                listPush.add(i);
                R[i].setIsFull(false);
            }
        }
    }
    public static void popALL(DecacCompiler compiler){
        for(int e= listPush.size(); e>0 ;e--){
            R[listPush.get(e)].setIsFull(true);
            compiler.addInstruction(new POP(R[listPush.get(e-1)]));
        }
        listPush= new ArrayList<Integer>();
    }
    public Boolean getIsPushed() {
        return isPushed;
    }



    public void setIsPushed(Boolean isPushed) {
        this.isPushed = isPushed;
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
        int maxRegister = compiler.getCompilerOptions().getNombreRegisters() -1;
        for (int i = 2; i <= maxRegister; i++) {
            if(!R[i].getIsFull()){
                return i;
            }
        }
        R[maxRegister].setIsPushed(true);
        compiler.addInstruction(new PUSH(R[maxRegister]));
        return maxRegister;
    }
}
