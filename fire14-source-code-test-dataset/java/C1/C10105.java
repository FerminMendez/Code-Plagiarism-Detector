package codejam2012.q;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class D
{
	static int H, W, D;
	static char[][] hall;
	static int startx, starty;

	static public int test(int dx, int dy, int dirx, int diry)
	{
//System.out.println("test " + dx + "/" + dy + " " + dirx + "/" + diry);
		int hx = startx, hy = starty;
		int rx = dy, ry = dx;
		int tx = 0, ty = 0;

		while( tx*tx + ty*ty <= D*D ){
			if( hx==startx && hy==starty && tx+ty>0 ){
				if( rx==2*dy && ry==dx+dy )
					return 1;
				if( ry==2*dx && rx==dy+dx )
					return 1;
			}
			if( rx < ry ){
				ry -= rx;
				rx = 2*dy;
				if( hall[hx+dirx][hy]=='#' ){
					dirx = -dirx;
				} else {
					hx += dirx;
				}
				tx++;
			} else
			if( rx > ry ){
				rx -= ry;
				ry = 2*dx;
				if( hall[hx][hy+diry]=='#' ){
					diry = -diry;
				} else {
					hy += diry;
				}
				ty++;
			} else
			if( rx==ry ){
				rx = 2*dy;
				ry = 2*dx;
				if( hall[hx+dirx][hy+diry]!='#' ){
					hx += dirx;
					hy += diry;
				} else
				if( hall[hx+dirx][hy]!='#' && hall[hx][hy+diry]!='#' ){
					return 0;
				} else {
					if( hall[hx+dirx][hy]=='#' ){
						dirx = -dirx;
					} else {
						hx += dirx;
					}
					if( hall[hx][hy+diry]=='#' ){
						diry = -diry;
					} else {
						hy += diry;
					}
				}
				tx++;
				ty++;
			}
		}
		return 0;
	}
	
	static public int multiTest(int x0, int y0, int x1, int y1)
	{
//System.out.println("multitest " + x0 + "/" + y0 + " " + x1 + "/" + y1)		;
		int count = 0;
		int x2 = x0+x1;
		int y2 = y0+y1;
		
		if( x2*x2 + y2*y2 <= D*D ){
			count += multiTest(x0, y0, x2, y2);
			count += test(x2, y2, +1, +1);
			count += test(x2, y2, +1, -1);
			count += test(x2, y2, -1, +1);
			count += test(x2, y2, -1, -1);
			count += multiTest(x2, y2, x1, y1);
		}
		
		return count;
	}
	
	static public void solveOne(int caseNo, Scanner in, PrintStream out)
	{
		H = in.nextInt();
		W = in.nextInt();
		D = in.nextInt();
		in.nextLine();

		hall = new char[W][H];
		for( int y=0 ; y<H ; y++ ){
			String line = in.nextLine();
			for( int x=0 ; x<W ; x++ ){
				hall[x][y] = line.charAt(x);
				if( hall[x][y]=='X' ){
					startx = x;
					starty = y;
				}
			}
		}
		
		int count = 0;
		count += test(1, 0, +1, 0);
		count += test(1, 0, -1, 0);
		count += test(0, 1, 0, +1);
		count += test(0, 1, 0, -1);
		
		count += multiTest(1,0,0,1);
		
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
	
	public static void main(String[] args)
	{
		if( args.length==0 ){
			String cname = D.class.getName().replaceAll("\\.", "/");
			String path = "src/" + cname + "-sample";
//			String path = "src/" + cname + "-small-attempt0";
//			String path = "src/" + cname + "-large";
			solveAll(path + ".in.txt", path + ".out");
		} else {
			String dir = "src/" + D.class.getPackage().getName().replaceAll("\\.", "/") + "/";
			String path = dir + args[0];
			solveAll(path + ".in.txt", path + ".out");
		}
	}
}
