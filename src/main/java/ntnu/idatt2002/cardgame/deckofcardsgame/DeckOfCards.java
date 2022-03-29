package ntnu.idatt2002.cardgame.deckofcardsgame;


import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    private final char[] suit = {'S', 'H', 'D', 'C'};
    private ArrayList<PlayingCard> playingCards;

    public DeckOfCards(){
        playingCards = new ArrayList<>();
        for (char c : suit) {
            for (int j = 1; 14 > j; j++) {
                playingCards.add(new PlayingCard(c, j));
            }
        }
    }

    public ArrayList<PlayingCard> getAllPlayingCards(){
        return playingCards;
    }

    public ArrayList<PlayingCard> dealHand(int n){
        ArrayList<PlayingCard> hand = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; n > i; i++){
            int r = random.nextInt(playingCards.size());
            hand.add(playingCards.get(r));
            playingCards.remove(r);
        }
        return hand;
    }

    public boolean isRoyalFlush(){
        return false;
    }
    public boolean isStraightFLush(){
        return false;
    }
    public boolean isFourOfAKind(){
        return false;
    }
    public boolean isFullHouse(){
        return false;
    }
    public boolean isFlush(){
        return false;
    }
    public boolean isStraight(){
        return false;
    }
    public boolean isThreeOfAKind(){
        return false;
    }
    public boolean isTwoPair(){
        return false;
    }
    public boolean isPair(){
        return false;
    }
    public boolean highCard(){
        return false;
    }





}

