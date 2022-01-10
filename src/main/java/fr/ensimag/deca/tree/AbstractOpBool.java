package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public abstract class AbstractOpBool extends AbstractBinaryExpr {

    public AbstractOpBool(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        Type typeLeftOperand =  super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type typeRightOperand =  super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        if(typeLeftOperand.isVoid()){
            throw new ContextualError("Void not supported for boolean operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isFloat()){
            throw new ContextualError("Float not supported for boolean operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isClass()){
            throw new ContextualError("Class not supported for boolean operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isString()){
            throw new ContextualError("String not supported for boolean operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isInt()){
            throw new ContextualError("Int not supported for boolean operation", getLeftOperand().getLocation());
        } else if(typeRightOperand.isVoid()){
            throw new ContextualError("Void not supported for boolean operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isFloat()){
            throw new ContextualError("Boolean not supported for boolean operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isClass()){
            throw new ContextualError("Class not supported for boolean operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isString()){
            throw new ContextualError("String not supported for boolean operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isInt()){
            throw new ContextualError("Int not supported for boolean operation", getRightOperand().getLocation());
        } else{ 
            return typeLeftOperand;
        }
            
    }

}
