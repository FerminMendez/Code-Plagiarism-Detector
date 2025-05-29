import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFileChooser;


public class Solver {
	
	public static int[][] getPossibleTriplets(int score){
		int s_3 = score/3;
		switch (score % 3){
		case 0:
			if ((score / 3) > 9){
				return new int[][]{new int[]{0,s_3,s_3,s_3,s_3}};
			}
			else {
				return new int[][]{new int[]{0,s_3,s_3,s_3,s_3}, new int[]{2,s_3+1,s_3-1,s_3,s_3+1}};
			}
		case 1:
			return new int[][]{new int[]{1,s_3+1,s_3,s_3,s_3+1}, new int[]{2,s_3+1,s_3-1,s_3+1,s_3+1}};
		case 2:
			return new int[][]{new int[]{1,s_3+1,s_3,s_3+1,s_3+1},new int[]{2,s_3+2,s_3,s_3,s_3+2}};
		}
		return null;
	}
	
	/**
	 * return 0 if the score can be obtained with the maximum judge >= p without surprise,
	 * 1 if it can be obtained with surprise
	 * -1 if it can't be obtained
	 * @param score
	 * @param p
	 * @return
	 */
	public static int isPossible(int score, int p){
		int s_3 = score/3;
		switch (score % 3){
		case 0:
			if (s_3 == 10){
				//only possibility 10 10 10
				return s_3 >= p ? 0 : -1;
			}
			else if (s_3 == 0){
				//only possibility 0 0 0
				return p == 0 ? 0 : -1;
			}
			else {
				return s_3 >= p ? 0 : (s_3 +1 >= p ? 1 : -1);
			}
		case 1:
			if (s_3 == 0){
				//only possibility 0 0 1
				return p <=1 ? 0 : -1;
			}
			return s_3+1 >= p ? 0 : -1;
		case 2:
			if (s_3 == 0){
				//only possibilities 0 1 1 and 0 0 2
				return p <= 1 ? 0 : (p == 2 ? 1 : -1);
			}
			return s_3+1 >= p ? 0 : (s_3+2 >=p ? 1 : -1);
		}
		return -1;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser(".");
		int ans = chooser.showOpenDialog(null);
		if (ans == JFileChooser.APPROVE_OPTION){
			File input = chooser.getSelectedFile();
			JFileChooser chooser2 = new JFileChooser(input.getParentFile());
			ans = chooser2.showSaveDialog(null);
			if (ans == JFileChooser.APPROVE_OPTION){
				File output = chooser2.getSelectedFile();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(input));
					PrintWriter writer = new PrintWriter(new FileWriter(output));
					String line = reader.readLine();
					int numCase = Integer.parseInt(line);
					for (int caseNum = 0 ; caseNum < numCase ; caseNum++){
						line = reader.readLine();
						String[] tokens = line.split(" ");
						int numScores = Integer.parseInt(tokens[0]);
						int numSurprise = Integer.parseInt(tokens[1]);
						int p = Integer.parseInt(tokens[2]);
						int numPossibleWithoutSurprise = 0;
						int numPossibleWithSurprise = 0;
						int[] scores = new int[numScores];
						for (int t = 3 ; t < tokens.length ; t++){
							scores[t-3] = Integer.parseInt(tokens[t]);
							int r = isPossible(scores[t-3], p);
							if (r == 0){
								numPossibleWithoutSurprise++;
							}
							else if (r == 1){
								numPossibleWithSurprise++;
							}
						}
						if (caseNum > 0){
							writer.println();
						}
						writer.print("Case #"+(caseNum+1)+": "+(numPossibleWithoutSurprise+Math.min(numPossibleWithSurprise, numSurprise)));
					}
					writer.flush();
					writer.close();
					reader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
