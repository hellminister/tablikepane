package ca.dauqui.test;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var scene2 = new PlayArea();

        stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}