package fr.ensimag.deca.tree;

import java.io.PrintStream;
import java.lang.reflect.Constructor;

import javax.print.attribute.standard.Media;

import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.SUBSP;

public class MethodCall extends AbstractExpr{
    private final AbstractExpr objectName;
    private final AbstractIdentifier methodName;
    private final ListExpr listParameters;
    public MethodCall(AbstractExpr expr, AbstractIdentifier ident, ListExpr listExpr){
        this.objectName = expr;
        this.methodName = ident;
        this.listParameters = listExpr;
    }
    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type leftType = this.objectName.verifyExpr(compiler, localEnv, currentClass);
        if(!compiler.getEnvTypes().get(leftType.getName()).isClass()){
            throw new ContextualError("Methods can only be used on objects.", this.objectName.getLocation());
        }
        EnvironmentExp classeAppelanteEnv = ((ClassDefinition)compiler.getEnvTypes().get(leftType.getName())).getMembers();
        this.methodName.verifyExpr(compiler, classeAppelanteEnv, currentClass);
        if(!classeAppelanteEnv.get(methodName.getName()).isMethod()){
            throw new ContextualError(methodName.getName().getName()+" isn't a method.", this.methodName.getLocation());
        }
        this.methodName.setDefinition(((MethodDefinition) classeAppelanteEnv.get(methodName.getName())));
        Signature sign = ((MethodDefinition) classeAppelanteEnv.get(methodName.getName())).getSignature();
        if(sign.size()-1 != this.listParameters.getList().size()){
            throw new ContextualError("Problem in the number of parameters of the function.", this.methodName.getLocation());
        }
        System.out.println(sign.size());
        int i = 1;
        for (AbstractExpr expression: this.listParameters.getList()){
            Type exprType = expression.verifyExpr(compiler, localEnv, currentClass);
            if (!sign.paramNumber(i).sameType(exprType)){
                if(!(sign.paramNumber(i).isFloat() && exprType.isInt())){
                    throw new ContextualError("Method "+methodName.getName().getName()+" expecting "+sign.paramNumber(i).getName().getName()+" received "+exprType.getName().getName(), expression.getLocation());
                }
            }
            if(!((ClassType)exprType).isSubClassOf((ClassType)sign.paramNumber(i))){
                throw new ContextualError("Method "+methodName.getName().getName()+" expecting "+sign.paramNumber(i).getName().getName()+" received "+exprType.getName().getName(), expression.getLocation());
            }
            i++;

        }
        this.setType(sign.paramNumber(0));

        return sign.paramNumber(0);
    }
    @Override
    public int codeGenExpr(DecacCompiler compiler) {
        compiler.addInstruction(new ADDSP(this.listParameters.size()+1));
        compiler.addInstruction(new LOAD(Register.getR(objectName.codeGenExpr(compiler)), Register.getR(0)));
        compiler.addInstruction(new STORE(Register.getR(0), new RegisterOffset(0, Register.SP)));
        int compteur = -1;
        for(AbstractExpr expr : this.listParameters.getList()){
            int reg = expr.codeGenExpr(compiler);
            compiler.addInstruction(new STORE(Register.getR(reg), new RegisterOffset(compteur, Register.SP)));
            compteur --;
        }
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.SP), Register.R1));
        //compiler.addInstruction(new CMP(new NullOperand(),Register.R1));
        //compiler.addInstruction(new BEQ(new Label("deferencement.null")));
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.R1),Register.R1));
        compiler.addInstruction(new BSR(new RegisterOffset(methodName.getMethodDefinition().getIndex()+1, Register.R1)));
        compiler.addInstruction(new SUBSP(this.listParameters.size()+1));
        return 0;
    }
    @Override
    public void decompile(IndentPrintStream s) {
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        objectName.prettyPrint(s, prefix, false);
        methodName.prettyPrint(s, prefix, false);
        listParameters.prettyPrint(s, prefix, false);
        // TODO Auto-generated method stub
        
    }
    @Override
    protected void iterChildren(TreeFunction f) {
        // TODO Auto-generated method stub
        objectName.iterChildren(f);
        methodName.iterChildren(f);
        listParameters.iterChildren(f);
    }

    
}
