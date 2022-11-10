package risk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Controller().getVieuw(), 1600, 1000);
        scene.getStylesheets().add("hex.css");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/game.png")));
        stage.setTitle("Risk!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}