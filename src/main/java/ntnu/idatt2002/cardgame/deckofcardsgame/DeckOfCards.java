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

    /*public boolean isRoyalFlush(){

    }
    public boolean isStraightFLush(){

    }
    public boolean isFourOfAKind(){

    }
    public boolean isFullHouse(){

    }
    public boolean isFlush(){

    }
    public boolean isStraight(){

    }
    public boolean isThreeOfAKind(){

    }
    public boolean isTwoPair(){

    }
    public boolean isPair(){

    }
    public boolean highCard(){

    }*/





}

