import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Prob3 {

	
	public static int calc(int n1, int n2){
		Set<String> set = new HashSet();
		int c=0;
		for(;n1<=n2;n1++){
			String sn = ""+n1;
			Set<String> tested = new HashSet();
			for(int i=0;i<sn.length();i++){				
				String s = sn.substring(i,sn.length())+sn.substring(0,i);
				if(s.charAt(0)=='0') continue;
				if(tested.contains(s)) continue; 
				tested.add(s);
				int s2 = Integer.parseInt(s);
				if(set.contains(s) && s2>=n1 && s2<=n2){
					c++;
				}else{
					set.add(s);
				}
			}
			
		}
		return c;
	}
	
	public static void main(String[] args) {
			
		try{

		  FileInputStream fstream = new FileInputStream("C-small-attempt2.in");

		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;

		  FileWriter fstream1 = new FileWriter("C-small-attempt2.out");
		  BufferedWriter out = new BufferedWriter(fstream1);
//		  out.write("Hello Java");
		  //Close the output stream
		  
		  
		  long l = Long.parseLong(br.readLine());
		  for(long i=0; i<l && (strLine = br.readLine()) != null; i++)   {
			  String[] s = strLine.split(" "); 
			  int res = calc(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			  System.out.println("Case #"+(i+1)+": " +res);
			   out.write("Case #"+(i+1)+": " +res+"\n");
			  
			 // System.out.println("\n\n\n\n\n\n\n\n");
		  }			
		  out.close();
		} catch (Exception e1){
	    	e1.printStackTrace();
		}
	}
		
}
