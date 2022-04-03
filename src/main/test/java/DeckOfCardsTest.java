import ntnu.idatt2002.cardgame.deckofcardsgame.DeckOfCards;
import org.junit.jupiter.api.Test;

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

        deckOfCards.dealHand(5);
        assertEquals(5, deckOfCards.getHand().size());
        assertEquals(47,deckOfCards.getAllPlayingCards().size());
        System.out.println(deckOfCards.isHearts());
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
}


