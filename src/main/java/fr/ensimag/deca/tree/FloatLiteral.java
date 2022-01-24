package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.Register;
import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Single precision, floating-point literal
 *
 * @author gl46
 * @date 01/01/2022
 */
public class FloatLiteral extends AbstractExpr {

    public float getValue() {
        return value;
    }
    public static int i = 1;
    private float value;

    public FloatLiteral(float value) {
        Validate.isTrue(!Float.isInfinite(value),
                "literal values cannot be infinite");
        Validate.isTrue(!Float.isNaN(value),
                "literal values cannot be NaN");
        this.value = value;
    }
   // @Override
   /* protected int codeGenPrint(DecacCompiler compiler) {
        int i = Register.getEmptyReg();
    	compiler.addInstruction(new LOAD(new ImmediateFloat(value), Register.getR(i)));
        Register.getR(i).setIsFull(true);
        return i;
    }*/
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        if (this.value > Math.pow(2, 32)){throw new ContextualError("Débordement lors d'une opération sur des flottants", this.getLocation());}
       // System.out.println("VerifyExpr FloatLiteral:");
       Type t = new FloatType(DecaParser.tableSymb.create("float"));
       this.setType(t);
       return t;
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print(java.lang.Float.toString(value));
    }

    @Override
    String prettyPrintNode() {
        return "Float (" + getValue() + ")";
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int i = Register.getEmptyReg(compiler);
    	compiler.addInstruction(new LOAD(new ImmediateFloat(value), Register.getR(i)));
        Register.getR(i).setIsFull(true);
        return i;
    }

}
