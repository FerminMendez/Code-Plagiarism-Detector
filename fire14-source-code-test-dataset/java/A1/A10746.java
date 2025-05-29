import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Googlers {

	static int T = 0;
	
	public static void main(String[] args) {
		Googlers c = new Googlers();
		c.parseInput();
	}
	
	private void parseInput()
	{
		try{
		    FileInputStream fstream = new FileInputStream("B-small-attempt1.in");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    
		    FileWriter fwstream = new FileWriter("B-small-attempt1.out");
	        BufferedWriter out = new BufferedWriter(fwstream);
	        
		    if((strLine = br.readLine()) != null)
		    	T = Integer.parseInt(strLine);

		    for( int ctr = 1; ctr <= T; ctr++ )
		    {
		    	if(ctr > 1 )
		    		out.newLine();
		    	
		    	int N = 0;
		    	int S = 0;
		    	int p = 0;
		    	String strLine2;
		    	
		    	if((strLine2 = br.readLine()) != null)
		    	{
//		    		System.out.println(strLine2);
		    	}

		    	String [] numberStrings = strLine2.split(" ");
	    		N = Integer.parseInt(numberStrings[0]);
	    		S = Integer.parseInt(numberStrings[1]);
	    		p = Integer.parseInt(numberStrings[2]);
		    			    		
		    	int answer = 0;
		    	
		    	// run for each player
		    	for( int i = 0; i < N; i++ )
		    	{
		    		int score = Integer.parseInt(numberStrings[3+i]);
		    		
		    		int triple = p*3;
		    		if(triple == 0) {
		    			answer++;
		    		}else if(score == 0) {
		    			continue;
		    		} else if(score >= triple-2) {
		    			answer++;
		    		} else if((S > 0) && (score >= triple-4)) {
		    			S--;
		    			answer++;
		    		}		    		
		    		
		    	}
//		    	System.out.println(answer);
	    		out.write("Case #" + ctr +": " + answer);
		    }
		    in.close();
		    out.close();
		    }catch (Exception e)
		    {
		    	System.err.println("Error: " + e.getMessage());
		    }
	}
}
