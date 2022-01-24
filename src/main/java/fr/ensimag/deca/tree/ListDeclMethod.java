package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;

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
                for( AbstractDeclMethod DeclMethod : this.getList()){
                    DeclMethod.verifyDeclMethod(compiler, localEnv, currentClass);
                }
    }
    public void codeGenListDeclMethod(DecacCompiler compiler) {
        for (AbstractDeclMethod i : getList()) {
            i.codeGenDeclMethod(compiler);
        }
    }

}
