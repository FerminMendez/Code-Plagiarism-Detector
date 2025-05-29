package codejam2012qual;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;

import util.InputReader;

public class RecycledNumbers implements Runnable {

	private InputReader in;
	private PrintWriter out;
	private static String delimiter = " ";
	
	public static void main(String[] args) {
		new Thread(new RecycledNumbers()).start();
	}
	
	public RecycledNumbers() {
		try {			
			BufferedReader buffer = new BufferedReader(new FileReader("d:\\C-small-attempt0.in")); 
			in = new InputReader(buffer);
			
			System.setOut(new PrintStream(new FileOutputStream("d:\\output.txt")));
			out = new PrintWriter(System.out);
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}	
	}
	
	@Override
	public void run() {
		
		int numTests = in.readInt();		
		
        for (int testNumber = 0; testNumber < numTests; testNumber++) {
        	
			out.print("Case #" + (testNumber + 1) + ": ");
        
			String line = in.readString();
			String[] boundary = line.split(delimiter);
			int min = Integer.parseInt(boundary[0]);
			int max = Integer.parseInt(boundary[1]);
			//out.println("min = "+min +"\tmax = "+max);
			
			int counter = 0;
			
			for(int i = min; min < max; max--) {
				i = min;
				
				for(; i< max; i++) {
					//out.println("i = "+i +"\tmax = "+max);
					if(testRecycle(i, max) == true)
						counter++;
				}
			}			

			out.println(counter);
		}
		out.close();
	}

	private boolean testRecycle(int a, int b) {

		String strA = a+"";
		String strB = b+"";		
		String newStrB = strB + strB;
		
		if(newStrB.indexOf(strA) > -1)
			return true;
		
		return false;
	}	

}
