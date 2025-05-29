import java.io.*;
import java.util.StringTokenizer;

/**
 * User: Grant
 * Date: 14/04/12
 * Time: 22:51
 */
public class ProblemB {
    public static void main(String[] args) throws IOException {

        // Prepare output file
        File outputFile = new File("E:\\Programming\\Java\\CodeJam\\resources\\problemBOutput.txt");
        if(outputFile.exists()) {
            outputFile.delete();
        }

        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Read input file
        File inputFile = new File("E:\\Programming\\Java\\CodeJam\\resources\\TestInput.txt");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Integer testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine().trim(), " ");
            int googlerCount = Integer.parseInt(st.nextToken().trim());
            int totalSurpriseCount = Integer.parseInt(st.nextToken().trim());
            int bestResult = Integer.parseInt(st.nextToken().trim());

            int outputNum = 0;

            int surprisesUsed = 0;
            start: for(int j = 0; j < googlerCount; j++) {
                int total = Integer.parseInt(st.nextToken().trim());
                boolean surpriseAvailable = false;
                for(int x = 0; x <= 10; x++) {
                    for(int y = 0; y <= 10; y++) {
                        for(int z = 0; z <= 10; z++) {
                            if(x + y + z == total
                                    && (x >= bestResult
                                        || y >= bestResult
                                        || z >= bestResult)) {
                                if(Math.abs(x-y) <= 1 && Math.abs(y-z) <= 1 && Math.abs(x-z) <= 1) {
                                    outputNum++;
                                    continue start;
                                }
                                if(!surpriseAvailable
                                    && surprisesUsed < totalSurpriseCount
                                    && Math.abs(x-y) <= 2 && Math.abs(y-z) <= 2 && Math.abs(x-z) <= 2) {
                                    surpriseAvailable = true;
                                }
                            }
                        }
                    }
                }
                if(surpriseAvailable) {
                    surprisesUsed++;
                    outputNum++;
                }
            }

            bufferedWriter.write("Case #" + (i+1) + ": " + outputNum + "\n");
        }

        bufferedReader.close();
        fileReader.close();

        // Write output file
        bufferedWriter.flush();
        fileWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}


















