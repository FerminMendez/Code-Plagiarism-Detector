import java.io.*;
import java.util.*;

public class Run
{

	private static class GooglerRating {
		int total;
		int r1, r2, r3;
		int r1s, r2s, r3s;
		
		public GooglerRating ( int totalRating ) {
			total = totalRating;
			
			int mod = totalRating % 3;
			switch ( mod )
			{
				case 0 :
					r3 = r2 = r1 = totalRating / 3;
					r1s = r1 - 1;
					r2s = r2;
					r3s = r3 + 1;
					break;
				case 1 :
					r3 = r2 = r1 = totalRating / 3;
					r3++;
					r1s = r1 - 1;
					r2s = r2 + 1;
					r3s = r3;
					break;
				case 2 :
					r3 = r2 = r1 = totalRating / 3;
					r1++;
					r2++;
					r1s = r1-1;
					r2s = r2-1;
					r3s = r3+2;
				default:
					break;
			}
			
			if ( totalRating == 0 )
			{
				r3s = r2s = r1s = r3 = r2 = r1 = 0;
			}
			if ( totalRating == 1 )
			{
				r3s = r2s = r1s = r3 = r2 = r1 = 0;
				r3s = r3 = 1;
			}
		}
		
		public int bestResult ( ) {
			return Math.max ( r1, Math.max ( r2, r3 ) );
		}
		public int bestSurpriseResult ( ) {
			return Math.max ( r1s, Math.max ( r2s, r3s ) );
		}
		
		public String toString () {
			return "[(" + r1 + ", " + r2 + ", " + r3 + "), " + "(" + r1s + ", " + r2s + ", " + r3s + ")*]";
		}
	}
	
	private static class ProblemInstance {
		int numGooglers;
		int numSurprises;
		int possibleBestResult;
		
		List <GooglerRating> ratings;
		
		public static ProblemInstance from ( String testCase ) {
			ProblemInstance p = new ProblemInstance ();
			
			String[] tokens = testCase.split("\\s+");
			
			p.numGooglers = Integer.parseInt ( tokens[0] );
			p.numSurprises= Integer.parseInt ( tokens[1] );
			p.possibleBestResult = Integer.parseInt ( tokens[2] );
			
			p.ratings = new ArrayList < GooglerRating > ( p.numGooglers );
			
			for ( int googlerIndex = 0; googlerIndex < p.numGooglers; googlerIndex++ ) {
				p.ratings.add ( new GooglerRating ( Integer.parseInt ( tokens[3 + googlerIndex] ) ) );
			}
			
			return p;
		}
		
		public String toString () {
			return "Find the number of ratings that have the best result >= " + possibleBestResult + " with " + numSurprises + " surprises\n\tRatings = " + ratings.toString();
		}
	}
	
	private static String readFile ( String[] args ) {
		StringBuilder text = new StringBuilder();
		try {
			Scanner scanner = new Scanner(new File ( args[0] ));
			while (scanner.hasNextLine())
			{
				text.append(scanner.nextLine() + '\n');
			}
		}
		catch ( Exception e )
		{
			
		}
		finally
		{
		}
		return text.toString();
	}
	
	private static void p ( Object o ) {
		System.out.println ( o );
	}
	public static void main(String[] args) {
		String fileText = readFile ( args );
		Scanner s = new Scanner ( fileText );
		int numTests = Integer.parseInt(s.nextLine ());
		
		for (int testIndex = 1; testIndex <= numTests; testIndex++) {
			String testCase = s.nextLine();
			ProblemInstance p = ProblemInstance.from ( testCase );
			// p ( p.toString() );
			
			List < GooglerRating > allRatings = new ArrayList < GooglerRating > ( p.ratings );
			
			// Find ones that work without surprise			
			int bestWithoutSurprise = 0;
			for ( int i = allRatings.size() - 1; i >= 0; i-- )
			{
				GooglerRating rating = allRatings.get(i);
				if ( rating.bestResult() >= p.possibleBestResult )
				{
					bestWithoutSurprise++;
					allRatings.remove ( i );
				}
			}
			
			// find number of ones that work with surprise
			int bestWithSurprise = 0;
			for ( GooglerRating rating : allRatings )
			{
				if ( rating.bestSurpriseResult () >= p.possibleBestResult )
					bestWithSurprise++;				
			}
			
			int totalPassing = bestWithoutSurprise + Math.min ( bestWithSurprise, p.numSurprises );
			p ( "Case #" + testIndex + ": " + totalPassing );
		}
	}
}