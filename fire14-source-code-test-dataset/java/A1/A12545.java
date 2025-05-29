package codejam2012.q;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class B
{
	static public void solveOne(int caseNo, Scanner in, PrintStream out)
	{
		int n = in.nextInt();
		int s = in.nextInt();
		int p = in.nextInt();

		int norm = 0;
		int surp = 0;
		
		// array
		for( int i=0 ; i<n ; i++ ){
			int score = in.nextInt();
			if( score>=28 ){
				if( 10 >=p ) norm++;
			} else
			if( score<=1 ){
				if( 0 >=p ) norm++;
			} else {
				if( score%3==0 ){
					if( score/3 >=p ) norm++;
					else if( score/3+1 >=p ) surp++;
				}
				if( score%3==1 ){
					if( score/3+1 >=p ) norm++;
					else if( score/3+1 >=p ) surp++;
				}
				if( score%3==2 ){
					if( score/3+1 >=p ) norm++;
					else if( score/3+2 >=p ) surp++;
				}
			}
		}
		in.nextLine();

		int answer = norm + (s<surp ? s : surp); 

		String ans = "Case #" + caseNo + ": " + answer;

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
			String cname = B.class.getName().replaceAll("\\.", "/");
//			String path = "src/" + cname + "-sample";
			String path = "src/" + cname + "-small-attempt0";
//			String path = "src/" + cname + "-large";
			solveAll(path + ".in.txt", path + ".out");
		} else {
			String dir = "src/" + B.class.getPackage().getName().replaceAll("\\.", "/") + "/";
			String path = dir + args[0];
			solveAll(path + ".in.txt", path + ".out");
		}
	}
}
