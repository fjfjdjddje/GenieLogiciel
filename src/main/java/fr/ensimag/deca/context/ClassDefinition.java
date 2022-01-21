package fr.ensimag.deca.context;

import fr.ensimag.deca.tree.Location;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Operand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;

import org.apache.commons.lang.Validate;

/**
 * Definition of a class.
 *
 * @author gl46
 * @date 01/01/2022
 */
public class ClassDefinition extends TypeDefinition {
    private RegisterOffset adresseSuperClass = new RegisterOffset(1, Register.GB);

 
    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public RegisterOffset getAdresseSuperClass() {
        return adresseSuperClass;
    }

    public void setAdresseSuperClass(RegisterOffset adresseSuperClass) {
        this.adresseSuperClass = adresseSuperClass;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public void incNumberOfFields() {
        this.numberOfFields++;
    }

    public int getNumberOfMethods() {
        return numberOfMethods;
    }

    public void setNumberOfMethods(int n) {
        Validate.isTrue(n >= 0);
        numberOfMethods = n;
    }
    
    public int incNumberOfMethods() {
        numberOfMethods++;
        return numberOfMethods;
    }

    private int numberOfFields = 0;
    private int numberOfMethods = 0;
    
    @Override
    public boolean isClass() {
        return true;
    }
    
    @Override
    public ClassType getType() {
        // Cast succeeds by construction because the type has been correctly set
        // in the constructor.
        return (ClassType) super.getType();
    };

    public ClassDefinition getSuperClass() {
        return superClass;
    }

    private final EnvironmentExp members;
    private final ClassDefinition superClass; 

    public EnvironmentExp getMembers() {
        return members;
    }

    public ClassDefinition(ClassType type, Location location, ClassDefinition superClass) {
        super(type, location);
        EnvironmentExp parent;
        if (superClass != null) {
            parent = superClass.getMembers();
        } else {
            parent = null;
        }
        members = new EnvironmentExp(parent);
        this.superClass = superClass;
        
    }
}
