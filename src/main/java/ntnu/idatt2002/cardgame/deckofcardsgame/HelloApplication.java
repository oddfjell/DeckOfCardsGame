package ntnu.idatt2002.cardgame.deckofcardsgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //original
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("DeckOfCards!");
        stage.setScene(scene);
        stage.show();*/

        //does also work
        /*Text text = new Text(10, 40, "Hello World!");
        text.setFont(new Font(40));
        Scene scene = new Scene(new Group(text));

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();*/

        GridPane gridpane = new GridPane();
        Scene scene = new Scene(gridpane,800, 600);
        stage.setTitle("DeckOfCards");
        //stage.setFullScreen(true);
        stage.setScene(scene);
        gridpane.setPadding(new Insets(25,25,25,25));
        gridpane.setHgap(150);
        gridpane.setVgap(10);



        Button button = new Button();
        button.setText("Add team");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Faen");
                gridpane.add(new Text(10,40,"elo"),0,1);
            }
        });


        Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction(e -> System.exit(0));

        //addTeam.setAlignment(Pos.BOTTOM_LEFT);

        //TextField textField = new TextField ();

        PhongMaterial grey = new PhongMaterial();
        grey.setDiffuseColor(Color.YELLOW);
        grey.setSpecularColor(Color.RED);
        Box box = new Box(125.0, 50.0,0.0);
        box.setMaterial(grey);

        Text title = new Text();
        title.setText("Gambling");
        title.setFont(Font.font ("Comic Sans MS", 30));
        title.setFill(Color.YELLOWGREEN);
        gridpane.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));


        gridpane.add(button, 0,6);
        gridpane.add(box,0,2);
        gridpane.add(exit, 0,5);
        gridpane.add(title,0,0);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}