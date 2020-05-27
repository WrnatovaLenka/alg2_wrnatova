package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class Mkdir extends Command {
    
    @Override
    public String execute(File actualDir) {
    File newFile = new File(params[1]);
        if (!newFile.exists()) {
            try {
                newFile.mkdir();
            } catch (Exception e) {
                throw new RuntimeException("Novy soubor nemohl byt vytvoren");
            }
        }

        return "soubor " + newFile.getName() + " byl vytvoren";

    }
  
}
