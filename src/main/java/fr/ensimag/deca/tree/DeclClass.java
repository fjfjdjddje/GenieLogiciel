package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.IndentPrintStream;
import java.io.PrintStream;

/**
 * Declaration of a class (<code>class name extends superClass {members}<code>).
 * 
 * @author gl46
 * @date 01/01/2022
 */
public class DeclClass extends AbstractDeclClass {
    final private AbstractIdentifier superclass;
    final private AbstractIdentifier className;
    final private ListDeclField listField;
    final private ListDeclMethod listMethod;

    public DeclClass(AbstractIdentifier superclass, AbstractIdentifier className,ListDeclField listField , ListDeclMethod listMethod) {
       /* Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);*/
        this.superclass = superclass;
        this.className = className;
        this.listField = listField;
        this.listMethod = listMethod;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class { ... A FAIRE ... }");
    }

    @Override
    protected void verifyClass(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        if(compiler.getEnvTypes().getCurrentEnvironment().containsKey(className.getName())){
            throw new ContextualError("Class "+className.getName().getName()+" already declared.", className.getLocation());
        }
        if(!compiler.getEnvTypes().getCurrentEnvironment().containsKey(superclass.getName())){
            throw new ContextualError("Superclass "+superclass.getName().getName()+" undefined.", superclass.getLocation());
        } 
        if(!compiler.getEnvTypes().getCurrentEnvironment().get(superclass.getName()).isClass()){
                throw new ContextualError(this.superclass.getName().getName()+ " is not a class", this.getLocation());
        }
        try{
            Definition def= new ClassDefinition(new ClassType(DecaParser.tableSymb.create(className.getName().getName()),this.getLocation(),superclass.getClassDefinition()),this.getLocation(), superclass.getClassDefinition());
            this.className.setDefinition(def);
            compiler.getEnvTypes().getCurrentEnvironment().put(className.getName(), def);
        }catch (Exception e){
           System.out.println("Error in the declaration of the class in the environement.");
        }
    }

    @Override
    protected void verifyClassMembers(DecacCompiler compiler)
            throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for(AbstractDeclField field : listField.getList()){
            field.verifyDeclField(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());
            this.className.getClassDefinition().incNumberOfFields();
        }
        
        for(AbstractDeclMethod field : listMethod.getList()){
            field.verifyDeclMethod(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());
            this.className.getClassDefinition().incNumberOfMethods();

        }
    }
    
    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
       
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        //throw new UnsupportedOperationException("Not yet supported");
        superclass.prettyPrint(s, prefix, true);
        className.prettyPrint(s, prefix, true);
        listField.prettyPrint(s, prefix, false);
        listMethod.prettyPrint(s, prefix, false);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        //throw new UnsupportedOperationException("Not yet supported");
        superclass.iter(f);
        className.iter(f);
        listField.iter(f);
        listMethod.iter(f);
    }

}
