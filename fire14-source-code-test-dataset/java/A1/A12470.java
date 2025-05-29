import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.math.*;
import java.text.*;


public class Gjam{
    
static int _pow(int num, int power)
{
  int product=1;
  for(int i=0;i<power;i++)
    product *= num;
  
  return product;
}


public static void main(String asdf[])
{
  //long startTime = System.currentTimeMillis();
  String name = "B-small-attempt0";
  String output="";
  String inputFileName = name+".in";
  String outputFileName = name+".out";
  
  if(asdf.length!=0)
    inputFileName = asdf[0] ;
 
  Scanner input;
  
  try
  {
    input = new Scanner(new FileReader(inputFileName));
      
    /******************************************************************/
    //start coding
    int T = input.nextInt();
    
    //input.nextLine();
    // loop every case
    for(int i=0;i<T;i++)
    {
      
      int res=0;
      int n = input.nextInt();
      int s = input.nextInt();
      int p = input.nextInt();
      //int[] t = new int[n];
            
      
      for(int j=0;j<n;j++)
      {
         int t = input.nextInt();
         if(t!=0)
         {
           int mod = t%3;
           int ave = t/3;
           
           switch(mod) 
           {
             case 0: 
               if(ave>=p) ++res;
               else if(ave+1>=p) 
               {
                 if(s>0)
                 {
                   --s;
                   ++res;
                 }
               }
               break;
               
             case 1:
               if(ave+1>=p) ++res;
               break;
               
             case 2:
               if(ave+1>=p) ++res;
               else if(ave+2>=p) 
               {
                 if(s>0)
                 {
                   --s;
                   ++res;
                 }
               }
               break;
           }
     
         }
      }
      if(p==0) res = n;
   
      //output
      String out = "Case #" + (i+1) + ": " + res +"\n";
      output += out;
      System.out.print(out);
    }
    //DecimalFormat df = new DecimalFormat ("0.0");
    //double sdds = 5312341.082491924125979175;System.out.println(df.format(sdds) );    
    //end coding
    /******************************************************************/
    
    output = output.trim();
    
    input.close();
    
    createFile( outputFileName, output);
    
    //System.out.print(output);
    
    //System.out.print("\n\n <Time> "+ (System.currentTimeMillis()-startTime)/1000 );
  }
  catch(FileNotFoundException e)
  {
    System.out.print(e);
  }
  catch( Exception e)
  {
      System.out.println(e);
  }
  
}


public static void createFile( String file , String input ) throws IOException
  {
    File file2 = new File(file);
    
    {
      PrintWriter fileOut = new PrintWriter( file );
      try
      {
        int n =0;
        String input2=input;
        
        while( input.indexOf('\n') != -1 )
        {
          input2 = input.substring( 0, input.indexOf('\n') );
          input = input.substring( input.indexOf('\n') + 1 );
          fileOut.print(input2);
          fileOut.println();
        }
        fileOut.print(input);
        //JOptionPane.showMessageDialog(null, "file: " + "created");
      }
      
      catch( Exception e)
      {
        System.out.println(e);
      }
      finally
      {
        fileOut.close();
      }
    }
  
  }


}