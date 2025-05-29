package problemB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



public class DancingwithTheGooglers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		FileWriter fw = new FileWriter("B-small-attempt0.out");
		/*BufferedReader in = new BufferedReader(new FileReader("A-large-practice.in"));
		FileWriter fw = new FileWriter("A-large-practice.out");*/
		int T = new Integer(in.readLine());
		for (int cases = 1; cases <= T; cases++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int numG = new Integer(st.nextToken());
			int numTriplets = new Integer(st.nextToken());
			int leastP = new Integer(st.nextToken());
			Integer[] A = new Integer[numG];
			for (int i = 0; i < A.length; i++){
				A[i] = new Integer(st.nextToken());
			}
			Arrays.sort(A, Collections.reverseOrder());
			int result = 0;
			for (int i = 0; i < A.length; i++){
				if (A[i] >= 2){
					if (A[i] > (leastP * 3 - 3)){
						result++;
					}
					else{
						if ((A[i] > (leastP *3 - 5)) && numTriplets > 0){
							result++;
							numTriplets--;
						}
					}
				}
				else{
					if (A[i] >= leastP){
						result++;
					}
				}
			}
			
			if (cases != T) {fw.write("Case #" + cases + ": "+ result + "\n"); }
			else{fw.write("Case #" + cases + ": "+ result);}
		}
		fw.flush();
		fw.close();
	}
}
