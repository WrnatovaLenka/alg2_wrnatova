package elevengame;

/**
 *
 * @author lenka.wrnatova
 */
public class Card {
    private String symbol; //suit
    private String value; //rank
    private int nPoints; //2-10 body podle hodnoty, A 1 bod, J,Q,K 0 bodu //mohl by byt byte

    public Card(String symbol, String value, int nPoints) {
        this.symbol = symbol;
        this.value = value;
        this.nPoints = nPoints;
    }

    
    
    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public int getnPoints() {
        return nPoints;
    }
    
    @Override
    public String toString() {
        return "Card{" + "symbol=" + symbol + ", value=" + value + ", nPoints=" + nPoints + '}';
    }
    
}
