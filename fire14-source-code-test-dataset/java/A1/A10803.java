package qualification.Dancing;

import java.io.*;
import qualification.Tongues.Tongues;

/**
 *
 * @author farshid
 */
public class Interface {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        String inPath, outPath;

        IO.println("Enter input path:");
        inPath = IO.readln();
        IO.println("Enter output path:");
        outPath = IO.readln();

        IO.println("Solving...");

        Dancing d = new Dancing();
        FileInputStream fis = new FileInputStream(inPath);
        InputStreamReader in = new InputStreamReader(fis, "UTF-8");
        BufferedReader reader = new BufferedReader(in);

        FileOutputStream fos = new FileOutputStream(outPath);
        OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter writer = new BufferedWriter(out);

        int count = Integer.parseInt(reader.readLine());
        int[] output = new int[count];

        for (int i = 0; i < count; i++) {
            output[i] = d.solve(reader.readLine());
        }

        reader.close();

        for (int i = 0; i < count; i++) {
            writer.write("Case #" + (i + 1) + ": " + output[i]);
            writer.newLine();
        }

        writer.close();

        IO.println("Done.");
        IO.readln();

    }
}
