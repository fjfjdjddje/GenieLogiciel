package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.SUB;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.OPP;
import fr.ensimag.ima.pseudocode.instructions.POP;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class UnaryMinus extends AbstractUnaryExpr {

    public UnaryMinus(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        Type operandType=super.getOperand().verifyExpr(compiler, localEnv, currentClass);
        if(!operandType.isFloat() && !(operandType.isInt())){
            throw new ContextualError(operandType.getName().getName()+" not supported for UnaryMinus.", getLocation());
        }else{
            this.setType(operandType);
            return operandType;
        }
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }

    @Override
        public int codeGenExpr(DecacCompiler compiler) {
            int reg1 = super.getOperand().codeGenExpr(compiler);
            if(super.getOperand() instanceof Selection){
                compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(reg1)), Register.getR(reg1)));   
            }
            Register.getR(reg1).setIsFull(true);
            compiler.addInstruction(new OPP(Register.getR(reg1),Register.getR(reg1)));
            return reg1;
        }   

}
