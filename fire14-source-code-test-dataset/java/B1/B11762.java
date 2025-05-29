package round03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Problem

Do you ever become frustrated with television because you keep seeing the same things, recycled over and over again? Well I personally don't care about television, but I do sometimes feel that way about numbers.

Let's say a pair of distinct positive integers (n, m) is recycled if you can obtain m by moving some digits from the back of n to the front without changing their order. For example, (12345, 34512) is a recycled pair since you can obtain 34512 by moving 345 from the end of 12345 to the front. Note that n and m must have the same number of digits in order to be a recycled pair. Neither n nor m can have leading zeros.

Given integers A and B with the same number of digits and no leading zeros, how many distinct recycled pairs (n, m) are there with A ¡Â n < m ¡Â B?
Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing the integers A and B.
Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1), and y is the number of recycled pairs (n, m) with A ¡Â n < m ¡Â B.
Limits

1 ¡Â T ¡Â 50.
A and B have the same number of digits.
Small dataset

1 ¡Â A ¡Â B ¡Â 1000.
Large dataset

1 ¡Â A ¡Â B ¡Â 2000000.
Sample


input

4
1 9
10 40
100 500
1111 2222

output 

Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287


 * @author chmin
 *
 */
public class RecycledNumbers {
	
	public static class RNumber {
		String n;
		int cntShift = 0;
		public RNumber( int n){
			init(n);
		}
		
		public void init( int  n ){
			this.n = "" + n;
			cntShift = 0;
		}
		
		public int next() {
			int pos = n.length()-1;
			cntShift ++;
			
			while ( n.charAt(pos) == '0'){
				pos --;
				cntShift ++;
			}
			
			if ( pos > 0 ) {
				String v = n.substring(pos , n.length()) + n.substring(0, pos);
				n = v;
			}
			
			return Integer.parseInt(n);
		}
		
		public boolean hasNext() {
			return cntShift < n.length();
		}
	}
	public void solve() throws IOException{
		Scanner scanner = new Scanner (getClass().getResourceAsStream("R3-small.in"));
		int T = scanner.nextInt();
		RNumber rnum = new RNumber(0);
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T ; i++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			set.clear();
			for( int n = A ; n <= B ; n++){
				rnum.init(n);
				while ( rnum.hasNext() ){
					int m = rnum.next();
					if ( n < m  && m <= B) {
						set.add(n + " " + m);
					}
				}
			}
			sb.append("Case #" + (i+1) + ": " + set.size() + System.getProperty("line.separator"));
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("R3-small.out"));
		bw.write(sb.toString());
		bw.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			new RecycledNumbers().solve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
