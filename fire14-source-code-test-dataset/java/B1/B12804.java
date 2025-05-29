import java.io.*;
import java.util.*;

public class Recycle {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("input.in"));
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		int T = sc.nextInt(); // number of cases
		int A;
		int B;
		int counter;
		int m;
		String nStr = "";
		String mStr = "";
		String front = "";
		String back = "";
		
		for(int i = 1; i <= T; i++) { // for each test case
			A = sc.nextInt();
			B = sc.nextInt();
			counter = 0;
			
			for(int n = A; n <= B; n++) { // at most 899 loops
				nStr = Integer.toString(n);
				if(nStr.charAt(0) == '0')
					continue;
				// create m
				for(int j = 1; j < nStr.length(); j++) { // at most 3 loops
					front = nStr.substring(0, j);
					back = nStr.substring(j);
					mStr = back.concat(front);
					if(mStr.charAt(0) == '0')
						continue;
					m = Integer.parseInt(mStr);
					
					if(n >= A && n < m && m <= B)
						counter++;
				}
			}
			out.write("Case #" + i + ": " + counter);
			if(i != T)
				out.newLine();
		}
		out.close();
	}
}
