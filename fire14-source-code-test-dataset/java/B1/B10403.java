import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {
	
	public static void main(String[] args) throws Exception {
		System.out.println(
			parseOfFile(new File("C:\\code\\teste.txt"))
		);
	}
	
	public static String parseOfFile(File file) throws Exception {
		FileInputStream fstream = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuffer sb = new StringBuffer();

		String strLine;
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine.trim());
			sb.append("\n");
		}

		return parser(sb.toString());
	}
	
	public static String parser(String string) {
		String[] lines = string.split("\n");
		StringBuffer sb = new StringBuffer();
		
		for (int index = 1; index < lines.length; index++) {
			String[] values = lines[index].split(" ");
			int a = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);
			
			sb.append("Case #");
			sb.append(index);
			sb.append(": ");
			sb.append(quantidade(a, b));
			
			if (index != lines.length - 1) sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static int quantidade(int a, int b) {
		List<Integer> availablesNumbers = new ArrayList<Integer>();
		Set<Pair> pairs = new HashSet<Pair>();
		
		for (int number = a; number <= b; number++) 
			availablesNumbers.add(number);
		
		for (Integer integer : availablesNumbers) {
			String string = integer.toString();
			for (int index = 1; index <= string.length(); index++) {
				String newString = string.substring(index) + string.substring(0, index);
				Integer newNumber = Integer.parseInt(newString);
				
				if (!availablesNumbers.contains(newNumber)) continue;
				if (integer.equals(newNumber)) continue;
				if (integer < newNumber) continue;
				
				pairs.add(new Pair(integer, newNumber));
			}
		}
		
		return pairs.size();
	}
	
	public static class Pair {
		Integer a;
		Integer b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj.getClass() != Pair.class) return false;
			Pair other = (Pair) obj;
			
			if (other.a.equals(a) && other.b.equals(b)) return true;
			if (other.a.equals(b) && other.b.equals(a)) return true;
			if (other.b.equals(a) && other.a.equals(b)) return true;
			
			return false;
		}
		
		@Override
		public String toString() {
			return "[ " + a + ", " + b + " ]";
		}
	}

}
