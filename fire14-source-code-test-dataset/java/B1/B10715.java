import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		File inputFile = new File("input.txt");
		BufferedReader br = null;
		FileOutputStream out = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			String line;
			line = br.readLine();
			if (line == null) {
				throw new IllegalStateException("Empty input file!!!");
			}
			
			
			StringBuilder result = new StringBuilder();
			
			int length = Integer.parseInt(line), i = 1;
			while (i <= length) {
				result.append("Case #").append(i).append(": ");
///////////////////////////////////////////////////////////////////////////////////////////////////

				Set<String> match = new HashSet<String>();
				String[] numbers = br.readLine().split(" ");
				int n = Integer.parseInt(numbers[0]);
				int m = Integer.parseInt(numbers[1]);
				for (int j = n;j < m; j++) {
					String num = j + "";
					char[] charArray = num.toCharArray();
					if (num.length() < 2 || isCharsEqual(charArray)) {
						continue;
					}
					
					addMatches(charArray, n, m, match);
				}
				result.append(match.size());
				
///////////////////////////////////////////////////////////////////////////////////////////////////
				result.append("\n");
				i++;
			}
			
			File outputFile = new File("output.txt");
			outputFile.delete();
			outputFile.createNewFile();
			
			out = new FileOutputStream(outputFile);
			out.write(result.toString().getBytes());
	} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static boolean isCharsEqual(char[] num) {
		char c = num[0];
		for (int i = 1; i < num.length; i++) {
			if (c != num[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void addMatches(char[] num, int lower, int upper, Set<String> match) {
		String n = new String(num);
		char[] tmp = spin(num);
		
		for (int i = 1; i < num.length; i++) {
			if (tmp[0] != '0') {
				int m = Integer.parseInt(new String(tmp));
				String key = genKey(n, "" + m);
				if (lower <= m && m <= upper && !n.equals(m + "") && !match.contains(key)) {
					match.add(key);
				}
			}
			tmp = spin(tmp);
		}
	}
	
	private static char[] spin(char[] source) {
		char[] target = new char[source.length];
		for (int i = 1; i < source.length; i++) {
			target[i] = source[i - 1];
		}
		target[0] = source[source.length - 1];
		return target;
	}
	
	private static String genKey(String n, String m) {
		if (n.compareTo(m) < 0) {
			return n + "|" + m;
		} else 
			return m + "|" + n;
	}
}
