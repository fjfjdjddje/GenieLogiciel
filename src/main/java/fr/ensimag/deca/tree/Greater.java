package fr.ensimag.deca.tree;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.GT;
import fr.ensimag.ima.pseudocode.Register;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Greater extends AbstractOpIneq {

    public Greater(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return ">";
    }
    @Override
    public int genCodeOperation(DecacCompiler compiler){
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        compiler.addInstruction(new GT(Register.getR(reg2), Register.getR(reg1)));
        Register.getR(reg2).setIsFull(false);
        return reg1; 
    }
}
