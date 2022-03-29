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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DeckOfCards deckOfCards = new DeckOfCards();
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
        //stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("Pictures/pngwing.com")));
        //stage.setFullScreen(true);
        stage.setScene(scene);
        gridpane.setPadding(new Insets(25,25,25,25));
        gridpane.setHgap(50);
        gridpane.setVgap(10);
        gridpane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0))));


        /**
         * The text
         */

        Text hand = new Text();
        Text hearts = new Text();
        hearts.setText("Hearts: ");
        gridpane.add(hearts,0,4);


        /**
         * NO no
         */

        InputStream no = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\king-dice-cuphead.png");
        Image imageNo = new Image(no);
        ImageView imageViewNo = new ImageView();
        imageViewNo.setImage(imageNo);
        imageViewNo.setFitWidth(100);//575
        imageViewNo.setPreserveRatio(true);

        /**
         * Buttons
         */

        Button button = new Button();
        button.setText("Deal Hand");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Faen");
                deckOfCards.dealHand(5);
                hand.setText(deckOfCards.showHand());
                gridpane.add(hand,1,1);
                gridpane.getChildren().remove(imageViewNo);
                gridpane.add(imageViewNo,0,2);

                gridpane.getChildren().remove(hearts);
                hearts.setText("Hearts: " + deckOfCards.isHearts());
                gridpane.add(hearts,0,4);
            }
        });

        /*Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction(e -> System.exit(0));*/


        Button remove = new Button();
        remove.setText("Remove Hand");
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Faen");
                gridpane.getChildren().remove(hand);
                deckOfCards.shuffleCards();
                gridpane.getChildren().remove(imageViewNo);
                gridpane.add(imageViewNo,0,3);

                gridpane.getChildren().remove(hearts);
                hearts.setText("Hearts: ");
                gridpane.add(hearts,0,4);

            }
        });

        /**
         * Box
         */

        //addTeam.setAlignment(Pos.BOTTOM_LEFT);

        //TextField textField = new TextField ();

        PhongMaterial purple = new PhongMaterial();
        purple.setDiffuseColor(Color.MEDIUMPURPLE);
        purple.setSpecularColor(Color.PURPLE);
        Box box = new Box(400.0, 300.0,0.0);//400 og 300
        box.setMaterial(purple);

        /**
         * Title
         */

        Text title = new Text();
        title.setText("Gambling");
        title.setFont(Font.font ("Comic Sans MS", 30));
        title.setFill(Color.MEDIUMPURPLE);

        /**
         * Image and icon
         */

        //InputStream stream = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\mrDice2.png");
        InputStream stream = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\mrDice.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //imageView.setX(10);
        //imageView.setY(10);
        imageView.setFitWidth(300);//575
        imageView.setPreserveRatio(true);
        //Image image = new Image("");
        //gridpane.add(image, 2, 2);


        InputStream icon = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\mrDice.png");
        Image imageIcon = new Image(icon);
        ImageView imageViewIcon = new ImageView();
        imageViewIcon.setImage(imageIcon);
        stage.getIcons().add(imageIcon);


        /**
         * The children
         */

        gridpane.add(button, 0,2);
        gridpane.add(box,1,1);
        //gridpane.add(exit, 1,2);
        gridpane.add(title,0,0);
        gridpane.add(remove, 0,3);
        gridpane.add(imageView,0,1);
        gridpane.add(imageViewNo,0,3);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}