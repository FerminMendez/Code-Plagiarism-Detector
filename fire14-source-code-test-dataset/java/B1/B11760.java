package be.tim.recycled;

import java.io.*;

/**
 *
 * @author Tim Boeckstaens
 * @version 1.0
 */
public class Recycle {

    private int N;

    public void process(String inputFile, String outputFile) {

        Recycler recycler = new Recycler();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);
            String line;
            String string;

            N = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= N; i++) {
                line = reader.readLine();
                if (line != null) {
                    string = recycler.process(line);
                    writer.write("Case #" + i + ": " + string);
                    if(i != N){
                        writer.write("\n");
                    }
                } else {
                    System.out.println("Error while reading all lines.");
                }
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
