package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        String help = "HELP\n" + String.format("%-30s %s\n", "help", "Display help")
                               + String.format("%-30s %s\n", "dir", "Display list of files and folders")
                               + String.format("%-30s %s\n", "dir [-o]", "Display an ordered list of files and folders")
                               + String.format("%-30s %s\n", "dir [-e] [file extension]", "Display an ordered list of files and folders with specific extension")
                               + String.format("%-30s %s\n", "dir [-s] [size]", "Display an ordered list of files and folders bigger than specified size")
                               + String.format("%-30s %s\n", "cd [folder name]", "Change directory - move to a specific folder")
                               + String.format("%-30s %s\n", "cd ..", "Change directory - move to the folder one level higher")
                               + String.format("%-30s %s\n", "mkdir [folder name]", "Create new folders")
                               + String.format("%-30s %s\n", "rename [nameFrom] [nameTo]", "Rename folder or file")
                               + String.format("%-30s %s\n", "exit", "Finish program cmd")
                               + String.format("%-30s %s\n", "recdir", "Dir recursive");
        return help;
    }
    
}
