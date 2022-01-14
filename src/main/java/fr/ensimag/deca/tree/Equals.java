package fr.ensimag.deca.tree;
import fr.ensimag.ima.pseudocode.instructions.SEQ;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.SUB;
import fr.ensimag.ima.pseudocode.Label;

import fr.ensimag.deca.DecacCompiler;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */


public class Equals extends AbstractOpExactCmp {

    public Equals(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "==";
    }


    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        compiler.addInstruction(new SEQ(Register.getR(reg2)));
        Register.getR(reg1).setIsFull(false);
        return reg2;
    } 
    public int codeGenCond(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
        int reg3 = Register.getEmptyReg();
        Register.getR(reg3).setIsFull(true);
        compiler.addInstruction(new LOAD(new ImmediateInteger(1), Register.getR(reg3)));
        compiler.addInstruction(new BEQ(new Label("Egal")));
        compiler.addInstruction(new SUB(new ImmediateInteger(1), Register.getR(reg3)));
        compiler.addLabel(new Label("Egal"));
        Register.getR(reg2).setIsFull(false);
        Register.getR(reg1).setIsFull(false);
        return reg3;
    }   
    
}
