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
    public void genCodeOperation(DecacCompiler compiler) {
        super.getLeftOperand().codeGenPrint(compiler);
        super.getRightOperand().codeGenPrint(compiler);
        compiler.addInstruction(new MUL(Register.getR(2), Register.R1));
        if (super.getLeftOperand() instanceof FloatLiteral){
            compiler.addInstruction(new WFLOAT());
        }else{
            compiler.addInstruction(new WINT());
        }  
    } 

    @Override
    protected String getOperatorName() {
        return "*";
    }

}
