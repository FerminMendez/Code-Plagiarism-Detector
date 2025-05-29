import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner input;
		try {
			File in = new File(args[0]);
			input = new Scanner(in);
			int testcaseSize = Integer.parseInt(input.nextLine());
			int testcaseNo = 1;
			
			String output = "";
			while ((input.hasNext()) && testcaseNo <= testcaseSize) {
				//read input
				String s = input.nextLine();			
				//solve problem
				String result = solve(s);
				//record formatted result 
				String outputLine = String.format("Case #%d: %s\n", testcaseNo, result);
				//append output
				output += outputLine;
				
				testcaseNo++;
			}
			input.close();
			//print output
			System.out.print(output);
			// write output file
			FileWriter writer = new FileWriter(in.getName() +".out");
			writer.write(output);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String solve (String text){
		String result = "";
		int A = Integer.parseInt(text.substring(0,text.indexOf(" ")));
		int B = Integer.parseInt(text.substring(text.indexOf(" ")+1, text.length()));
		HashSet<Integer> set = new HashSet<Integer>();
		int digits = text.indexOf(" ");

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int n=A; n<=B; n++){
			if (!set.contains(n)) {
				String nString = Integer.toString(n);
				HashSet<Integer> group = new HashSet<Integer>();
				group.add(n);
				
				for (int j=1; j<digits; j++){
					String part1 = nString.substring(0,j);
					String part2 = nString.substring(j,digits);
					int m = Integer.parseInt(part2+part1);
					if (m>=A && m<=B && m!=n) {
						group.add(m);
					}
				}
				
				for (int i : group) set.add(i);
				Object[] groupArray = group.toArray();
				for (int i=0; i<group.size()-1; i++){
					for (int j=i+1; j<group.size(); j++){
						list1.add((Integer)groupArray[i]);
						list2.add((Integer)groupArray[j]);
					}
				}
			}
		}
		
//		for (int i=0;i<list1.size();i++){
//			System.out.println(String.format("(%d,%d);", list1.get(i), list2.get(i)));
//		}
//		System.out.println();
		result = String.valueOf(list1.size());
		return result;
	}
}
