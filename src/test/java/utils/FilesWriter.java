package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesWriter {

    public static void writeToFile (String value) throws IOException {
        File file = new File("src/test/resources/results.txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(value + "\n" + "--------------------" + "\n");
        writer.flush();
        writer.close();
    }

    public static void cleanFile (String fileName) throws IOException {
        FileWriter fwOb = new FileWriter(fileName, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

}
