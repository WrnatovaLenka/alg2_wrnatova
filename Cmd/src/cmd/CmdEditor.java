package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class CmdEditor implements CmdInterface {
    private static boolean isRunning;
    private static File actualDir;
    private Command command;
    
    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
    
    public static void setIsRunning(boolean state) {
        isRunning = state;
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute
//        isRunning = false;
        return command.execute(actualDir);
    }
    
    static public void changeActualDir(File path) {
        actualDir = path;
    }
    
}
