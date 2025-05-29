import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Dance {
	static int no_Test_Cases =0; 			  		//number of test cases
	static String input_Array[];					//to read input file	
	static int output_Array[];  					// to write the t output lines
		
	public static void main(String[] args) {
		readFile();
		
			
		for (int i = 0; i< no_Test_Cases; i++ ){
			googler_Dance(i);
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
	
	public static void googler_Dance(int i){
		
		String s1 = input_Array[i];
		
		String s2[] = s1.split(" ");
		
		int no_Googler = Integer.parseInt(s2[0]);
		int no_Surprise = Integer.parseInt(s2[1]);
		int best_Score = Integer.parseInt(s2[2]);
		int counter = 0; 				// to count the no of googler getting more than best_Score
		
		
			for (int i1 = 0; i1<no_Googler; i1++){
				int score;
				score = Integer.parseInt(s2[3+i1]);
				
				int rem = score%3;
				int x = score/3;
				
				switch (rem) {
					case 0:
						if (x >= best_Score)
							counter++;
						else {
							if (no_Surprise > 0){
								if (x-1 >= 0 && x+1 <=10){
									if (x >= best_Score -1){
										counter++;
										no_Surprise--;
									}
								}
							}
						}	
					break;
					
					case 1:
						if (x >= best_Score -1)
							counter++;
						
					break;
					
					case 2:
						if (x >= best_Score -1)
							counter++;
						else {
							if (no_Surprise > 0){
								if (x+2 <= 10){
									if (x >= best_Score -2){
										counter++;
										no_Surprise--;
									}
								}
							}
						}	
					break;
					
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
