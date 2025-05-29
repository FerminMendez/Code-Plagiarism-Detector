package Qualification;

import java.util.*;
import java.io.*;

public class C {
	
	private static boolean checkRecycling2( String n, String m ){
		String last;
		String first;
		int status = 0;
		for( int pos=n.length()-1; pos>0; pos-- ){
			
			last = n.substring(pos);
			first = n.substring(0, pos);
			
			//System.out.println( last + " " + first );
			
			//new Scanner(System.in).nextLine();
			
			if( (last+first).equals( m )){
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean checkRecycling( String n, String m ){
		boolean flag = true;
		int sz = n.length(), mPos;
		for( int pos=sz-1; pos>0; pos-- ){
			flag = true;
			mPos = 0;
			
			for( int i=pos; i<sz; i++ ){
				if( n.charAt(i) != m.charAt( mPos++ ) ){
					flag = false;
					break;
				}
			}
			
			if( !flag ) continue;
			flag = true;
			
			for( int i=0; i<pos; i++ ){
				if( n.charAt(i) != m.charAt( mPos++ ) ){
					flag = false;
					break;
				}
			}
			
			if( flag )
				return true;
			
		}
		
		return false;
	}
	
	private static int getRecycled(String... split) {
		int times=0;
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt( split[1] );
		
		String nS, mS;
		
		for( int n=a; n<b; n++ ){
			for( int m=n+1; m<=b; m++ ){
				
				nS = String.format("%d", n);
				mS = String.format("%d", m);
				
				//System.out.println( nS + " " + mS );
				
				if( checkRecycling( nS, mS ) ){
					times++;
				}
				
			}
		}
		
		return times;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner( new File( "C-small-attempt1.in" ) );
		//Scanner in = new Scanner( new File( "A-large.in" ) );
		PrintWriter out = new PrintWriter( new FileOutputStream( new File( "outC.txt" ) ), true );
		
		long cases;
		
		cases = Long.parseLong( in.nextLine() );
		
		String input;
		for( long i=0; i<cases; i++  ){
			out.print("Case #" + (i+1) + ": ");
			/*
			 * START 
			 */
			
			input = in.nextLine();
			
			out.print( getRecycled( input.split(" ") ) );
			
			/*
			 *  END
			 */
			out.println();
		}

	}

	



	

}
