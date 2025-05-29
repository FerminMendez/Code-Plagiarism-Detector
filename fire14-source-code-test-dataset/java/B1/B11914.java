package qualificationround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemCRecycledNumbers {

	@SuppressWarnings("unchecked")
	public ProblemCRecycledNumbers() {
		try {
			FileReader fr = new FileReader("C-small-attempt0.in");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("C-small-attempt0.out");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int numCases = Integer.parseInt(br.readLine());
			int caseNum = 1;
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				
				String[] nums = line.split(" ");
				int lowNum = Integer.parseInt(nums[0]);
				int highNum = Integer.parseInt(nums[1]);
				
				Set<Pair> possibles = new HashSet<Pair>();
				for (int num = lowNum; num<= highNum; num++) {
					Pair[] recycled = getRecycledNumbers(num);
					for (int i=0; i<recycled.length; i++) {
						if (recycled[i] != null && recycled[i].int1 >= lowNum) {
							possibles.add(recycled[i]);
						}
					}
				}
				
				System.out.println(possibles);
				
				String output = "Case #"+ caseNum;
				output += ": "+possibles.size();
				
				System.out.println(output);
				bw.append(output);
				if (caseNum != numCases)
					bw.newLine();
				
				caseNum++;
				line = br.readLine();
			}
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printArr(Pair[] arr) {
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("]");
	}
	
	public Pair[] getRecycledNumbers(int num) {
		String numSt = num + "";
		Pair[] recycled = new Pair[numSt.length() - 1];
		
		for(int i=0; i<recycled.length; i++) {
			String newNumSt = numSt.substring(i + 1) + numSt.substring(0, i+1);
			int newNum = Integer.parseInt(newNumSt);

			if (! newNumSt.substring(0,1).equals("0") && newNum < num) {
				//no leading 0's
				recycled[i] = new Pair(newNum, num);
			} else {
				recycled[i] = null;
			}
		}
		
		return recycled;
	}
	
	public static void main(String[] args) {
		new ProblemCRecycledNumbers();
	}
	
	class Pair implements Comparable<Pair>{
		int int1, int2;
		
		public Pair(int int1, int int2) {
			this.int1 = int1;
			this.int2 = int2;
		}
		
		public boolean equals(Pair p) {
			return 
					(p.int1 == this.int1 && p.int2 == this.int2) ||
					(p.int2 == this.int1 && p.int1 == this.int2);
		}
		
		public boolean equals(Object p) {
			return this.equals((Pair) p);
		}
		
		public int hashCode() {
			return this.int1 * 10000000 + int2;
		}
		
		public String toString() { return "("+int1+","+int2+")"; }

		public int compareTo(Pair p) {
			return this.int1 - p.int1;
		}
	}

}
