package codejam2012qual;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

import util.InputReader;

public class DancingGooglers implements Runnable {

	private InputReader in;
	private PrintWriter out;
	private static String delimiter = " ";
	
	public static void main(String[] args) {
		new Thread(new DancingGooglers()).start();
	}
	
	public DancingGooglers() {
		try {			
			BufferedReader buffer = new BufferedReader(new FileReader("d:\\B-small-attempt0.in")); 
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
			String[] strVector = line.split(delimiter);
			
			int numbers = Integer.parseInt(strVector[0]);
			if (numbers == 0) {
				out.println(0);
				continue;
			}
			
			int surTriplets = Integer.parseInt(strVector[1]);
			int target = Integer.parseInt(strVector[2]);
						
			int[] scores = new int[numbers];
			for(int i=0; i<numbers; i++) {
				scores[i] = Integer.parseInt(strVector[i+3]);
			}
			
			int counter = 0;
			Arrays.sort(scores);
			for(int i = scores.length-1; i>=0 && surTriplets>=0 ; i--) {
				//out.print(scores[i]/3.0+"\t");
				
				if((scores[i] - target) >= 2*(target-1) && (scores[i] - target)>=0)
					counter++;
				else if(surTriplets > 0) {
					if((scores[i] - target) >= 2*(target-2) && (scores[i] - target)>=0) {
						counter++;
						surTriplets--;
					}						
				}
				else
					break;
			}			
			out.println(counter);
		}
		out.close();
	}

}
