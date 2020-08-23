package Expressions.Functions;

import Expressions.Base.Expression;
import Expressions.Primitives.BinaryOperations.Multiply;
import Expressions.Primitives.Variable;

abstract class Function extends Expression {
    Function(Expression input) {
        this.input = input;
    }

    @Override
    public Expression deriv(Variable var) {
        return new Multiply(getSelfDeriv(), input.deriv(var));
    }
    abstract Expression getSelfDeriv();
    Expression input;
}
