package co.rfcasallasm.firstround.recycled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static int findRecycledNumbers( int a, int b ){				
		validationSet = new TreeSet<String>();
		int longitud = String.valueOf( b ).length();
		for( int index = b; index >= a; index-- ){			
			countIntoRange( index, longitud, a, b );					
		}
		return validationSet.size();
	}		
	
	private static void countIntoRange( int number, int longitud, int a, int b ){		
		String numero = String.valueOf( number );
		while( numero.length() < longitud ){
			numero = "0"+numero;
		}
		for( int i = 0; i < longitud; i++ ){
			int newNumber = Integer.parseInt( numero.substring( numero.length()-(i+1) ) + numero.substring( 0, numero.length()-(i+1) ) );
			if( number < newNumber && newNumber >= a && newNumber <= b ){								
				validationSet.add(number+"->"+newNumber);
				//System.out.println(number+"->"+newNumber);
			}
		}		
	}
	
	private static Set<String> validationSet;
	
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
			int a = Integer.parseInt( splitProblem[ 0 ] );
			int b = Integer.parseInt( splitProblem[ 1 ] );			
			solution.append( findRecycledNumbers( a, b ) );			
			bufferedWriter.write( solution.toString() );
			bufferedWriter.write( "\n" );
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}
			
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Calendar calIni = Calendar.getInstance();
		Calendar calFin = null;		
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
		calFin = Calendar.getInstance();
		System.out.println("Tiempo:"+(calFin.getTimeInMillis()-calIni.getTimeInMillis())/1000);
	}


}
