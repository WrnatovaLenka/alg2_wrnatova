package app;

/**
 *
 * @author lenka.wrnatova
 */
public class Position {
    private String position;
    private int hourRate;

    public Position(String position, int hourRate) {
        this.position = position;
        this.hourRate = hourRate;
    }

    public String getPosition() {
        return position;
    }

    public int getHourRate() {
        return hourRate;
    }
    
    
    
}
