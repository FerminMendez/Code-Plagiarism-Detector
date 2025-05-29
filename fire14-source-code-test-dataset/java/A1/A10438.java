package ulohy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Codejam_2 {
	
	static byte cases;
	static int[] googlers = new int[100];
	static int[] supr_triplets = new int[100];
	static int[][] total_scores = new int[100][100];
	static int[][] max = new int[100][100];
	static int[][] supr_max = new int[100][100];
	static int[] treshold = new int[100];
	static int[] result = new int[100];
	
	public static void read_input() {
		
		Scanner s = null;
		try {
			s = new Scanner(new FileReader("./src/ulohy/B-small-attempt0.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		cases = s.nextByte();		
		
		for (int i = 0; i < cases; i++) {
			googlers[i] = s.nextInt();
			supr_triplets[i] = s.nextInt();
			treshold[i] = s.nextInt();
			for (int j = 0; j < googlers[i]; j++) {
				total_scores[i][j] = s.nextInt();				
			}			
		}

		s.close();	
	}
	
	public static void write_output() {
		FileWriter outFile;
		try {
			outFile = new FileWriter("./src/ulohy/output");		
			PrintWriter out = new PrintWriter(outFile);
			for (int i = 1; i <= cases; i++) {
				out.println("Case #"+i+": "+result[i-1]);				
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void main(String args[]) {
		
		read_input();
		
		for (int i = 0; i < cases; i++) {			
			for (int j = 0; j < googlers[i]; j++) {
				if (total_scores[i][j] > 0) {
					switch (total_scores[i][j] % 3) {
					case 0:
						max[i][j] = total_scores[i][j]/3;
						supr_max[i][j] = total_scores[i][j]/3 + 1;
						break;
					case 1:
						max[i][j] = total_scores[i][j]/3 + 1;
						supr_max[i][j] = total_scores[i][j]/3 + 1;
						break;
					case 2:
						max[i][j] = total_scores[i][j]/3 + 1;
						supr_max[i][j] = total_scores[i][j]/3 + 2;
						break;
					default:
						break;
					}
				}
			}
			
			for (int j = 0; j < googlers[i]; j++) {
				if (max[i][j] >= treshold[i]) {
					result[i]++;
				} else {
					if (supr_max[i][j] >= treshold[i] && supr_triplets[i] > 0) {
						result[i]++;
						supr_triplets[i]--;
					}
				}
			}
		}
		
		write_output();
		
	}

}
