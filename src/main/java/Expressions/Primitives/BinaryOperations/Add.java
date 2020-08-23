package Expressions.Primitives.BinaryOperations;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.Variable;

public class Add extends BinaryOperation {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Expression deriv(Variable var) {
        return new Add(left.deriv(var) , right.deriv(var));
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return left.eval() + right.eval();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}
