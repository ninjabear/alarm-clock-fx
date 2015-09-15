package core;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Platform.setImplicitExit(true);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml_main.fxml"));
        primaryStage.setTitle("AlarmClock");
        Rectangle2D screen = Screen.getPrimary().getBounds();
        Scene s = new Scene(root, screen.getWidth(), screen.getHeight());
        s.getStylesheets().add("/style.css");
        primaryStage.setScene(s);
        primaryStage.setFullScreen(true);
        
        primaryStage.show();

    }

    @Override
    public void stop()
    {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
