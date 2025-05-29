import java.util.*;
import java.io.*;


public class Recycle {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Recycle.out")));
		StringTokenizer st;
		
		st = new StringTokenizer(f.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int A, B;
		int numDigit;
		int temp, temp1, temp2, tempPow;
		int countRecycle;
		int[] result = new int[T];
		boolean[] set = new boolean[3000];
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 1000; j++)
				set[j] = false;
			
			st = new StringTokenizer(f.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			for(int j = A; j <= B; j++) {
				countRecycle = 1;
				if(set[j])
					continue;
				else {
					set[j] = true;
					numDigit = 1;
					while(j/(int)Math.pow(10, numDigit) != 0)
						numDigit++;
					for(int k = 1; k < numDigit; k++) {
						tempPow = (int) Math.pow(10, k);
						temp1 = j/tempPow;
						temp2 = j - temp1 * tempPow;
//						System.out.println("j: " + j + "\ntemp1: " + temp1 + "\ntemp2: " + temp2 + "\ntempPow: " + tempPow);

						if(temp2*10 / tempPow == 0)
							continue;
						temp = temp2 * (int) Math.pow(10, numDigit - k) + temp1;
						
//						System.out.println("j: " + j + "\ntemp1: " + temp1 + "\ntemp2: " + temp2 + "\ntemp:" + temp);
						
						if( (A <= temp) && ( temp <= B) && (!set[temp]) ) {
							set[temp] = true;
							countRecycle++;
						}				
					}
				}
				result[i] += countRecycle * (countRecycle - 1) / 2;
			}
		}
		
		for(int i = 0; i < T; i++) {
			out.println("Case #" + (i + 1) + ": " + result[i]);
		}
		
		out.close();
	}

}
