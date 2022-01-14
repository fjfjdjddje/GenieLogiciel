package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.*;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.Register;

/**
 * Arithmetic binary operations (+, -, /, ...)
 * 
 * @author gl46
 * @date 01/01/2022
 */
public abstract class AbstractOpArith extends AbstractBinaryExpr {

    public AbstractOpArith(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        System.out.println("VerifyExpr OpArith Begin:");
        Type typeLeftOperand =  super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type typeRightOperand =  super.getRightOperand().verifyExpr(compiler, localEnv, currentClass);
        if(typeLeftOperand.isVoid()){
            throw new ContextualError("Void not supported for arithmetic operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isBoolean()){
            throw new ContextualError("Boolean not supported for arithmetic operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isClass()){
            throw new ContextualError("Class not supported for arithmetic operation", getLeftOperand().getLocation());
        } else if(typeLeftOperand.isString()){
            throw new ContextualError("String not supported for arithmetic operation", getLeftOperand().getLocation());
        } else if(typeRightOperand.isVoid()){
            throw new ContextualError("Void not supported for arithmetic operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isBoolean()){
            throw new ContextualError("Boolean not supported for arithmetic operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isClass()){
            throw new ContextualError("Class not supported for arithmetic operation", getRightOperand().getLocation());
        } else if(typeRightOperand.isString()){
            throw new ContextualError("String not supported for arithmetic operation", getRightOperand().getLocation());
        } else {
            System.out.println("VerifyExpr OpArith End:");
            if(typeLeftOperand.isFloat() && typeRightOperand.isInt()){
                setRightOperand(new ConvFloat(super.getRightOperand()));
                Type t= new FloatType(DecaParser.tableSymb.create("float"));
                this.setType(t);
                return t;
            } else if(typeLeftOperand.isInt() && typeRightOperand.isFloat()){
                setLeftOperand(new ConvFloat(super.getLeftOperand()));
                Type t= new FloatType(DecaParser.tableSymb.create("float"));
                this.setType(t);
                return t;
            }else if(typeLeftOperand.isFloat() && typeRightOperand.isFloat()){
                Type t= new FloatType(DecaParser.tableSymb.create("float"));
                this.setType(t);
                return t;
            }else{
                Type t= new IntType(DecaParser.tableSymb.create("int"));
                this.setType(t);
                return t;
            }
        }   
    }
   
}
