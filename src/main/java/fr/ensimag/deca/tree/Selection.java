package fr.ensimag.deca.tree;

import java.io.PrintStream;
import java.lang.reflect.Constructor;

import javax.print.attribute.standard.Media;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.ClassType;
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
        Type leftType = this.expr.verifyExpr(compiler, localEnv, currentClass);
        if(!compiler.getEnvTypes().get(leftType.getName()).isClass()){
            throw new ContextualError("Fields can only be used on objects.", this.expr.getLocation());
        }
        EnvironmentExp classeAppelanteEnv = ((ClassDefinition)compiler.getEnvTypes().get(leftType.getName())).getMembers();
        this.ident.verifyExpr(compiler, classeAppelanteEnv, currentClass);
        if(!classeAppelanteEnv.get(ident.getName()).isField()){
            throw new ContextualError(ident.getName().getName()+" isn't a field of the class in question.", this.ident.getLocation());
        }
        if(((FieldDefinition)classeAppelanteEnv.get(ident.getName())).getVisibility() == Visibility.PROTECTED){
            if(currentClass == null){
                throw new ContextualError(ident.getName().getName()+" is a protected field.", this.ident.getLocation());
            }
            else if(!((ClassType)currentClass.getType()).isSubClassOf((ClassType)leftType)){
                throw new ContextualError(ident.getName().getName()+" is a protected field.", this.ident.getLocation());
            }
            System.out.println(currentClass.getType().getName().getName()+" == "+ leftType.getName().getName());
        }

        return ident.getType();
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
