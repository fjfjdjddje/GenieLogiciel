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
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Operand;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import java.io.PrintStream;
import java.util.Map;
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
    public static boolean returnExiste = false;
    protected EnvironmentExp methodEnv;

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
        if(localEnv.getCurrentEnvironment().containsKey(methodName.getName())){
                    throw new ContextualError("method name already declared", this.getLocation());
                }
        this.type.verifyType(compiler);
        this.methodEnv = new EnvironmentExp(currentClass.getMembers());
        Signature methodSignature = new Signature();
        methodSignature.add(type.getType());
        listDeclParam.verifyListParam(compiler, this.methodEnv, currentClass);
        for(AbstractDeclParam par : this.listDeclParam.getList()){
            Type paramType = par.getType().getType();
            methodSignature.add(paramType);
        }
        int index = 0;
        ClassDefinition current = currentClass.getSuperClass();
        while(current != null){
            index += current.getNumberOfMethods();
            current = current.getSuperClass();
            }
        if(localEnv.get(methodName.getName())!= null){
            index = ((MethodDefinition)localEnv.get(methodName.getName())).getIndex();
        }
        else{
            index += currentClass.getNumberOfMethods();
            currentClass.incNumberOfMethods();
        }
        Label lab = new Label("code."+currentClass.getType().getName().getName() + "."+methodName.getName());
        MethodDefinition methodDef = new MethodDefinition(this.type.getType(), this.getLocation(), methodSignature, index);
        methodDef.setLabel(lab);

        methodName.setDefinition(methodDef);
        localEnv.getCurrentEnvironment().put(methodName.getName(), methodDef);
        
    }


    @Override
    protected void verifyBodyMethod(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
                this.body.verifyBody(compiler, this.methodEnv , currentClass, type.getType());
    }

    @Override
    public void codeGenDeclMethod(DecacCompiler compiler){
        returnExiste = true;
        compiler.addLabel(methodName.getMethodDefinition().getLabel());
        //Register.pushAll(compiler);
        Label lab1 = new Label("fin"+methodName.getMethodDefinition().getLabel().toString());
        this.body.codeGenDeclBody(compiler);
        if(returnExiste){
            compiler.addInstruction(new BRA(lab1));
            compiler.addInstruction(new WSTR("Erreur : sortie de la methode"+methodName.getMethodDefinition().getLabel().toString()+"sans return"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }
        compiler.addLabel(new Label("fin"+methodName.getMethodDefinition().getLabel().toString()));
        //Register.popALL(compiler);
        compiler.addInstruction(new RTS());
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
