import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Recycled {
	static int no_Test_Cases =0; 			  		//number of test cases
	static String input_Array[];					//to read input file	
	static int output_Array[];  					// to write the t output lines
		
	public static void main(String[] args) {
		readFile();
		
		for (int i = 0; i< no_Test_Cases; i++ ){
			recycled_Number(i);
		}
		
		writeFile();
	}		
		
	public static void readFile(){
		
		try{
				FileInputStream fstream = new FileInputStream("C:/sarab/input.txt");
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
               
                String strLine;
                
                strLine = br.readLine();
                no_Test_Cases = Integer.parseInt(strLine);
                
                input_Array = new String[no_Test_Cases];
                output_Array = new int[no_Test_Cases];
                
                for (int i = 0; i< no_Test_Cases; i++){
                		strLine = br.readLine();
                		input_Array[i] = strLine;
                } 		
                //Close the input stream
                in.close();
		}
        
		catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
        }
        
	} 
	
	public static void recycled_Number(int i){
		
		String s1 = input_Array[i];
		
		String s2[] = s1.split(" ");
		
		int a = Integer.parseInt(s2[0]);
		int b = Integer.parseInt(s2[1]);
		
		
		
		char c1[] = s2[0].toCharArray();
		int length = c1.length;
		
		int no_Array[] = new int[length-1];
		int counter = 0; 				
		String s3 = "";
		
		
		for (int i1 = a; i1 < b; i1++){
				String s4 = ""+i1;
				c1 = s4.toCharArray();
			for(int i2 = 0; i2 < length-1; i2++){
				
				for(int i3 =1; i3 <= length-1 ; i3++){
					s3 = s3+c1[i3];
				}
				s3 = s3+c1[0];
				//System.out.println(s3);
				no_Array[i2] = Integer.parseInt(s3);
				
				c1 = s3.toCharArray();
				s3 = "";
			
			}
			for (int i5 = 0; i5 < length -2 ;i5++){
				for (int i6 = i5+1; i6 < length -1; i6++){
					if(no_Array[i6] == no_Array[i5]){
						no_Array[i6] = i1;
					}
				}
			}
			for (int i4 =0; i4 < length-1 ; i4++){
				if (no_Array[i4] > i1 && no_Array[i4] <= b) {
					counter++;
					
				}
			}	
		
			
		}		
		output_Array[i]= counter;
		 
	}
		
		
	
	public static void writeFile(){
        String forOutput;
        try{
                 
                FileWriter fstream = new FileWriter("C:/sarab/output.txt");
                BufferedWriter out = new BufferedWriter(fstream);
                for (int i=0; i<no_Test_Cases; i++){
                	
                      forOutput="Case #"+(i+1)+": "+output_Array[i]+"";
                      out.write(forOutput);
                      out.newLine();
                }
                //Close the output stream
                out.close();
                }catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
                }

  }


}	

