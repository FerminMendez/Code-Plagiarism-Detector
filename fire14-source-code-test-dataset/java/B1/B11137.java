package recyclednumbers.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {

    public static List<String> readLines(String filename) {

        List<String> lines = new ArrayList<String>();

        try {

            InputStream is = IOUtil.class.getResourceAsStream("/META-INF/" + filename);

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();
            is.close();

            return lines;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void writeLines(String filename, List<String> lines) {

        try {

            File file = new File("src/META-INF/" + filename);

            FileWriter fileWriter = new FileWriter(file);

            for (int i = 0; i < lines.size(); i++) {
                fileWriter.write("Case #" + (i + 1) + ": " + lines.get(i) + "\n");
            }

            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}