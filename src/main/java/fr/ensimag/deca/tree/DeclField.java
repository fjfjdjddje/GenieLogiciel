package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Operand;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import java.io.PrintStream;
import java.util.Properties;


import org.apache.commons.lang.Validate;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class DeclField extends AbstractDeclField {

    final private AbstractIdentifier type;
    final private AbstractIdentifier fieldName;
    final private AbstractInitialization initialization;
    final private Visibility visibility;

    public DeclField(Visibility visibility, AbstractIdentifier type, AbstractIdentifier fieldName, AbstractInitialization initialization) {
        /*Validate.notNull(type);
        Validate.notNull(fieldName);
        Validate.notNull(initialization);*/
        this.type = type;
        this.fieldName = fieldName;
        this.initialization = initialization;
        this.visibility = visibility;
    }
    @Override
        String printNodeLine(PrintStream s, String prefix, boolean last,
            boolean inlist, String nodeName) {
        s.print(prefix);
        if (inlist) {
            s.print("[]>");
        } else if (last) {
            s.print("`>");
        } else {
            s.print("+>");
        }
        if (getLocation() != null) {
            s.print(" " + getLocation().toString());
        }
        s.print(" ");
        if(this.visibility == Visibility.PROTECTED){
            s.print("[visibility=PROTECTED] ");
        }else{
            s.print("[visibility=PUBLIC] ");
        }
        s.print(nodeName);
        s.println();
        String newPrefix;
        if (last) {
            if (inlist) {
                newPrefix = prefix + "    ";
            } else {
                newPrefix = prefix + "   ";
            }
        } else {
            if (inlist) {
                newPrefix = prefix + "||  ";
            } else {
                newPrefix = prefix + "|  ";
            }
        }
        prettyPrintType(s, newPrefix);
        return newPrefix;
    }
    @Override
    protected void verifyDeclField(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        this.type.verifyType(compiler);
        if(this.type.getType().isVoid()){
            throw new ContextualError("Void cannot be declared as a Class field.", this.type.getLocation());
        }
        if(this.type.getType().isString()){
            throw new ContextualError("String cannot be declared as a Class field.", this.type.getLocation());
        }
        if(localEnv.getCurrentEnvironment().containsKey(fieldName.getName())){
            throw new ContextualError("Field "+fieldName.getName().getName()+" already declared.", fieldName.getLocation());
        }
        try{
            Definition def= new FieldDefinition(this.type.getType(),this.fieldName.getLocation(),this.visibility,currentClass,currentClass.getNumberOfFields()+1);
            this.fieldName.setDefinition(def);
            this.fieldName.setType(this.type.getType());
            localEnv.getCurrentEnvironment().put(fieldName.getName(),fieldName.getExpDefinition());
        }catch (Exception e){
           System.out.println("Error in the declaration of the variable in the environement.");
        }
        this.initialization.verifyInitialization(compiler, this.type.getType(), localEnv, currentClass);

    }
    @Override
    public void codeGenDeclField(DecacCompiler compiler){
        int regIntia = this.initialization.codeGenIntialisation(compiler);
        if (regIntia != 0){
            //compiler.addInstruction(new STORE(Register.getR(regIntia), varName.getExpDefinition().getOperand()));}
        }else{
                if(type.getType().isFloat()){
                    compiler.addInstruction(new LOAD(new ImmediateFloat((float)0.0), Register.R0));
                }else if(type.getType().isClass()){
                    compiler.addInstruction(new LOAD(new NullOperand(), Register.R0));
                }else{
                    compiler.addInstruction(new LOAD(0, Register.R0));
                }
                //compiler.addInstruction(new STORE(Register.getR(0), varName.getExpDefinition().getOperand()));
            }
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(1)));
        int offset = fieldName.getFieldDefinition().getIndex();
        compiler.addInstruction(new STORE(Register.getR(regIntia), new RegisterOffset(offset,Register.getR(1))));
        Register.getR(regIntia).setIsFull(false);
    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        /*throw new UnsupportedOperationException("not yet implemented");
        type.decompile(s);
        s.print(type.getName().getName());
        s.print(" ");
        s.print(fieldName.getName().getName());
        initialization.decompile(s);*/
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        fieldName.iter(f);
        initialization.iter(f);
        //v.i
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        fieldName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
        //print()
    }
}
