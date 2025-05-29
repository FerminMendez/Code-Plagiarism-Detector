import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;

public class B
{	
	public B( String fn)
	{
		try{
			BufferedReader r = new BufferedReader( new FileReader( fn + ".in"));
			PrintWriter w = new PrintWriter( new FileWriter( fn + ".out"));
			int t = Integer.valueOf( r.readLine());
			for( int i = 0; i < t; i++){
				String[] line = r.readLine().trim().split( " ");
				int y = 0;
				int n = Integer.valueOf( line[0]);
				int s = Integer.valueOf( line[1]);
				int p = Integer.valueOf( line[2]);
				for( int j = 3; j < line.length; j++){
					int a = Integer.valueOf( line[j]);
					if( p == 1){
						if( a >= 1)
							y++;
					}else if( a >= p+2*(p-1)){
						y++;
					}else if( s > 0 && a >= p+2*(p-2)){
						s--;
						y++;	
					}
				}
				w.println( "Case #" + (i+1) + ": " + y);
				System.out.println( "Case #" + (i+1) + ": " + y);
			}
			w.close();
			r.close();
		}catch( Exception e){}
	}
	
	public static void main( String[] args) throws Exception
	{
		new B( args[0]);
	}
}