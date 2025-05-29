import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class habala {
        public static void main(String[] args) throws Exception {
        	
        	
        	String s2;
        	
        	
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.in")));
                PrintWriter out = new PrintWriter("output.out");
               
                int testCases = Integer.parseInt(in.readLine());
                
                for (int i = 1; i <= testCases; i++) {
                        String s = in.readLine();
                        
                        int Googlers, surprizes ,p;
                        int winers = 0;
					      StringTokenizer st = new StringTokenizer (s);
					      s2 = "";
					
					      s2 = st.nextToken();
					      Googlers = Integer.parseInt(s2);
					      surprizes  = Integer.parseInt(st.nextToken());
					      p = Integer.parseInt(st.nextToken());
					      
					      int minn = (3*p-2) < p ? p : (3*p-2) ;
					      int mins = (3*p-4) < p? p : (3*p-4) ;
					      
					     for(int j = 1 ; j <= Googlers ; j++)
						 {
					         
					           int scoure = Integer.parseInt(st.nextToken());
					           if (scoure >= minn )
					        	   winers++;
					           else if(scoure >= mins && surprizes > 0){
					        	   winers++;
					        	   surprizes--;
					           }
					       
					         
						}
                        
                        out.println("Case #"+i+": "+winers);
                        
                }
                out.close();
                in.close();
        }
}