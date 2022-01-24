package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

public class Cast extends AbstractExpr{
    private AbstractIdentifier ident;
    private AbstractExpr expr;
    public Cast(AbstractIdentifier ident, AbstractExpr expr){
        this.ident = ident;
        this.expr = expr;
    }
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type classe = this.ident.verifyType(compiler);
        if(!classe.isClass()){
            throw new ContextualError("Erreur cast: can only cast to a Class", this.ident.getLocation());
        }
        Type typeExpr = this.expr.verifyExpr(compiler, localEnv, currentClass);
        if(!typeExpr.isClass()){
            throw new ContextualError("Erreur cast.", this.expr.getLocation());
        }
        /*if(!((ClassType)typeExpr).isSubClassOf((ClassType)classe)){
            throw new ContextualError("Erreur cast: object cannot be casted.", this.expr.getLocation());
        }*/
        return classe;
        
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg = expr.codeGenExpr(compiler);
        return 0;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // TODO Auto-generated method stub
        ident.prettyPrint(s, prefix, true);
        expr.prettyPrint(s, prefix, false);
        
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        ident.iter(f);
        expr.iter(f);
        
    }
        
}
