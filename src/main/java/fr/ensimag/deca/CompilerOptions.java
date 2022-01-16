package fr.ensimag.deca;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * User-specified options influencing the compilation.
 *
 * @author gl46
 * @date 01/01/2022
 */
public class CompilerOptions {
    public static final int QUIET = 0;
    public static final int INFO  = 1;
    public static final int DEBUG = 2;
    public static final int TRACE = 3;
    public int getDebug() {
        return debug;
    }

    public int getNombreRegisters() {
        return nombreRegisters;
    }


    public boolean getRegisters() {
        return registers;
    }

    public boolean getNocheck() {
        return nocheck;
    }

    public boolean getVerification() {
        return verification;
    }

    public boolean getParse() {
        return parse;
    }
    public boolean getParallel() {
        return parallel;
    }

    public boolean getPrintBanner() {
        return printBanner;
    }
    
    public List<File> getSourceFiles() {
        return Collections.unmodifiableList(sourceFiles);
    }

    private int debug = 0;
    private boolean parallel = false;
    private boolean printBanner = false;
    private boolean parse = false;
    private boolean verification = false;
    private boolean nocheck = false;
    private boolean registers  = false;
    private int nombreRegisters = 16;
    private List<File> sourceFiles = new ArrayList<File>();

    
    public void parseArgs(String[] args) throws CLIException {
        // A FAIRE : parcourir args pour positionner les options correctement.
        boolean notOption = false;
        for(int i =0;i< args.length ;i++){
            if(String.valueOf(args[i].charAt(0)).equals("-") && !notOption){
                if(args[i].equals("-b")){
                    if(args.length == 1){
                        this.printBanner = true;
                    }else{
                        throw new Error("commande indéfinie");
                    }
                }else if(args[i].equals("-p")){
                    if(!this.verification){
                        this.parse = true;
                    }else{
                        throw new Error("Les options '-p' et '-v' sont incompatibles");
                    } 
                }else if(args[i].equals("-v")){
                    if(!this.parse){
                        this.verification = true;
                    }else{
                        throw new Error("Les options '-p' et '-v' sont incompatibles");
                    }
                }else if(args[i].equals("-n")){
                    this.nocheck = true;
                }else if(args[i].equals("-r")){
                    this.registers = true;
                    i++;
                    try{
                        nombreRegisters = Integer.parseInt(args[i]);
                    }
                    catch(NumberFormatException e){
                        throw new Error("Le nombre de registres doit être un entier.");
                    }
                }else if(args[i].equals("-d")){
                    this.debug++;
                }else if(args[i].equals("-P")){
                    this.parallel = true;
                }else{
                    throw new Error("option non définie");
                }
            }else if (String.valueOf(args[i].charAt(0)).equals("-") && notOption){
                throw new Error("commande indéfinie");
            }else{
                File file = new File(args[i]);
                sourceFiles.add(file);
                notOption = true;
            }
        }
        Logger logger = Logger.getRootLogger();
        // map command-line debug option to log4j's level.
        switch (getDebug()) {
        case QUIET: break; // keep default
        case INFO:
            logger.setLevel(Level.INFO); break;
        case DEBUG:
            logger.setLevel(Level.DEBUG); break;
        case TRACE:
            logger.setLevel(Level.TRACE); break;
        default:
            logger.setLevel(Level.ALL); break;
        }
        logger.info("Application-wide trace level set to " + logger.getLevel());

        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (assertsEnabled) {
            logger.info("Java assertions enabled");
        } else {
            logger.info("Java assertions disabled");
        }

        //throw new UnsupportedOperationException("not yet implemented");
    }

    protected void displayUsage() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
