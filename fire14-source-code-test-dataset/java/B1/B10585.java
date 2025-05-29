package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


/**
 *
 * @author Mudasar
 */
public class RecycledNumbers {
    
    static String strLine =null;
 static int result = 0;
    static int first = 0;
	static int second = 0;
 public static void main(String[] args) {
  
     try {
        
         FileInputStream fstream = new FileInputStream("textfile.in");
         // Get the object of DataInputStream
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));

         FileWriter ifstream = new FileWriter("output.txt");
         BufferedWriter out = new BufferedWriter(ifstream);


         int resultCounter = 0;
         
         while ((strLine = br.readLine()) != null) {
             if (resultCounter == 0) {
                 resultCounter = 1;
                 continue;
             }
             
             String records[] = new String[2];
             records = strLine.split(" ");
             first = Integer.parseInt(records[0]);
             second = Integer.parseInt(records[1]);
             
             result = recyleAble(first , second);
               
             
             String output = "Case #" + resultCounter + ": " + result + "\n";
            // System.out.println("Case #" + resultCounter + ": " + result);
             try {
                
                 out.write(output);
                

             } catch (Exception e) {
                 System.err.println("Error: " + e.getMessage());
             }
             result = 0;
             resultCounter++;
         }
         
         in.close();
         out.close();
     } catch (Exception e) {// Catch exception if any
         System.err.println("Error: " + e.getMessage());
     }
 }
private static  int recyleAble(int _first, int _second) {
	// TODO Auto-generated method stub
	int count = 0;
	for(int i = _first ; i< _second ; i++){
		for(int j = i + 1; j <= _second; j ++ )
			if(rotateAndCheck(i , j))
				count ++ ;
	}
   //System.out.println("/n");
	return count;
}
private static boolean rotateAndCheck(int i, int j) {
	// TODO Auto-generated method stub
	int length = Integer.toString(i).length();
	int r  ; 
	for(int b= (length-1) ; b>=0 ; b--)
	{
		r = i % 10 ; i/=10;
		i = (int) (r*Math.pow(10, length-1) + i );
		if ( i == j)
		{ // System.out.print(i + ", ");
			return true;
	}}
	

	return false;
}

}
