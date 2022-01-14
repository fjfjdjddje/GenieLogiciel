package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.ima.pseudocode.instructions.STORE;

/**
 * Assignment, i.e. lvalue = expr.
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Assign extends AbstractBinaryExpr {

    @Override
    public AbstractLValue getLeftOperand() {
        // The cast succeeds by construction, as the leftOperand has been set
        // as an AbstractLValue by the constructor.
        return (AbstractLValue)super.getLeftOperand();
    }

    public Assign(AbstractLValue leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        //System.out.println("verifyExpr Assign debut:");
        Type typeLeftExpr = super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        AbstractExpr rValue = super.getRightOperand().verifyRValue(compiler, localEnv, currentClass,typeLeftExpr);
        setRightOperand(rValue);
        //System.out.println("verifyExpr Assign fin:");
        //verifyRValue(compiler, localEnv, currentClass, typeLeftExpr);
        return typeLeftExpr;
    }


    @Override
    protected String getOperatorName() {
        return "=";
    }

    @Override
    public void codeGenInst(DecacCompiler compiler) {
        int reg = super.getRightOperand().codeGenExpr(compiler);
        compiler.addInstruction(new STORE(Register.getR(reg),((Identifier)(super.getLeftOperand())).getExpDefinition().getOperand()));
        Register.getR(reg).setIsFull(true);
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        // TODO Auto-generated method stub
        return 0;
    }

}
