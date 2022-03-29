import ntnu.idatt2002.cardgame.deckofcardsgame.DeckOfCards;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class DeckOfCardsTest {
    @Test
    public void cardTest(){
        DeckOfCards deckOfCards = new DeckOfCards();

        assertEquals(52, deckOfCards.getAllPlayingCards().size());
    }
}


