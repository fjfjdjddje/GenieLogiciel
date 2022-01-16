package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.ADD;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;




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


    //@Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenExpr(compiler);  
        Register.getR(reg2).setIsFull(true);
        if(Register.getR(reg1).getIsPushed()){
            compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
            compiler.addInstruction(new POP(Register.getR(reg1)));
            compiler.addInstruction(new ADD(Register.R0,Register.getR(reg1)));

        }else{
            compiler.addInstruction(new ADD(Register.getR(reg2),Register.getR(reg1)));
        }
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        return reg1;
    }    
}
