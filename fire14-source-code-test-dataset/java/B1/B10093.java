package codeJam2012_Qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class RecycledNumbers {
	private String FILE_NAME = "2012_QC_numbers_C-small-attempt0";
	private TreeMap<Double,Long> numbers;
	private int maxNum = 10000;
	
	private TreeMap<Double,Long> getNumbers() {
		if (numbers == null) {
			String value;
			long newNum;
			
			numbers = new TreeMap<Double,Long>();
			for (int i=10;i<=maxNum;i++) {
				value = String.valueOf(i);
				for (int pos=0;pos<value.length()-1;pos++) {
					long division = Math.round(Math.pow(10,pos+1)); 
					int power = value.length()-pos-1; 
					newNum = Math.round(i/division + (i%division)*Math.pow(10,power));
					
					if (i<newNum && newNum<=maxNum && value.length()==String.valueOf(newNum).length()) {
						numbers.put(Double.valueOf(i+"."+newNum),newNum);
					}
				}
			}
		}
		return numbers;
	}

	private int solve(String input) {
		Scanner sc = new Scanner(input);
		
		double lowest = sc.nextInt();
		double highest = sc.nextInt();
		int count = 0;
		
		NavigableMap<Double,Long> recycles = getNumbers().subMap(lowest, true, highest, true);
		for (Map.Entry<Double, Long> recycle : recycles.entrySet()) {
			if (recycle.getValue()<highest+1) {
				count++;
			}
		}
		
		return count;
	}
	
	public void run() throws IOException {
		Scanner sc = new Scanner(new FileReader(FILE_NAME+".in"));
		PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME+".out"));
		
		int cases = Integer.valueOf(sc.nextLine());
		for (int i=1;i<=cases;i++) {
			String input = sc.nextLine();
			System.out.println("Input #"+i+": "+input);

			String output = "Case #"+i+": "+solve(input);
			pw.println(output);
			System.out.println(output);
		}
		
		pw.flush();
		pw.close();
		sc.close();
	}
	public static void main(String[] args) throws IOException {
		new RecycledNumbers().run();
	}
}
