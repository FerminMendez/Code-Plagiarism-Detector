import java.io.*;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        try {
            Scanner inputReader = new Scanner(new File("S:\\input.in"));
            int inputCases = inputReader.nextInt();
            PrintWriter outputWriter = new PrintWriter("S:\\output.in");
            for (int currentInputCase = 0; currentInputCase < inputCases; currentInputCase++) {
                String markUpString = "";
                int milestone = 0;
                int firstA = inputReader.nextInt();
                int secondB = inputReader.nextInt();
                for (int currentN = firstA; currentN < secondB; currentN++) {
                    String n = currentN + "";
                    for (int i = 1; i <= n.length() - 1; i++) {
                        String trimString = n.substring(n.length() - i, n.length()) + n.substring(0, n.length() - i);
                        if (!trimString.startsWith("0")) {
                            if (!n.equals(trimString)) {
                                int trimmedInt = Integer.parseInt(trimString);
                                if (trimmedInt <= secondB && trimmedInt > (Integer.parseInt(n))) {
                                    if (!markUpString.contains(n + "#" + trimString)) {
                                        markUpString += (n + "#" + trimString + ",");
                                        milestone++;
                                    }
                                }
                            }
                        }
                    }
                }
                outputWriter.write("Case #" + (currentInputCase + 1) + ": " + milestone + "\n");
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {

        }
    }

}
