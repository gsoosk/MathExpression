package Expressions.Primitives.BinaryOperations;

import Expressions.Base.Expression;

public abstract class BinaryOperation extends Expression {
    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

//    @Override
//    public Expression eval(Variable variable, double value) throws VariableHasNotValue{
//
//        Class currentClass = this.getClass();
//        Expression evaluatedObject;
//        try {
//            evaluatedObject = (Expression) currentClass.getConstructor(Expression.class, Expression.class).newInstance(
//                    left.eval(variable, value),
//                    right.eval(variable, value)
//            );
//        } catch (Exception e) {
//            throw new VariableHasNotValue();
//        }
//        return evaluatedObject;
//    }

    protected Expression left;
    protected Expression right;
}
