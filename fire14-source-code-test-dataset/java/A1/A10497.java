import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		CaseB[] cases = read("B-small-attempt0.in");
		/*
		// test reading
		for (CaseB c : cases) {
			print(c.getInfo());
		}*/
		
		for (CaseB c : cases) {
			// for each case
			for (int i = 0; i < c.t.length; i++) {
				// for each googler
				int avgBase = c.t[i] / 3;
				int addPoint = c.t[i] % 3;
				int bestResult = avgBase;
				
				// assume no surprising first, if addpoint > 0, best result is at least avgBase + 1
				if (addPoint > 0) {
					bestResult += 1;
				}
				if (bestResult >= c.p) {
					// already larger than p, no surprising needed 
					c.increment();
				} else {
					// use surprising point if possible, 3 conditions
					// 1. still has surprising point to use
					// 2. addPoint is 0 or 2 (surprising can make a difference)
					// 3. total point >= 2 (can't make point 2 apart if the total point is < 2) 
					if (c.hasS() && addPoint != 1 && c.t[i] >= 2) {
						// when addPoint is 0 or 2, best result can be incremented by 1 if is surprising triplet
						if (bestResult + 1 >= c.p) {
							c.useS();
							c.increment();
						}
					}
				}
			}
		}
		
		// write result
		writeFile(cases, "B-small-attempt0.out");
		print("Complete!");
	}
	
	public static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}
	
	public static void print(Object o) {
		System.out.println(o);
	}
	
	public static void writeFile(CaseB[] result, String out) {
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
	
	public static CaseB[] read(String file) {
		BufferedReader reader = null;
		CaseB[] cases = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			
			// get test case count
			int caseCount = Integer.parseInt(reader.readLine());
			cases = new CaseB[caseCount];
			for (int i = 0; i < cases.length; i++) {
				Scanner scan = new Scanner(reader.readLine());
				int n = scan.nextInt();
				int s = scan.nextInt();
				int p = scan.nextInt();
				int[] t = new int[n];
				for (int x = 0; x < n; x++) {
					t[x] = scan.nextInt();
				}
				
				cases[i] = new CaseB(s, p, t);
				scan.close();
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

class CaseB {
	//private int n;	// number of Googler
	private int s;	// number of surprising triplets
	int p;	// expected best result
	int[] t; // total score of each Googler
	
	private int result;
	
	public CaseB(int s, int p, int[] t) {
		this.s = s;
		this.p = p;
		this.t = t;
		this.result = 0;
	}

	public void increment() {
		result++;
	}
	
	public boolean hasS() {
		return s > 0;
	}
	
	public void useS() {
		s--;
	}
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "" + result;
	}
	
	public String getInfo() {
		String out = t.length + " " + s + " " + p;
		for (int i = 0; i < t.length; i++) {
			out += " " + t[i];
		}
		return out;
	}
}
