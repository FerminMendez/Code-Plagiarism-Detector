package recyclednumbers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package recyclednumbers;

/**
 *
 * @author sony
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        
  BufferedReader br=new BufferedReader(new FileReader(args[0]));
  
  int Testcases=Integer.parseInt(br.readLine());
  
  for(int i=0;i<Testcases;i++)
  {
  String[] numbers=br.readLine().split(" ");
  //System.out.print(numbers[0]+":"+numbers[1]+"\n");
  int first=Integer.parseInt(numbers[0]);
  int second=Integer.parseInt(numbers[1]);
  int TotalCount=0;
 if(second<10)
 {
 System.out.print("Case #"+(i+1)+": 0\n");
 continue;
 
 }
  for(Integer n=first;n<second;n++)
  {
  String nString=n.toString();
 // System.out.print("--"+nString+"\n");
  for(int j=1;j<nString.length();j++)
  {
      String dumm=nString.substring(j);
      dumm+=nString.substring(0,j);
     // System.out.print(dumm+"\n");
  String mString=dumm;

  //System.out.print(mString+"--");
  //Thread.sleep(1000);
  int mvalue=Integer.parseInt(mString);
  if(mvalue>n&&mvalue<=second)
      TotalCount++;
  }
  
  }
          
  System.out.print("Case #"+(i+1)+":"+" "+TotalCount+"\n");
  
  
  }
  
  
    }
}
