package ulohy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codejam_3 {
	
	static byte cases;
	static int A, B;
	static List<Integer> l1 = new ArrayList<Integer>();
	static List<Integer> l2 = new ArrayList<Integer>();
	static int[] pairs;
	static int[] rotated_array = new int[10]; 
	
	public static void read_input() {
		
		Scanner s = null;
		try {
			s = new Scanner(new FileReader("./src/ulohy/C-small-attempt1.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		cases = s.nextByte();
		
		pairs = new int[cases]; 
		
		for (int i = 0; i < cases; i++) {
			l1.add(s.nextInt());
			l2.add(s.nextInt());			
		}

		s.close();	
	}
	
	public static void write_output() {
		FileWriter outFile;
		try {
			outFile = new FileWriter("./src/ulohy/output");		
			PrintWriter out = new PrintWriter(outFile);
			for (int i = 1; i <= cases; i++) {
				out.println("Case #"+i+": "+pairs[i-1]);				
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int rotateNumber(int number, int mul)	{
		return number / 10 + mul * (number % 10);		
    }
	
	public static void main(String args[]) {
		
		int rotated;
		
		read_input();
		
		for (int i = 0; i < cases; i++) {			
			
			int numdigits = (int) Math.log10((double)l1.get(i)); // would return numdigits - 1
			int multiplier = (int) Math.pow(10.0, (double)numdigits);
			
			for (int j = l1.get(i); j <= l2.get(i); j++) {
				rotated = rotateNumber(j, multiplier);
				
				for (int k = 0; k <= numdigits; k++) {					
					if (j < rotated && rotated <= l2.get(i)) {
						for (int k2 = 0; k2 < k; k2++) {
							if (rotated == rotated_array[k2]) {
								pairs[i]--;
							}
						}
						pairs[i]++;
					}
					rotated_array[k] = rotated;
					rotated = rotateNumber(rotated, multiplier);
				}				
			}
		}
		
		write_output();
		
	}

}