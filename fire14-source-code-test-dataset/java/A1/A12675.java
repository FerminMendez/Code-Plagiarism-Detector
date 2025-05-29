package y2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class QR2 {
	
	public static void main(String[] args) throws Exception {
		Scanner inputFile=new Scanner(new File(args[0]));
		PrintWriter outputFile=new PrintWriter(new File(args[1]));
			
		int t=Integer.parseInt(inputFile.nextLine());	
		for(int i=0;i<t;i++){
			int result = 0;
			
			String[] aCase = inputFile.nextLine().split(" ");
			
			int numGooglers = Integer.parseInt(aCase[0]);
			int numSurprising = Integer.parseInt(aCase[1]);
			int p = Integer.parseInt(aCase[2]);
			int[][] scoreboard = new int[numGooglers][5];
			
			for(int j=0; j<numGooglers; j++) {
				scoreboard[j][0] = Integer.parseInt(aCase[3+j]);
			}
			
			for(int j=0; j<numGooglers;j++) {
				int avg = scoreboard[j][0]/3;
				int mod = scoreboard[j][0]%3;
				
				scoreboard[j][1] = mod;
				switch(mod) {
				case 0:
					scoreboard[j][2] = avg; scoreboard[j][3] = avg; scoreboard[j][4] = avg;
					break;
				case 1:
					scoreboard[j][2] = avg+1; scoreboard[j][3] = avg; scoreboard[j][4] = avg;
					break;
				case 2:
					scoreboard[j][2] = avg+1; scoreboard[j][3] = avg+1; scoreboard[j][4] = avg;
					break;
				}
			}
			
			for(int j=0; j<numGooglers;j++) {
				if(scoreboard[j][2] >= p) {
					result = result + 1;
				} else if( scoreboard[j][2] == p-1	//diff with 1 score
						&& numSurprising > 0		//still has suprise quota
						&& scoreboard[j][1] != 1	//suprise-able?
						&& (scoreboard[j][0] >= 3 && scoreboard[j][0] <= 27) //suprise-able?
						) {
					result = result + 1;
					numSurprising = numSurprising - 1;
				}
			}
			
			outputFile.println("Case #"+(i+1)+": " + result);
			System.out.println("Case #"+(i+1)+": " + result);
		}

		inputFile.close();
		outputFile.close();
	}
	
}
