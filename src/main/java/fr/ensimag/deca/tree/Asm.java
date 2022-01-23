package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.InlinePortion;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class Asm extends AbstractInst{
    private String str;
    public Asm(String str){
        this.str = str;
    }
    public String getString(){
        return this.str;
    }
    public void setString(String str){
        this.str = str;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass,
            Type returnType) throws ContextualError {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        // TODO Auto-generated method stub
        str = str.substring(1, str.length()-1);
        compiler.add(new InlinePortion(str));
        
    }
}
