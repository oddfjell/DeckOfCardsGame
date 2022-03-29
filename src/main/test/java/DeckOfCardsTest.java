import ntnu.idatt2002.cardgame.deckofcardsgame.DeckOfCards;
import ntnu.idatt2002.cardgame.deckofcardsgame.PlayingCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckOfCardsTest {
    @Test
    public void cardTest(){
        DeckOfCards deckOfCards = new DeckOfCards();

        assertEquals(52, deckOfCards.getAllPlayingCards().size());
    }

    @Test
    public void getDealHandTest(){
        DeckOfCards deckOfCards = new DeckOfCards();

        //Checks if hand is taken from the stack
        deckOfCards.dealHand(5);
        //assertEquals(5, deckOfCards.dealHand(5).size());
        assertEquals(5, deckOfCards.getHand().size());
        assertEquals(47,deckOfCards.getAllPlayingCards().size());
        System.out.println(deckOfCards.isHearts());
        //System.out.println(deckOfCards.getHand().get(0).getAsString());
    }

    @Test
    public void shuffleTest(){
        DeckOfCards deckOfCards = new DeckOfCards();

        deckOfCards.dealHand(5);
        assertEquals(47,deckOfCards.getAllPlayingCards().size());
        deckOfCards.shuffleCards();
        assertEquals(52,deckOfCards.getAllPlayingCards().size());
        assertEquals(0,deckOfCards.getHand().size());
    }

   /* @Test
    public void isFourOfAKIndTest(){
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.setHand("H6");
        deckOfCards.setHand("S6");
        deckOfCards.setHand("D6");
        deckOfCards.setHand("C6");
        deckOfCards.setHand("C3");
        //assertTrue(deckOfCards.isFourOfAKind());
        assertEquals(47,deckOfCards.getAllPlayingCards());
    }

    @Test
    public void setHandTest(){
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.setHand("H6");
        assertEquals(1, deckOfCards.getHand().size());
        //assertEquals(51,deckOfCards.getAllPlayingCards());
    }*/
}


