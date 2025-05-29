package recycledNumbers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Flow {

	public static InputData Readin(String filename){
		try {
			FileReader fr = new FileReader(filename);
			Scanner  sc = new Scanner(fr);  
	        
	        int Test_Number = sc.nextInt();
	        System.out.println("The Number of Tests: "+Test_Number);
	        
	        int[] A = new int[Test_Number];
	        int [] B = new int[Test_Number];
	        for(int i=0;i<Test_Number;i++){
	        	int testA = sc.nextInt();
	        	A[i] = testA;
	        	
	        	int testB = sc.nextInt();
	        	B[i] = testB;        	
	        	
	        	
	        	System.out.print("Test "+(i+1)+" "+testA+" ");
	        	System.out.println(testB+" ");
	        }
	        
	        sc.close();
	        
	        InputData inputdata = new InputData(Test_Number, A, B);
	        return inputdata;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;  
		}

	}

	public static void Writeout(OutputData outputdata, String filename) {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			
			int Test_Number = outputdata.getSteps().length;
			for(int i=0;i<Test_Number;i++){
				pw.println("Case #"+(i+1)+": "+outputdata.getSteps()[i]);
			}
			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
