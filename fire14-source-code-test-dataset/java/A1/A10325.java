
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dafferianto
 */
public class DancingWithTheGooglers {
    private static Scanner inputStream;
    private static PrintWriter outputStream;
    private static int T, N, S, p, div, mod, counter;
    private static int[] t;
    private static ArrayList<Integer> aList;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            inputStream = new Scanner(new FileReader(args[0]));
            outputStream = new PrintWriter(new FileWriter("OutputDancingWithTheGooglers.txt"));
            
            T = inputStream.nextInt();
            //T = Integer.parseInt(inputStream.nextLine());
            
            for (int i = 0; i < T; i++) { // For each test case
                N = inputStream.nextInt();
                S = inputStream.nextInt();
                p = inputStream.nextInt();
                aList = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    aList.add(inputStream.nextInt());
                }
                
                Collections.sort(aList);
                
                counter = 0;
                
                for (int j = 0; j < N; j++) {
                    int ti = aList.get(j);
                    if (ti / 3 >= p) {
                        counter = counter + N - j; 
                        break;
                    } else { 
			if (ti-p < 0) {
                            continue;
                        }
                        int res = (ti - p) / 2;
			if (S == 0){
                            if (isLegal(p, res, ti-p-res) && (!isSurprising(p, res, ti-p-res))) 
                                counter++;
                            continue;
			}
                            if (isLegal(p, res, ti-p-res)){
				if (isSurprising(p, res, ti-p-res)){
                                    S--;
                                }
				counter++;
                            }
                    }
                    
                }
                outputStream.println("Case #" + (i+1) + ": " + counter);
                //System.out.println("Case #" + (i+1) + ": " + counter);
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

    private static boolean isLegal(int p, int res, int i) {
        if ((Math.abs(p - res) <= 2) && (Math.abs(res - i) <= 2) && (Math.abs(p - i) <= 2)) {
            return true;
        }
        return false;
    }

    private static boolean isSurprising(int p, int res, int i) {
        if ((Math.abs(p - res) == 2) || (Math.abs(res - i) == 2) || (Math.abs(p - i) == 2)) {
            return true;
        }
	return false;
    }
}
