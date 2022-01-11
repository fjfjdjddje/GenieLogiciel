package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Operand;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

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
            throw new ContextualError("Type not supported for UNaryMinus", getLocation());
        }else{
            return operandType;
        }
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }

}
