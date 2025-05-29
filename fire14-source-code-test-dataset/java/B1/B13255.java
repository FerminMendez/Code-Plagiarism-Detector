import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NumberRecycling {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {
	    FileInputStream fstream = new FileInputStream("D:/work/java dev/Google code jam 2012/bin/C-small-attempt0.in");
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    String numberOfTest = reader.readLine();
	    Integer T = Integer.valueOf(numberOfTest);
	    File result = new File("D:/work/java dev/Google code jam 2012/bin/Cresult.txt");
	    FileWriter writer = new FileWriter(result);
	    PrintWriter pWriter = new PrintWriter(writer);
	    for (int j = 0; j < T; j++) {
		String[] dataset = reader.readLine().split(" ");
		int A = Integer.valueOf(dataset[0]);
		int B = Integer.valueOf(dataset[1]);
		int numberOfRecycledPairs = 0;
		for (int n = A; n <= B; n++) {
		    for (int m = n + 1; m <= B; m++) {
			if (n != m) {
			    if (isRecycleNumbers(String.valueOf(n), String.valueOf(m))) {
				numberOfRecycledPairs++;
			    }
			}
		    }
		}
		pWriter.println("Case #" + (j + 1) + ": " + numberOfRecycledPairs);
	    }
	    pWriter.flush();
	    pWriter.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private static boolean isRecycleNumbers(String n, String m) {
	boolean result = false;
	for (int i = 1; i < n.length(); i++) {
	    String nPrime = moveNumberToTheBack(n, i);
	    if (nPrime.equals(m)) {
		return true;
	    }
	}
	return result;
    }

    private static String moveNumberToTheBack(String n, int i) {
	String start = n.substring(i);
	String end = n.substring(0, i);
	return start + end;
    }
}
