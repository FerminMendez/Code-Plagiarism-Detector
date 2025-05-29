import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;


public class QuestionC {

	//final static String FNAME = "C:\\CodeJam\\RecycledNumbers";
	final static String FNAME = "C:\\CodeJam\\C-small-attempt0";
	//final static String FNAME = "C:\\CodeJam\\A-large-practice";
    public static Scanner in;
    public static PrintWriter out;

    static void open() throws IOException {
        Locale.setDefault( Locale.US );
        in = new Scanner( new File( FNAME + ".in" ) );
        out = new PrintWriter( new File( FNAME + ".out" ) );
    }

    static void close() throws IOException {
        out.close();
    }

        
    
	public static void main(String[] args)throws IOException {
		open();
        int N = in.nextInt();
        //int T = Integer.parseInt(in.nextLine());
        /*    -------- Main code ----------  */
        
        for(int i = 0 ; i < N ; i++){
        	int A = in.nextInt();
        	int B = in.nextInt();
        	//System.out.println(A + "----" + B);
        	int absMinFirstDigit = Character.digit(Integer.toString(A).toCharArray()[0],10);
        	int absMaxFirstDigit = Character.digit(Integer.toString(B).toCharArray()[0],10);
        	//System.out.println(absMinFirstDigit + "----" + absMaxFirstDigit);
        	
        	long count = 0;
        	if(A>=10){
            	for(int n = A ; n <= B; n++){
            		char[] numChars = Integer.toString(n).toCharArray();
            		int maxLen = numChars.length;
            		int firstDigitOfNum = Character.digit(numChars[0],10);
            		Set<Integer> checkDupSet = new HashSet<Integer>();
            		for(int j = 1 ; j <= maxLen-1 ; j++){
            			int numAtJIindex = Character.digit(numChars[j], 10);
            			if ( (numAtJIindex<absMinFirstDigit) || 
            					(numAtJIindex>absMaxFirstDigit) || 
            					(numAtJIindex<firstDigitOfNum ) ) 
            				continue;
            			//Generate m
            			int m = 0;
            			for(int k = 0 , rot = j; k < maxLen ; k++, rot = (rot + 1)%maxLen ){
            				m = m * 10 + Character.digit(numChars[rot],10);
            				//System.out.println("Number generated : "+ m);
            			}
            			if(m>n && m<=B ){
            				if(checkDupSet.add(m)){
	            				//System.out.println("Valid Number generated : "+ n + " : " + m);
	            				count++;
            				}
            			}
            		}
            		
            	}
        	}
        		
        	
        	       	
        	
        	
	    	//Print to file	
        	out.println( "Case #" + (i+1) + ": "+count);
	        //System.out.println( "Case #" + (i+1) + ": "+count);	
        }
        
        close();

	}

}
