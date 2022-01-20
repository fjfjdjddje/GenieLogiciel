package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.context.VoidType;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.Signature;
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
public class DeclMethod extends AbstractDeclMethod {

    final private AbstractIdentifier type;
    final private AbstractIdentifier methodName;
    final private ListDeclParam listDeclParam;
    final private MethodBody body;
    private EnvironmentExp methodEnv;

    public DeclMethod(AbstractIdentifier type, AbstractIdentifier methodName,ListDeclParam listDeclParam,
    MethodBody body) {
       /* Validate.notNull(type);
        Validate.notNull(methodName);
        Validate.notNull(initialization);*/
        this.type = type;
        this.methodName = methodName;
        this.listDeclParam = listDeclParam;
        this.body = body;
    }

    @Override
    protected void verifyDeclMethod(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
                if(compiler.getEnvTypes().getCurrentEnvironment().containsKey(methodName.getName())){
                    throw new ContextualError("method name already declared", this.getLocation());
                }
        this.type.verifyType(compiler);
        this.methodEnv = new EnvironmentExp(localEnv);
        Signature methodSignature = new Signature();
        methodSignature.add(type.getType());
        listDeclParam.verifyListParam(compiler, this.methodEnv, currentClass);
        for(AbstractDeclParam par : this.listDeclParam.getList()){
            Type paramType = par.getType().getType();
            methodSignature.add(paramType);
        }
        MethodDefinition methodDef = new MethodDefinition(this.type.getType(), this.getLocation(), methodSignature, currentClass.getNumberOfMethods()+1);
        EnvironmentExp typesEnv = compiler.getEnvTypes();
        typesEnv.getCurrentEnvironment().put(methodName.getName(), methodDef);
        
    }
    @Override
    public void codeGenDeclMethod(DecacCompiler compiler){
        /*int regIntia = this.initialization.codeGenIntialisation(compiler);
        compiler.addInstruction(new STORE(Register.getR(regIntia), methodName.getExpDefinition().getOperand()));
        Register.getR(regIntia).setIsFull(false);*/
    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        /*throw new UnsupportedOperationException("not yet implemented");
        //type.decompile(s);
        s.print(type.getName().getName());
        s.print(" ");
        s.print(methodName.getName().getName());
        initialization.decompile(s);*/
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        methodName.iter(f);
        listDeclParam.iter(f);
        //initialization.iter(f);
        body.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        methodName.prettyPrint(s, prefix, false);
        listDeclParam.prettyPrint(s, prefix, false);
        //initialization.prettyPrint(s, prefix, true);
        body.prettyPrint(s, prefix, false);

    }
}
