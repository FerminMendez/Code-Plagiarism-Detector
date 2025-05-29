
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author dafferianto
 */
public class RecycledNumbers {
    private static Scanner inputStream;
    private static PrintWriter outputStream;
    private static int T, lower, upper, counter, tempNumber, result;
    private static String numberString, tempNumberString;
    private static HashMap<Integer, Integer> aHashMap;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            inputStream = new Scanner(new FileReader(args[0]));
            outputStream = new PrintWriter(new FileWriter("RecycledNumbersOutput.txt"));
            
            T = inputStream.nextInt();
            //T = Integer.parseInt(inputStream.nextLine());
            
            for (int i = 0; i < T; i++) { // For each test case
                lower = inputStream.nextInt();
                upper = inputStream.nextInt();
                aHashMap = new HashMap<Integer, Integer>();
                //result = solve(lower, upper);
                //outputStream.println("Case #" + (i+1) + ": " + result);
                outputStream.println("Case #" + (i+1) + ": " + solve(lower, upper));
                //System.out.println("Case #" + (i+1) + ": " + result);
            }
            
        } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
        }
    }

    private static int solve(int lower, int upper) {
        counter = 0;
        for (int currentNumber = lower; currentNumber <= upper; currentNumber++) {
            if (aHashMap.containsKey(currentNumber)) {
                continue;
            }
            counter += process(currentNumber);
        }
        return counter;
    }
    
    private static int process(int aNumber) {
        int localCounter = 0;
        numberString = Integer.toString(aNumber);
        for (int i = numberString.length()-1; i > 0; i--) {
            if (Character.getNumericValue(numberString.charAt(i)) == 0) {
                continue;
            }
            tempNumberString = numberString.substring(i) + numberString.substring(0, i);
            tempNumber = Integer.parseInt(tempNumberString);
            if (tempNumber == aNumber) {
                continue;
            }
            if (aHashMap.containsKey(tempNumber)) {
                continue;
            }
            if ((tempNumber >= lower) && (tempNumber <= upper)) {
                localCounter++;
                aHashMap.put(tempNumber, tempNumber);
                //System.out.println(tempNumber);
            }
        }
        if (localCounter != 0) {
            aHashMap.put(aNumber, aNumber);
            //System.out.println(aNumber);
        }
        if (localCounter > 1) {
            return sumOfSequence(localCounter);
        }
        return localCounter;
    }

    private static int sumOfSequence(int aCounter) {
        int tempSum = 0;
        for (int i = 1; i <= aCounter; i++) {
            tempSum += i;
        }
        return tempSum;
    }
}
