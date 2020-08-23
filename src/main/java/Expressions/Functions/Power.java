package Expressions.Functions;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.BinaryOperations.Multiply;
import Expressions.Primitives.Const;
import Expressions.Primitives.Variable;

public class Power extends Function {
    public Power(Expression input, double exponent) {
        super(input);
        this.exponent = exponent;
    }

    @Override
    Expression getSelfDeriv() {
        return new Multiply(new Const(exponent) , new Power(input, exponent-1));
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return Math.pow(input.eval(), this.exponent);
    }

    @Override
    public String toString() {
        return "(" + input.toString() + ") ^ " + exponent;
    }

    private double exponent;
}
