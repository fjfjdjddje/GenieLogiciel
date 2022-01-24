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
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.SUBSP;

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
        }catch (Exception e){
           System.out.println("Error in the declaration of the class in the environement.");
        }
    }

    @Override
    protected void verifyClassMembers(DecacCompiler compiler)
            throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        this.className.getClassDefinition().setNumberOfFields(this.superclass.getClassDefinition().getNumberOfFields());
        for(AbstractDeclField field : listField.getList()){
            field.verifyDeclField(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());
            this.className.getClassDefinition().incNumberOfFields();
        }
       // this.className.getClassDefinition().setNumberOfFields(this.className.getClassDefinition().getNumberOfFields()+this.superclass.getClassDefinition().getNumberOfFields());
        

        //System.out.println(this.className.getName().getName()+" == "+ this.className.getClassDefinition().getNumberOfFields());
        
        for(AbstractDeclMethod method : listMethod.getList()){
            method.verifyDeclMethod(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());

        }
    }
    
    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for(AbstractDeclMethod method : listMethod.getList()){
            method.verifyBodyMethod(compiler, this.className.getClassDefinition().getMembers(), className.getClassDefinition());
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
            //System.out.println(this.superclass.getDefinition()+ " hhhhhruf");
            ((ClassDefinition)this.className.getDefinition()).setAdresseClass(new RegisterOffset(RegisterOffset.lastReg, Register.GB));
            compiler.addInstruction(new LEA(((ClassDefinition)this.superclass.getDefinition()).getAdresseClass(), Register.R0));
            compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));
            RegisterOffset.lastReg ++;
            //on LOAD le code de equals.object
            /*compiler.addInstruction(new LOAD(new LabelOperand(new Label("code.Object.equals")), Register.R0));
            compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));*/
        //listMethod.codeGenListDeclMethod(compiler);
        EnvironmentExp current =((ClassDefinition)(compiler.getEnvTypes().getCurrentEnvironment().get(className.getName()))).getMembers();
        /*while(current != null){
            for(Map.Entry<Symbol,Definition> a : current.getCurrentEnvironment().entrySet()){
                if(a.getValue().isMethod()){
                   // System.out.println("methode",)
                   compiler.addInstruction(new LOAD(new LabelOperand(((MethodDefinition)a.getValue()).getLabel()), Register.R0));
                   compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg + ((MethodDefinition)a.getValue()).getIndex(), Register.GB)));
                }
            }
            current = current.getParentEnvironment();
        }*/
        generation(current, compiler);
        ClassDefinition courant = ((ClassDefinition)(compiler.getEnvTypes().getCurrentEnvironment().get(className.getName())));
        int offs = 0;
        while(courant != null){
            offs += courant.getNumberOfMethods();
            courant = courant.getSuperClass();
        }
        RegisterOffset.lastReg += offs;
       // System.out.println(RegisterOffset.lastReg+1+"lolololololo");
        //a changerrrrrrrrrrrrrrrrrrrrrrr
       
    }
    private void generation(EnvironmentExp environnement, DecacCompiler compiler){
        if(environnement.getParentEnvironment() != null){
            generation(environnement.getParentEnvironment(), compiler);
        }
        for(Map.Entry<Symbol,Definition> a : environnement.getCurrentEnvironment().entrySet()){
            if(a.getValue().isMethod()){
               // System.out.println("methode",)
               compiler.addInstruction(new LOAD(new LabelOperand(((MethodDefinition)a.getValue()).getLabel()), Register.R0));
               compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg + ((MethodDefinition)a.getValue()).getIndex(), Register.GB)));
            }
        }

    }
    public void codeGenDeclClassField(DecacCompiler compiler){
        Label lab1 = new Label("init."+this.className.getName().getName());
        compiler.addLabel(lab1);
        className.getClassDefinition().setInitClass(lab1);
        ((ClassDefinition)compiler.getEnvTypes().get(className.getName())).setInitClass(lab1);
        
        if(!this.superclass.getName().getName().equals("Object")){
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R0));
            compiler.addInstruction(new PUSH(Register.R0));
            compiler.addInstruction(new BSR(superclass.getClassDefinition().getInitClass()));
            compiler.addInstruction(new SUBSP(1));
        }
        for(AbstractDeclField field : listField.getList()){
            field.codeGenDeclField(compiler);
        } 
        compiler.addInstruction(new RTS());
    }
    @Override
    public void codeGenDeclClassMethods(DecacCompiler compiler) {
        listMethod.codeGenListDeclMethod(compiler);
    }

}
