package codejam.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chenling
 */
public class FileUtil {

    public static List<String> readLines(String fileName) {
        List<String> result = new ArrayList<String>();
        FileReader in = null;
        try {
            in = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(in);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    result.add(line);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static void writeLines(String fileName, List<String> lines) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(writer);
            for (String line : lines) {
                printWriter.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
