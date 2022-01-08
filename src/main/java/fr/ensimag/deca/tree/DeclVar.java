package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.commons.lang.Validate;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class DeclVar extends AbstractDeclVar {

    
    final private AbstractIdentifier type;
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;

    public DeclVar(AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
    }

    @Override
    protected void verifyDeclVar(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
                if(!(compiler.getEnvTypes().getCurrentEnvironment().containsKey(type.getName()))){
                    throw new ContextualError("Ce type n'existe pas", type.getLocation());
                }
                if(localEnv.getCurrentEnvironment().containsKey(varName.getName())){
                    throw new ContextualError("Varable deja déclaré", varName.getLocation());
                }else{
                    try{
                        Definition def= new VariableDefinition(this.type.getType(),this.varName.getLocation() );
                        this.varName.setDefinition(def);
                       
                        localEnv.declare(varName.getName(),varName.getExpDefinition());
                        System.out.println(localEnv.getCurrentEnvironment());}
                    catch (Exception e){
                       System.out.println("Error en declaration de variable dans l'environnement");
                    }
                }
                this.initialization.verifyInitialization(compiler, this.type.getType(), localEnv, currentClass);

    }

    
    @Override
    public void decompile(IndentPrintStream s) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        varName.iter(f);
        initialization.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
    }
}
