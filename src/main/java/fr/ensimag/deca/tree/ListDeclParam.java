package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;


public class ListDeclParam extends TreeList<AbstractDeclParam> {

    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclParam i : getList()) {
            i.decompile(s);
        }

    }
   
    void verifyListParam(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
               /* for( AbstractParam Param : this.getList()){
                    Param.verifyParam(compiler, localEnv, currentClass);
                }*/
    }
    public void codeGenListParam(DecacCompiler compiler) {
       /* for (AbstractParam i : getList()) {
            i.codeGenParam(compiler);
        }*/
    }

}
