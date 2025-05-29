package wangshu.codejam.google.com;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;


public class QC {
	
	public static long calculateNumber(int A, int B){
		
		int size = B-A+1; // Number of integers between A and B
		int A1; // Auxiliary variable that helps to calculate numberOfDigits;
		int numberOfDigits; // Number of digits of A
		int multiple = 1; // Auxiliary variable that helps to calculate rotation;
		int count = 0; // Count stores for each integer between A and B ,
		               //the number of rotated integer that also between A and B
		long result = 0;
		boolean[] counted = new boolean[size]; //Indicate whether the number has been counted or not
		
		//Initialize counted array		
		Arrays.fill(counted, false);
		
		// Calculate the number of digits of A
		for(numberOfDigits=0, A1=A; A1!=0; numberOfDigits++){
			A1 = A1/10;
			multiple = multiple*10;
		}
		
		multiple = multiple/10;
		
		//Calculate the result
		for(int i=A; i<=B; i++){
			count = 0;
			if(!counted[i-A]){
	
				int k=i;
				
//System.out.println("#######");				
				for(int j=0; j<numberOfDigits; j++){						
					if( k>=A && k<=B && !counted[k-A]){
						count ++;
						counted[k-A] = true;
//System.out.println("k is " + k);									
					}
					
					int unitNnumber = k%10;
					k = k/10 + multiple*unitNnumber;
				}
				
			}
/*
if(count > 1){
	System.out.println("**************");
}
*/
			result = result+ ((count)*(count-1))/2;
			
		}		
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.lang.Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("qc_in_small.txt"));  // Scanner for input file
		FileWriter outputFile = new FileWriter("qc_out_small.txt");
		
		int A, B;
		//Read number of test cases
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			A = sc.nextInt();
			B = sc.nextInt();
			
		if(B < A)
			throw (new Exception("B is less than A"));
			
//System.out.println("Case #" + (i+1) + ": " + calculateNumber(A, B));
//System.out.println("---------------------------");
			outputFile.write("Case #" + (i+1) + ": " + calculateNumber(A, B)+"\r\n");
		}
		outputFile.flush();
	}

}
