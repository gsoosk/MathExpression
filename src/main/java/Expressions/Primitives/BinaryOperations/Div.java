package Expressions.Primitives.BinaryOperations;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.Variable;

public class Div extends BinaryOperation {
    public Div(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Expression deriv(Variable var) {
        Expression numerator = new Sub(
                new Multiply(left.deriv(var), right),
                new Multiply(left, right.deriv(var))
        );
        Expression denominator = new Multiply(right, right);
        return new Div(numerator, denominator);
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return left.eval() / right.eval();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }
}
