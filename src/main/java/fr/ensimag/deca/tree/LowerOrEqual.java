package fr.ensimag.deca.tree;
import fr.ensimag.ima.pseudocode.instructions.SLE;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class LowerOrEqual extends AbstractOpIneq {
    public LowerOrEqual(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "<=";
    }


    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        int reg3 = 0;
        while(reg2 == reg1){
            reg3 = Register.getEmptyReg(compiler);
            compiler.addInstruction(new LOAD(Register.getR(reg2),Register.getR(reg3)));
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            reg1 = reg3;
        }
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new SLE(Register.getR(reg1)));
        if(Register.getR(reg2).getNbrPushed()!=0){
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            }
        else{
                Register.getR(reg2).setIsFull(false);
            }
        return reg1;
    }


    @Override
    public int codeGenCond(DecacCompiler compiler,Label lab2) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        int reg3 = 0;
        while(reg2 == reg1){
            reg3 = Register.getEmptyReg(compiler);
            compiler.addInstruction(new LOAD(Register.getR(reg2),Register.getR(reg3)));
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            reg1 = reg3;
        }
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new SLE(Register.getR(reg2)));
        compiler.addInstruction(new LOAD(new ImmediateInteger(0),Register.getR(reg1)));
        compiler.addInstruction(new CMP(Register.getR(reg1),Register.getR(reg2)));
        compiler.addInstruction(new BEQ(lab2));
        if(Register.getR(reg2).getNbrPushed()!=0){
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            }
        else{
                Register.getR(reg2).setIsFull(false);
            }
        if(Register.getR(reg1).getNbrPushed()!=0){
                compiler.addInstruction(new POP(Register.getR(reg1)));
                Register.getR(reg1).setNbrPushed(Register.getR(reg1).getNbrPushed()-1);
                }
        else{
                    Register.getR(reg1).setIsFull(false);
                }
        return 0;
    } 

}
