package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Register;
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
        int reg1 = super.getLeftOperand().codeGenPrint(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenPrint(compiler);   
        Register.getR(reg2).setIsFull(true);
        int reg3 = 0;
        while(reg2 == reg1){
            reg3 = Register.getEmptyReg(compiler);
            compiler.addInstruction(new LOAD(Register.getR(reg2),Register.getR(reg3)));
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            reg1 = reg3;
        }
        compiler.addInstruction(new SUB(Register.getR(reg2), Register.getR(reg1)));
        if(Register.getR(reg2).getNbrPushed()!=0){
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            }
        else{
                Register.getR(reg2).setIsFull(false);
            }
        return reg1; 
    } 
    @Override
    protected String getOperatorName() {
        return "-";
    }

}
