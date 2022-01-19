package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

public class ListDeclMethod extends TreeList<AbstractDeclMethod> {

    @Override
    public void decompile(IndentPrintStream s) {
        /*throw new UnsupportedOperationException("Not yet implemented");
        for (AbstractDeclMethod i : getList()) {
            i.decompile(s);
        }*/

    }


    void verifyListDeclMethod(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
                /*System.out.println("verify listDeclMethod: start");
                for( AbstractDeclMethod DeclMethod : this.getList()){
                    DeclMethod.verifyDeclMethod(compiler, localEnv, currentClass);
                }
                //System.out.println("verify listDeclMethod: end");*/
    }
    public void codeGenListVar(DecacCompiler compiler) {
        /*for (AbstractDeclMethod i : getList()) {
            i.codeGenDeclMethod(compiler);
        }*/
    }

}
