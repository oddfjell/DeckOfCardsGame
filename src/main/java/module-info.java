module ntnu.idatt2002.cardgame.deckofcardsgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens ntnu.idatt2002.cardgame.deckofcardsgame to javafx.fxml;
    exports ntnu.idatt2002.cardgame.deckofcardsgame;
}