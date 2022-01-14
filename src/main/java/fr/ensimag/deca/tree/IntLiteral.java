package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.IntType;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.Register;
import java.io.PrintStream;

/**
 * Integer literal
 *
 * @author gl46
 * @date 01/01/2022
 */
public class IntLiteral extends AbstractExpr {
    public static int i = 1;
    public int getValue() {
        return value;
    }

    private int value;

    public IntLiteral(int value) {
        this.value = value;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        //System.out.println("VerifyExpr IntLiteral:");
        Type t = new IntType(DecaParser.tableSymb.create("int"));
        this.setType(t);
        return t;
    }/*
    @Override
    protected int codeGenPrint(DecacCompiler compiler) {
        int i = Register.getEmptyReg();
    	compiler.addInstruction(new LOAD(new ImmediateInteger(value), Register.getR(i)));
        Register.getR(i).setIsFull(true);
        return i;
    }*/


    @Override
    String prettyPrintNode() {
        return "Int (" + getValue() + ")";
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print(Integer.toString(value));
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
        int i = Register.getEmptyReg();
    	compiler.addInstruction(new LOAD(new ImmediateInteger(value), Register.getR(i)));
        Register.getR(i).setIsFull(true);
        return i;
    }

}
