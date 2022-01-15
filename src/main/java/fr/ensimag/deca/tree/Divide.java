package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.QUO;
import fr.ensimag.ima.pseudocode.instructions.DIV;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.Register;
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
        int reg3 = 0;
        while(reg2 == reg1){
            reg3 = Register.getEmptyReg(compiler);
            compiler.addInstruction(new LOAD(Register.getR(reg2),Register.getR(reg3)));
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            reg1 = reg3;
        }
        if(super.getLeftOperand().getType().isFloat()){
            compiler.addInstruction(new DIV(Register.getR(reg2), Register.getR(reg1)));
        }else{
            compiler.addInstruction(new QUO(Register.getR(reg2), Register.getR(reg1)));
        }
        if(Register.getR(reg2).getNbrPushed()!=0){
            compiler.addInstruction(new POP(Register.getR(reg2)));
            Register.getR(reg2).setNbrPushed(Register.getR(reg2).getNbrPushed()-1);
            }
            else{
                Register.getR(reg2).setIsFull(false);
            }
        return reg1; 
    }


    
}
