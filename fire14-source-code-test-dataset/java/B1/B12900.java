import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class gcjq3 {

	public static void main(String[] args) {
	       
		try{
			FileInputStream ifstream = new FileInputStream("files/C-small-attempt0.in");
			DataInputStream in = new DataInputStream(ifstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileOutputStream ofstream = new FileOutputStream("files/output");
			DataOutputStream out = new DataOutputStream(ofstream);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			
			int numCases = Integer.parseInt(br.readLine());
			
			for(int i=0; i<numCases; i++){
				bw.write("Case #" + Integer.toString(i+1) + ": " + compute(br.readLine()) + "\n");
				bw.flush();
			}
			
			in.close();
			out.close();
			
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}           
    
    public static String compute(String in){
   	
        int c = 0;
    	
    	String[] parms = in.split(" ");
        
        int ns = Integer.parseInt(parms[0]);
        int ne = Integer.parseInt(parms[1]);
        
        
        while(ns <= ne){
        	String num = Integer.toString(ns);
        	for(int i=1; i<num.length(); i++){
        		if(num.substring(i).charAt(0) != '0'){
        			String rnum = num.substring(i) + num.substring(0, i);
        			
        			if(Integer.parseInt(rnum) <= ne && Integer.parseInt(num) < Integer.parseInt(rnum)){
        				c++;
        			}
        		}
        	}
        		
        	ns++;
        }
               
        return Integer.toString(c);
    }
}

