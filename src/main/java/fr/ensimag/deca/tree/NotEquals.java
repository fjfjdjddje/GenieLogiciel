package fr.ensimag.deca.tree;
import fr.ensimag.ima.pseudocode.instructions.SNE;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.BEQ;


/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class NotEquals extends AbstractOpExactCmp {

    public NotEquals(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "!=";
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new SNE(Register.getR(reg2)));
        Register.getR(reg1).setIsFull(false);
        return reg2;
    }


    @Override
    public int codeGenCond(DecacCompiler compiler,Label lab2) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new SNE(Register.getR(reg2)));
        compiler.addInstruction(new LOAD(new ImmediateInteger(0),Register.getR(reg1)));
        compiler.addInstruction(new CMP(Register.getR(reg1),Register.getR(reg2)));
        compiler.addInstruction(new BEQ(lab2));
        Register.getR(reg1).setIsFull(false);
        Register.getR(reg2).setIsFull(false);
        return 0;
    }



    
}

