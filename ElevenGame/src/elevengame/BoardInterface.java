package elevengame;

/**
 *
 * @author lenka.wrnatova
 */
public interface BoardInterface {

    public String getName();
    
    public int nCards();
    
    public int getDeckSize();
    
    public String getCardDescriptionAt(int index);

    public boolean isAnotherPlayPossible();

    public boolean playAndReplace(String[] selectedCardsPositions);

    public boolean hasWon();
}
