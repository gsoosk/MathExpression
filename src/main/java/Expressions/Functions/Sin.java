package Expressions.Functions;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.Variable;

public class Sin extends Function {
    public Sin(Expression input) {
        super(input);
    }

    @Override
    Expression getSelfDeriv() {
        return new Cos(input);
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return Math.sin(input.eval());
    }

    @Override
    public String toString() {
        return "sin(" + input.toString() + ")";
    }
}
