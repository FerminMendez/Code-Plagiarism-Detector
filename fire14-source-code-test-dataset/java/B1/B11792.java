import java.io.*;
import java.util.*;
// read file name frome command line
public class ProblemC{
	public static void main(String args[]){
	
		
		try{
			// reading file initialization
			String 			filename = args[0];
			FileReader 		frStream = new FileReader(		filename);
			BufferedReader 	brStream = new BufferedReader(	frStream);
			// writing file initializtion
			FileWriter     fwStream = new FileWriter(		filename.substring(0, filename.length()-3)+"Output.in" );
			BufferedWriter bwStream = new BufferedWriter( 	fwStream  );
			PrintWriter    pwStream = new PrintWriter(    	bwStream  );
			
			String text = brStream.readLine();
			int numCase =  Integer.parseInt( text );


                        for( int i = 0 ; i < numCase ; i++){
                            text = brStream.readLine();
                            StringTokenizer currLine = new StringTokenizer( text );
                            int min = Integer.parseInt(currLine.nextToken());
                            int max = Integer.parseInt(currLine.nextToken());
                            int counter = 0;
                            for( int j = min ; j < max ; j++){
                                String number =""+j;
                                int count=0;
                                for( int k = 1 ;k < number.length(); k++){
                                    String pairnumber=number.substring(k)+number.substring(0,k);
                                    int pair=Integer.parseInt(pairnumber);
                                    if(pair > j  && pair <= max ){
                                        count++;

                                        counter++;
                                        if(i==3 && count > 1)
                                            System.out.println(counter+" "+j+" "+pair);
                                        continue;
                                    }
                                }
                            }
                           pwStream.println ("Case #" + (i+1) + ": " +counter);
                    }
			// close all I/O files
			brStream.close();
			pwStream.close();
			
		}
		catch(IOException e){}
	}
}