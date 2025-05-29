

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Problem2 {
	public static void main(String arg[])
	{

	 try{
         FileInputStream fstream = new FileInputStream("textfile.txt");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         
         FileWriter foutstream = new FileWriter("D:\\Problem2output.txt");
         BufferedWriter out = new BufferedWriter(foutstream);
         
         
         String strLine,copyStrLine="";
         int caseCount = -1;
         strLine = br.readLine();
         caseCount = Integer.parseInt(strLine);
        
         for(int j=0; j < caseCount; j++)
                 //System.out.println (strLine);
         {
        	 strLine = br.readLine();
        	 String[] splitStrings = strLine.split(" ");
        	 int countGooglers = Integer.parseInt(splitStrings[0]);
             int surprisingSet = Integer.parseInt(splitStrings[1]);
             int pValue = Integer.parseInt(splitStrings[2]);
             int pMaxCount = 0;
             
             for(int i = 0 ; i < countGooglers; i++ )
             {
            	 int score = Integer.parseInt(splitStrings[3+i]);
            	 int n = score / 3;
            	 if(pValue > score){
            		 continue;
            	 }
            	 if(score % 3 == 0){
            		 if(n >= pValue){
            			 pMaxCount++;
            		 }
            		 if(n == pValue - 1){
            			 	if(surprisingSet > 0){
            			 		pMaxCount++;
            			 		surprisingSet--;
            			 	}
            		 }
            	 }
            	 else if(score % 3 == 1){
            		 if(n >= pValue - 1){
            			 pMaxCount++;
            		 }
            	 }
            	 else{
            		 if(n >= pValue - 1){
            			 pMaxCount++;
            		 }
            		 if(n == pValue - 2){
            			 	if(surprisingSet > 0){
            			 		pMaxCount++;
            			 		surprisingSet--;
            			 	}
            		 }
            	 }        	 
             }
           	 System.out.println("Case #" + (j + 1) + ": " + pMaxCount + "\n");
             out.write("Case #" + (j + 1) + ": " + pMaxCount + "\n");
         
         }
         out.close();
	 	} 
	 catch (Exception e) {
         System.err.println("Error: " + e.getMessage());
 
	   }
	}

}
