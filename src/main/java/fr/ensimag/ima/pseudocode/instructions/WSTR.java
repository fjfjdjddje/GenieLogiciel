package fr.ensimag.ima.pseudocode.instructions;

import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateString;
import fr.ensimag.ima.pseudocode.UnaryInstruction;

/**
 * @author Ensimag
 * @date 01/01/2022
 */
public class WSTR extends UnaryInstruction {
    public WSTR(GPRegister gpRegister) {
        super(gpRegister);
    }
    
    public WSTR(String message) {
        super(new ImmediateString(message));
    }
    
}
