import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;


public class Main {
    
    public static void main( String[] args ) {

	try {
	    BufferedReader reader = new BufferedReader( new FileReader( "C:\\file.in") );
	    ArrayList<Integer> results = new ArrayList<Integer>();
	    reader.readLine();
	    String line = reader.readLine();
	    int j = 0;
	    while( line != null ) {
		j++;
		ArrayList<Collection<Triplet>> tripletCollections = new ArrayList<Collection<Triplet>>();
		String[] parameters = line.split( " " );
		int nrOfPlayers = Integer.valueOf( parameters[0] );
		int nrOfSurprises = Integer.valueOf( parameters[1] );
		int treshold = Integer.valueOf( parameters[2] );
		System.out.println("Iteration nr." + String.valueOf( j ));
		System.out.println("Generating triplets for " + String.valueOf( nrOfPlayers ));
		for( int i = 3; i < parameters.length; i++ ) {
		    tripletCollections.add( generateTriplets( Integer.valueOf( parameters[i]) ) );
		}
		System.out.println("Selecting triplets");
		Triplet[] selectedTriplet = new Triplet[nrOfPlayers];
		int surprising = 0;
		for( int i = 0; i < tripletCollections.size(); i++ ) {
		    Collection<Triplet> triplets = tripletCollections.get( i );
		    if( getAboveNotSurprising( triplets, treshold ) != null ) {
			selectedTriplet[i] = getAboveNotSurprising( triplets, treshold );
		    }
		    else if( getAboveAndSurprising( triplets, treshold ) != null ) {
			selectedTriplet[i] = getAboveAndSurprising( triplets, treshold );
			surprising++;
		    }
		    else if( getBelowNotSurprising( triplets, treshold ) != null ) {
			selectedTriplet[i] = getBelowNotSurprising( triplets, treshold );
		    }
		    else {
			selectedTriplet[i] = getBelowAndSurprising( triplets, treshold );
			surprising++;
		    }
		}
		System.out.println("Improving triplets");
		if( nrOfPlayers == 1 ) {
		    System.out.println( "only one player");
		}
		if( surprising != nrOfSurprises ) {
		    if( surprising < nrOfSurprises ) {
			System.out.println("More surprises than expected");
			int i = 0;
			while( ( i < nrOfPlayers ) && ( surprising != nrOfSurprises ) ) {
			    Collection<Triplet> triplets = tripletCollections.get( i );
			    if( !selectedTriplet[i].isSurprising() ) {
				if( getAboveAndSurprising( triplets,  treshold ) != null ) {
				    selectedTriplet[i] = getAboveAndSurprising( triplets,  treshold );
				    surprising++;
				}
			    }
			    i++;
			}
			i=0;
			while( ( i < nrOfPlayers ) && ( surprising != nrOfSurprises ) ) {
			    Collection<Triplet> triplets = tripletCollections.get( i );
			    if( !selectedTriplet[i].isSurprising() ) {
				if( getBelowAndSurprising( triplets,  treshold ) != null ) {
				    selectedTriplet[i] = getBelowAndSurprising( triplets,  treshold );
				    surprising++;
				}
			    }
			    i++;
			}
		    }
		    else {			
			int i=0;
			while( ( i < nrOfPlayers ) && ( surprising != nrOfSurprises ) ) {
			    Collection<Triplet> triplets = tripletCollections.get( i );
			    if( selectedTriplet[i].isSurprising() ) {
				if( getBelowNotSurprising( triplets,  treshold ) != null ) {
				    selectedTriplet[i] = getBelowNotSurprising( triplets,  treshold );
				    surprising--;
				}
			    }
			    i++;
			}
			
		    }
		}
		int result = 0;
		for( Triplet triplet : selectedTriplet ) {
		    if( triplet.getBestResult() >= treshold ) {
			result++;
		    }
		}
		results.add(result);
		line = reader.readLine();
	    }
	    System.out.println("Writing output");
	    BufferedWriter writer = new BufferedWriter( new FileWriter( "C:\\output.txt") );
	    for( int i = 0; i < results.size(); i++ ) {
		writer.write( "Case #" + String.valueOf( i+1 ) + ": " + String.valueOf( results.get( i ) ) );
		writer.newLine();
	    }
	    writer.close();
	}
	catch( Exception e ) {
	    
	}
	

    }
    
    private static Collection<Triplet> generateTriplets( int aSum ) {
	ArrayList<Triplet> result = new ArrayList<Triplet>();
	int temp;
	if( aSum % 3 == 0 ) {
	  result.add( new Triplet( aSum/3, aSum/3, aSum/3 ) );  
	}
	if( (aSum - 1) % 3 == 0  && (aSum - 1) >= 0 ) {
	  temp = ( aSum - 1 ) / 3;
	  if( temp + 1 <= 10 ) {
	      result.add( new Triplet( temp, temp, temp + 1 ) );	      
	  }
	}
	if( (aSum - 2) % 3 == 0 && (aSum - 2) >= 0) {
	    temp = ( aSum - 2 ) / 3;
	    if( temp + 2 <= 10 ) {
		result.add(  new Triplet( temp, temp, temp + 2 ) );		
	    }
	    if( temp + 1 <= 10 ) {
		result.add(  new Triplet( temp, temp + 1, temp + 1 ) );		
	    }
	}
	if( (aSum - 3) % 3 == 0 && (aSum - 3) >= 0) {
	    temp = ( aSum - 3 ) / 3;
	    if( temp + 2 <= 10 ) {
		result.add(  new Triplet( temp, temp + 1, temp + 2 ) );
	    }
	}
	if( (aSum - 4) % 3 == 0 && (aSum - 4) >= 0) {
	    temp = ( aSum - 4 ) / 3;
	    if( temp + 2 <= 10 ) {
		result.add(  new Triplet( temp, temp + 2, temp + 2 ) );
	    }
	}
	return result;
    }
    
    private static Triplet getAboveNotSurprising( Collection<Triplet> aCollection, int aTreshold ) {
	for (Triplet triplet : aCollection ) {
	    if( ( triplet.getBestResult() >= aTreshold ) && !triplet.isSurprising() ) {
		return triplet;
	    }
	    
	}
	return null;
    }

    private static Triplet getBelowNotSurprising( Collection<Triplet> aCollection, int aTreshold ) {
	for (Triplet triplet : aCollection ) {
	    if( ( triplet.getBestResult() < aTreshold ) && !triplet.isSurprising() ) {
		return triplet;
	    }
	    
	}
	return null;
    }
    
    private static Triplet getAboveAndSurprising( Collection<Triplet> aCollection, int aTreshold ) {
	for( Triplet triplet : aCollection ) {
	    if( ( triplet.getBestResult() >= aTreshold ) && triplet.isSurprising() ) {
		return triplet;
	    }
	}
	return null;
    }
    
    private static Triplet getBelowAndSurprising( Collection<Triplet> aCollection, int aTreshold ) {
	for( Triplet triplet : aCollection ) {
	    if( ( triplet.getBestResult() < aTreshold ) && triplet.isSurprising() ) {
		return triplet;
	    }
	}
	return null;
    }

}
