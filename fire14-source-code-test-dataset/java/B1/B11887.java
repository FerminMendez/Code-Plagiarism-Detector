import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class CRecycledNumbers {
	public static HashSet<Integer> hs = new HashSet<Integer>();
	public static int m;

	public static void solve() throws NumberFormatException, IOException {
		File f = new File("E:\\downloads\\C-small-attempt0.in");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		File f2 = new File("C:\\Users\\kimo\\Desktop\\out.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
		int x = Integer.parseInt(reader.readLine());
		String st[] = null;

		for (int k = 0; k < x; k++) {
	
			st = reader.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			m = Integer.parseInt(st[1]);
			int count = 0;
			for (int i = n; i < m + 1; i++) {
				
				if (i < m) {
					count += numOfways(i + "");
				}
			}
			writer.write("Case #" + (k + 1) + ": " + count);
		writer.newLine();
		}
		writer.close();
		reader.close();
	}

//	public static boolean check(String n, String m) {
//		boolean found = false;
//		int i = 0;
//		for (; i < n.length() && !found; i++) {
//			if (n.charAt(i) == m.charAt(0)) {
//				found = true;
//			}
//		}
//
//		int j = 0;
//		i = i - 1;
//		while (j < m.length() && found) {
//
//			if (n.charAt(i) != m.charAt(j))
//				found = false;
//			j++;
//			i = (i + 1) % m.length();
//		}
//		return found;
//	}

	public static int numOfways(String n) {
		String tail = "";
		String head = "";
		String ss = "";
		int counter = 0;
hs.clear();
		for (int i = 1; i < n.length(); i++) {
			tail = n.substring(i, n.length());
			head = n.substring(0, i);
			ss = tail + head;
			
			int ssi = Integer.parseInt(ss);
			if ((ssi + "").length() == n.length()&&ssi>Integer.parseInt(n)) {
				if ( ssi <= m&&!hs.contains(ssi)) {
					hs.add(ssi);
					
					counter++;
				}
				
			}

		}
		return counter;

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		solve();
		//m=500;
		//System.out.println(numOfways("301"));
	}

}
