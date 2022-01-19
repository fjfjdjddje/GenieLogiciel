package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;


public abstract class AbstractDeclParam extends Tree {
    
    public abstract AbstractIdentifier getType();

    public abstract void codeGenDeclParam(DecacCompiler compiler);
    protected abstract void verifyDeclParam(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError;
}
