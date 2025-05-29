import java.io.*;
import java.util.*;

public class core {
	public static void main(String[] argv) throws Exception {
	
		String inputFile = argv[0];
		Scanner scan = null;
		FileReader fR = null;
		BufferedReader bR = null;

		int T;
		
		
		try{
			
			fR = new FileReader(inputFile);
			bR = new BufferedReader(fR);

			
			
			T = Integer.parseInt(bR.readLine());
			
			for(int i = 0; i <= T; i++){
				
				String[] temp = (bR.readLine()).split(" ");
				int[] input = new int[temp.length];
				for(int j =0; j < temp.length; j++){
					input[j] = Integer.parseInt(temp[j]);
				
				}
				
				int N = input[0];
				int S = input[1];
				int p = input[2];
				int[] division = new int[N];
				int[] remainder = new int[N];
				int out=0;
				
				
				for(int k = 3; k < input.length; k++){
					
					division[k-3] = input[k]/3;
					remainder[k-3] = input[k]-(division[k-3]*3);
					//System.out.println("" + division[k-3] + " : " + remainder[k-3] );
				}
				
				//System.out.println();
				
				for(int l = 0; l < division.length; l++){
					if(division[l]>=p){
						out++;
						//System.out.println("Did " + l);
					} else if ((division[l] == (p-1)) && (remainder[l]>0) ){
						out++;
						//System.out.println("Did 1 " + l);
					} else if ((division[l] == (p-2)) && (remainder[l]==2) && S > 0){
						out++;
						S--;
						//System.out.println("Did 2 " + l);
					} else if (division[l] == p-1 && remainder[l] == 0 && S > 0 && division[l] > 0){
						out++;
						S--;
						//System.out.println("Did 3 " + l);
					} 
						
				}
				
				int caseIndex = i+1;
				System.out.println("Case #" + caseIndex + ": " + out);
			
			}
			
		} catch(Exception e){}
	}
}
