package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.ADD;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Plus extends AbstractOpArith {
    public Plus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
 

    @Override
    protected String getOperatorName() {
        return "+";
    }
        @Override
    public void genCodeOperation(DecacCompiler compiler) {
        super.getLeftOperand().codeGenPrint(compiler);
        super.getRightOperand().codeGenPrint(compiler);
        compiler.addInstruction(new ADD(Register.getR(2), Register.R1));
        if (super.getLeftOperand() instanceof FloatLiteral){
            compiler.addInstruction(new WFLOAT());
        }else{
            compiler.addInstruction(new WINT());
        }  
    }  
}
