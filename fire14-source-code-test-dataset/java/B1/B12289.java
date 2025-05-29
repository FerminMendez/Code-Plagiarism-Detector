import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	int noOfTestCases = 0;
	int[][] testData;
	
	
	public static void main ( String[] args ) {
		
		String fileName = "problemc.sample.in";
		
		if ( args.length > 0 ) {
			fileName = args[0];
		}
		
		RecycledNumbers rn = new RecycledNumbers ( );
		
		try {
			rn.readInputFile ( fileName );
		}
		catch ( IOException e ) {
			System.err.println ( "Problem reading the input file" );
			e.printStackTrace();
		}
		//rn.getRotatedNumbers ( "123456" );
		rn.processTestData ( );
	}
	
	private void processTestData ( ) {
		
		for ( int i = 0; i < noOfTestCases; i++ ) {
			Set < String > unique = new HashSet < String >(); 
			int from = testData[i][0];
			int to = testData[i][1];
			
			for ( int j = from; j <= to; j++ ) {
				int[] rotatedNumbers = getRotatedNumbers ( "" + j );
				
				checkIfValid ( rotatedNumbers, j, from, to, unique );
			}
			System.out.println ( "Case #" + (i+1) + ": " + unique.size ( ));
		}
		
	}
	
	private void checkIfValid ( int[] in, int current, int from, int to, Set < String > unique ) {
		
	
		for ( int i = 0; i < in.length; i++ ) {
			int number = in[i];
			if ( number < from ) {
				
			}
			else if ( number > to ) {
				
			}
			else if ( number <= current ) {
				
			}
			else {
				//System.out.println ( number );
				unique.add ( ""+ number + current );
			}
		}
	}
	
	private int[] getRotatedNumbers ( String input ) {
		
		int length = input.length ( );
		int[] output = new int[length-1];
		char[] outstring = input.toCharArray();
		
		for (int i = 0; i < length-1; i++)  { //Length-1 or length?
			char ch = outstring[length - 1];
			for (int j = length - 1; j > 0; j--)  {
				outstring[j] = outstring[j - 1];
			}
			outstring[0] = ch;
			output[i] = Integer.parseInt ( new String(outstring ) );
			
		}
		
		return output;
		
	}
	
	private void readInputFile ( String fileName ) throws IOException {
		
		BufferedReader br = new BufferedReader ( new FileReader ( fileName ) );
		noOfTestCases = Integer.parseInt ( br.readLine ( ) );
		testData = new int[noOfTestCases][2];
		
		for ( int i = 0; i < noOfTestCases; i++ ) {
			String[] data = br.readLine ( ).split ( " " );
			testData[i][0] = Integer.parseInt ( data[0] );
			testData[i][1] = Integer.parseInt ( data[1] );
		}
	}
}
