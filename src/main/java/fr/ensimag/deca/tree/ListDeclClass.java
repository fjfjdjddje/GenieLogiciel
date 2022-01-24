package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.TSTO;

import org.apache.log4j.Logger;

/**
 *
 * @author gl46
 * @date 01/01/2022
 */
public class ListDeclClass extends TreeList<AbstractDeclClass> {
    private static final Logger LOG = Logger.getLogger(ListDeclClass.class);
    
    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclClass c : getList()) {
            c.decompile(s);
            s.println();
        }
    }

    /**
     * Pass 1 of [SyntaxeContextuelle]
     */
    void verifyListClass(DecacCompiler compiler) throws ContextualError {
        //LOG.debug("verify listClass: start");
        //throw new UnsupportedOperationException("not yet implemented");
        for( AbstractDeclClass declclass : this.getList()){
            declclass.verifyClass(compiler);
        }
        //LOG.debug("verify listClass: end");
    }

    /**
     * Pass 2 of [SyntaxeContextuelle]
     */
    public void verifyListClassMembers(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for( AbstractDeclClass declclass : this.getList()){
            declclass.verifyClassMembers(compiler);
        }

    }
    
    /**
     * Pass 3 of [SyntaxeContextuelle]
     */
    public void verifyListClassBody(DecacCompiler compiler) throws ContextualError {
        //throw new UnsupportedOperationException("not yet implemented");
        for( AbstractDeclClass declclass : this.getList()){
            declclass.verifyClassBody(compiler);
        }
    }
    public void codeGenListDeclClass(DecacCompiler compiler){
        compiler.addInstruction(new LOAD(new NullOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));
        RegisterOffset.lastReg ++;
        //on LOAD le code de equals.object
        compiler.addInstruction(new LOAD(new LabelOperand(new Label("code.Object.equals")), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(RegisterOffset.lastReg, Register.GB)));
        RegisterOffset.lastReg ++;
        for( AbstractDeclClass declclass : this.getList()){
            declclass.codeGenDeclClass(compiler);
        }
        compiler.addInstruction(new TSTO(RegisterOffset.lastReg));
        compiler.addInstruction(new BOV(new Label("pile_pleine")));
        compiler.addInstruction(new ADDSP(RegisterOffset.lastReg));
    }
    public void codeGenInitFields(DecacCompiler compiler){
        for( AbstractDeclClass declclass : this.getList()){
            declclass.codeGenDeclClassField(compiler);
        }
    }
    public void codeGenMethods(DecacCompiler compiler){
        for( AbstractDeclClass declclass : this.getList()){
            declclass.codeGenDeclClassMethods(compiler);
        }
    }
}
