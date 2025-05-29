import java.util.*;
import java.io.*;
class Recycled_Numbers
{
  public static void main(String arg [])
  {
    int check =-456;
       String m="";
    int counter =0;
    int calculate =0;
    String sub="";
    int mi =0;
     int ma=0;
    String path;
    String first,second;
    int numberOfLoops=0;
     Scanner read = new Scanner(System.in);
    System.out.println("pls enter your file");
    path = read.nextLine();
    
   
    BufferedWriter bw;
    try
    {
      File  fobj = new File(path);
      Scanner sc = new Scanner(fobj);
      bw =new BufferedWriter( new FileWriter("RecycleOutput.txt"));
      int tests = sc.nextInt()  ,meter = 1;
      while (meter <= tests)
      {  
     
        mi= sc.nextInt();
          ma =sc.nextInt();
     
    while(mi<=ma)
    {
         counter =0;  
        m = mi+"";
     
     
      while(counter <m.length()-1)
      {
        numberOfLoops=m.length()-1;
        second = m.substring(numberOfLoops -counter);
        first = m.substring(0,numberOfLoops-counter);
        sub = second+first;
     
        if ((Integer .parseInt(sub)>mi)&&(Integer .parseInt(sub)<=ma)&&(Integer .parseInt(sub)!=check) )
        {
            
          calculate++;
        check= Integer .parseInt(sub);
        }
        
        counter++;
      }
      
      
      mi++;
    } 
    bw.write("Case #"+meter+": " +calculate );
    bw.newLine();
    calculate =0;
    meter++;
    } 
    bw.close();
      }//end of try
    catch(IOException e)
    {
      System.out.println(e);
    }
   
    }    
}