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
import fr.ensimag.deca.context.ParamDefinition;
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
public class DeclParam extends AbstractDeclParam {

    final private AbstractIdentifier type;
    final private AbstractIdentifier paramName;

    public AbstractIdentifier getType() {
        return type;
    }

    public DeclParam(AbstractIdentifier type, AbstractIdentifier paramName) {
        /*Validate.notNull(type);
        Validate.notNull(paramName);*/
        this.type = type;
        this.paramName = paramName;
    }

    @Override
    protected void verifyDeclParam(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        this.type.verifyType(compiler);
        if(localEnv.getCurrentEnvironment().containsKey(paramName.getName())){
            throw new ContextualError("parametre "+paramName.getName().getName()+" already mentionned.", paramName.getLocation());
        }
            Definition def= new ParamDefinition(this.type.getType(),this.paramName.getLocation());
            ((ParamDefinition)def).setParamOrder(ListDeclParam.order);
            this.paramName.setDefinition(def);
            this.paramName.setType(this.type.getType());  
            localEnv.getCurrentEnvironment().put(paramName.getName(),paramName.getExpDefinition());
    }
    @Override
    public void codeGenDeclParam(DecacCompiler compiler){
        /*int regIntia = this.initialization.codeGenIntialisation(compiler);
        compiler.addInstruction(new STORE(Register.getR(regIntia), paramName.getExpDefinition().getOperand()));
        Register.getR(regIntia).setIsFull(false);*/
    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("not yet implemented");
        //type.decompile(s);
        s.print(type.getName().getName());
        s.print(" ");
        s.print(paramName.getName().getName());
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        paramName.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        paramName.prettyPrint(s, prefix, false);
    }
}
