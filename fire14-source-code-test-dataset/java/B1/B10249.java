import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;



public class RNumber extends Basic2
{

   public static void main(String[] args) throws Exception 
   {
      RNumber p3 = new RNumber();
      p3.initialize();
      p3.printOutput();
      p3.bos.close();
   }
   
   @Override
   public void printOutput() throws Exception
   {
      int noTC = Integer.parseInt(bis.readLine());
      int runningTC = 1;
      while(runningTC<=noTC)
      {
         String[] a_b_str =bis.readLine().split(" ");
         long[] a_b = new long[]{Long.parseLong(a_b_str[0]),Long.parseLong(a_b_str[1])};
         if(a_b[0]>a_b[1])
         {
            long temp = a_b[0];
            a_b[0] = a_b[1];
            a_b[1] = temp;
         }
         Set<Long> found = new HashSet<Long>();
         int leading =0;
         for(long i=a_b[0];i<=a_b[1];i++)
         {
            long numberToCheck = i;
            for(long k = numberToCheck+1;k<=a_b[1];k++)
            {
               if(((""+k).length()==(""+numberToCheck).length()) && (""+k+""+k).contains(""+numberToCheck))
               {
                     leading++;
               }
               /*int t= k;
               String n=""+numberToCheck;
               int ld = 0;
               while(t>10 && t%10==0 && t>a_b[0])
               {
                  t=t/10;
                  ld++;
               }
               String ldSt="";
               for(int hh=0;hh<ld;hh++)
               {
                     ldSt ="0"+ldSt;
                     if(Integer.parseInt(ldSt+t)!=Integer.parseInt(t+ldSt))
                     {
                        found.add(ldSt+t);
                        found.add(t+ldSt);
                     }
               }*/
            }
         }
         bos.println("Case #"+runningTC+": "+leading);
         runningTC++;
      }
   }
}

abstract class Basic2
{
   protected BufferedReader bis;
   
   protected PrintWriter bos;
   
   protected void initialize() throws Exception
   {
      FileReader fs = null;
      FileWriter fr = null;

      fs = new FileReader(
            "C:\\CJ\\input2.txt");
      bis = new BufferedReader(fs);

      fr = new FileWriter(
            "C:\\CJ\\output2.txt");
      bos = new PrintWriter(fr);

   }
   
   public abstract void printOutput() throws Exception;
}
