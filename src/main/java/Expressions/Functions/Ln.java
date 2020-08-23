package Expressions.Functions;

import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Primitives.BinaryOperations.Div;
import Expressions.Primitives.Const;
import Expressions.Primitives.Variable;

public class Ln extends Function{
    public Ln(Expression input) {
        super(input);
    }

    @Override
    Expression getSelfDeriv() {
        return new Div(new Const(1), input);
    }

    @Override
    public double eval() throws VariableHasNotValue {
        return Math.log(input.eval());
    }

    @Override
    public String toString() {
        return "ln( " + input.toString() + ")";
    }
}
