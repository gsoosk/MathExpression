package Expressions.Primitives;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
// TODO: Think about eval!
public class Variable extends Expression  {
    public Variable(String name) {
        this.name = name;
        this.value = 0;
        this.validValue = false;
    }

    public void setValue(double value) {
        this.value = value;
        this.validValue = true;
    }

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
        this.validValue = true;
    }

    @Override
    public Expression deriv(Variable variable) {
        if (variable == this)
            return new Const(1);
        return new Const(0);
    }

//    @Override
//    public Expression eval(Variable variable, double value) {
//        if (variable == this)
//            return new Const(value);
//        else
//            return new Variable(name, this.value);
//    }

    @Override
    public double eval() throws VariableHasNotValue {
        if(validValue)
            return value;
        throw new VariableHasNotValue(name);
    }

    @Override
    public String toString() {
        return validValue ? name + ":" + value : name;
    }

    private String name;
    private double value;
    private boolean validValue;
}
