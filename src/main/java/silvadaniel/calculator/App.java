package silvadaniel.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

/**
 * Main point of entry for the JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * Starts the JavaFX application
     *
     * @param stage the stage to start the application
     */
    @Override
    public void start(Stage stage) {
        loadMain(stage);
    }

    /**
     * Loads the main view of the application
     *
     * @param stage the stage to load the view into
     */
    public void loadMain(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/silvadaniel/calculator/calculatorView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    CalculatorController calculatorController = fxmlLoader.getController();
                    calculatorController.equalsClick();
                    event.consume();
                }
            });
            stage.setTitle("Calculator");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading calculator");
            alert.setContentText("An error occurred while loading the calculator. Please try again.");
        }
    }
}