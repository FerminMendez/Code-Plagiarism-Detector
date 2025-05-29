import static java.util.Arrays.deepToString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;

public class B {
	public BufferedReader in;
	public PrintWriter out;
	
	void debug(Object...os) 	{System.err.println(deepToString(os));}
	static void pl(Object s)	{System.out.println(s);}
	static void p(Object s)		{System.out.print(s);}

	public Hashtable<Integer, B.Triplet> map;
	
	class Triplet {
		int a1 = 0,b1 = 0,c1 = 0;
		int a2 = 0,b2 = 0,c2 = 0;
		public Triplet()	{}
		
		public void tripletSu(int a1, int b1, int c1) {	//with surprize
			this.a1 = a1;
			this.b1 = b1;
			this.c1 = c1;
		}

		public void tripletNo(int a2, int b2, int c2) {	//without surprize
			this.a2 = a2;
			this.b2 = b2;
			this.c2 = c2;
		}
		
		public int getHighestWithSurprize()	{
			int max = a1;
			if (b1 > max)	max = b1;
			if (c1 > max)	max = c1;
			return max;
		}
		
		public int getHighestWithoutSurprize()	{
			int max = a2;
			if (b2 > max)	max = b2;
			if (c2 > max)	max = c2;
			return max;
		}
	}
	
	private B.Triplet generateTriplet(int t)	{
		Triplet trip = new Triplet();

		//Handle special cases
		if (t == 0)	return trip;	//all values already init to 0, can simple return trip
		int v = t / 3;
		if (t == 30)	{
			trip.tripletNo(v, v, v);
			return trip;
		}
		if (t == 29)	{
			trip.tripletNo(v+1, v+1, v);
			return trip;
		}
		if (t == 1)	{
			trip.tripletNo(v+1, v, v);
			return trip;
		}
		//Handle default cases
		if (t % 3 == 0)	{			
			trip.tripletNo(v, v, v);
			trip.tripletSu(v+1, v, v-1);			
		}
		else if (t % 3 == 1){
			trip.tripletNo(v+1, v, v);
			trip.tripletSu(v+1, v+1, v-1);
		}
		else {
			trip.tripletNo(v+1, v+1, v);
			trip.tripletSu(v+2, v, v);
		}
		return trip;
	}
	
	private int solve(int N, int S, int p, ArrayList<Integer> s) {
		int count = 0;
		int v;
		Triplet trip;

		for(int i = 0; i < N; ++i)	{
			trip = map.get(s.get(i));
			v = trip.getHighestWithoutSurprize();
			if (v >= p)	{
				++count;
			}
			else if (S > 0)	{
				v = trip.getHighestWithSurprize();
				if (v >= p)	{
					++count;
					--S;	//one of the surprizes used
				}
			}
		}
		return count;
	}

	public void run() throws Exception	{
		//pre-generate Triplet cases
		map = new Hashtable<Integer, B.Triplet>();
		for(int i = 0; i <= 30; ++i)
			map.put(i,generateTriplet(i));		

		int T,N,S,p,v;
		ArrayList<Integer> s = new ArrayList<Integer>();
		String line;String[] tok;

		in = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
		out = new PrintWriter(new File("B-small-attempt0.out"));
//		in = new BufferedReader(new FileReader(new File("B-large.in")));
//		out = new PrintWriter(new File("B-large.out"));

		T = new Integer(in.readLine());
		for(int t=1;t<=T;++t)	{
			line = in.readLine();
			tok = line.split(" ");
			N = new Integer(tok[0]);
			S = new Integer(tok[1]);
			p = new Integer(tok[2]);
			s = new ArrayList<Integer>(N);
			for(int n = 0; n < N; ++n)
				s.add(new Integer(tok[n+3]));
			v = solve(N,S,p,s);
			System.out.println("Case #" + t + ": " + v);
			out.println("Case #" + t + ": " + v);
		}
		in.close();out.close();		
	}

	public static void main(String[] args) {
		try {
			java.util.Date t1 = new java.util.Date();
			new B().run();
			java.util.Date t2 = new java.util.Date();
			long diff = (t2.getTime() - t1.getTime());
			System.out.println("Time: "+(((float)diff)/1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
