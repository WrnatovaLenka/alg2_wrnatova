package elevengame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *reprezentuje balicek karet
 * @author lenka.wrnatova
 */
public class Deck {
    List<Card> deckCards = new ArrayList();
    private int deckCardsSize;
    private String[] symbol;
    private String[] value;
    private int[] nPoints;
    
    public Deck(String[] symbol, String[] value, int[] points) {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < value.length; j++) {
                Card c = new Card(symbol[i],value[j], points[j]);
                deckCards.add(c); 
                deal();
            }
        }
        shuffle();
        deckCardsSize = deckCards.size();
    }
    
    public int nCardsInDeck(){
        return deckCardsSize;
    }
    
    public void deal(){
       deckCardsSize--;
    }
    
    public void shuffle(){
        Collections.shuffle(deckCards);
    }

    @Override
    public String toString() {
        return "Deck{" + "deckCards=" + deckCards + ", deckCardsSize=" + deckCardsSize + '}';
    }
    
    public boolean isEmpty(){
        if(deckCards.size() == 0){
            return true;
        }
        return false;
    }

    public List<Card> getDeckCards() {
        return deckCards;
    }
    
    public Card getDeckCard(int index){
        return deckCards.get(index);
    }

    
}
