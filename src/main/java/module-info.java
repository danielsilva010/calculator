module silvadaniel.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens silvadaniel.calculator to javafx.fxml;
    exports silvadaniel.calculator;
}