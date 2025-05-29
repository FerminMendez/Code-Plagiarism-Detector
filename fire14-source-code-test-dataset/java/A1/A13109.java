import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Dancing {

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
			    
			    int N = Integer.parseInt(splitStr[0]);		//Num googlers
			    int S = Integer.parseInt(splitStr[1]);		//Num suprising scores
			    int best = Integer.parseInt(splitStr[2]);	//Best score
			    
			    int numNormal = 0;
			    int numSpecial = 0;
			    
			    for(int j = 3;j<splitStr.length;j++){
			    	int tot = Integer.parseInt(splitStr[j]);
			    	
			    	if(tot<best){
			    		continue;
			    	}else if(tot>=((3*best)-2)){
			    		numNormal++;
			    	}else if(tot>=((3*best)-4)){
			    		numSpecial++;
			    	}else{
			    		continue;
			    	}
			    }
			    
			    int numPossible = 0;
			    if(numSpecial<S){
			    	numPossible = numNormal+numSpecial;
			    }else{
			    	numPossible = numNormal+S;
			    }

			    
				String op = "Case #"+i+": "+numPossible;
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
	
}

