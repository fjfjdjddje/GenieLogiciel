package fr.ensimag.deca.tree;

import java.io.PrintStream;
import java.lang.reflect.Constructor;

import javax.print.attribute.standard.Media;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

public class MethodCall extends AbstractExpr{
    private final AbstractExpr expr;
    private final AbstractIdentifier ident;
    private final ListExpr listExpr;
    public MethodCall(AbstractExpr expr, AbstractIdentifier ident, ListExpr listExpr){
        this.expr = expr;
        this.ident = ident;
        this.listExpr = listExpr;
    }
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expr.prettyPrint(s, prefix, false);
        ident.prettyPrint(s, prefix, false);
        listExpr.prettyPrint(s, prefix, false);
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        expr.iterChildren(f);
        ident.iterChildren(f);
        listExpr.iterChildren(f);
    }

    
}
