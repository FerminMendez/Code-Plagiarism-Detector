package szarfos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<String[]> numbers;
	
	public static void main(String[] args) throws IOException {
		readFile();
		BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
		for (int i = 0; i < numbers.size(); i++) {
			int bound1 = Integer.parseInt(numbers.get(i)[0]);
			int bound2 = Integer.parseInt(numbers.get(i)[1]);
			int c = 0;
			for (int n1 = bound1; n1 <= bound2; n1++) {
				for (int n2 = bound1; n2 <= bound2; n2++) {					
					if (isRecNums(Integer.toString(n1), Integer.toString(n2))) {
						c++;
					}
				}
			}
			
			System.out.println("Number of rec nums: " + c/2);
			int caseNum = i+1;
		    out.write("Case #" + caseNum + ": " + c/2);		
		    out.newLine();
		}	
		out.close();
	}		
	
	public static void readFile() {
		try {
			numbers = new ArrayList<String[]>();
		    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		    String str;
		    in.readLine();
		    while ((str = in.readLine()) != null) {
		    	String[] n = str.split(" ");
		    	numbers.add(n);
		    }
		    in.close();
		} catch (IOException e) {
		}
	}
	
	public static boolean isRecNums(String n, String m) {
		if (n.length() != m.length())
			return false;
		
		if (n.equals(m))
			return false;
		
		for (int i = 0; i < n.length()-1; i++) {
			if (changeNumber(n, i).equals(m)) {
				return true;
			}
		}
		return false;
	}
	
	public static String changeNumber(String n, int k) {
		String tmp = n.substring(n.length()-1-k, n.length());
		n = tmp + n.substring(0, n.length()-1-k);
		
		return n;
	}
	

}
