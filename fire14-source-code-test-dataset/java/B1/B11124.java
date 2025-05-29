package qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemC {

	/**
	 * @param args
	 */
	public static String input = "C-small-attempt0.in";
	public static HashSet<Integer> testSet;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileReader(input));
		int t = in.nextInt();
		PrintWriter out = new PrintWriter(new FileWriter("out"));
		for (int test = 0; test < t; test++) {
			testSet = new HashSet<Integer>();
			int a = in.nextInt();
			int b = in.nextInt();
			int result = 0;
			for(int number = a; number<=b;number++){
				String s = Integer.toString(number);
				int length = s.length();
				if(length<=1){
					continue;
				}
				int bigPow = (int) Math.pow(10, length-1);
				int pow = 1;
				for(int i = s.length()-1; i>=1;i--){
					String partOne = s.substring(i);
					String partTwo = s.substring(0,i);
					int partOneNumber = Integer.parseInt(partOne);
					int partTwoNumber = Integer.parseInt(partTwo);
					int newNumber = partOneNumber*bigPow/pow+partTwoNumber;
					if(newNumber>=a&&newNumber<=b){
						if(newNumber > number){
							result++;
						}
					}
					pow*=10;
				}
				
			}
			out.println("Case #"+(test+1)+": "+result);
			out.flush();
		}
		out.close();
	}

}
