import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintStream;

public class RecycledNumbers {
	public boolean testRecycled(int a, int b) {
		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
//		if(sa.indexOf('0')!=-1 || sb.indexOf('0')!=-1)
//			return false;
		int n = sa.length();
		for(int i=0; i<n; i++) {
			StringBuffer buf = new StringBuffer();
			buf.append(sa.substring(n-1));
			buf.append(sa.substring(0,n-1));
			sa = buf.toString();
			if(sb.equals(sa))
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		RecycledNumbers rn = new RecycledNumbers();
		LineNumberReader in = new LineNumberReader(new FileReader(args[0]+".in"));
		String line = null;
		line = in.readLine();
		if(line==null||line.length()==0)
			return;
		int T = 0;
		T = Integer.parseInt(line);
		PrintStream out = new PrintStream(args[0]+".out");
		System.out.println(new java.util.Date());
		for(int k=1; k<=T; k++){
			line = in.readLine();
			String[] data = line.split(" ");
			// brute force
			int n = 0;
			int A = Integer.parseInt(data[0]); 
			int B = Integer.parseInt(data[1]); 
			for(int i = A; i<B; i++) {
				for(int j = i+1; j<=B; j++) {
					if(rn.testRecycled(i, j))
						n++;
				}
			}
			StringBuffer buf = new StringBuffer();
			buf.append("Case #");
			buf.append(k);
			buf.append(": ");
			buf.append(n);
			out.println(buf.toString());
			System.out.println(buf.toString());
		}
		System.out.println(new java.util.Date());
		in.close();
		out.close();
	}

}
