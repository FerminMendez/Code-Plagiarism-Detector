import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;

public class C
{	
	public C( String fn)
	{
		try{
			BufferedReader r = new BufferedReader( new FileReader( fn + ".in"));
			PrintWriter w = new PrintWriter( new FileWriter( fn + ".out"));
			int t = Integer.valueOf( r.readLine());
			for( int i = 0; i < t; i++){
				String[] line = r.readLine().trim().split( " ");
				int y = 0;
				int a = Integer.valueOf( line[0]);
				int b = Integer.valueOf( line[1]);
				
				for( int j = a; j < b; j++){
					for( int k = j+1; k <= b; k++){
					
						String n = String.valueOf( j);	
						String m = String.valueOf( k);
						
						int c = 0;
						while( (c = n.indexOf( m.charAt( 0), c)) != -1){
							if( m.equals( n.substring( c) + n.substring( 0, c))){
								y++;
								break;
							}
							c++;	
						}
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
		new C( args[0]);
	}
}