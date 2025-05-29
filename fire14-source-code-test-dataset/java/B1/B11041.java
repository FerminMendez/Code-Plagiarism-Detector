import java.io.*;
import java.util.StringTokenizer;

/**
 * User: Grant
 * Date: 14/04/12
 * Time: 23:29
 */
public class ProblemC {
    public static void main(String[] args) throws IOException {
        // Prepare output file
        File outputFile = new File("E:\\Programming\\Java\\CodeJam\\resources\\problemCOutput.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Read input file
        File inputFile = new File("E:\\Programming\\Java\\CodeJam\\resources\\TestInput.txt");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Integer testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            System.out.println(" ");
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine().trim(), " ");
            int lower = Integer.parseInt(st.nextToken().trim());
            int upper = Integer.parseInt(st.nextToken().trim());

            int count = 0;
            for (int left = lower; left < upper; left++) {
                for (int right = (left + 1); right <= upper; right++) {
                    String leftStr = left + "";
                    String rightStr = right + "";
                        int start = -1;
                        while((start = leftStr.indexOf(rightStr.charAt(0), start+1)) != -1) {
                            if (rightStr.equals(leftStr.substring(start, leftStr.length()) + leftStr.substring(0, start))) {
                                count++;
                                break;
                            }
                        }
                }
            }


            StringBuilder outputLine = new StringBuilder("Case #");
            outputLine.append(i+1).append(": ").append(count).append("\n");
            bufferedWriter.write(outputLine.toString());
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
