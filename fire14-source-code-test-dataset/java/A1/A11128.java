package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintWriter out = null;
		BufferedReader in = null;
		String test;
		
		try {
			
			out = new PrintWriter(args[1]);
			in = new BufferedReader(new FileReader(args[0]), 1024);
			
			// number of test cases
			in.readLine();
			
			for (int i=1; (test=in.readLine())!=null; i++) {
				String parameters[] = test.split(" ");
				int googlers = 0;
				int surprising = 0;
				int totalSurprising = Integer.parseInt(parameters[1]);
				int minScore = Integer.parseInt(parameters[2]);
				int minTotal = minScore * 3;
				for (int j=3; j<parameters.length; j++) {
					int score = Integer.parseInt(parameters[j]);
					if (minTotal==0) {
						googlers++;
					}
					else if (score==0) {
						// do nothing
					}
					else if (score>=minTotal-2) {
						googlers++;
					}
					else if (score>=minTotal-4&&surprising<totalSurprising) {
						googlers++;
						surprising++;
					}
				}
				out.printf("Case #%d: %d%n", i, googlers);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (in!=null)
				in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (out!=null)
			out.close();
		
		
	}

}
