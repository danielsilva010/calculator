package silvadaniel.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private Calculator calculator = new Calculator();

    @FXML
    private Button Button0;

    @FXML
    private TextField tfView;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button clearButton;

    @FXML
    private Button click9;

    @FXML
    private Button decimalButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button multiplicationButton;

    @FXML
    private Button percentButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button plusOrMinusButton;

    @FXML
    void button9(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "9" : oldText + "9";
        calculator.setCurrentValue(9);
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
        calculator.setCurrentValue(0);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click1(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "1" : oldText + "1";
        calculator.setCurrentValue(1);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click2(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "2" : oldText + "2";
        calculator.setCurrentValue(2);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click3(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "3" : oldText + "3";
        calculator.setCurrentValue(3);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click4(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "4" : oldText + "4";
        calculator.setCurrentValue(4);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click5(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "5" : oldText + "5";
        calculator.setCurrentValue(5);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click6(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "6" : oldText + "6";
        calculator.setCurrentValue(6);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click7(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "7" : oldText + "7";
        calculator.setCurrentValue(7);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void click8(ActionEvent event) {
        String oldText = tfView.getText();
        String newText = oldText.equals("0") ? "8" : oldText + "8";
        calculator.setCurrentValue(8);
        updateView(Double.parseDouble(newText));
    }

    @FXML
    void decimalClick(ActionEvent event) {

    }

    @FXML
    void divideClick(ActionEvent event) {

    }

    @FXML
    void equalsClick(ActionEvent event) {

    }

    @FXML
    void minusClick(ActionEvent event) {

    }

    @FXML
    void multiplicationClick(ActionEvent event) {

    }

    @FXML
    void percentClick(ActionEvent event) {

    }

    @FXML
    void plusClick(ActionEvent event) {

    }

    @FXML
    void plusOrMinusClick(ActionEvent event) {

    }

    public void updateView(double value) {
        tfView.setText(String.format("%.0f", value));
    }

}
