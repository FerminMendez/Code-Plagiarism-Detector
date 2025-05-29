import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class gcjq1 {

	public static void main(String[] args) {
	       
		try{
			FileInputStream ifstream = new FileInputStream("files/B-small-attempt0.in");
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
        String[] parms = in.split(" ");
        
        int N = Integer.parseInt(parms[0]);
        int s = Integer.parseInt(parms[1]);
        int p = Integer.parseInt(parms[2]);
        int []t = new int[N];
        
        for(int i=0; i<N; i++){
        	t[i] = Integer.parseInt(parms[i+3]);
        }
        
        int c = 0;
        
        for(int i=0; i<N; i++){
          	int n = p+(2*(p-1));
          	
          	if(t[i] >= n){
        		c++;        	
        	}
        	else {
        		n = p+(2*(p-2));
           		if(t[i] >= n && t[i] > 0 && s>0){
        			c++;
        			s--;
        		}
        	}
        }
        
        return Integer.toString(c);
    }
}

