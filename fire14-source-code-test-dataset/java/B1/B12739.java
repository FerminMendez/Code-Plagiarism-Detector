import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RecycledNumbers {
	
	private static String shiftLeft(String str) {
		
		char first_char = str.charAt(0);
		
		String new_number_str = str.substring(1);
		
		new_number_str += first_char;
		
		return new_number_str;
	}
	
	private static boolean recycled(int num1, int num2) {
		String num1Str = Integer.toString(num1);
		String num2Str = Integer.toString(num2);
		
				
		for(int i = 0; i < num2Str.length() - 1; i++) {
			String newStr2 = shiftLeft(num2Str);
			if(num1Str.equals(newStr2))
				return true;
			
			num2Str = newStr2;
		}
		return false;
	}
	
	private static int numDigits(int number) {
		if(number == 0)
			return 1;
		
		int numDigits = 0;
		while(number != 0) {
			number /= 10;
			numDigits++;
		}
		
		return numDigits;
	}

	public static void main(String[] args) throws IOException {
		  FileInputStream fstream = new FileInputStream("input.txt");
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  
		  FileWriter fstreamOut = new FileWriter("output.txt");
		  BufferedWriter out = new BufferedWriter(fstreamOut);
		  
		  String strLine = br.readLine();
		  if(strLine.charAt(strLine.length() - 1) == '\n')
			  strLine = strLine.substring(0, strLine.length() - 1);
		  
		  int numCases = Integer.parseInt(strLine);
		  
		  for(int i = 1; i <= numCases; i++) {
			  strLine = br.readLine();
			  if(strLine.charAt(strLine.length() - 1) == '\n')
				  strLine = strLine.substring(0, strLine.length() - 1);
			  
			  int space = strLine.indexOf(' ');
			  
			  int A = Integer.parseInt(strLine.substring(0, space));
			  int B = Integer.parseInt(strLine.substring(space + 1));
			  
			  //System.out.println(A + " and " + B);
			  
			  int numCase = 0;
			  
			  for(int m = A + 1; m <= B; m++) {
				  for(int n = A; n < m; n++) {
					  if(recycled(n, m)) {
						  //System.out.println("WORKS: " + m + " and " + n);
						  numCase++;
					  }
				  }
			  }
			  
			 out.write("Case #" + i + ": " + numCase);
			 if(i < numCases)
				 out.write("\n");
		  }
		  
		  in.close();
		  br.close();
		  
		  out.close();
	}
}
