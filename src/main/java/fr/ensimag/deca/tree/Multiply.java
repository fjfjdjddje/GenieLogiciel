package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.MUL;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Multiply extends AbstractOpArith {
    public Multiply(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    @Override
    public int genCodeOperation(DecacCompiler compiler) {
        super.getLeftOperand().codeGenPrint(compiler);
        super.getRightOperand().codeGenPrint(compiler);
        int reg1= Register.getEmptyReg();
        Register.getR(reg1).setIsFull(true);
        int reg2= Register.getEmptyReg();
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new MUL(Register.getR(reg2), Register.getR(reg1)));
        Register.getR(reg2).setIsFull(false);
        if (super.getLeftOperand() instanceof FloatLiteral){
            compiler.addInstruction(new WFLOAT());
        }else{
            compiler.addInstruction(new WINT());
        } 
        return reg1;  
    } 

    @Override
    protected String getOperatorName() {
        return "*";
    }

}
