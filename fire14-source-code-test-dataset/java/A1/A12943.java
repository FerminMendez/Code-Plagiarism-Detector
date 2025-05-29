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
			int numberOfPersons = Integer.parseInt(numbers.get(i)[0]);
			int surp = Integer.parseInt(numbers.get(i)[1]);
			int limit = Integer.parseInt(numbers.get(i)[2]);
			
			List<Integer> totalPoints = new ArrayList<Integer>();
			for (int j = 3; j < numbers.get(i).length; j++) {
				totalPoints.add(Integer.parseInt(numbers.get(i)[j]));
			}
					
			List<Integer[]> points = new ArrayList<Integer[]>();
			for (int j = 0; j < totalPoints.size(); j++) {
				points.add(splitPoints(totalPoints.get(j)));
			}
			
			int currentSurp = 0;
			int count = 0;
			for (int j = 0; j < points.size(); j++) {								
				if (totalPoints.get(j) > 1 &&
						points.get(j)[0] > 0 && points.get(j)[0] == limit - 1 && currentSurp < surp) {
					if (points.get(j)[1] != points.get(j)[2] || 
							(points.get(j)[0] == points.get(j)[1] && points.get(j)[0] == points.get(j)[2])) {
						points.get(j)[0]++;
						currentSurp++;
					}														
				}
				
				if (points.get(j)[0] >= limit) {
					count++;
				}
			}								
			
			int caseNum = i+1;
			out.write("Case #" + caseNum + ": " + count);		
		    out.newLine();
		}
		out.close();
	}		
	
	public static Integer[] splitPoints(int p) {
		Integer[] points = new Integer[3];
		int m = p / 3;		
		if (p%3 == 1) {
			points[0] = m+1;
			points[1] = m;
			points[2] = m;
		} else if (p%3 == 2) {
			points[0] = m+1;
			points[1] = m+1;
			points[2] = m;
		} else {
			points[0] = m;
			points[1] = m;
			points[2] = m;
		}
					
		return points;
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
	
}
