
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RockHead
 */
public class Recycle {
    
     public static void main(String args[]) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RockHead\\Desktop\\C-small-attempt0.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RockHead\\Desktop\\Recycle_Sol.txt"));
        int testNo = Integer.parseInt(reader.readLine());
        int count=0;
        for(int i=1;i<=testNo;i++)
        {
            String str=reader.readLine();                
            String[] info=str.split(" ");
            
            int A=Integer.parseInt(info[0]);
            int B=Integer.parseInt(info[1]);
            
            int n=A;
           for(int j=n;j<B;j++)
           {
              int m=j+1;
               for(int k=m;k<=B;k++)
               {
                  // System.out.println("Recycle (" + j +" "+ k  +") "+ isRecycled(Integer.toString(j),Integer.toString(k)));
                   if(isRecycled(Integer.toString(j),Integer.toString(k)))
                    count++;
               }
           } 
            System.out.println("Case #"+ i+": "+count );
            writer.write("Case #"+ i+": "+count);
            writer.newLine();
            count=0;
            
        }
        
        
        reader.close();
        writer.close();
}
     
     
     public static boolean isRecycled(String a,String b)
     {
        //move from the back of a to the front 
         for(int i=a.length();i>0;i--)
         {
             String subOne=a.substring(i);
             String subTwo=a.substring(0,i);
             String newString=subOne+subTwo;
             if(newString.equals(b))
                return true;
         }
         
         return false;
     }
     }
