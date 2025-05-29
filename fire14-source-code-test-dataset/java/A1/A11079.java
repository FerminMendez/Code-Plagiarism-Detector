package qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemB {

	/**
	 * @param args
	 */
	public static String input = "B-small-attempt0.in";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileReader(input));
		int t = in.nextInt();
		PrintWriter out = new PrintWriter(new FileWriter("out"));
		for(int test = 0;test <t;test++){
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int canHaveSurprising = 0;
			int mustHaveSurprising = 0;
			int notHaveSurprising = 0;
			int[] totalScore = new int[n];
			for(int i = 0 ;i<n;i++){
				totalScore[i] = in.nextInt();
				if(totalScore[i] >= 3*p-2){
					canHaveSurprising++;
				}
				else if(totalScore[i] < 3*p-2 && totalScore[i]>=3*p-4){
					if(3*p-4>=0){
						mustHaveSurprising++;
					}
				}
				else {
					notHaveSurprising++;
				}
			}
			int result = canHaveSurprising+Math.min(mustHaveSurprising, s);
			out.println("Case #"+(test+1)+": "+result);
			out.flush();
		}
		out.close();
	}

}
