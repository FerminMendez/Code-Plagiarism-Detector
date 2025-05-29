import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("B-small.in"));
		FileWriter fw = new FileWriter("B-small.out");
		
		int T = in.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int[] totalScores = new int[N];
			int special = 0;
			for(int i = 0; i < N; i++) {
				totalScores[i] = in.nextInt();
				if(totalScores[i] >= 3) {
					int remainder = totalScores[i] % 3;
					int mid = totalScores[i] / 3;
					
					if(remainder == 0) {//mid mid mid or mid-1 mid mid+1;
						if(mid >= p)
							count++;
						else if(mid+1 >= p && special < S) {
							special++;
							count++;
						}
					} else if(remainder == 1) {//mid mid mid+1 or mid-1 mid+1 mid+1
						if(mid >= p)
							count++;
						else if(mid+1 >= p)
							count++;
						
					} else {//mid mid+1 mid+1 or mid mid mid+2
						if(mid >= p)
							count++;
						else if(mid+1 >= p)
							count++;
						else if(mid+2 >= p && special < S) {
							special++;
							count++;
						}
					}
				} else {
					if((totalScores[i] == 0 && p == 0) || (totalScores[i] == 1 && p <= 1))
						count++;
					else if(totalScores[i] == 2) {
						if(p <=1) {
							count++;
						} else if(p == 2 && special < S) {
							special++;
							count++;
						}
					}
				}
				
			}
			
			fw.write ("Case #" + tc + ": " + count + "\n");
		}
		fw.flush();
		fw.close();
	}

}
