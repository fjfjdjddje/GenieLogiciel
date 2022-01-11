package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Minus extends AbstractOpArith {
    public Minus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }
    @Override
    public void genCodeOperation(DecacCompiler compiler){}
    
}
