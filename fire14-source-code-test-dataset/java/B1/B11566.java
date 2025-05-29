import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class Solve3 {

	public static void main(String[] args) {

		FileReader fr;
		FileWriter fw;
		try {
			File fi = new File("input.txt");
			fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			fw = new FileWriter("output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			boolean f = true;
			int tCount = Integer.MAX_VALUE;
			int c = 1;
			String line = null;
			while((line = br.readLine()) != null && c <= tCount) {
				if(f) {
					f = false;
					tCount = Integer.parseInt(line);
					continue;
				}

				long ans = getVal(line);
				String os = "Case #" + c + ": " + ans;


				bw.write(os);
				bw.newLine();
				c++;
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (FileNotFoundException eg) {
			// TODO Auto-generated catch block
			eg.printStackTrace();
		} catch (IOException ed) {
			// TODO Auto-generated catch block
			ed.printStackTrace();
		}
	}

	private static int getDC(long n) {
		int c = 0;
		while(n > 0) {
			c++;
			n = n/10;
			if(n == 0) {
				break;
			}
		}
		return c;
	}

	public static long getVal(String line) {
		String[] sa = line.split(" ");
		long n = Integer.parseInt(sa[0].trim());
		long m = Integer.parseInt(sa[1].trim());
		int dc = getDC(n);
		long count = 0;
		Map s = new HashMap();
		for(long i = n; i <= m; i++) {
			Set _s = correct(i, n, m, dc);
			if (_s.isEmpty()) continue;
			Iterator it = _s.iterator();
			while(it.hasNext()) {
			   Long o = (Long)it.next();
			   if (s.containsKey(o)) {
				   it.remove();
			   }
			}
			
			if (_s.isEmpty()) continue;
			s.put(i, _s);
		}
		
		Iterator mit = s.keySet().iterator();
		while(mit.hasNext()) {
			count += ((Set)s.get(mit.next())).size();
		}
		return count;
	}
	
	public static Set correct(long nt, long n, long m, int dc) {
		Set l = new HashSet();
		for(int i = 1; i < dc ;i ++) {
			long tens = (long)Math.pow(10, dc - i);
			long tenso = (long)Math.pow(10, i);
			long left = nt/tens;
			long right = nt%tens;
			long n_ = right * tenso + left;
			if (n_ >= n && n_ <= m && n_ != nt){
				l.add(n_);
			}
		}
		return l;
	}

}


