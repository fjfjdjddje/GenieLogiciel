package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Return extends AbstractInst {
    
    private AbstractExpr expression;
    
    public AbstractExpr getExpression() {
        return expression;
    }
    
    public void setExpression(AbstractExpr expression) {
        this.expression = expression;
    }
    
    public Return(AbstractExpr argument) {
        this.expression = argument;
    }
    
    @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("not yet implemented");
        s.print("return ");
        expression.decompile();
        s.println(";");
    }
    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass,
            Type returnType) throws ContextualError {
        // TODO Auto-generated method stub
        if(currentClass != null){
            Type exprType = expression.verifyExpr(compiler, localEnv, currentClass);
            System.out.println(exprType.getName().getName());
            if(exprType.isClass() ){
                if(!returnType.isClass()){
                    throw new ContextualError("Type de retour incompatible", getLocation());
                }
                ClassType typeClass=(ClassType) exprType;
                if(!typeClass.isSubClassOf((ClassType)returnType)){
                    throw new ContextualError("Le type de retour n'est pas une sous classe de celui attendu", getLocation());
                }
            }else{
                if(!exprType.sameType(returnType)){
                    if(!(returnType.isFloat() && exprType.isInt())){
                        throw new ContextualError("Type de retour different de celui attendu", getLocation());
                    }else{
                        expression=new ConvFloat(expression);
                    }
                }
            }
        }else{
            throw new ContextualError("Return can not be used in the main", this.getLocation());
        }
        
    }
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // TODO Auto-generated method stub
        expression.prettyPrint(s, prefix,false);
        
    }
    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        expression.iter(f);
        
    }
}
