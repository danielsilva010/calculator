package silvadaniel.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private final Calculator calculator = new Calculator();

    @FXML
    private TextField tfView;

    @FXML
    void button9(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "9" : oldText + "9";
        updateView(Double.parseDouble(newText));

    }

    @FXML
    void clearClick(ActionEvent event) {
        calculator.setCurrentValue(0);
        calculator.setStoredValue(0);
        calculator.setCurrentOperation(Operations.NONE);
        updateView(0);
    }

    @FXML
    void click0(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "0" : oldText + "0";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click1(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "1" : oldText + "1";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click2(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "2" : oldText + "2";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click3(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "3" : oldText + "3";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click4(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "4" : oldText + "4";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click5(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "5" : oldText + "5";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click6(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "6" : oldText + "6";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click7(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "7" : oldText + "7";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click8(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "8" : oldText + "8";
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void decimalClick(ActionEvent event) {
        String oldText = tfView.getText();
        if (!oldText.contains(".")) {
            String newText = oldText + ".";
            updateView(Double.parseDouble(newText));
            calculator.setCurrentValue(Double.parseDouble(newText));
        }
    }

    @FXML
    void divideClick(ActionEvent event) {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.DIVISION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }


    @FXML
    void equalsClick(ActionEvent event) {
        calculator.setCurrentValue(Double.parseDouble(tfView.getText()));
        if (calculator.getCurrentOperation() != Operations.NONE) {
            double result = calculator.performOperation();
            updateView(result);
            calculator.setCurrentOperation(Operations.NONE);
            calculator.setStoredValue(0.0);
            calculator.setCurrentValue(0.0);
        } else {
            updateView(calculator.getCurrentValue());
        }
    }

    @FXML
    void minusClick(ActionEvent event) {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.SUBTRACTION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }

    @FXML
    void multiplicationClick(ActionEvent event) {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.MULTIPLICATION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }

    @FXML
    void percentClick(ActionEvent event) {
        //divide current val by 100
        double value = Double.parseDouble(tfView.getText());
        value /= 100.00;
        updateView(value);
        calculator.setCurrentValue(value);
    }

    @FXML
    void plusClick(ActionEvent event) {
        performPendingOperation();
        calculator.setCurrentOperation(Operations.ADDITION);
        calculator.setStoredValue(Double.parseDouble(tfView.getText()));
        tfView.setText("0");
    }


    @FXML
    void plusOrMinusClick(ActionEvent event) {
        double value = Double.parseDouble(tfView.getText());
        value *= -1;
        updateView(value);
        calculator.setCurrentValue(value);
    }

    private void performPendingOperation() {
        if (calculator.getCurrentOperation() != Operations.NONE) {
            calculator.setCurrentValue(Double.parseDouble(tfView.getText()));
            double result = calculator.performOperation();
            calculator.setStoredValue(result); // Store the result for the next operation
            updateView(result);
        }
    }

    public void updateView(double value) {
        if (value == (long) value) tfView.setText(String.format("%d", (long) value));
        else tfView.setText(String.format("%s", value));
    }

}
