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

public class Selection extends AbstractLValue{
    private final AbstractExpr expr;
    private final AbstractIdentifier ident;
    public Selection(AbstractExpr expr, AbstractIdentifier ident){
        this.expr = expr;
        this.ident = ident;
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
        // TODO Auto-generated method stub
        expr.prettyPrint(s, prefix, false);
        ident.prettyPrint(s, prefix, false);

        
    }
    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        expr.iter(f);
        ident.iter(f);
    }
    
}
