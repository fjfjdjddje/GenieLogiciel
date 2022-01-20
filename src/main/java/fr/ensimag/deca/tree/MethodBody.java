package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

public class MethodBody extends Tree{
    final private ListInst listInst ;
    final private ListDeclVar listDeclVar;
    public MethodBody(ListInst listInst, ListDeclVar listDeclVar){
        this.listInst = listInst;
        this.listDeclVar = listDeclVar;
    }
    @Override
    protected
    void iterChildren(TreeFunction f) {
        listInst.iter(f);
        listDeclVar.iter(f);
    }

    public void verifyBody(DecacCompiler compiler,EnvironmentExp methodEnv, ClassDefinition currentClass,Type returnType)
        throws ContextualError{
            listDeclVar.verifyListDeclVariableMethod(compiler, methodEnv, currentClass);
            listInst.verifyListInst(compiler, methodEnv, currentClass, returnType);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        listInst.prettyPrint(s, prefix, false);
        listDeclVar.prettyPrint(s, prefix, false);
    }
    @Override
    public void decompile(IndentPrintStream s) {
        // TODO Auto-generated method stub
        
    }
}
