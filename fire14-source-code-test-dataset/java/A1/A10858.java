import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class letDance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 StringBuffer output = new StringBuffer();
		 
			try{
				  FileInputStream fstream = new FileInputStream("/Users/iToR/Documents/workspace/CodeJam2/src/B-small-attempt2.in");
				
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				
				 
				  strLine = br.readLine();
				  int line = (new Integer(strLine)).intValue();
				  
				  int i = 1;
				  while ((strLine = br.readLine()) != null)   {
					 
					  
					  
					 
						
							output.append("Case #"+i+": ");
							
							String[] temp;
							 
							  /* delimiter */
							  String delimiter = " ";
							  /* given string will be split by the argument delimiter provided. */
							  temp = strLine.split(delimiter);
							  
							  int compet = (new Integer(temp[0])).intValue();
							  int surprise = (new Integer(temp[1])).intValue();
							  int max = (new Integer(temp[2])).intValue();
							  int count = 0;
							 
							for(int j = 3;j<temp.length;j++){
								
								int dif = (new Integer(temp[j])).intValue()-(3*max);
								if(max==0){
									count++;
								}
								else if((new Integer(temp[j])).intValue()==0){
									
								}
								else if(dif>=0||dif==-1||dif==-2){
									count++;
								}
								else if(dif==-3||dif==-4){
									if(surprise>0){
										count++;
										surprise--;										
									}
									
								}
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
				  System.err.println("Error: " + e.getMessage());
				  }
			//write output
			 	try{
				
				  FileWriter fstream = new FileWriter("result.txt");
				  BufferedWriter out = new BufferedWriter(fstream);
				  out.append(output);
				 
				  out.close();
				  }catch (Exception e){
				  System.err.println("Error: " + e.getMessage());
				  }
	}

}
