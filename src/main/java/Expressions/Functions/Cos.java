package Expressions.Functions;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.BinaryOperations.Multiply;
import Expressions.Primitives.Const;
import Expressions.Primitives.Variable;

public class Cos extends Function {
    public Cos(Expression input) {
        super(input);
    }

    @Override
    Expression getSelfDeriv() {
        return new Multiply(new Const(-1), new Sin(input));
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return Math.cos(input.eval());
    }
    @Override
    public String toString() {
        return "cos(" + input.toString() + ")";
    }
}