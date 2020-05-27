package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class Exit extends Command{
    
    @Override
    public String execute(File actualDir) {
        CmdEditor.setIsRunning(false);
        return "program ukoncen";
        
    }
    
}
