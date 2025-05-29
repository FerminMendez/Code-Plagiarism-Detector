import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;


public class q3 {
	
	
	
	public static void main(String args[]) throws Exception {
		String path = "./src/";
		String ifile = path + "C-small-attempt0.in";
		String ofile = path + "C-small-attempt0.out";
		int i = 0, j = 0;
	

		BufferedReader in = new BufferedReader(new FileReader(ifile));
		StringBuilder os = new StringBuilder();
		
		
		String line = null;
		int ln = 0;
		
		in.readLine();
		while ((line = in.readLine()) != null) {
			String vs[] = line.split(" ");
			
			++ln;
			

			
			os.append(String.format("Case #%d: %d", ln, rnum(Long.parseLong(vs[0]), 
					Long.parseLong(vs[1]))));
			os.append('\n');
		}
		
		in.close();
		
		
		Writer out = new BufferedWriter(new FileWriter(ofile));
		out.write(os.toString());
		out.close();
	}
	
	static long rnum(long min, long max) {
		long c = 0, i = 0;
		int j = 0, k = 0;
		
		for (i = min; i <= max; ++i) {
			int length = (int)Math.log10(i) + 1;
			int num[] = new int[length];
			
			
			long t = i;
			j = 0;
			while (t > 0) {
				num[j++] = (int)t%10;
				t = t / 10;
			}
			
			
			int first = num.length - 1;

			HashSet<Long> s = new HashSet<Long>();
			
			for (j = first - 1; j >= 0; --j) {
				if (num[j] >= num[first]) {
					int temp = j;
					long nr = 0;
					for (k = length - 1; k >= 0; --k) {
						nr += num[temp--] * (Math.pow(10,k));
						if (temp == -1)
							temp = first;
					}
					

					if (nr > i && nr > min && nr <= max && !s.contains(new Long(nr))) {
						c++;
						s.add(new Long(nr));
					}
				}
			}
			
		}
		
		return c;
	}

	


}

