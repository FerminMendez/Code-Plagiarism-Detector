import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Recycling {

	public static void main(String[] args) {
		try{
			
			//Input
			FileInputStream fstream = new FileInputStream("input.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//Output
			FileWriter ostream = new FileWriter("output.out");
			BufferedWriter out = new BufferedWriter(ostream);

			String str;
			//Read header & get num cases
			str = br.readLine();
			int numCases = Integer.parseInt(str);
			
			//Read File Line By Line
			for(int i = 1;i<=numCases;i++){
			    str = br.readLine();
			    String[] splitStr = str.split(" ");
			    
			    int A = Integer.parseInt(splitStr[0]);		
			    int B = Integer.parseInt(splitStr[1]);
			    
			    int numPairs = 0;
			    
			    for(int n=A;n<B;n++){
			    	for(int m=n+1;m<=B;m++){
			    		numPairs+=compare(n,m);
			    	}
			    }

			    
				String op = "Case #"+i+": "+numPairs;
				System.out.println(op);
				out.write(op);
				
				if(i!=numCases){
					out.newLine();
				}
			}
			
			
			//Close the input stream
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static int compare(int n,int m){
		String N = String.valueOf(n);
		String M = String.valueOf(m);
		
		//If length of String is 1, not a pair
		if(N.length() ==1 || M.length() == 1){
			return 0;
		}
		//If not same length, not a pair
		if(N.length() != M.length()){
			return 0;
		}
		
		//If they are the same, not a pair
		if(n==m){
			return 0;
		}
		
		for(int i=1;i<N.length();i++){
			//Match start region of N and end region of M
			Boolean one = N.regionMatches(0, M, M.length()-i, i);
			//Match end region of N and start region of M
			Boolean two = N.regionMatches(i, M, 0, M.length()-i);
			
			if(one && two){
				return 1;
			}
		}
		
		return 0;
	}
	
}

