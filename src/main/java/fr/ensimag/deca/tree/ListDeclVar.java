package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

/**
 * List of declarations (e.g. int x; float y,z).
 * 
 * @author gl46
 * @date 01/01/2022
 */
public class ListDeclVar extends TreeList<AbstractDeclVar> {
    public static int localOff = 1;
    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclVar i : getList()) {
            i.decompile(s);
        }

    }

    /**
     * Implements non-terminal "list_decl_var" of [SyntaxeContextuelle] in pass 3
     * @param compiler contains the "env_types" attribute
     * @param localEnv 
     *   its "parentEnvironment" corresponds to "env_exp_sup" attribute
     *   in precondition, its "current" dictionary corresponds to 
     *      the "env_exp" attribute
     *   in postcondition, its "current" dictionary corresponds to 
     *      the "env_exp_r" attribute
     * @param currentClass 
     *          corresponds to "class" attribute (null in the main bloc).
     */    
    void verifyListDeclVariable(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
                for( AbstractDeclVar declvariable : this.getList()){
                    declvariable.verifyDeclVar(compiler, localEnv, currentClass);
                }
    }

    void verifyListDeclVariableMethod(DecacCompiler compiler,EnvironmentExp localEnv,ClassDefinition currentClass) 
        throws ContextualError {
            for( AbstractDeclVar declvariable : this.getList()){
                declvariable.verifyDeclVarMethod(compiler, localEnv, currentClass);
            }
}
    public void codeGenListVar(DecacCompiler compiler) {
        for (AbstractDeclVar i : getList()) {
            i.codeGenDeclVariable(compiler);
        }
    }
    public void codeGenListVarLoc(DecacCompiler compiler) {
        for (AbstractDeclVar i : getList()) {
            i.codeGenDeclVariableLoc(compiler);
            localOff ++;
        }
        localOff = 1;
    }

}
