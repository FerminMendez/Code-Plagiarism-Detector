/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recyclednumbers;

/**
 *
 * @author vandit
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.String;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author vandit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filePathIn = args[0];
        String filePathOut = args[1];
        //String filePathIn = "/home/vandit/Desktop/GoogleCodeJam/Qualifying round/testinput.in";
        //String filePathOut = "/home/vandit/Desktop/GoogleCodeJam/Qualifying round/testOutput.out";
        FileReader fr = null;
        BufferedReader inputFileReader = null;
        FileWriter fw = null;
        BufferedWriter outputFileWriter = null;
        try {
            fr = new FileReader(filePathIn);
            inputFileReader = new BufferedReader(fr);

            fw = new FileWriter(filePathOut);
            outputFileWriter = new BufferedWriter(fw);


            int numberOfTestCases = Integer.parseInt(inputFileReader.readLine());

            for (int i = 0; i < numberOfTestCases; i++) {
                String inputContent = inputFileReader.readLine();
                
                StringTokenizer tokenizer = new StringTokenizer(inputContent);
                int startingNumber = Integer.parseInt(tokenizer.nextToken());
                int endingNumber = Integer.parseInt(tokenizer.nextToken());

                HashSet<Pair> numbers =  new RecycleNumbers().findAllRecycledNumbers(startingNumber,endingNumber);
                
                String outputContent = Integer.toString(numbers.size());
                //String outputContent =
                String output = "Case #" + (i+1) + ": " + outputContent+"\n";
                outputFileWriter.write(output);

            }
        outputFileWriter.flush();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                outputFileWriter.close();
                inputFileReader.close();
                fr.close();
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

