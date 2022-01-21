package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.RFLOAT;

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
       /* int reg = Register.getEmptyReg(compiler);
        Register.getR(reg).setIsFull(true);
        compiler.addInstruction(new RFLOAT());
        compiler.addInstruction(new LOAD(Register.getR(1),Register.getR(reg)));
        return reg;*/
        return 0;
    }

}
