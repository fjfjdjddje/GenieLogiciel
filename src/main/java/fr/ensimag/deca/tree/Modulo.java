package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Modulo extends AbstractOpArith {

    public Modulo(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        System.out.println("Modulo verify expr: begin");
        Type typeLeftOperande= super.getLeftOperand().verifyExpr(compiler, localEnv,currentClass);
        Type typeRightOperande= super.getRightOperand().verifyExpr(compiler,localEnv, currentClass);
        if(!typeLeftOperande.isInt() || !typeRightOperande.isInt()){
            throw new ContextualError("Modulo is not defined for this type", this.getLocation());
        } else {
            System.out.println("Modulo verify expr: end");
            return typeLeftOperande;
        }
    }


    @Override
    protected String getOperatorName() {
        return "%";
    }

}
