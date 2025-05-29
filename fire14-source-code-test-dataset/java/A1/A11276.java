package co.rfcasallasm.firstround.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static Integer findGooglerAtLeastOrBetter( int surprisingCases, int atLeastThisResult, int totalPoints[] ){
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		List<List<int[]>> explodedValues = new ArrayList<List<int[]>>();
		for( int i = 0; i < totalPoints.length; i++ ){
			List<int[]> combinations = findCombinations( totalPoints[ i ] );
			for( int[] combination : combinations ){
				System.out.print( combination[ 0 ]+"-"+combination[ 1 ]+"-"+combination[ 2 ]+" " );
			}
			System.out.println("");
			explodedValues.add( combinations );
		}		
		return findMaxValue( explodedValues, 0, surprisingCases, atLeastThisResult );
	}	
	
	private static Integer findMaxValue( List<List<int[]>> explodedValues, int index, int surprisingCases, int atLeastThisResult ){
		if( explodedValues.size() <= index ){
			if( surprisingCases > 0 ){
				return null;
			}
			return 0;
		}
		Integer retValue = null;
		List<int[]> thisValues = explodedValues.get( index );
		for( int[] curCmb : thisValues ){			
			boolean isSurprisingCase = ( (curCmb[ 2 ]-curCmb[ 1 ]) == 2 || (curCmb[ 2 ]-curCmb[ 0 ]) == 2 || (curCmb[ 1 ]-curCmb[ 0 ]) == 2);			
			if( !(surprisingCases == 0 && isSurprisingCase) ){
				Integer maxNextVal = findMaxValue( explodedValues, index+1, ( isSurprisingCase ? (surprisingCases-1) : surprisingCases ), atLeastThisResult );
				if( maxNextVal != null ){
					maxNextVal += ( ( curCmb[ 0 ] >= atLeastThisResult || curCmb[ 1 ] >= atLeastThisResult || curCmb[ 2 ] >= atLeastThisResult ) ? 1 : 0 );
					if( retValue == null || retValue.intValue() < maxNextVal.intValue() ){
						retValue = maxNextVal;
					}
				}
			}
		}
		return retValue;
	}
	
	
	private static void solveProblem( File inputFile ) throws IOException{
		BufferedReader bufferedReader = new BufferedReader( new FileReader( inputFile ) );
		BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( new File( inputFile.getParent(), inputFile.getName().substring( 0, inputFile.getName().length()-3 )+".out" ) ) );
		Long t = Long.parseLong( bufferedReader.readLine() );
		String problem = null;
		StringBuilder solution = null;
		for( long problemIndex = 0l; problemIndex < t; problemIndex++ ){
			problem = bufferedReader.readLine();
			solution = new StringBuilder("Case #"+(problemIndex+1)+": ");			
			String[] splitProblem = problem.split(" ");
			//int n = Integer.parseInt( splitProblem[ 0 ] );
			int s = Integer.parseInt( splitProblem[ 1 ] );
			int p = Integer.parseInt( splitProblem[ 2 ] );
			int scores[] = new int[ splitProblem.length - 3 ];
			for( int i = 0; i < scores.length; i++ ){
				scores[ i ] = Integer.parseInt( splitProblem[ 3+i ] );
			}
			solution.append( findGooglerAtLeastOrBetter( s, p, scores ) );			
			bufferedWriter.write( solution.toString() );
			bufferedWriter.write( "\n" );
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}
		
	private static int[][] mask = {{0,0,0},{-1,0,1},{-1,1,0},{1,-1,0},{0,-1,1},{1,0,-1},{0,1,-1}};
	
	private static boolean checkNewItem( int newItem[], int totalScore ){
		return ( newItem[0] >= 0 && newItem[0] <= 10 && newItem[1] >= 0 && newItem[1] <= 10 && newItem[2] >= 0 && newItem[2] <= 10 && (newItem[0]+newItem[1]+newItem[2]) == totalScore && ( newItem[2]-newItem[1] ) >= 0 && ( newItem[2]-newItem[1] ) <= 2 && ( newItem[1]-newItem[0] ) >= 0 && ( newItem[1]-newItem[0] ) <= 2 && ( newItem[2]-newItem[0] ) <= 2 );
	}
	private static List<int[]> findCombinations( int totalScore ){
		List<int[]> retValue = new ArrayList<int[]>();
		int divisor = (totalScore / 3);
		int iterator[] = new int[]{divisor,divisor,(totalScore-2*divisor)};
		for( int i = 0; i < mask.length; i++){
			int newItem[] = new int[]{iterator[0]+mask[i][0], iterator[1]+mask[i][1], iterator[2]+mask[i][2]};
			if( checkNewItem( newItem, totalScore ) ){
				retValue.add( newItem );
			}
		}
		return retValue;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		File folder = new File(".");
		System.out.println("Searching files in "+folder.getAbsolutePath());
		String[] inputFileList = folder.list( new FilenameFilter() {			
			@Override
			public boolean accept(java.io.File dir, String name) {
				return name != null && name.endsWith(".in");
			}
		});
		for( String fileName : inputFileList ){
			System.out.println( fileName );
			Main.solveProblem( new File( folder.getAbsolutePath(), fileName ) );
		}
	}

}
