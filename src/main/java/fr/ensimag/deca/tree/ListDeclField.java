package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

/**
 * List of declarations (e.g. int x; float y,z).
 * 
 * @author gl46
 * @date 01/01/2022
 */
public class ListDeclField extends TreeList<AbstractDeclField> {
    private Visibility visibility = Visibility.PUBLIC;
    public Visibility getVisibility() {
        return visibility;
    }
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }


    @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("Not yet implemented");
       /* for (AbstractDeclField i : getList()) {
            i.decompile(s);
        }*/

    }
  
    void verifyListDeclField(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
              /*  System.out.println("verify listDeclField: start");
                for( AbstractDeclField DeclField : this.getList()){
                    DeclField.verifyDeclField(compiler, localEnv, currentClass);
                }
                System.out.println("verify listDeclField: end");*/
    }
    public void codeGenListField(DecacCompiler compiler) {
       /* for (AbstractDeclField i : getList()) {
            i.codeGenDeclField(compiler);
        }*/
    }
    /*@Override
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
*/
}
