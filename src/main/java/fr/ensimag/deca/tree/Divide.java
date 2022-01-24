package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.QUO;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.DIV;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Divide extends AbstractOpArith {
    public Divide(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "/";
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler){
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenExpr(compiler);   
        Register.getR(reg2).setIsFull(true);
        if(Register.getR(reg1).getIsPushed()){
            if(super.getLeftOperand().getType().isFloat()){
                compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
                if(super.getLeftOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(1)), Register.getR(1)));   
                }
                if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateFloat(0), Register.getR(reg1)));
                compiler.addInstruction(new CMP(Register.R0, Register.getR(reg1)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
                compiler.addInstruction(new POP(Register.getR(reg1)));
                if(super.getRightOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
                }
                compiler.addInstruction(new DIV(Register.getR(0), Register.getR(reg1)));
            }else{
                compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
                if(super.getLeftOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(1)), Register.getR(1)));   
                }
                if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.getR(reg1)));
                compiler.addInstruction(new CMP(Register.R0, Register.getR(reg1)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
                compiler.addInstruction(new POP(Register.getR(reg1)));
                if(super.getRightOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
                }
                compiler.addInstruction(new QUO(Register.getR(0), Register.getR(reg1)));
            }
        }else{
            if(super.getLeftOperand().getType().isFloat()){
                if(super.getLeftOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
                }
                if(super.getRightOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg2)), Register.getR(reg2)));   
                }
                if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateFloat(0), Register.getR(0)));
                compiler.addInstruction(new CMP(Register.R0, Register.getR(reg2)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
                compiler.addInstruction(new DIV(Register.getR(reg2), Register.getR(reg1)));
            }else{
                if(super.getLeftOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
                }
                if(super.getRightOperand() instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg2)), Register.getR(reg2)));   
                }
                if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.getR(0)));
                compiler.addInstruction(new CMP(Register.R0, Register.getR(reg2)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
                compiler.addInstruction(new QUO(Register.getR(reg2), Register.getR(reg1)));
            }
        }
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        return reg1; 
    }


    
}
