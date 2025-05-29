package recycled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    
    public static void main( String[] args ) {
	try {
	    ArrayList<Integer> results = new ArrayList<Integer>();
	    BufferedReader reader = new BufferedReader( new FileReader( "C:\\file.in") );
	    reader.readLine();
	    String line = reader.readLine();
	    
	    while( line != null ) {
		String[] parameters = line.split( " " );
		results.add( getRecycledPairs( Integer.valueOf( parameters[0] ), Integer.valueOf( parameters[1] ) ) );
		line = reader.readLine();
	    }
	    
	    BufferedWriter writer = new BufferedWriter( new FileWriter( "c:\\output.txt" ) );
	    for( int i = 0; i < results.size(); i++ ) {
		writer.write( "Case #" + String.valueOf( i+1 ) + ": " + String.valueOf( results.get( i ) ) );
		writer.newLine();
	    }
	    
	    writer.close();
	}
	catch( Exception e ) {
	    
	}
	
	
    }
    
    private static int getRecycledPairs( int aMin, int aMax ) {
	if( String.valueOf( aMin ).length() != String.valueOf( aMax ).length() ) {
	    return 0;
	}
	int result = 0;
	for( int i = aMin; i <= aMax; i++ ) {
	    result += getNumberOfCombinations( i, aMax );	    	    
	}
	return result;
    }
    
    private static int getNumberOfCombinations( int aNumber, int aMax ) {
	String string = String.valueOf( aNumber );
	int numberOfDigits = string.length(); 
	String temp;
	int result = 0;
	ArrayList<Integer> values = new ArrayList<Integer>();
	for( int i = 1; i < string.length(); i++ ) {
	    temp = string.substring( i, string.length() ) + string.substring( 0, i );
	    int value = Integer.valueOf( temp );
	    if( String.valueOf( value ).length() != numberOfDigits ) {
		continue;
	    }
	    if( (value > aNumber ) && (value <= aMax ) && !values.contains( value ) ) {
		result++;
		values.add( value );
	    }
	}
	return result;
    }

}
