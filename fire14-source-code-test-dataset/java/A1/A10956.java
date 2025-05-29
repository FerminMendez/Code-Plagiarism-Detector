import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class QB2012 {

	public static void main(String[] args) throws Exception {
		new QB2012();
	}
	
	static final String filename = "B-small-attempt0";
	int testcases;
	//HashMap<int[], Integer> map;
	
	public QB2012() throws Exception {	
		FileReader ifile = new FileReader(filename+".in");
		Scanner scanner = new Scanner(ifile);
		testcases = Integer.parseInt(scanner.nextLine());
		FileWriter ofile = new FileWriter(filename+".out");
		for (int i = 1; i <= testcases; i++) {
			ofile.write("Case #"+i+": "+solve(scanner.nextLine())+(i != testcases ? "\n" : ""));
		}
		ofile.close();
		System.out.println("Finished");
	}

	private int solve(String line) throws Exception {
		Scanner scanner = new Scanner(line);
		int N = scanner.nextInt();
		int S = scanner.nextInt();
		int p = scanner.nextInt();
		int[] t = new int[N];
		for (int i = 0; i < N; i++)
			t[i] = (scanner.nextInt());
		return solveRec(t, 0, S, p);
	}
	
	private int solveRec(int[] t, int i, int S, int p) {
		if (i == t.length)
			return 0;
		if (S == 0)
			return couldScoreP(t[i], false, p) + solveRec(t, i+1, 0, p);
		else
			return Math.max(couldScoreP(t[i], false, p) + solveRec(t, i+1, S, p), couldScoreP(t[i], true, p) + solveRec(t, i+1, S-1, p));
	}

	private int couldScoreP(int i, boolean suprised, int p) {
		if (i < p)
			return 0;
		int a = (i-p)/2;
		if (a < p-2 || a < p-1 && !suprised)
			return 0;
		return 1;
	}
	
}
