package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.SUB;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Minus extends AbstractOpArith {
    public Minus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenExpr(compiler);  
        Register.getR(reg2).setIsFull(true);
        if(Register.getR(reg1).getIsPushed()){
            
            compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R1));
            compiler.addInstruction(new POP(Register.getR(reg1)));
            if(super.getLeftOperand() instanceof Selection){
                compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(1)), Register.getR(1)));   
            }
            if(super.getRightOperand() instanceof Selection){
                compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
            }
            compiler.addInstruction(new SUB(Register.R1,Register.getR(reg1)));
        }else{
            if(super.getLeftOperand() instanceof Selection){
                compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
            }
            if(super.getRightOperand() instanceof Selection){
                compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg2)), Register.getR(reg2)));   
            }
        compiler.addInstruction(new SUB(Register.getR(reg2),Register.getR(reg1)));
        }
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        return reg1;
    }   
    @Override
    protected String getOperatorName() {
        return "-";
    }

}
