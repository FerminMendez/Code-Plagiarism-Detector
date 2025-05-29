import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class RecycledNumbers{
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		
		File inf = new File("/home/jeyram/Downloads/"+"C-small-attempt1.in");
		File of = new File("/home/jeyram/Downloads/"+"rl-rn2-output.in");
		FileInputStream in = new FileInputStream(inf);
		FileOutputStream out = new FileOutputStream(of);
		// Get the object of DataInputStream
		  //DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  if ((strLine = br.readLine()) != null)   {
			  System.out.println (strLine);
			  int itrs= Integer.parseInt(strLine);
			  int count=0;
			  //#test cases
			  while (count < itrs)   {
				  if ((strLine = br.readLine()) != null){
					  //	input str
					  String[] inst = strLine.split(" ");
					  //start no
					  final int A = Integer.parseInt(inst[0]);
					  //end no
					  final int B = Integer.parseInt(inst[1]);	  
					  //no of numbers
					  int y=0;
					  //no of iterations check 3 for 4 digit number
					  int exp = (String.valueOf(A)).length()-1;
					  int exC=1;
					  while (exC<=exp){
						  int n =A;						  
						  while(n<=B){
							  int pow =1;
							  for(int p1=1;p1<exC;p1++)
							  {pow*=10;}
							  int q = n / (10*pow);
							  int r = n % (10*pow);
							  if(r!=0 && q!=0){
								  String ne = String.valueOf(r)+String.valueOf(q);
								  int m = Integer.parseInt(ne);
								  if((m<=B) && (n!=m) && (m>n) && 
										  (String.valueOf(n)).length()==(String.valueOf(m)).length()){//valid pair
									  //System.out.println(":"+n +":"+m);									  
									  y++;
									  }
							  }
							  n++;
						  }
						  exC++;
					  }
							  
					  

					  System.out.println("output string"+y);
					  //write as Case #1: 2 3
					  BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(out));
					  bw.write("Case #"+(count+1)+": "+y);
					  bw.newLine();
					  bw.flush();
					  }
				  count++;
			  }
		  
		  }
		  //Close the input stream
		  in.close();
		  out.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
		}
	}
}