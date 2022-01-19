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
    final private AbstractIdentifier varName;
    final private ListDeclParam listDeclParam;
    final private ListInst listInst;
    final private ListDeclVar listDeclVar;

    public DeclMethod(AbstractIdentifier type, AbstractIdentifier varName,ListDeclParam listDeclParam,
    ListDeclVar listDeclVar,ListInst listInst) {
       /* Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);*/
        this.type = type;
        this.varName = varName;
        this.listDeclParam = listDeclParam;
        this.listDeclVar = listDeclVar;
        this.listInst = listInst;

    }

    @Override
    protected void verifyDeclMethod(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Signature methodSignature = new Signature();
        methodSignature.add(type.getType());
        for(AbstractDeclParam par : this.listDeclParam.getList()){
            methodSignature.add(par.getType().getType());
        }
        listDeclVar.verifyListDeclVariable(compiler, localEnv, currentClass);
        listInst.verifyListInst(compiler, localEnv, currentClass, new VoidType(DecaParser.tableSymb.create("void")));
    }
    @Override
    public void codeGenDeclMethod(DecacCompiler compiler){
        /*int regIntia = this.initialization.codeGenIntialisation(compiler);
        compiler.addInstruction(new STORE(Register.getR(regIntia), varName.getExpDefinition().getOperand()));
        Register.getR(regIntia).setIsFull(false);*/
    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        /*throw new UnsupportedOperationException("not yet implemented");
        //type.decompile(s);
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
        //initialization.iter(f);
        listInst.iter(f);
        listDeclVar.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        //initialization.prettyPrint(s, prefix, true);
        listInst.prettyPrint(s, prefix, false);
        listDeclVar.prettyPrint(s, prefix, false);
    }
}
