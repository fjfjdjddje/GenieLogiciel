package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.REM;
import fr.ensimag.ima.pseudocode.Register;
/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Modulo extends AbstractOpArith {

    public Modulo(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        //System.out.println("Modulo verify expr: begin");
        Type typeLeftOperande= super.getLeftOperand().verifyExpr(compiler, localEnv,currentClass);
        Type typeRightOperande= super.getRightOperand().verifyExpr(compiler,localEnv, currentClass);
       
        /*super.getLeftOperand().setType(typeLeftOperande);
        super.getRightOperand().setType(typeRightOperande);*/
        if(!typeLeftOperande.isInt() || !typeRightOperande.isInt()){
            throw new ContextualError("Only integers are allowed for modulo operation.", this.getLocation());
        } else {
            //System.out.println("Modulo verify expr: end");
            this.setType(typeLeftOperande);
            return typeLeftOperande;
        }
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getLeftOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = super.getRightOperand().codeGenExpr(compiler);  
        Register.getR(reg2).setIsFull(true);
        if(Register.getR(reg1).getIsPushed()){
            compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R1));
            if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.getR(reg1)));
                compiler.addInstruction(new CMP(Register.R1, Register.getR(reg1)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
            //compiler.addInstruction(new LOAD(Register.getR(reg1),Register.R0));
            compiler.addInstruction(new POP(Register.getR(reg1)));
            compiler.addInstruction(new REM(Register.R1,Register.getR(reg1)));
        }else{
            if(!compiler.getCompilerOptions().getNocheck()){
                compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.getR(1)));
                compiler.addInstruction(new CMP(Register.R1, Register.getR(reg2)));
                compiler.addInstruction(new BEQ(compiler.getLabelDivErreur()));
                }
            compiler.addInstruction(new REM(Register.getR(reg2),Register.getR(reg1)));
        }
        if(!Register.getR(reg2).getIsPushed()){
            Register.getR(reg2).setIsFull(false);}
        return reg1;
    }   

    @Override
    protected String getOperatorName() {
        return "%";
    }

}
