import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class DancingGooglers {
	public static final int MAX_SCORE = 10;
	public static final int MIN_SCORE = 0;
	public static final int MAX_TOTAL = 30;
	public static final int MIN_TOTAL = 0;
	private Map<Integer,Integer> normal;
	private Map<Integer,Integer> surprising;
	private List<Integer> normals;
	public DancingGooglers() {
		int i=0;
		normal = new TreeMap<Integer, Integer>();
		surprising = new TreeMap<Integer, Integer>();
		normals = new ArrayList<Integer>();
		normal.put(0, 0); 
		surprising.put(0, 0); 
		for(i=MIN_TOTAL+1;i<=MAX_TOTAL;i++) {
			int base = i/3;
			int mod = i%3;
			List<Integer> scores = new ArrayList<Integer>();
			switch(mod) {
			case 0:
				scores.add(base);
				normal.put(i, Collections.max(scores));
				scores.add(Math.max(0, base-1));
				scores.add(Math.min(10, base+1));
				surprising.put(i, Collections.max(scores)); 
				break;
			case 1:
				scores.add(base);
				scores.add(Math.min(10, base+1));
				normal.put(i, Collections.max(scores));
				scores.add(Math.max(0, base-1));
				surprising.put(i, Collections.max(scores)); 
				break;
			case 2:
				scores.add(base+1);
				scores.add(Math.max(0, base));
				normal.put(i, Collections.max(scores));
				scores.add(Math.min(10, base+2));
				surprising.put(i, Collections.max(scores)); 
				break;
			}
			if(surprising.get(i).equals(normal.get(i))) {
				normals.add(i);
			}
		}
		System.out.println(normal);
		System.out.println(surprising);
		System.out.println(normals);
	}
	public List<Integer> surprising(List<Integer> numbers, int p) {
		List<Integer> surprising = new ArrayList<Integer>();
		for (Integer n : numbers) {
			if(!normals.contains(n) && this.surprising.get(n)>=p && this.normal.get(n)<p) {
				surprising.add(n);
			}
		}
		return surprising;
	}
	public int solve(List<Integer> numbers, int S, int p) {
		int result = 0;
		List<Integer> listSS = surprising(numbers,p);
		int SS = listSS.size();
		Iterator<Integer> i = numbers.iterator();
		if(SS==S || S>SS) { // take all the surprising
			while(i.hasNext()) {
				int n = i.next();
				if(listSS.contains(n) && surprising.get(n)>=p) {
					System.out.println("score: "+surprising.get(n));
					result++;
				}
				else if(normal.get(n)>=p) {
					System.out.println("score: "+normal.get(n));
					result++;
				}
				else {
					System.out.println("score: "+normal.get(n));
				}
			}
		}
		else if(S<SS) { // choose the p best!!!
			result += S;
			while(i.hasNext()) {
				int n = i.next();
				System.out.println("score: "+normal.get(n));
				if(normal.get(n)>=p) {
					result++;
				}
			}
		}else if(S==0) { // take all as normals
			while(i.hasNext()) {
				int n = i.next();
				if(normal.get(n)>=p) {
					result++;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		DancingGooglers dg = new DancingGooglers();
		LineNumberReader in = new LineNumberReader(new FileReader(args[0]+".in"));
		String line = null;
		line = in.readLine();
		if(line==null||line.length()==0)
			return;
		int T = 0;
		T = Integer.parseInt(line);
		PrintStream out = new PrintStream(args[0]+".out");
		for(int i=1; i<=T; i++){
			line = in.readLine();
			String[] data = line.split(" ");
			int N = Integer.valueOf(data[0]);
			int S = Integer.valueOf(data[1]);
			int p = Integer.valueOf(data[2]);
			List<Integer> numbers = new ArrayList<Integer>();
			for(int j=0; j<N; j++) {
				numbers.add(Integer.parseInt(data[3+j]));
			}
			StringBuffer buf = new StringBuffer();
			buf.append("Case #");
			buf.append(i);
			buf.append(": ");
			buf.append(dg.solve(numbers, S, p));
			out.println(buf.toString());
			System.out.println(line);
			System.out.println(buf.toString());
//			System.out.println("Numbers: " +numbers);
//			System.out.println("Surprising: " +dg.surprising(numbers,p));
//			System.out.println("S: " +S);
//			System.out.println("p: " +p);
		}
		in.close();
		out.close();
	}
}
