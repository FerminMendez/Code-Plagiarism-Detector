import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProbB {
	static int[][] SurprisingCombinations = {{0,0,2},{0,1,2},{0,2,2}};
	static int[][] notSurprisingCombinations = {{0,0,0},{0,0,1},{0,1,1}};
	public static void main(String[] args) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter("d:\\codejam2012\\outputfile.txt"));
			Scanner scanner = new Scanner(new File("d:\\codejam2012\\B-small-attempt1.in"));
			
			
			int cases = scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 1; i <= cases; i++) {
				int n = scanner.nextInt(), s = scanner.nextInt(), p = scanner.nextInt();
				int[] dancers = new int[n];
				for (int j = 0; j < dancers.length; j++) {
					dancers[j] = scanner.nextInt();
				}
				int sol = solve(dancers, n, s, p);
				out.println("Case #"+i+": " +sol);
			}

			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private static int solve(int[] dancers, int n, int s, int p) {
		int ret = 0;
		
		for (int i = 0; i < dancers.length; i++) {
			if(isDoneWithCombinations(notSurprisingCombinations,dancers[i], p)){
				//here not surprising sequence and can get atleast p
				ret++;
			}else if(isDoneWithCombinations(SurprisingCombinations,dancers[i], p) && s > 0){
				//here surprising sequence and can get atleast p
				ret++;
				s--;
			}
		}
		return ret;
	}
	private static boolean isDoneWithCombinations(int[][] combinations, int seq, int p) {
		boolean sol = false;
		for (int i = 0; i < combinations.length; i++) {
			int sub = 0;
			for (int j = 0; j < combinations[i].length; j++) {
				sub += combinations[i][j];
			}
			if((seq - sub) >= 0 && (seq - sub)% 3 == 0 && ((seq - sub) / 3) + combinations[i][2] >= p){
				sol = true;
			}
		}
		return sol;
	}

}
