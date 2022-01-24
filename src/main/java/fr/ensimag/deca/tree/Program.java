package fr.ensimag.deca.tree;

import java.io.PrintStream;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.BooleanType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.context.IntType;
import fr.ensimag.deca.context.TypeDefinition;
import fr.ensimag.deca.context.VoidType;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.HALT;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.SEQ;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

/**
 * Deca complete program (class definition plus main block)
 *
 * @author gl46
 * @date 01/01/2022
 */
public class Program extends AbstractProgram {
    private static final Logger LOG = Logger.getLogger(Program.class);
    
    
    public Program(ListDeclClass classes, AbstractMain main) {
        Validate.notNull(classes);
        Validate.notNull(main);
        this.classes = classes;
        this.main = main;
        
        //typeEnv.put(new Symbol("Object"),);    
    }
    public ListDeclClass getClasses() {
        return classes;
    }
    public AbstractMain getMain() {
        return main;
    }
    private ListDeclClass classes;
    private AbstractMain main;

    @Override
    public void verifyProgram(DecacCompiler compiler) throws ContextualError {
        //LOG.debug("verify program: start");
        //throw new UnsupportedOperationException("not yet implemented");

        classes.verifyListClass(compiler);
        classes.verifyListClassMembers(compiler);
        classes.verifyListClassBody(compiler);
        main.verifyMain(compiler);
        //LOG.debug("verify program: end");
    }

    @Override
    public void codeGenProgram(DecacCompiler compiler) {
        // A FAIRE: compléter ce squelette très rudimentaire de code
        if(!compiler.getCompilerOptions().getNocheck()){
            compiler.addInstruction(new BRA(compiler.getLabelDebutProg()));
            compiler.addLabel(compiler.getLabelDivErreur());
            compiler.addInstruction(new WSTR("Arret de l'execution: division par zéro impossible."));
            compiler.addInstruction(new HALT());
            compiler.addLabel(compiler.getLabelDebutProg());
        }
        compiler.addComment("Main program");
        classes.codeGenListDeclClass(compiler);
        compiler.addInstruction(new BRA(new Label("debutMain")));
        classes.codeGenInitFields(compiler);
        classes.codeGenMethods(compiler);
        compiler.addLabel(new Label("debutMain"));
        main.codeGenMain(compiler);
        /*compiler.addLabel(compiler.getLabFalse());
        compiler.addInstruction(new WSTR("False"));
        compiler.addLabel(compiler.getLabTrue());
        compiler.addInstruction(new WSTR("True"));*/
        compiler.addInstruction(new HALT());
        //Messages des erreures
        compiler.addLabel(new Label("code.Object.equals"));
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R0));
        compiler.addInstruction(new LOAD(new RegisterOffset(-3, Register.LB), Register.R1));
        compiler.addInstruction(new CMP(Register.R0, Register.R1));
        compiler.addInstruction(new SEQ(Register.getR(0)));
        compiler.addInstruction(new RTS());
        compiler.addLabel(new Label("code.instanceOf"));
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R0));
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.R0), Register.R0));
        compiler.addInstruction(new LOAD(new RegisterOffset(-3, Register.LB), Register.R1));
        compiler.addInstruction(new CMP(Register.R0, Register.R1));
        compiler.addInstruction(new SEQ(Register.getR(0)));
        compiler.addInstruction(new RTS());
        compiler.addLabel(new Label("deferencement_null"));
        compiler.addInstruction(new WSTR("Erreur : deferencement_null"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
        compiler.addLabel(new Label("pile_pleine"));
        compiler.addInstruction(new WSTR("Erreur : pile_pleine"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
        compiler.addLabel(new Label("tas_pleine"));
        compiler.addInstruction(new WSTR("Erreur : tas_pleine"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }

    @Override
    public void decompile(IndentPrintStream s) {
        //getClasses().decompile(s);
        getMain().decompile(s);
    }
    
    @Override
    protected void iterChildren(TreeFunction f) {
        classes.iter(f);
        main.iter(f);
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        classes.prettyPrint(s, prefix, false);
        main.prettyPrint(s, prefix, true);
    }
}
