package fr.ensimag.deca.tree;
import fr.ensimag.ima.pseudocode.instructions.SLT;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BGE;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.deca.DecacCompiler;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Lower extends AbstractOpIneq {

    public Lower(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "<";
    }


    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        if(super.getLeftOperand() instanceof Selection){
            compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));
        } 
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        if(super.getRightOperand() instanceof Selection){
            compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg2)), Register.getR(reg2)));
        } 
        if(Register.getR(reg1).getIsPushed()){
            compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
            compiler.addInstruction(new POP(Register.getR(reg1)));
            compiler.addInstruction(new CMP(Register.getR(0), Register.getR(reg1)));
            compiler.addInstruction(new SLT(Register.getR(reg1)));
        }else{
            compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
            compiler.addInstruction(new SLT(Register.getR(reg1)));
        }
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        return reg1;
    }


    @Override
    public void codeGenCond(DecacCompiler compiler,Label lab2) {
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        if(super.getLeftOperand() instanceof Selection){
            compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));
        }
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        if(super.getRightOperand() instanceof Selection){
            compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg2)), Register.getR(reg2)));
        } 
        if(Register.getR(reg1).getIsPushed()){
            compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
            compiler.addInstruction(new POP(Register.getR(reg1)));
            compiler.addInstruction(new CMP(Register.getR(0), Register.getR(reg1)));
            /*compiler.addInstruction(new SLT(Register.getR(0)));
            compiler.addInstruction(new LOAD(new ImmediateInteger(0),Register.getR(reg1)));
            compiler.addInstruction(new CMP(Register.getR(reg1),Register.getR(0)));
            compiler.addInstruction(new BEQ(lab2));*/
            compiler.addInstruction(new BGE(lab2));

        }else{
            compiler.addInstruction(new CMP(Register.getR(reg2), Register.getR(reg1)));
            /*compiler.addInstruction(new SLT(Register.getR(reg2)));
            compiler.addInstruction(new LOAD(new ImmediateInteger(0),Register.getR(reg1)));
            compiler.addInstruction(new CMP(Register.getR(reg1),Register.getR(reg2)));*/
            compiler.addInstruction(new BGE(lab2));
        }     
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        if(!Register.getR(reg1).getIsPushed()){
            Register.getR(reg1).setIsFull(false);}  
    }
}
