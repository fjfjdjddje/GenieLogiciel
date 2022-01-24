package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Initialization extends AbstractInitialization {

    public AbstractExpr getExpression() {
        return expression;
    }

    private AbstractExpr expression;

    public void setExpression(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    public Initialization(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    @Override
    protected void verifyInitialization(DecacCompiler compiler, Type t,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type expressionType = this.expression.verifyExpr(compiler, localEnv, currentClass);
        if(expressionType == null){
            if(!t.isClass()){
                throw new ContextualError("Assign incorrect: types incompatibles", this.getLocation());
            }
            return;
        }
            if(expressionType.isClass() && t.isClass()){
                if(!((ClassType)expressionType).isSubClassOf((ClassType)t)){
                    throw new ContextualError("Assign incorrect: types incompatibles", this.getLocation());
                }
            }
            if(!t.sameType(expressionType)){
                if(!(t.isFloat() && expressionType.isInt())){
                    throw new ContextualError("Assign incorrect: types différents", this.getLocation());
                }else{
                this.expression = new ConvFloat(this.expression);
                Type type = new FloatType(DecaParser.tableSymb.create("float"));
                this.expression.setType(type);
                }
            }
        /*if(!expressionType.sameType(t)){
            if(!(expressionType.isInt() && t.isFloat())){
                throw new ContextualError("Incorrect initialisation, incompatible types ( "+expressionType.getName().getName()+ "  and  "+t.getName().getName()+" ).", this.expression.getLocation());
            }
            else{
                this.expression = new ConvFloat(this.expression);
                Type type = new FloatType(DecaParser.tableSymb.create("float"));
                this.expression.setType(type);
            }
        }*/
        
    }
    @Override
    public int codeGenIntialisation(DecacCompiler compiler){
        return getExpression().codeGenExpr(compiler);
        
    }

    @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("Not yet implemented");
        s.print(" = ");
        this.getExpression().decompile(s);
        s.println(";");
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        expression.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expression.prettyPrint(s, prefix, true);
    }
}
