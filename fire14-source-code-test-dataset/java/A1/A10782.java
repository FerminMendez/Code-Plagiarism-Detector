import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DanceGoogle {
	public static void main( String[] args ) throws IOException {
		File fileOut = new File( "B-small-attempt4.out" );
		BufferedWriter writer = new BufferedWriter( new FileWriter(fileOut) );
		Scanner sc = new Scanner( new File ( "B-small-attempt4.in" ) );
		int count = 0;
		int number = sc.nextInt();
		int caseNumber = number;
		for ( int caseNumberIndex = 0; caseNumberIndex < caseNumber; caseNumberIndex++ ) {
			int numberOfDancer = sc.nextInt();
			int numberOfSuprise = sc.nextInt();
			int bestScore = sc.nextInt();
			int compare = ( bestScore * 3 ) - 2;
			for ( int dancerIndex = 0; dancerIndex < numberOfDancer; dancerIndex++ ) {
				number = sc.nextInt();
				if ( ( number > 28 ) || ( number < 2 ) ) {
					if ( number > 28 )
						count++;
					else if( (number > 0) && (bestScore == 1) )
						count++;						
				}
				else if ( number < compare ) {
					if ( number >= (compare - 2 ) ) {
						if ( numberOfSuprise > 0 ) {
							numberOfSuprise--;
							count++;
						}
					}
				}
				else 
					count++;	
			}
			if ( bestScore == 0 ) 
				count = numberOfDancer;
			writeOutput( writer, count, caseNumberIndex );
			count = 0;
		}
		writer.close();
		sc.close();
	}
	
	private static void writeOutput( BufferedWriter writer, int count, int caseNumber ) throws IOException {		
		writer.append( "Case #" + (caseNumber+1) );		
		writer.append( ": " + count );
		writer.append( "\r\n" );
		
	}
}
