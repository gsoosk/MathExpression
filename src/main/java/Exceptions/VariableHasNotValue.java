package Exceptions;

public class VariableHasNotValue extends Exception {
    public VariableHasNotValue(String variableName) {
        super("variable " + variableName + "has not value in this expression. Set a value for this variable before.");
    }
}
