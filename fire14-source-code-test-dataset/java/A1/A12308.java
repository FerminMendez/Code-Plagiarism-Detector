import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingGoogle {

	public static void main(String[] args) {
		
		try {
			FileWriter fout = new FileWriter("B-small-attempt1.out");
		    BufferedReader in = new BufferedReader(new FileReader("B-small-attempt1.in"));
		    BufferedWriter out = new BufferedWriter(fout);
		    
		    int T = Integer.parseInt(in.readLine());
		    String[] input;
		    
		    
		    for(int i=0; i<T; i++)
		    {
		    	System.out.println();
		    	System.out.println("Case #" + (i+1));
		    	int overs = 0;
		    	input = in.readLine().split(" ");
		    	int numGooglers = Integer.parseInt(input[0]);
		    	int surprises = Integer.parseInt(input[1]);
		    	int p = Integer.parseInt(input[2]);
		    	System.out.println("Looking for scores of " + p + " or higher with " + surprises + " surprises.");
		    	
		    	for(int j=0; j<numGooglers; j++)
		    	{
		    		System.out.print("Googler " + (j+1) + ": ");
		    		if(Integer.parseInt(input[j+3]) >= p && p < 2)
		    			overs++;
		    		else if(Integer.parseInt(input[j+3]) >= ((p*3)-2) && ((p*3)-2) > 0){
		    			overs++;
		    			System.out.println(input[j+3] + " is bigger than or equal to " + ((p*3)-2));
		    		}
		    		else if(Integer.parseInt(input[j+3]) >= ((p*3)-4) && ((p*3)-4) > 0) {
		    			if(surprises > 0) {
		    				overs++;
		    				surprises--;
		    				System.out.println(input[j+3] + " is bigger than or equal to " + ((p*3)-4) + " if we use a surprise.");
		    			}
		    			else System.out.println(input[j+3] + " is not bigger enough.");
		    		}
		    		else System.out.println(input[j+3] + " is not bigger enough.");
		    	}
		    	System.out.println("Case #" + (i+1) + ": " + overs);
		    	fout.write("Case #" + (i+1) + ": " + overs);
		    	out.newLine();
		    	out.flush();
		    }
		    in.close();
		    out.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
