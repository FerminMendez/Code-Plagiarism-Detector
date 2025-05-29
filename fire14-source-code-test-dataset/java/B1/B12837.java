import static java.util.Arrays.deepToString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class C {
	public BufferedReader in;
	public PrintWriter out;

	void debug(Object...os) 	{System.err.println(deepToString(os));}
	static void pl(Object s)	{System.out.println(s);}
	static void p(Object s)		{System.out.print(s);}

	private int solve(int A, int B) {
		int count = 0;
		StringBuilder nn,mm;
		int n,m,c;
		for(n = A; n < B; ++n)	{
			nn = new StringBuilder();
			nn.append(n);
			for(m = n+1; m <= B; ++m)	{
				mm = new StringBuilder();
				mm.append(m);
				if (mm.length() > nn.length())	{m = B+1;	break;}	//number of digits dont match
				int l = mm.length();
				for(c = 0; c < l-1; ++c)	{
					mm.append(mm.charAt(0)).deleteCharAt(0);	//rotate by 1 char
					if (mm.toString().equals(nn.toString()))	{
//						pl("\tMATCH "+n+" : "+m);
						++count;
						break;
					}
				}
			}
		}
		return count;
	}

	public void run() throws Exception	{
		int T,A,B,v;
		String line;String[] tok;

		in = new BufferedReader(new FileReader(new File("C-small-attempt0.in")));
		out = new PrintWriter(new File("C-small-attempt0.out"));
//		in = new BufferedReader(new FileReader(new File("C-large.in")));
//		out = new PrintWriter(new File("C-large.out"));

		T = new Integer(in.readLine());
		for(int t=1;t<=T;++t)	{
			line = in.readLine();
			tok = line.split(" ");
			A = new Integer(tok[0]);
			B = new Integer(tok[1]);
			v = solve(A,B);
			System.out.println("Case #" + t + ": " + v);
			out.println("Case #" + t + ": " + v);
		}
		in.close();out.close();		
	}

	public static void main(String[] args) {
		try {
			java.util.Date t1 = new java.util.Date();
			new C().run();
			java.util.Date t2 = new java.util.Date();
			long diff = (t2.getTime() - t1.getTime());
			System.out.println("Time: "+(((float)diff)/1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
