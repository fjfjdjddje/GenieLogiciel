package fr.ensimag.deca.context;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

import fr.ensimag.deca.tools.SymbolTable.Symbol;

/**
 * Dictionary associating identifier's ExpDefinition to their names.
 * 
 * This is actually a linked list of dictionaries: each EnvironmentExp has a
 * pointer to a parentEnvironment, corresponding to superblock (eg superclass).
 * 
 * The dictionary at the head of this list thus corresponds to the "current" 
 * block (eg class).
 * 
 * Searching a definition (through method get) is done in the "current" 
 * dictionary and in the parentEnvironment if it fails. 
 * 
 * Insertion (through method declare) is always done in the "current" dictionary.
 * 
 * @author gl46
 * @date 01/01/2022
 */
public class EnvironmentExp {
    // A FAIRE : implémenter la structure de donnée représentant un
    // environnement (association nom -> définition, avec possibilité
    // d'empilement).

    EnvironmentExp parentEnvironment;
    protected Map<Symbol,Definition> currentEnvironment =new HashMap<Symbol,Definition>();
    
    public EnvironmentExp(EnvironmentExp parentEnvironment) {
        this.parentEnvironment = parentEnvironment;
    }

    public Map<Symbol,Definition> getCurrentEnvironment(){
        return this.currentEnvironment;
    }

    public void setCurrentEnvironment(Map<Symbol,Definition> currentEnv){
        this.currentEnvironment=currentEnv;
    }
    public static class DoubleDefException extends Exception {
        private static final long serialVersionUID = -2733379901827316441L;
    }

    /**
     * Return the definition of the symbol in the environment, or null if the
     * symbol is undefined.
     */
    public Definition get(Symbol key) {
        //throw new UnsupportedOperationException("not yet implemented");
        EnvironmentExp current= this;
        while(!current.currentEnvironment.containsKey(key)){
            if(current!= null){
                current=current.parentEnvironment;
            }else{
                return null;
                //throw new IllegalArgumentException("Symbol not found ");
            }
        }
        return current.currentEnvironment.get(key);
        
    }

    /**
     * Add the definition def associated to the symbol name in the environment.
     * 
     * Adding a symbol which is already defined in the environment,
     * - throws DoubleDefException if the symbol is in the "current" dictionary 
     * - or, hides the previous declaration otherwise.
     * 
     * @param name
     *            Name of the symbol to define
     * @param def
     *            Definition of the symbol
     * @throws Exception
     *
     */
    public void declare(Symbol name, ExpDefinition def) throws Exception {
        //throw new UnsupportedOperationException("not yet implemented");
        if(this.currentEnvironment.containsKey(name)){
            throw new Exception("DoubleDefException");
        }else{
            this.currentEnvironment.put(name,def);
        }
    }

}
