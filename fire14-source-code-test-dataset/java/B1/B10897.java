import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class recy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stat[] = new int [2000001];
		
		StringBuffer output = new StringBuffer();
		 
		try{
			  FileInputStream fstream = new FileInputStream("/Users/iToR/Documents/workspace/CodeJam3/src/C-small-attempt4.in");
			
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			
			 
			  strLine = br.readLine();
			  int line = (new Integer(strLine)).intValue();
			  
			  int i = 1;
			  
			  
			  
			  
			  while ((strLine = br.readLine()) != null)   {
				 
				  //each case
				  
				 
				  	
					output.append("Case #"+i+": ");
						
					String[] temp;
						 
					/* delimiter */
					String delimiter = " ";
					/* given string will be split by the argument delimiter provided. */
			
					temp = strLine.split(delimiter);
					
					
					int orimin = (new Integer(temp[0])).intValue();
					int min = (new Integer(temp[0])).intValue();
					int max = (new Integer(temp[1])).intValue();
					int count = 0;
					
						 while(min<=max){
							 
							  //try swap
							  String tempStr = ""+min;
							  String oritempStr = ""+min;
							  int oricheck = (new Integer(oritempStr)).intValue();
							  stat[min] = 1;
							  for(int k = 0;k<oritempStr.length()-1;k++){
								  //System.out.println("before:"+ tempStr+"x"+tempStr.length());
								  char first = tempStr.charAt(0);
								  
								  tempStr = tempStr.substring(1,tempStr.length());
								  tempStr+= first;
								  
								  int check = (new Integer(tempStr)).intValue();
								  
								  //System.out.println("after:"+ tempStr+"x"+tempStr.length());
								  if(tempStr.charAt(0)=='0'){
									  
								  }
								  else if(check>0&&check<=max&&check>=orimin){
									  if(check>oricheck){
										  count++;
										 System.out.println(oritempStr+","+check);
									  }
								  }
								  
							  	}
							  
							  min++;							  
						  }
						 
						 
						
						output.append(count);
						if(i<line){
							output.append("\n");
							
						}			
						i++;
			  
			  
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error1: " + e.getMessage());
			  }
		//write output
		 	try{
			
			  FileWriter fstream = new FileWriter("result.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.append(output);
			 
			  out.close();
			  }catch (Exception e){
			  System.err.println("Error2: " + e.getMessage());
			  }
	}

}
