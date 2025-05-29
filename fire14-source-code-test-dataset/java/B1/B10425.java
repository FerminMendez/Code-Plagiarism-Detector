import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;



public class RecycledNumbers {

	static String inputLargeFile = "C-large.in";
	static String inputSmallFile = "C-small-attempt0.in";
	
	static String outSmallFile = "C-small-attempt0.out";
	static String outLargeFile = "C-large.out";
	
	static BufferedReader br ;
	static PrintWriter out ;
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(inputSmallFile)));
		out = new PrintWriter(new File(outSmallFile));
		
		String input = br.readLine();
		
		int testcases = Integer.parseInt(input.trim());
		
		for (int i = 0; i < testcases; i++) {
			   String range =  br.readLine();
			   String[] numbers = range.split(" ");
			     
			   int A = Integer.parseInt(numbers[0].trim());
			   int B = Integer.parseInt(numbers[1].trim());
               String part1=null;
               String part2=null;
               int count=0;
               int m =0;
               int endIndex =0;
               int beignIndex=0;
               
               String number = null; 
               String pair = null;
               
			   for(int n=A;n<=B;n++ ){      
		               
		              number = String.valueOf(n);
		              endIndex = number.length()-1;
		              
		             int last=0;
					 for(int p=endIndex;p>0;p--){
						 
						pair =  number.substring(p)+number.substring(beignIndex,p);
					    m=Integer.parseInt(pair); 
						
					  
					    if(m>n&&m<=B&&m!=last){
							
							count++;
							last=m;
							
							//out.println("count : " + count);
						}
					 
					 } 
				   }
				   
			   out.println("Case #"+ (i+1)+ ": " + count);	   
		}
			   
			   
			
			 	   				   
		out.close();
		br.close();
	   
			
		}
		
		
	}


