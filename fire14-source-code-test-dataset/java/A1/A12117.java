import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;


public class q2 {
	
	static int n = 0, s = 0, p = 0;
	static int t[];
	
	public static void main(String args[]) throws Exception {
		String path = "./src/";
		String ifile = path + "B-small-attempt1.in";
		String ofile = path + "B-small-attempt1.out";
		int i = 0, j = 0;
		
		

		
		
		BufferedReader in = new BufferedReader(new FileReader(ifile));
		StringBuilder os = new StringBuilder();

		
		
		String line = null;
		int ln = 0;
		
		in.readLine();
		
		while ((line = in.readLine()) != null) {
			String vs[] = line.split(" ");
			
			n = Integer.parseInt(vs[0]);
			s = Integer.parseInt(vs[1]);
			p = Integer.parseInt(vs[2]);
			
			t = new int[vs.length - 3];
			for (i = 0; i + 3< vs.length; ++i)
				t[i] = Integer.parseInt(vs[i+3]);
			
			++ln;
			os.append(String.format("Case #%d: %d", ln, max()));
			os.append('\n');
		}
		
		in.close();
		
		
		Writer out = new BufferedWriter(new FileWriter(ofile));
		out.write(os.toString());
		out.close();
	}
	
	static int max() {
//		Set<Integer> csp = new HashSet<Integer>();
//		Set<Integer> csc = new HashSet<Integer>();
		
		int max = 0;
		int i = 0,j = 0;
		
		int ipn = 0;
		int pn = 0;
		int cn = 0;
		
		int min_p;
		int max_p;
		
		if (p == 1) {
			min_p = 1;
			max_p = 0;
		}	
		else {
			min_p = p * 3 - 4;
			max_p = (p - 1) * 3;
		} 
		
		for (i = 0; i < t.length; ++i) {

			
			if (t[i] < min_p)
				++ipn;
			else if (t[i] > max_p)
				++cn;
			else
				++pn;
			
//			a += ((t[i] % 3) == 2) ? 2 : 1;
//
//			if ( a > p )
//				cs.add(new Integer(t[i]));
		}

		if (s <= pn)
			max = s + cn;
		else if (s > pn)
			max = pn + cn;
		
		
		return max;
	}
	
}

