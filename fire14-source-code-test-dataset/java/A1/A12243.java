import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithGooglers {

	public static void main(String[] args) throws Exception{
		char problem = 'B';
		boolean smallCase = true;
		boolean practice = false;
		BufferedReader br = new BufferedReader(new FileReader(problem + "-" + (smallCase ? "small" : "large") + (practice ? "-practice" : "") + ".in"));
		PrintWriter out = new PrintWriter(new FileWriter(problem + "-" + (smallCase ? "small" : "large") + (practice ? "-practice" : "") + ".out"));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			out.println("Case #" + i + ": " + solve(br.readLine()));
		}
		out.close();
		System.exit(0);
	}

	public static int solve(String in) {
		Scanner sc = new Scanner(in);
		int numPeople = sc.nextInt();
		int numSurprize = sc.nextInt();
		int target = sc.nextInt();
		int output = 0;
		for(; numPeople > 0; numPeople--) {
			int cur = sc.nextInt();
			if(cur >= target * 3 - 2) output ++;
			else if(target != 1 && numSurprize > 0 && cur >= target * 3 - 4) {
				output ++;
				numSurprize --;
			}
		}
		return output;
	}

}
