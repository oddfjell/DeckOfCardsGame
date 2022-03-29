package ntnu.idatt2002.cardgame.deckofcardsgame;


import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    private final char[] suit = {'S', 'H', 'D', 'C'};
    private ArrayList<PlayingCard> playingCards;
    private ArrayList<PlayingCard> hand;

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
    public ArrayList<PlayingCard> getHand(){
        return hand;
    }

    public ArrayList<PlayingCard> setHand(String string){
        for(PlayingCard playingCard:playingCards){
            if(playingCard.getAsString().equals(string)){
                hand.add(playingCard);
                playingCards.remove(playingCard);
            }
        }
        return hand;
    }

    public ArrayList<PlayingCard> dealHand(int n){
        //ArrayList<PlayingCard> hand = new ArrayList<>();
        hand = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; n > i; i++){
            int r = random.nextInt(playingCards.size());
            hand.add(playingCards.get(r));
            playingCards.remove(r);
        }
        return hand;
    }

    public void shuffleCards(){
        /*for(int i = 0; i < getHand().size(); i++){
            playingCards.add(getHand().get(i));
            hand.remove(getHand().get(i));
            //playingCards.add(playingCard);
            //hand.remove(playingCard);
            ////PlayingCard playingCard : hand
        }*/

        while(getHand().size() >= 1){
            playingCards.add(getHand().get(0));
            hand.remove(getHand().get(0));
        }
    }

    public String showHand(){
        String cards = "";
        for(PlayingCard playingCard:hand){
            cards += playingCard.getAsString() + " || ";
        }
        return cards;
    }


    /**
     * The client is only allowed to use these methods if he/her has five cards
     * @return
     */

    public int getFaceValue(){
        int face = 0;
        for (PlayingCard playingCard : hand) {
            face += playingCard.getFace();
        }
        return face;
    }

    public boolean isFlush(){
        return false;
    }



    /*
    public String getTheSuitsInOneString(){
        String suit = "";
        for(PlayingCard playingCard : hand){
            suit += playingCard.getSuit();
        }
        return suit;
    }

    public boolean isRoyalFlush(){
        long numberOfDifferentChars = getTheSuitsInOneString().chars().distinct().count();
        return getFaceValue() == 60 && numberOfDifferentChars == 1;
    }
    public boolean isStraightFLush(){
        long numberOfDifferentChars = getTheSuitsInOneString().chars().distinct().count();
        return numberOfDifferentChars == 1;
    }
    public boolean isFourOfAKind(){
        for(int i = 1; i < 14; i++){
            int count = 0;
            for(PlayingCard playingCard : hand){
                if(playingCard.getFace() == i){
                    count++;
                }
            }
            if (count == 4){
                return true;
            }
        }
        return false;
    }
    public boolean isFullHouse(){
        for(int i = 1; i < 13; i++){
            for(int j = 2; i < 14; j++){
                if(i != j){
                    int count3 = 0;
                    int count2 = 0;

                    for(PlayingCard playingCard : hand){
                        if(playingCard.getFace() == i){
                            count3++;
                        } else if (playingCard.getFace() == j){
                            count2++;
                        }
                    }

                    if (count3 == 3 && count2 == 2){
                        return true;
                    }
                }
            }
        }
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
*/


}

