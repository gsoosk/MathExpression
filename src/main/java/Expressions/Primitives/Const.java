package Expressions.Primitives;


import Expressions.Base.Expression;

public class Const extends Expression {

    public Const(double value) {
        this.value = value;
    }

    @Override
    public Expression deriv(Variable ignored) {
        return new Const(0);
    }

//    @Override
//    public Expression eval(Variable variable, double value) {
//        return new Const(this.value);
//    }

    @Override
    public double eval() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    private double value;
}
