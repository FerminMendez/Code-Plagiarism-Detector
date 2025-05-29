import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Recycled {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("io/recycled-biga.in"));
		FileWriter fw = new FileWriter(new File("io/recycled.out"));
		
		int cases = s.nextInt();
		s.nextLine();
		for(int i = 0; i < cases; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			String out = "Case #" + (i+1) + ": " + solve(a, b);
			System.out.println(out);
			fw.write(out + "\n");
		}
		
		s.close();
		fw.close();
	}

	private static int solve(int n, int m) {
		int rotations = Integer.toString(n).length();
		int count = 0;
		
		String nStr;
		
		
		// For each n to m
		for(int i = n; i < m; i++) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			nStr = "" + i;
			// Rotate through all possible configurations of n
			for(int r = 0; r < rotations -1; r++) {
				nStr = nStr.substring(rotations - 1) + nStr.substring(0, rotations-1);
				if(nStr.charAt(0) != '0') {
					int newN = Integer.parseInt(nStr);
					if(newN > i && newN <= m) {
						if(l.contains(newN) == false) {
							l.add(newN);
							count++;
						}
					}
				}
			}
		}
		
		return count;
	}

}
