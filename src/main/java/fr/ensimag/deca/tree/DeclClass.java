package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import net.bytebuddy.jar.asm.Label;

import java.io.PrintStream;
import java.util.Map;

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
        this.superclass.setDefinition(compiler.getEnvTypes().get(this.superclass.getName()));
        try{
            ClassDefinition defClass = (ClassDefinition) compiler.getEnvTypes().getCurrentEnvironment().get(superclass.getName());
            ClassType typeDeClasse = new ClassType(DecaParser.tableSymb.create(className.getName().getName()),this.getLocation(),defClass);
            Definition def= new ClassDefinition(typeDeClasse,this.getLocation(),defClass);
            this.className.setDefinition(def);
            this.className.setType(typeDeClasse);
            compiler.getEnvTypes().getCurrentEnvironment().put(className.getName(), def);
            System.out.println(compiler.getEnvTypes().getCurrentEnvironment());

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
        
        for(AbstractDeclMethod method : listMethod.getList()){
            method.verifyDeclMethod(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());

        }
    }
    
    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for(AbstractDeclMethod method : listMethod.getList()){
            method.verifyBodyMethod(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());
            this.className.getClassDefinition().incNumberOfMethods();
        }
    
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
    public void codeGenDeclClass(DecacCompiler compiler){
            System.out.println(this.superclass.getDefinition()+ " hhhhhruf");
            ((ClassDefinition)this.className.getDefinition()).setAdresseSuperClass(new RegisterOffset(RegisterOffset.lastReg, Register.GB));
            compiler.addInstruction(new LEA(((ClassDefinition)this.superclass.getDefinition()).getAdresseSuperClass(), Register.R0));
            compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));
            RegisterOffset.lastReg ++;
            //on LOAD le code de equals.object
            /*compiler.addInstruction(new LOAD(new LabelOperand(new Label("code.Object.equals")), Register.R0));
            compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));*/
        //listMethod.codeGenListDeclMethod(compiler);
        EnvironmentExp current =((ClassDefinition)(compiler.getEnvTypes().getCurrentEnvironment().get(className.getName()))).getMembers();
        ClassDefinition courant = ((ClassDefinition)(compiler.getEnvTypes().getCurrentEnvironment().get(className.getName())));
        while(current != null){
            for(Map.Entry<Symbol,Definition> a : current.getCurrentEnvironment().entrySet()){
                if(a.getValue().isMethod()){
                   // System.out.println("methode",)
                   compiler.addInstruction(new LOAD(new LabelOperand(((MethodDefinition)a.getValue()).getLabel()), Register.R0));
                   compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg + ((MethodDefinition)a.getValue()).getIndex(), Register.GB)));
                }
            }
            current = current.getParentEnvironment();
        }
        RegisterOffset.lastReg += courant.getNumberOfMethods();
       
    }

}
