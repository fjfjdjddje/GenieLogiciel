package fr.ensimag.deca.context;

import fr.ensimag.deca.tree.Location;

/**
 * Definition of a method parameter.
 *
 * @author gl46
 * @date 01/01/2022
 */
public class ParamDefinition extends ExpDefinition {

    private int paramOrder = 1;
    public ParamDefinition(Type type, Location location) {
        super(type, location);
    }



    public int getParamOrder() {
        return paramOrder;
    }



    public void setParamOrder(int paramOrder) {
        this.paramOrder = paramOrder;
    }



    @Override
    public String getNature() {
        return "parameter";
    }

    @Override
    public boolean isExpression() {
        return true;
    }

    @Override
    public boolean isParam() {
        return true;
    }

}
