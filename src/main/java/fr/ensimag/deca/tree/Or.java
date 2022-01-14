package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.ADD;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.SGE;
import fr.ensimag.ima.pseudocode.Register;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Or extends AbstractOpBool {

    public Or(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "||";
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenExpr(compiler);   
        Register.getR(reg2).setIsFull(true);
        int reg3 = Register.getEmptyReg();  
        Register.getR(reg3).setIsFull(true);
        compiler.addInstruction(new LOAD(new ImmediateInteger(1),Register.getR(reg3)));
        compiler.addInstruction(new ADD(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new CMP(Register.getR(reg3), Register.getR(reg1)));
        compiler.addInstruction(new SGE(Register.getR(reg1)));
        Register.getR(reg2).setIsFull(false);
        Register.getR(reg3).setIsFull(false);
        return reg1;
    }


}
