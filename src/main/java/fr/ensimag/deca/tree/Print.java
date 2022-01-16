package fr.ensimag.deca.tree;

import fr.ensimag.deca.tools.IndentPrintStream;

/**
 * @author gl46
 * @date 01/01/2022
 */
public class Print extends AbstractPrint {
    /**
     * @param arguments arguments passed to the print(...) statement.
     * @param printHex if true, then float should be displayed as hexadecimal (printx)
     */
    public Print(boolean printHex, ListExpr arguments) {
        super(printHex, arguments);
    }
    @Override
    public void decompile(IndentPrintStream s) {
        //throw new UnsupportedOperationException("not yet implemented");
        
        s.print("print(");
        for(AbstractExpr arg : super.getArguments().getList()){
            arg.decompile(s);
        }
        s.print(");");
    }
    @Override
    String getSuffix() {
        return "";
    }
}
