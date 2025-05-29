package numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader("C-small0.in"));
		BufferedWriter wr = new BufferedWriter(new FileWriter("output"));
		
		Integer cases = Integer.valueOf(br.readLine());
		for (int caseNumber = 1; caseNumber<=cases; ++caseNumber){
			String[] line = br.readLine().split(" ");
			Integer A = Integer.valueOf(line[0]);
			Integer B = Integer.valueOf(line[1]);
			StringBuffer bf = new StringBuffer();
			bf.append("Case #");
			bf.append(caseNumber);
			bf.append(": ");
			
			if (A<11)
				A = 11;
			int counter = 0;
			for (int n=A; n<=B;++n){
				counter += findRecycled(n, B);
			}
			bf.append(counter);
			wr.write(bf.toString());
			wr.newLine();
			wr.flush();
		}

	}

	private static int findRecycled(int n, int limit) {
		
		int retVal = 0;
		HashSet<String> possibles = new HashSet<String>();
		String base = String.valueOf(n);
		for (int i=1; i<base.length();++i){
			String possibility = base.substring(i).concat(base.substring(0,i));
			possibles.add(possibility);
		}
		for (String possibility : possibles){
			int check = Integer.valueOf(possibility);
			if (check>n && check<=limit)
				++retVal;
		}
		return retVal;
	}

}
