package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.SUB;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
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
            throw new ContextualError("Type not supported for UnaryMinus", getLocation());
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
            Register.getR(reg1).setIsFull(true);
            compiler.addInstruction(new LOAD(new ImmediateInteger(0),Register.R0));
            compiler.addInstruction(new SUB(Register.R0,Register.getR(reg1)));
            return reg1;
        }   

}
