package wrnatova_hurricane;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author lenka.wrnatova
 */
public interface HurricaneInterface {
    
    public void load()throws FileNotFoundException, IOException;
    public String hurricanesInYears(int y1, int y2);
    public String hurricaneByName(String name);
    public String hurricaneInfoBySpeed();
    
}
