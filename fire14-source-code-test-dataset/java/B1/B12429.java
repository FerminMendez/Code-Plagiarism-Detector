import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class recycle {
	static int count=0;
	static int A = 0;
	static int B = 0;
	
	public static void permutes(String start){
		int n = Integer.valueOf(start);
		for(int i=1;i<start.length();i++){
			String current = start.substring(0, i);
			String rest = start.substring(i, start.length());
			String finish = rest+current;
			int m = Integer.valueOf(finish);
			if(n==m){
				break;
			}
				
			if(m<=B && n<m){
				count++;
			
			}
		}
		
	}
	public static void main(String args[])
	 {
		String line;
		  int i=0;
		  try{
		  FileInputStream fstream1 = new FileInputStream("Ctest.txt");
		  DataInputStream in1 = new DataInputStream(fstream1);
		  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		  FileWriter fw = new FileWriter("outC.txt");
		  BufferedWriter out = new BufferedWriter(fw);
		 
		  while ((line = br1.readLine()) != null)   {  
		  		

		  		if(i!=0){
		  			String outpt = "Case #"+i+": ";
		  			String brkline[]=line.split(" ");
		  			A = Integer.valueOf(brkline[0]);
		  			//System.out.println("A= "+A);
		  			B = Integer.valueOf(brkline[1]);
		  			//System.out.println("B= "+B);
		  			
		  			for(int p=A;p<=B;p++){
		  				permutes(String.valueOf(p));
		  			}
		  			outpt = outpt+count;		
		  			out.write(outpt+"\n");
		  			System.out.println(outpt);
		  			}
		  		
		  		i++;
		  		count=0;
		  	  }
		  
		  //Close the input stream
		  in1.close();
		  //Close the output stream
		  out.close();
		    }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e);
		  }
/////////////////////////////////////////////////				
		
	 }
}
