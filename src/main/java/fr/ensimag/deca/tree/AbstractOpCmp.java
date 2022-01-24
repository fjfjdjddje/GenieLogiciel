package fr.ensimag.deca.tree;

import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.BooleanType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public abstract class AbstractOpCmp extends AbstractBinaryExpr implements Condition{

    public AbstractOpCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type typeLeftOperand =  super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type typeRightOperand =  super.getRightOperand().verifyExpr(compiler, localEnv, currentClass);
        if(typeLeftOperand.isVoid()){
            throw new ContextualError("Void not supported for comparison operation.", super.getLeftOperand().getLocation());
        } else if(typeRightOperand.isVoid()){
            throw new ContextualError("Void not supported for comparison operation.", super.getRightOperand().getLocation());
        } 
        if(this instanceof AbstractOpExactCmp){
          if(!typeLeftOperand.sameType(typeRightOperand)){
            if(!((typeLeftOperand.isInt() && typeRightOperand.isFloat()) || (typeLeftOperand.isFloat() && typeRightOperand.isInt()))){
                throw new ContextualError("Cannot compare a "+typeLeftOperand.getName().getName()+ " and a "+ typeRightOperand.getName().getName(), this.getLocation());
            }else{
                if(typeLeftOperand.isInt()){
                    setLeftOperand(new ConvFloat(super.getLeftOperand()));
                }else{
                    setRightOperand(new ConvFloat(super.getRightOperand()));
                }
            }
        }
        }
        else{
            if(typeLeftOperand.isString()){
                throw new ContextualError("String not supported for inequality operations", super.getLeftOperand().getLocation());
            } else if(typeRightOperand.isString()){
                throw new ContextualError("String not supported for inequality operations", super.getRightOperand().getLocation());
            } else if(typeLeftOperand.isBoolean()){
                throw new ContextualError("Booleans not supported for inequality operations", super.getLeftOperand().getLocation());
            } else if(typeRightOperand.isBoolean()){
                throw new ContextualError("Booleans not supported for inequality operations", super.getRightOperand().getLocation());
            } else{
                if(typeLeftOperand.isFloat() && typeRightOperand.isInt()){
                    setRightOperand(new ConvFloat(super.getRightOperand()));
                } else if(typeLeftOperand.isInt() && typeRightOperand.isFloat()){
                    setLeftOperand(new ConvFloat(super.getLeftOperand()));
                }
            } 
        }
        Type t= new BooleanType(DecaParser.tableSymb.create("boolean"));
        this.setType(t);
        return t;
}


}
