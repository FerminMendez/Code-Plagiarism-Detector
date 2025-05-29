import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		int c = 1;
		while(scan.hasNextLine()) {
			Scanner ls = new Scanner(scan.nextLine());
			ls.nextInt();
			int s = ls.nextInt();
			int p = ls.nextInt();
			ArrayList<Integer> sc = new ArrayList<Integer>();
			while(ls.hasNextInt()) {
				sc.add(ls.nextInt());
			}
			System.out.println("Case #" + c++ + ": " + process(s, p, sc));
		}
	
	}
	
	public static int process(int surprises, int scoreToBeat, ArrayList<Integer> scores) {
		int ok = 0;
		int s = 0;
		for (int i = 0; i < scores.size(); i++) {
			int score = scores.get(i);
			int third = score / 3;
			int rem = score % 3;
			if(third >= scoreToBeat || (rem > 0 && (third + 1) >= scoreToBeat)) {
				ok++;
			} else {
				if(s < surprises && rem != 1) {
					if((rem == 2 && (third + 2) >= scoreToBeat) || (rem == 0 && (third > 0) && (third + 1) >= scoreToBeat)) {
						s++;
						ok++;
					}
				}
			}
		}
		return ok;
	}
	
}
