package ntnu.idatt2002.cardgame.deckofcardsgame;


import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    private final char[] suit = {'S', 'H', 'D', 'C'};
    private final char[] suitSign = {'♠', '♥', '♦', '♣'};
    private ArrayList<PlayingCard> playingCards;
    private ArrayList<PlayingCard> hand;

    /**
     * Constructor of the deck of cards
     */
    public DeckOfCards(){
        playingCards = new ArrayList<>();
        int suitSignCount = 0;
        for (char c : suit) {
            for (int j = 1; 14 > j; j++) {
                playingCards.add(new PlayingCard(c, j, suitSign[suitSignCount]));
            }
            suitSignCount++;
        }
    }

    /**
     * Gets all the playingcards as an ArrayList
     * @return
     */
    public ArrayList<PlayingCard> getAllPlayingCards(){
        return playingCards;
    }

    /**
     * Gets the hand of the player as an ArrayList
     * @return
     */
    public ArrayList<PlayingCard> getHand(){
        return hand;
    }

    /**
     * Method to deal the hand with a parameter for the number of cards.
     * Removes the cards in the hand from the deck.
     * @param n
     * @return ArrayList
     */
    public ArrayList<PlayingCard> dealHand(int n){
        hand = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; n > i; i++){
            int r = random.nextInt(playingCards.size());
            hand.add(playingCards.get(r));
            playingCards.remove(r);
        }
        return hand;
    }

    /**
     * Method to shuffle cards.
     * Removes the cards from the hand and creates them in the deck.
     */
    public void shuffleCards(){
        while(getHand().size() >= 1){
            playingCards.add(getHand().get(0));
            hand.remove(getHand().get(0));
        }
    }

    /**
     * String which returns the hand
     * @return String
     */
    public String showHand(){
        String cards = "";
        for(PlayingCard playingCard:hand){
            cards += playingCard.getAsSignString() + " ";
        }
        return cards;
    }

    /**
     * Gets the sum of the faces of the hand
     * @return int
     */
    public int getFaceValue(){
        int face = 0;
        for (PlayingCard playingCard : hand) {
            face += playingCard.getFace();
        }
        return face;
    }


    /**
     * Checks if the players hand has a flush -> five cards with the same suit
     * @return String
     */
    public String isFlush(){
        int S = 0;
        int H = 0;
        int D = 0;
        int C = 0;

        for(PlayingCard playingCard : hand){
            if(playingCard.getSuit()=='S'){
                S++;
            } else if(playingCard.getSuit()=='H'){
                H++;
            }else if(playingCard.getSuit()=='D'){
                D++;
            }else{
                C++;
            }
        }

        if(S >= 5){
            return "♠Flush of spades♠";
        }else if(H >= 5){
            return "♥Flush of hearts♥";
        }else if(D >= 5){
            return "♦Flush of diamonds♦";
        }else if (C >= 5){
            return "♣Flush of clubs♣";
        } else{
            return "You do not have a flush";
        }


    }

    /**
     * Checks if the hand has some hearts
     * @return String
     */
    public String isHearts(){
        String hearts = "";
        for(PlayingCard playingCard : hand){
            if(playingCard.getSuit() == 'H'){
                hearts += playingCard.getAsSignString() + " ";
            }
        }
        if(hearts.length() == 0){
            hearts = "There are no hearts";
        }
        return hearts;
    }

    /**
     * Checks if the queen of spades is in the hand
     * @return true/false
     */
    public boolean isQueenOfSpades(){
        for(PlayingCard playingCard : hand){
            if(playingCard.getAsString().equals("S12")){
                return true;
            }
        }
        return false;
    }
}

