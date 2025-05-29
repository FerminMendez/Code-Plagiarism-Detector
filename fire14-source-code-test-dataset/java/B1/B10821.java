import java.math.*;
import java.io.*;
import java.util.*;

public class Recycle {

    public static void main(String[] args) {
	Recycle r = new Recycle();
	writeOutput(r.countRecycleds(readInput()));
    }

    // Count all recycleds for all the inputs
    public String countRecycleds(ArrayList<String> lines) {
	String line;
	StringBuffer out = new StringBuffer();
	for (int i = 1; i < lines.size(); i++) {
	    line = lines.get(i);
	    String[] args = line.split(" ");
	    out.append("Case #" + i + ": ");
	    out.append(countRecycleds(Integer.parseInt(args[0]),
				      Integer.parseInt(args[1])));
	    out.append("\n");
	}
	return out.toString();
    }

    // Count all recycleds between A and B
    public int countRecycleds(int A, int B) {
	int count = 0;
	for (int n = A; n <= B; n++) {
	    count += countRecycledsForN(n, B);
	}
	return count;
    }

    // Count recycleds for one n (ie, number of ms)
    public int countRecycledsForN(int n, int B) {
	int digits = countDigits(n);
	int count = 0;
	Map<Integer,Boolean> used = new HashMap<Integer, Boolean>();
	// For each number of digits we're swapping
	for(int swap = 1; swap < digits; swap++) {
	    // The base 10 number to swap
	    int swapper = (int)Math.pow(10, swap);
	    // The digits being swapped
	    int swappedDigits = n % swapper;
	    // n without the digits being swapped
	    int swappedN = n / swapper;
	    int m = (swappedDigits * (int)Math.pow(10, digits - swap)) 
		+ swappedN;
	    // If m is valid, count it
	    if (n < m && m <= B && !used.containsKey(m)) {
		count++;
		used.put(m, true);
	    }
	}
	return count;
    }
    
    // Count the number of digits in n (base 10)
    public int countDigits(int n) {
	return (int)Math.log10(n) + 1;
    }

    public static void writeOutput(String s) {
	try{
	    BufferedWriter out = new BufferedWriter(new FileWriter("./Output.txt"));
	    out.write(s);
	    out.close();
	}catch (Exception e){
	    System.out.println(s);
	    throw new RuntimeException("Oops, couldn't write");
	}
    }

    public static ArrayList<String> readInput() {
	ArrayList<String> lines = new ArrayList<String>();
	try {
	    FileInputStream fstream = new FileInputStream("./Input.txt");
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String str;
	    while ((str = br.readLine()) != null) {
		lines.add(str);
	    }
	    br.close();
	    return lines;
	} catch (Exception e) {
	    throw new RuntimeException("Couldn't read");
	}
    }
}