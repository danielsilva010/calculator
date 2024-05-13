package silvadaniel.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController {
    private final Calculator calculator = new Calculator();

    @FXML
    private TextField tfView;

    @FXML
    void keyPressed(KeyEvent event) {
        System.out.println("Key Pressed: " + event.getCode());
        switch (event.getCode()) {
            case NUMPAD0, DIGIT0:
                click0();
                break;
            case NUMPAD1, DIGIT1:
                click1();
                break;
            case NUMPAD2, DIGIT2:
                click2();
                break;
            case NUMPAD3, DIGIT3:
                click3();
                break;
            case NUMPAD4, DIGIT4:
                click4();
                break;
            case NUMPAD5, DIGIT5:
                click5();
                break;
            case NUMPAD6, DIGIT6:
                click6();
                break;
            case NUMPAD7, DIGIT7:
                click7();
                break;
            case NUMPAD8, DIGIT8:
                click8();
                break;
            case NUMPAD9, DIGIT9:
                click9();
                break;
            case ADD:
                plusClick();
                break;
            case SUBTRACT, MINUS:
                minusClick();
                break;
            case MULTIPLY, ASTERISK:
                multiplicationClick();
                break;
            case DIVIDE:
                divideClick();
                break;
            // enter
            case ENTER:
                equalsClick();
                break;
            case DECIMAL:
                decimalClick();
                break;
            case ESCAPE, DELETE, BACK_SPACE:
                clearClick();
                break;
            default:
                break;
        }
    }

    /**
     * Handles the click event for the number 9
     */
    @FXML
    void click9() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "9" : oldText + "9";
        updateView(Double.parseDouble(newText));

    }

    /**
     * Clears the current value and stored value and sets the current operation to NONE
     */
    @FXML
    void clearClick() {
        calculator.setCurrentValue(0);
        calculator.setStoredValue(0);
        calculator.setCurrentOperation(Operations.NONE);
        updateView(0);
    }

    /**
     * Handles the click event for the number 0
     */
    @FXML
    void click0() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "0" : oldText + "0";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 1
     */
    @FXML
    void click1() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "1" : oldText + "1";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 2
     */
    @FXML
    void click2() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "2" : oldText + "2";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 3
     */
    @FXML
    void click3() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "3" : oldText + "3";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 4
     */
    @FXML
    void click4() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "4" : oldText + "4";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 5
     */
    @FXML
    void click5() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "5" : oldText + "5";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 6
     */
    @FXML
    void click6() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "6" : oldText + "6";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 7
     */
    @FXML
    void click7() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "7" : oldText + "7";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the number 8
     */
    @FXML
    void click8() {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "8" : oldText + "8";
        updateView(Double.parseDouble(newText));
    }

    /**
     * Handles the click event for the decimal point
     */
    @FXML
    void decimalClick() {
        String oldText = tfView.getText();
        if (!oldText.contains(".")) {
            String newText = oldText + ".";
            updateView(Double.parseDouble(newText));
            calculator.setCurrentValue(Double.parseDouble(newText));
        }
    }

    /**
     * Handles the click event for the divide operation
     */
    @FXML
    void divideClick() {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.DIVISION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }


    /**
     * Handles the click event for the equals operation
     */
    @FXML
    void equalsClick() {
        String text = tfView.getText();
        if (text.isEmpty()) {
            // Ignore ENTER key press if text field is empty
            return;
        }

        calculator.setCurrentValue(Double.parseDouble(text));
        if (calculator.getCurrentOperation() != Operations.NONE) {
            try {
                double result = calculator.performOperation();
                updateView(result);
                calculator.setCurrentOperation(Operations.NONE);
                calculator.setStoredValue(0.0);
                calculator.setCurrentValue(0.0);
            } catch (ArithmeticException e) {
                // Print an error message and reset the calculator
                calculator.setCurrentOperation(Operations.NONE);
                calculator.setStoredValue(0.0);
                calculator.setCurrentValue(0.0);
                tfView.setText("Error   ");
            }
        } else {
            updateView(calculator.getCurrentValue());
        }
    }

    /**
     * Handles the click event for the multiplication operation
     */
    @FXML
    void minusClick() {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.SUBTRACTION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }

    /**
     * Handles the click event for the multiplication operation
     */
    @FXML
    void multiplicationClick() {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.MULTIPLICATION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }

    /**
     * Handles the click event for the percent operation
     */
    @FXML
    void percentClick() {
        //divide current val by 100
        double value = Double.parseDouble(tfView.getText());
        value /= 100.00;
        updateView(value);
        calculator.setCurrentValue(value);
    }

    /**
     * Handles the click event for the plus operation
     */
    @FXML
    void plusClick() {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.ADDITION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }


    /**
     * Handles the click event for the plus or minus operation
     */
    @FXML
    void plusOrMinusClick() {
        double value = Double.parseDouble(tfView.getText());
        value *= -1;
        updateView(value);
        calculator.setCurrentValue(value);
    }

    /**
     * Handles the click event for the square root operation
     */
    private void performPendingOperation() {
        if (calculator.getCurrentOperation() != Operations.NONE) {
            calculator.setCurrentValue(Double.parseDouble(tfView.getText()));
            double result = calculator.performOperation();
            calculator.setStoredValue(result); // Store the result for the next operation
            updateView(result);
        }
    }

    /**
     * Updates the view with the given value
     *
     * @param value the value to update the view with
     */
    public void updateView(double value) {
        if (value == (long) value) tfView.setText(String.format("%d", (long) value));
        else tfView.setText(String.format("%s", value));
    }

}
