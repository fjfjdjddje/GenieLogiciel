package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.context.IntType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.WSTR;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.WFLOATX;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.SEQ;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Label;
import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Print statement (print, println, ...).
 *
 * @author gl46
 * @date 01/01/2022
 */
public abstract class AbstractPrint extends AbstractInst {

    private boolean printHex;
    private ListExpr arguments = new ListExpr();
    
    abstract String getSuffix();

    public AbstractPrint(boolean printHex, ListExpr arguments) {
        Validate.notNull(arguments);
        this.arguments = arguments;
        this.printHex = printHex;
    }

    public ListExpr getArguments() {
        return arguments;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass, Type returnType)
            throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for(AbstractExpr arg : this.arguments.getList()){
            arg.verifyExpr(compiler, localEnv, currentClass);
        }
    }
    static int iterateur = 0;
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        for (AbstractExpr a : getArguments().getList()) {
                int i = a.codeGenExpr(compiler);
                if(a instanceof Selection){
                    compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(i)), Register.getR(1)));
                }else{
                    compiler.addInstruction(new LOAD(Register.getR(i), Register.getR(1)));}
                Register.getR(i).setIsFull(false);
                if (a.getType().isInt()){
                    compiler.addInstruction(new WINT());
                }else if(a.getType().isFloat()){
                    if(printHex){
                        compiler.addInstruction(new WFLOATX());

                    }else{
                        compiler.addInstruction(new WFLOAT());
                    }
                }else if (a.getType().isBoolean()){
                    Label labFalse = new Label("printFalse"+iterateur);
                    Label labFin = new Label("endPrint"+iterateur);
                    compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.R1));
                    compiler.addInstruction(new CMP(Register.getR(i),Register.R1));
                    compiler.addInstruction(new BEQ(labFalse));
                    compiler.addInstruction(new WSTR("true"));
                    compiler.addInstruction(new BRA(labFin));
                    compiler.addLabel(labFalse);
                    compiler.addInstruction(new WSTR("false")); 
                    compiler.addLabel(labFin);
                    iterateur++;
            }
        }
    }

    private boolean getPrintHex() {
        return printHex;
    }

   /* @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("not yet implemented");
        s.print("print(");
        for(AbstractExpr arg : this.arguments.getList()){
            arg.decompile(s);
        }
        s.print(");");
    }*/

    @Override
    protected void iterChildren(TreeFunction f) {
        arguments.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        arguments.prettyPrint(s, prefix, true);
    }

}
