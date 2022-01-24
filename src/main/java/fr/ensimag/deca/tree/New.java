package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.NEW;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RFLOAT;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import java.io.PrintStream;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class New extends AbstractExpr {
    private final AbstractIdentifier ident ;
    public New(AbstractIdentifier ident){
        this.ident = ident;
    }
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        ident.verifyType(compiler);
        return ident.getType();
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print("New(");
        ident.decompile(s);
        s.print(")");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
        ident.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
        ident.prettyPrint(s, prefix, false);
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        /*if(Register.getR(2).getIsFull()){
            compiler.addInstruction(new PUSH(Register.getR(2)));
        }else{
            Register.getR(2).setIsFull(true);
        }*/
        if(ident.getName().getName().equals("Object")){
            compiler.addInstruction(new NEW(1, Register.getR(1)));
            compiler.addInstruction(new LOAD(new NullOperand(), Register.R0));
            compiler.addInstruction(new STORE(Register.R0,new RegisterOffset(0, Register.getR(1))));
        }else{
        compiler.addInstruction(new NEW(ident.getClassDefinition().getNumberOfFields() +1, Register.getR(1)));
        compiler.addInstruction(new LEA(ident.getClassDefinition().getAdresseClass(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0,new RegisterOffset(0, Register.getR(1))));
        compiler.addInstruction(new PUSH(Register.getR(1)));
        compiler.addInstruction(new BSR(((ClassDefinition)compiler.getEnvTypes().get(this.ident.getName())).getInitClass()));
        compiler.addInstruction(new LOAD(new RegisterOffset(0,Register.SP),Register.getR(1)));}
        return 1;
    }

}
