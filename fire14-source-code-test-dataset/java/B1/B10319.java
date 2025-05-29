/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vhd
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class NewClass {
    public static void main(String vhd[]) throws Exception
    {
       
      

      
     // FileInputStream fis = new FileInputStream ("jam.txt");
     // FileOutputStream out=new FileOutputStream("outt.txt");
     
        RandomAccessFile file = new RandomAccessFile("jam.txt", "rw");
        RandomAccessFile file1 = new RandomAccessFile("outt.txt", "rw");
        String t = file.readLine();
        int times= Integer.parseInt(t);

        
        
        for( int r= 1 ; r<= times ; r++)
        {
     
            StringTokenizer st= new StringTokenizer(file.readLine()); 
       
        int num1 = Integer.parseInt(st.nextToken());
        int num2=   Integer.parseInt(st.nextToken());
        
      char ch ;
      int count =0;
      //fis.read();
      Scanner sc = new Scanner (System.in);
      
      
      int main1 = num1;
      
      int main2= num2;
      int mid = (num1 + num2 )/2;
      int n,m;
     String s1 = (Integer.valueOf(num1)).toString();
     String s2 = (Integer.valueOf(num2)).toString();
    
     int temp;
     int len1 = s1.length();
     int len2 = s2.length();
     int k =0,l =0;
     int arr[] = new int[100];
  
     
      for( int i = num1 ; i< num2 ; i++)
      {
          while(k<len1)
             {
                 n= i%10;
                 m= i/10;
                 arr[k]=n* (int)Math.pow(10.0, len1-1) +m;

                
                      
                 i= arr[k++];

             } k=0;
         temp= 0;
         while(k<len1)
         {
            if(i != arr[k] && arr[k]>i && arr[k]<=num2 )
              {
                  
                  count++;
              } k++;
         }
         k=0;
          
      }
     
file1.write(("Case #"+r+": " +count+ "\n").getBytes());
               
        }
    }
}