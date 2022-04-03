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

public class CardsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /**
         * Here the pane, scene and stage is initialized
         */
        DeckOfCards deckOfCards = new DeckOfCards();
        GridPane gridpane = new GridPane();
        Scene scene = new Scene(gridpane,675, 650);//800 600

        stage.setTitle("DeckOfCards");
        stage.setScene(scene);

        gridpane.setPadding(new Insets(25,25,25,25));
        gridpane.setHgap(50);
        gridpane.setVgap(10);
        gridpane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0))));


        /**
         * Makes the text on the pane
         */
        String heartsText = "Hearts: ";
        String sumText = "Sum of your faces: ";
        String isQueenOfSpadesText = "Is the Queen of Spades here?: ";
        String flushText = "Flush?: ";

        Text hand = new Text();
        hand.setFont(Font.font ("Comic Sans MS", 30));

        Text hearts = new Text();
        checkHandText(gridpane,hearts,heartsText,0,4);

        Text sum = new Text();
        checkHandText(gridpane,sum,sumText,0,5);

        Text isQueenOfSpades = new Text();
        checkHandText(gridpane,isQueenOfSpades,isQueenOfSpadesText,0,6);

        Text flush = new Text();
        checkHandText(gridpane,flush,flushText,0,7);


        /**
         * Gif import
         */

        InputStream no = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\king-dice-cuphead.png");
        Image imageNo = new Image(no);
        ImageView imageViewNo = new ImageView();
        imageViewNo.setImage(imageNo);
        imageViewNo.setFitWidth(100);//575
        imageViewNo.setPreserveRatio(true);

        /**
         *Here the buttons are initialised
         */

        Button button = new Button();
        button.setText("Deal Hand");
        gridpane.add(button, 0,2); //TODO flyttet på den

        Button remove = new Button();
        remove.setText("Remove Hand");


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deckOfCards.dealHand(5);
                hand.setText(deckOfCards.showHand());
                gridpane.add(hand,1,1);

                gridpane.getChildren().remove(button);
                gridpane.add(remove, 0,2);

                gridpane.getChildren().remove(hearts);
                hearts.setText(heartsText + deckOfCards.isHearts());
                gridpane.add(hearts,0,4);

                gridpane.getChildren().remove(sum);
                sum.setText(sumText + deckOfCards.getFaceValue());
                gridpane.add(sum,0,5);

                gridpane.getChildren().remove(isQueenOfSpades);
                isQueenOfSpades.setText(isQueenOfSpadesText + deckOfCards.isQueenOfSpades());
                gridpane.add(isQueenOfSpades,0,6);

                gridpane.getChildren().remove(flush);
                flush.setText(flushText + deckOfCards.isFlush());
                gridpane.add(flush,0,7);

            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gridpane.getChildren().remove(hand);
                deckOfCards.shuffleCards();

                gridpane.getChildren().remove(remove);
                gridpane.add(button, 0,2);

                removeText(gridpane,hearts,heartsText,0,4);
                removeText(gridpane,sum,sumText,0,5);
                removeText(gridpane,isQueenOfSpades,isQueenOfSpadesText,0,6);
                removeText(gridpane,flush,flushText,0,7);

            }
        });

        /**
         * The box used to mark where you can se the hand
         */

        PhongMaterial purple = new PhongMaterial();
        purple.setDiffuseColor(Color.MEDIUMPURPLE);
        purple.setSpecularColor(Color.PURPLE);
        Box box = new Box(275.0, 50.0,0.0);//400 og 300
        box.setMaterial(purple);

        /**
         * Title text
         */

        Text title = new Text();
        title.setText("Poker");
        title.setFont(Font.font ("Comic Sans MS", 30));
        title.setFill(Color.MEDIUMPURPLE);

        /**
         * Image and icon
         */

        InputStream stream = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\mrDice.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(300);//575
        imageView.setPreserveRatio(true);

        InputStream icon = new FileInputStream("src\\main\\java\\ntnu\\idatt2002\\cardgame\\deckofcardsgame\\mrDice.png");
        Image imageIcon = new Image(icon);
        ImageView imageViewIcon = new ImageView();
        imageViewIcon.setImage(imageIcon);
        stage.getIcons().add(imageIcon);


        /**
         * TAdding the objects to the pane
         */


        gridpane.add(box,1,1);
        gridpane.add(title,0,0);
        gridpane.add(imageView,0,1);
        gridpane.add(imageViewNo,0,3);


        stage.show();
    }

    /**
     * Launches the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Method to get text
     * @param gridpane
     * @param t
     * @param s
     * @param column
     * @param row
     */
    public void checkHandText(GridPane gridpane, Text t, String s, int column, int row){
        t.setFont(Font.font ("Comic Sans MS", 15));
        t.setText(s);
        gridpane.add(t,column,row);
    }

    /**
     * Method to remove text
     * @param gridpane
     * @param t
     * @param s
     * @param column
     * @param row
     */
    public void removeText(GridPane gridpane, Text t, String s, int column, int row){
        gridpane.getChildren().remove(t);
        t.setText(s);
        gridpane.add(t,column,row);
    }
}