import java.io.*;
import java.util.Scanner;
 
public class functions {
	int solve(String A, String B){

		int result = 0;

		int n = A.length();
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		int i = 0, j = 0, k = 0, index = 0;
		String temp_a = A;
		String temp2 = "";
		int[] array = new int[8];
		for(i = 0; i<8;i++) array[i] = -1;
		
		i = 0;
		int jj = 0,kk = 0;
		while(Integer.parseInt(A) < b-1){
			
			for( index = 0; index <= n-2; index++){
				temp2 = "";
				kk = 0;
				for(j = index; j >= 0; j--){
					temp2 = temp2 + A.charAt(n-1-j);
				}
				for(k = 0; k < n-index-1; k++){
					temp2 = temp2 + A.charAt(k);
				}
				
				int c = Integer.parseInt(temp2);
				if ( c <= b && c > Integer.parseInt(A)) {
					for(jj = 0; jj < 8; jj++){
						if(array[jj] == c){
							break;
						}
					}
					if(jj == 8){
					result = result + 1;
					array[kk++] = c;
					}
					System.out.println("("+A+","+temp2+")");
				}

			}
			A = Integer.toString(Integer.parseInt(A)+1);
			i++;
		}
		
		return result;
	}
}
