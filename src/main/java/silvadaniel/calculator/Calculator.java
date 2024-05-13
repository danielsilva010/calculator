package silvadaniel.calculator;

public class Calculator {
    private double currentValue;
    private double storedValue;
    private Operations currentOperation;
    private boolean isError;

    // arithmetic operations
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public double performOperation() {
        if (currentOperation == null) {
            return currentValue;
        }
        switch (currentOperation) {
            case ADDITION:
                return add(storedValue, currentValue);
            case SUBTRACTION:
                return subtract(storedValue, currentValue);
            case MULTIPLICATION:
                return multiply(storedValue, currentValue);
            case DIVISION:
                return divide(storedValue, currentValue);
            default:
                return currentValue;
        }
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(double storedValue) {
        this.storedValue = storedValue;
    }

    public Operations getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(Operations currentOperation) {
        this.currentOperation = currentOperation;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}