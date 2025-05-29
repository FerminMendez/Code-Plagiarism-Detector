package GoogleCodeJam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class RecycledNumbers {

	
	public static void main(String[] args) throws IOException {
		InputScanner1 in = new InputScanner1(new File("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
		
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			
			HashSet<String> set = new HashSet<String>();
			int a = in.nextInt();
			int b = in.nextInt();
			
			for (int n = a; n <= b ; n++) {
				
				String number = ""+n;
				int len = Integer.toString(n).length();
				
				for (int j = 1; j < len ; j++) {
					String temp = number.substring(j) + number.substring(0, j);
					
					int k = Integer.valueOf(temp);
					if( k<=b && n<k && number.length() == Integer.toString(k).length()){
						
						
						set.add(number+" "+k);
					}
				}
				
			}
			
			int result = set.size();
			out.println("Case #"+i+": "+result);
		}
		
	
		out.close();
	}


}


class InputScanner1 {
	BufferedReader br;
	StringTokenizer strtok = null;

	public InputScanner1(InputStream stream) {
		br = new BufferedReader(new InputStreamReader(stream));

	}

	public InputScanner1(File file) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(file));
	}

	public String next() {
		if (strtok == null || !strtok.hasMoreTokens()) {
			try {
				strtok = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return strtok.nextToken();
	}

	public int nextInt() {
		int i;
		try {
			i = Integer.parseInt(next());
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
		return i;
	}

	public String nextLine() {
		if (strtok == null || !strtok.hasMoreTokens()) {
			try {
				strtok = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return strtok.nextToken("\n").trim();
	}

}