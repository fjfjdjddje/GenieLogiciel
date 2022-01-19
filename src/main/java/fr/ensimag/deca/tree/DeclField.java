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
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Operand;
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
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;
    final private Visibility v;

    public DeclField(Visibility v, AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        /*Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);*/
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
        this.v = v;
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
        if(this.v == Visibility.PROTECTED){
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
                /*this.type.verifyType(compiler);
                if(localEnv.getCurrentEnvironment().containsKey(varName.getName())){
                    throw new ContextualError("Variable "+varName.getName().getName()+" already declared.", varName.getLocation());
                }
                    try{
                        Definition def= new VariableDefinition(this.type.getType(),this.varName.getLocation());
                        def.isExpression();
                        this.varName.setDefinition(def);
                        this.varName.setType(this.type.getType());
        
                        RegisterOffset GB3 = new RegisterOffset(RegisterOffset.lastReg, Register.GB);
                        this.varName.getExpDefinition().setOperand(GB3);
                        RegisterOffset.lastReg ++;
                        //def.setOperand();
                        localEnv.declare(varName.getName(),varName.getExpDefinition());
                        //System.out.println(localEnv.getCurrentEnvironment());
                    }catch (Exception e){
                       System.out.println("Error in the declaration of the variable in the environement.");
                    }
                
                this.initialization.verifyInitialization(compiler, this.type.getType(), localEnv, currentClass);*/

    }
    @Override
    public void codeGenDeclField(DecacCompiler compiler){
        /*int regIntia = this.initialization.codeGenIntialisation(compiler);
        compiler.addInstruction(new STORE(Register.getR(regIntia), varName.getExpDefinition().getOperand()));
        Register.getR(regIntia).setIsFull(false);*/
    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        /*throw new UnsupportedOperationException("not yet implemented");
        type.decompile(s);
        s.print(type.getName().getName());
        s.print(" ");
        s.print(varName.getName().getName());
        initialization.decompile(s);*/
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        varName.iter(f);
        initialization.iter(f);
        //v.i
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
        //print()
    }
}
