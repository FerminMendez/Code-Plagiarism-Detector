package codejam2012.q;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class C
{
	static public void solveOne(int caseNo, Scanner in, PrintStream out)
	{
		int A = in.nextInt();
		int B = in.nextInt();
		in.nextLine();

		int size=0;
		int a=A;
		while( a>0 ) { a/=10 ; size++; }

		int count = 0;
		int[] rev = new int[10];
		int[] pow = new int[]{ 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

		for( int n=A ; n<=B ; n++ ){
			int ir = 0;
			for( int k=1 ; k<size ; k++ ){
				int m = n/pow[size-k] + (n%pow[size-k])*pow[k];
				if( A<=n && n<m && m<=B ){
					int i;
					for( i=0 ; i<ir ; i++ ){
						if( m==rev[i] ) break;
					}
					if( i==ir ){
//						System.out.println( "("+n+","+m+") ");
						count++;
						rev[ir++] = m;
					}
				}
			}
		}

		String ans = "Case #" + caseNo + ": " + count;
		System.out.println(ans);
		if( out!=null ){
			out.println(ans);
		}
	}
	
	static public void solveAll(String infilename, String outfilename)
	{
		try {
			FileInputStream stream = new FileInputStream(infilename);
			Scanner in = new Scanner(stream);
			PrintStream out = null;
			if( outfilename!=null ){
				out = new PrintStream(outfilename);
				System.out.println("--- " + outfilename);
			}

			int nbcases = in.nextInt();
			in.nextLine();
			for( int n=1 ; n<=nbcases ; n++ ){
				solveOne(n, in, out);
			} // for n
			
		} catch( IOException ex ){
			ex.printStackTrace();
		}
		
	}
	
	public static void solve(String dir, String problem){
		solveAll(dir + problem + ".in.txt", dir + problem + ".out");
	}
	
	public static void main(String[] args)
	{
		if( args.length==0 ){
			String cname = C.class.getName().replaceAll("\\.", "/");
			String path = "src/" + cname + "-sample";
//			String path = "src/" + cname + "-small-attempt0";
//			String path = "src/" + cname + "-large";
			solveAll(path + ".in.txt", path + ".out");
		} else {
			String dir = "src/" + C.class.getPackage().getName().replaceAll("\\.", "/") + "/";
			String path = dir + args[0];
			solveAll(path + ".in.txt", path + ".out");
		}
	}
}
