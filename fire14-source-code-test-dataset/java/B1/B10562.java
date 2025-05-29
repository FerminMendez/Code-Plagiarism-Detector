import java.io.*;
import java.util.ArrayList;

public class recycled {
    public static void main(String[] args) {
	String filename = args[0];
	ArrayList<String> input = new ArrayList<String>();
	ArrayList<String> output = new ArrayList<String>();
	try {
	    BufferedReader br = new BufferedReader(new FileReader(filename));
	    while (true) {
		String line = br.readLine();
		if (line == null) break;
		input.add(line);
	    }
	    br.close();
	    input.remove(0);
	} catch (IOException e) {
	    System.out.println("Input error. Try a different filename.");
	}
	for (String line: input) {
	    String out = ""+checkCondition(line);
	    output.add(out);
	}
	try {
	    PrintWriter pr = new PrintWriter(new FileWriter("output.txt"));
	    for (int i = 0;i < output.size();i++) {
		String line = output.get(i);
		pr.println("Case #" + (i+1) + ": " + line);
	    }
	    pr.close();
	} catch (IOException e) {
	    System.out.println("Output error. Hmph.");
	}
	System.out.println("Process complete.");
    }
    private static int checkCondition(String line) {
	String[] numString = line.split(" ");
	int a = Integer.parseInt(numString[0]);
	int b = Integer.parseInt(numString[1]);
	int recycled = 0;
	for (int n = a;n <= b;n++) {
	    String N = ""+n;
	    for (int m = n;m <= b;m++) {
		String M = ""+m;
		if (areRecycled(M,N) && !(M.equals(N))) {
		    recycled++;
		    System.out.println(M + " " + N);
		}
	    }
	}
	return recycled;
    }
    private static boolean areRecycled(String M,String N) {
	String n = N;
	for (int i = 1;i < N.length();i++) {
	    n = permute(n);
	    if (M.equals(n)) {
		return true;
	    }
	}
	return false;
    }
    private static String permute(String n) {
	char q = n.charAt(0);
	return n.substring(1) + q;
    }
}
