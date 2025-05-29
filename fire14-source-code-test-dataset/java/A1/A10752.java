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

public class DancingGooglers {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		
		File inf = new File("/home/jeyram/Downloads/"+"B-small-attempt0.in");
		File of = new File("/home/jeyram/Downloads/"+"rl-dg-output.in");
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
					  //number of googlers
					  int N = Integer.parseInt(inst[0]);
					  //number of surprises atleast ==2
					  int S = Integer.parseInt(inst[1]);	  
					  //result of atleast p		  
					  int p = Integer.parseInt(inst[2]);
					  //max no of googlers with p
					  int y=0;
					  //scores list
					  int[] ti =  new int[inst.length-3];
					  int j=0;
					  for(int i=3;i<inst.length;i++){
						  ti[j] = Integer.parseInt(inst[i]);
						  int q = (ti[j]>0)?ti[j]/3:0;
						  int r = (ti[j]>0)?ti[j] % 3:0;
						  if(q==0&& r==0){
							  if(q>=p){
								  y++;
							  }
						  }else 
						  //eliminate surprise count
						  //divis by 3 r 0 
						  //2 strat one sur :n,n,n | n+1,n-1,n (sur)
						  if (r==0){
							  //regular strat
								  if(q>=p){
									  y++;
								  }else{
									  if(S>0){//surprise strat
										  if(((q+1)>=p) || (q>=p) || ((q-1)>=p)){
											  y++;S--;
										  }									  
									  }
								  }
							  
						  }
						  //divis by 3 r 1
						  //2 strat one sur :n,n,n+1 | n+1,n-1,n+1 (sur)
						  else if(r==1){
							  //regular strat
								  if(((q+1)>=p) || (q>=p)){
									  y++;
								  } else {
									  if(S>0){//surprise strat
										  if(((q+1)>=p) || ((q-1)>=p)){
											  y++;S--;
										  	}
									  	}	  
								  }
						  }
						  //divis by 3 r 2
						  //2 strat one sur :n+1,n+1,n |n+2,n,n (sur)
						  else if(r==2){
							  
							  //regular strat
								  if(((q+1)>=p) || (q>=p)){
									  y++;
								  } else {
									  if(S>0){//surprise strat
										  if(((q+2)>=p) || ((q)>=p)){
											  y++;S--;
										  }
									  }	  
								  }
						  }
						  j++; 
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