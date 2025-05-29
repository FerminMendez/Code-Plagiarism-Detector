import java.io.*;
import java.util.*;

public class Java{

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("B-small-attempt1.in"));
			int cases = Integer.parseInt(in.readLine());
			for (int i = 1; i <= cases; i ++){
				String[] temp = (in.readLine()).split(" ");
				int players = Integer.parseInt(temp[0]);
				int surprise = Integer.parseInt(temp[1]);
				int best = Integer.parseInt(temp[2]);
				int[] totals = new int [players];
				for (int k = 0; k < players; k ++)
					totals[k] = Integer.parseInt(temp[k+3]);
				logic(players, surprise, best, totals, i);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("INPUT ERROR");
		}
	}

	public static void logic(int numOfPlayers, int surprise, int bestScore, int[] totals, int caseNum){
		int result = 0;
		int maybe = 0;
		for (int i = 0; i < numOfPlayers; i ++){
			int min = totals[i]/3;
			if (min >= bestScore) result ++;
			else if (totals[i] != 0) {
				int x = totals[i] - (2 * min);
				if (x >= bestScore && ((x-1 == min) || (x-1 == bestScore))) result ++;
				else if ((x >= bestScore) || ((x == min) && (x+1 == bestScore) && (bestScore - min < 2))) maybe ++;
			}
		}
		if (maybe > surprise) System.out.println("Case #" + caseNum + ": " + (result + surprise));
		else System.out.println("Case #" + caseNum + ": " + (result + maybe));
	}
}