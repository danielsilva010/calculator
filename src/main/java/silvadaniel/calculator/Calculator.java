package silvadaniel.calculator;

/*
 * Calculator model for controller to manipulate
 */
public class Calculator {
    private double currentValue;
    private double storedValue;
    private Operations currentOperation;
    private boolean isError;

    /**
     * Adds two numbers, a and b and returns the result
     *
     * @param a first number to add, a double value
     * @param b second number to add, a double value
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers, a and b and returns the result
     *
     * @param a first number to subtract, a double value
     * @param b second number to subtract, a double value
     * @return the difference of a and b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers, a and b and returns the result
     *
     * @param a first number to multiply, a double value
     * @param b second number to multiply, a double value
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers, a and b and returns the result
     *
     * @param a first number to divide, a double value
     * @param b second number to divide, a double value
     * @return the quotient of a and b
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Performs the operation based on the current operation and returns the result
     *
     * @return the result of the operation
     */
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