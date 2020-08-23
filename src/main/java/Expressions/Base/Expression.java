package Expressions.Base;

import Exceptions.VariableHasNotValue;
import Expressions.Primitives.Variable;

interface Derivation {
    Expression deriv(Variable var);
}

interface Evaluation {
    double eval() throws VariableHasNotValue;
}

public abstract class Expression implements Derivation, Evaluation {
    public abstract Expression deriv(Variable var);
    public abstract double eval() throws VariableHasNotValue;
}
