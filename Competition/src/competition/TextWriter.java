package competition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author lenka.wrnatova
 */
public class TextWriter extends Writer{

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException{
        File resultFile = new File(dataDirectory, resultFilepath);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath)))) {
            pw.println("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner.toString());
                n++;
            }
        }
    }
    
}
