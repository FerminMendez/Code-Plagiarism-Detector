import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QC2012 {

	public static void main(String[] args) throws Exception {
		new QC2012();
	}
	
	static final String filename = "C-small-attempt0";
	int testcases;
	
	public QC2012() throws Exception {
		FileReader ifile = new FileReader(filename+".in");
		Scanner scanner = new Scanner(ifile);
		testcases = Integer.parseInt(scanner.nextLine());
		FileWriter ofile = new FileWriter(filename+".out");
		for (int i = 1; i <= testcases; i++) {
			ofile.write("Case #"+i+": "+solve(scanner.nextInt(), scanner.nextInt())+(i != testcases ? "\n" : ""));
		}
		ofile.close();
		System.out.println("Finished");
	}

	private int solve(int A, int B) throws Exception {
		int sum = 0;
		for (int n = A; n <= B-1; n++) {
			for (int m = n+1; m <= B; m++) {
				if (isRecycled(Integer.toString(n),Integer.toString(m)))
					sum++;
			}
		}
		return sum;
	}

	private boolean isRecycled(String n, String m) {
		String rotn = n;
		do {
			if (rotn.equals(m))
				return true;
			rotn = rotR(rotn);
		} while(!n.equals(rotn));
		return false;
	}

	private String rotR(String n) {
		return n.charAt(n.length()-1) + n.substring(0, n.length()-1);
	}
	
	
}
