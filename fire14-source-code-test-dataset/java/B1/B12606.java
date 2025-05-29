
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem3 {

	
	public static void main(String arg[])
	{
		

	
	 try{
         FileInputStream fstream = new FileInputStream("textfile.txt");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         
         FileWriter foutstream = new FileWriter("d:\\Problem3output.txt");
         BufferedWriter out = new BufferedWriter(foutstream);
         
         
         String strLine, copyStrLine = "";
         int caseCount = -1;
         strLine = br.readLine();
         caseCount = Integer.parseInt(strLine);
         for(int j=0; j < caseCount; j++)
                 //System.out.println (strLine);
         {
        	 strLine = br.readLine();
        	 String[] splitStrings = strLine.split(" ");
        	 int A = Integer.parseInt(splitStrings[0]);
        	 int B = Integer.parseInt(splitStrings[1]);
        	 int recycleCount = 0;
        	 for(int n = A; n < B; n++)
        	 {
        		int count = 10 ;
        		int counter = 0;
        		int len = splitStrings[1].length()-1;
        		int  arrayNumbers[];
        		
        		HashSet hashSet = new HashSet();
        		while(counter < len)
        		{
        			int tail = n % count;
        			int front = n / count;
        			
        			count = count * 10 ;
        			int val = (int) Math.pow(10,(len - counter));
        			int m = tail * val + front;
        			//System.out.println(i+":"+":"+temp+":"+val);
        			if(m > A && m <= B && m > n)
        			{
        				hashSet.add(new Integer(m));
        			}
        			counter++;
        		}
        		recycleCount = recycleCount + hashSet.size();
        	 }
        	 System.out.println(recycleCount);
           
           	out.write("Case #" + (j + 1) + ": " + recycleCount + "\n");
         
         }
         out.close();
	 	} 
	 catch (Exception e) {
         System.err.println("Error: " + e.getMessage());
 
	   }
	}
}
