package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.ParamDefinition;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Operand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;

import java.io.PrintStream;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.log4j.Logger;

/**
 * Deca Identifier
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Identifier extends AbstractIdentifier implements Condition {
    @Override
    protected void checkDecoration() {
        if (getDefinition() == null) {
            //throw new DecacInternalError("Identifier " + this.getName() + " has no attached Definition");
        }
    }
    
    @Override
    public Definition getDefinition() {
        return definition;
    }

    /**
     * Like {@link #getDefinition()}, but works only if the definition is a
     * ClassDefinition.
     * 
     * This method essentially performs a cast, but throws an explicit exception
     * when the cast fails.
     * 
     * @throws DecacInternalError
     *             if the definition is not a class definition.
     */
    @Override
    public ClassDefinition getClassDefinition() {
        try {
            return (ClassDefinition) definition;
        } catch (ClassCastException e) {
            throw new DecacInternalError(
                    "Identifier "
                            + getName()
                            + " is not a class identifier, you can't call getClassDefinition on it");
        }
    }

    /**
     * Like {@link #getDefinition()}, but works only if the definition is a
     * MethodDefinition.
     * 
     * This method essentially performs a cast, but throws an explicit exception
     * when the cast fails.
     * 
     * @throws DecacInternalError
     *             if the definition is not a method definition.
     */
    @Override
    public MethodDefinition getMethodDefinition() {
        try {
            return (MethodDefinition) definition;
        } catch (ClassCastException e) {
            throw new DecacInternalError(
                    "Identifier "
                            + getName()
                            + " is not a method identifier, you can't call getMethodDefinition on it");
        }
    }

    /**
     * Like {@link #getDefinition()}, but works only if the definition is a
     * FieldDefinition.
     * 
     * This method essentially performs a cast, but throws an explicit exception
     * when the cast fails.
     * 
     * @throws DecacInternalError
     *             if the definition is not a field definition.
     */
    @Override
    public FieldDefinition getFieldDefinition() {
        try {
            return (FieldDefinition) definition;
        } catch (ClassCastException e) {
            throw new DecacInternalError(
                    "Identifier "
                            + getName()
                            + " is not a field identifier, you can't call getFieldDefinition on it");
        }
    }

    /**
     * Like {@link #getDefinition()}, but works only if the definition is a
     * VariableDefinition.
     * 
     * This method essentially performs a cast, but throws an explicit exception
     * when the cast fails.
     * 
     * @throws DecacInternalError
     *             if the definition is not a field definition.
     */
    @Override
    public VariableDefinition getVariableDefinition() {
        try {
            return (VariableDefinition) definition;
        } catch (ClassCastException e) {
            throw new DecacInternalError(
                    "Identifier "
                            + getName()
                            + " is not a variable identifier, you can't call getVariableDefinition on it");
        }
    }

    /**
     * Like {@link #getDefinition()}, but works only if the definition is a ExpDefinition.
     * 
     * This method essentially performs a cast, but throws an explicit exception
     * when the cast fails.
     * 
     * @throws DecacInternalError
     *             if the definition is not a field definition.
     */
    @Override
    public ExpDefinition getExpDefinition() {
        try {
            return (ExpDefinition) definition;
        } catch (ClassCastException e) {
            throw new DecacInternalError(
                    "Identifier "
                            + getName()
                            + " is not a Exp identifier, you can't call getExpDefinition on it");
        }
    }

    @Override
    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public Symbol getName() {
        return name;
    }

    private Symbol name;

    public Identifier(Symbol name) {
        Validate.notNull(name);
        this.name = name;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        if(localEnv.get(this.name) == null){
            throw new ContextualError(this.name.getName()+" used but not declared.", this.getLocation());
        }else{
            this.setType(localEnv.get(this.name).getType());
            this.setDefinition(localEnv.get(this.name));
            //EnvironmentExp courant = localEnv;
            /*System.out.println("==============================");
            while(courant != null){
                System.out.println("zbiiiiiiii123"+localEnv.get(this.name)+"dee : "+this.name.getName());
                courant = courant.getParentEnvironment();
            }
            System.out.println("===============================");*/
            return localEnv.get(this.name).getType();
        }
        
    }

    /**
     * Implements non-terminal "type" of [SyntaxeContextuelle] in the 3 passes
     * @param compiler contains "env_types" attribute
     */
    @Override
    public Type verifyType(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        if(!(compiler.getEnvTypes().getCurrentEnvironment().containsKey(this.getName()))){
            throw new ContextualError("Inexisting type.", this.getLocation());
        }else{
            Type type=compiler.getEnvTypes().getCurrentEnvironment().get(this.getName()).getType();
            this.setType(type);
            this.setDefinition(compiler.getEnvTypes().getCurrentEnvironment().get(this.getName()));           
        }
        return this.getType();
    }
    
    
    private Definition definition;


    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print(name.toString());
    }

    @Override
    String prettyPrintNode() {
        return "Identifier (" + getName() + ")";
    }

    @Override
    protected void prettyPrintType(PrintStream s, String prefix) {
        Definition d = getDefinition();
        if (d != null) {
            s.print(prefix);
            s.print("definition: ");
            s.print(d);
            s.println();
        }
    }

   /* @Override
    public int codeGenPrint(DecacCompiler compiler) {
        int reg = Register.getEmptyReg();
        compiler.addInstruction(new LOAD(this.getExpDefinition().getOperand(), Register.getR(reg)));
        return reg;
        //return ((RegisterOffset)((AbstractIdentifier)this).getExpDefinition().getOperand()).getOffset();
    }
    public Operand codeGenOperation1(DecacCompiler compiler) {

        return int;
    }*/
    public  void codeGenCond(DecacCompiler compiler, Label lab2){
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg = Register.getEmptyReg(compiler);
        Register.getR(reg).setIsFull(true);
        if(this.getDefinition().isField()){
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(0)));
            compiler.addInstruction(new LOAD(new RegisterOffset(this.getFieldDefinition().getIndex(), Register.R0), Register.getR(reg)));
            }
        else if(this.getDefinition().isParam()){
            int offs = ((ParamDefinition)this.getDefinition()).getParamOrder();
            compiler.addInstruction(new LOAD(new RegisterOffset(-2- offs, Register.LB), Register.getR(reg)));
        }
        else{
            compiler.addInstruction(new LOAD(this.getExpDefinition().getOperand(), Register.getR(reg)));
        }
        
        return reg;
    }
}
