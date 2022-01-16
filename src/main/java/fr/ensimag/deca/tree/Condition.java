package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
public interface Condition{


    public  void codeGenCond(DecacCompiler compiler, Label lab2);

}
