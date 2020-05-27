package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        String help = "HELP\n" + String.format("%-7s %s\n", "help", "Display help")
                               + String.format("%-7s %s\n", "dir", "Display list of files and folders")
                               + String.format("%-30s %s\n", "dir [-o]", "Display an ordered list of files and folders")
                               + String.format("%-30s %s\n", "cd [folder name]", "Change directory - move to a specific folder")
                               + String.format("%-30s %s\n", "cd ..", "Change directory - move to the folder one level higher")
                               + String.format("%-30s %s\n", "mkdir [folder name]", "Create new folders")
                               + String.format("%-30s %s\n", "rename [nameFrom] [nameTo]", "Display help")
                               + String.format("%-30s %s\n", "exit", "Exit cmd");
        return help;
    }
    
}
