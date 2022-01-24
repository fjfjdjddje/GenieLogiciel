package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.BooleanType;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.SUBSP;

public class Instanceof extends AbstractBinaryExpr implements Condition{
    public Instanceof(AbstractExpr expr, AbstractIdentifier ident){
        super(expr, ident);
    }
    @Override
    protected String getOperatorName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type lefType = super.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        if(!lefType.isClass()){
            throw new ContextualError("Left operand of InstanceOf should be an Object.", super.getLeftOperand().getLocation());
        }
        Type rightType = ((Identifier)super.getRightOperand()).verifyType(compiler);
        if(!rightType.isClass()){
            throw new ContextualError("Right operand should be a Class.", super.getRightOperand().getLocation());
        }
        this.setType(new BooleanType(DecaParser.tableSymb.create("boolean")));
        return new BooleanType(DecaParser.tableSymb.create("boolean"));
    }

    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        int reg = super.getLeftOperand().codeGenExpr(compiler);
        compiler.addInstruction(new ADDSP(2));
        compiler.addInstruction(new STORE(Register.getR(reg), new RegisterOffset(0, Register.SP)));
        compiler.addInstruction(new LEA(((Identifier)super.getRightOperand()).getClassDefinition().getAdresseClass(), Register.getR(reg)));
        compiler.addInstruction(new STORE(Register.getR(reg), new RegisterOffset(-1, Register.SP)));
        if (!Register.getR(reg).getIsPushed()){
            Register.getR(reg).setIsFull(false);
        }
        compiler.addInstruction(new BSR(new Label("code.instanceOf")));
        compiler.addInstruction(new SUBSP(2));
        return 0;
    }
    @Override
    public void codeGenCond(DecacCompiler compiler, Label lab2) {
        int reg = super.getLeftOperand().codeGenExpr(compiler);
        compiler.addInstruction(new ADDSP(2));
        compiler.addInstruction(new STORE(Register.getR(reg), new RegisterOffset(0, Register.SP)));
        compiler.addInstruction(new LEA(((Identifier)super.getRightOperand()).getClassDefinition().getAdresseClass(), Register.getR(reg)));
        compiler.addInstruction(new STORE(Register.getR(reg), new RegisterOffset(-1, Register.SP)));
        if (!Register.getR(reg).getIsPushed()){
            Register.getR(reg).setIsFull(false);
        }
        compiler.addInstruction(new BSR(new Label("code.instanceOf")));
        compiler.addInstruction(new SUBSP(2));
        compiler.addInstruction(new LOAD(0,Register.R1));
        compiler.addInstruction(new CMP(Register.R1, Register.R0));
        compiler.addInstruction(new BEQ(lab2));
        
    }
    
}
