import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;


public class C {
	public static void main(String[] args) {
		// split table
		int split[] = new int[10];
		for (int i = 0; i < split.length; i++) {
			split[i] = (int)Math.pow(10, i);
		}
		
		// read input
		CaseC[] cases = read("C-small-attempt0.in");
		int front, back, size, m, a, b;
		// calculate each case
		for (CaseC c : cases) {
			// in each case
			size = c.getSize();
			a = c.getA();
			b = c.getB();
			for (int n = a; n <= b; n++) {
				// for each value in range [A, B]
				for (int i = size - 1; i > 0; i--) {
					front = n / split[i];
					back = n % split[i];
					
					if (back < split[i-1]) {
						// ignore case with leading zero(s) in "back" part
						//System.err.printf("Leading zero at position %d in number %d\n", i, n);
						continue;
						
					}
					
					m = back * split[size - i] + front;
					if (m > n && m <= b) {
						c.increment(n, m);
					}
				}
			}
		}
		
		// write output
		writeFile(cases, "C-small-attempt0.out");
		print("Complete!");
	}
	
	public static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}
	
	public static void print(Object o) {
		System.out.println(o);
	}
	
	public static void writeFile(CaseC[] result, String out) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(out);
			for (int i = 0; i < result.length; i++) {
				writer.printf("Case #%d: %s\n", i+1, result[i]);
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	public static CaseC[] read(String file) {
		BufferedReader reader = null;
		CaseC[] cases = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			
			// get test case count
			int caseCount = Integer.parseInt(reader.readLine());
			cases = new CaseC[caseCount];
			for (int i = 0; i < cases.length; i++) {
				String[] paramStr = reader.readLine().split(" ");
				cases[i] = new CaseC(Integer.parseInt(paramStr[0]), Integer.parseInt(paramStr[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cases;
	}
}

class CaseC {
	private int a;
	private int b;
	private int size;
	//private int count; 
	private HashSet<String> set; 
	
	public CaseC(int a, int b) {
		this.a = a;
		this.b = b;
		this.size = String.valueOf(b).length();
		this.set = new HashSet<String>();
		//System.out.printf("A=%d, B=%d, Size=%d\n", a, b, size);
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getSize() {
		return size;
	}

	public void increment(int n, int m) {
		
		String s = n + ":" + m;
		if (set.contains(s)) {
			//System.err.println("Duplicated entry: " + s);
		} else {
			set.add(s);
			//count++;
		}
	}
	
	public int getCount() {
		//return count;
		return set.size();
	}
	
	@Override
	public String toString() {
		return "" + set.size();
	}
}