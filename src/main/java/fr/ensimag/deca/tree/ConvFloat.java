package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.ima.pseudocode.instructions.FLOAT;


/**
 * Conversion of an int into a float. Used for implicit conversions.
 * 
 * @author gl46
 * @date 01/01/2022
 */
public class ConvFloat extends AbstractUnaryExpr {
    public ConvFloat(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        return super.getOperand().verifyExpr(compiler, localEnv, currentClass);
        
    }


    @Override
    protected String getOperatorName() {
        return "/* conv float */";
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg1 = super.getOperand().codeGenExpr(compiler);
        Register.getR(reg1).setIsFull(true);
        int reg2 = Register.getEmptyReg(compiler);
        Register.getR(reg2).setIsFull(true);
        compiler.addInstruction(new FLOAT(Register.getR(reg1),Register.getR(reg2)));
        Register.getR(reg1).setIsFull(false);
        return reg2;
    }

}
