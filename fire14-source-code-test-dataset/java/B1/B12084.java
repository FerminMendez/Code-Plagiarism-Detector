import java.io.*;
import java.util.*;

public class C
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numCases; i++) {
			solveCase(i+1, br.readLine());
		}
	}
	
	private static void solveCase(int caseNum, String line) {
		String[] parts = line.split(" ");
	
		int start = Integer.parseInt(parts[0]);
		int end = Integer.parseInt(parts[1]);
		
		System.out.println("Case #"+caseNum+": "+solve(start, end));
	}
	
	private static int solve(int start, int end) {
		
		int res = 0;
		for(int i = start; i <= end; i++) {
			HashSet<Integer> encountered = new HashSet<Integer>();
			
			String asString = ""+i;
			for(int index = 1; index < asString.length(); index++) {
				char letter = asString.charAt(index);
				if(letter == '0') {
					//System.out.println(i+": skip index "+index);
					continue; // cant have leading 0
				}
				int switched = Integer.parseInt(asString.substring(index)+asString.substring(0, index));
				if(switched > i && switched >= start && switched <= end) {
					//encountered.add(i);
					
					if(encountered.contains(switched)){
						//System.out.println("already had "+switched);
						continue;
					}
					encountered.add(switched);
					res++;
					//System.out.println(i+": "+switched);
				} else {
					//System.out.println(i+": "+switched+" doesnt work");
				}
			}
		}
		return res;
	}
}