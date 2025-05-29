import java.util.Scanner;
import java.io.*;
public class Recycle
{
    static String out="",output="";
    
    public static void main(String[] args) 
    {
        try
        {
             Scanner in = new Scanner(new File("recycle.in"));  // STATE THE INPUT FILE
             int n = in.nextInt();                                  //INITIALIZE NUMBER OF CASES   'N'               
             int count = 1;
             String out = "";
             while(in.hasNext())
             {
              // INITIALIZE OTHER STUFFS HERE               
               int a = in.nextInt();
               int b = in.nextInt();
               //PROCESS DATA HERE AND WRITE EACH RESULT TO THE output VARIABLE
               
               //END OF PROCESS 
             out += "Case #"+count+": "+ process(a,b)+"\n";
             count++;
             try
             {
                 File file = new File("output.dat");
                 PrintWriter output = new PrintWriter(file);
                 output.write(out);
                 output.close();
                }
                catch(Exception exception)
                {
                 System.out.println("CANNOT WRITE TO FILE");
                }             
             }
    }catch(Exception exception){
        System.out.println("CANNOT READ FROM FILE");
    }
    System.out.println("DATA HAS BEEN WRITTEN TO FILE");       
    }
    
    public static int process(int A, int B)
    {
        int counter = 0;
        
        //String all[] = getGenerated(Integer.toString(A));   //THE TRUE VALUES ARE NOT GETTING INSIDE ALL[]
        for(int i = A; i <= B; i++)
        { 
            String all[] = getGenerated(Integer.toString(i));
            for(int j = 0; j < all.length; j++)
            {
              if((i < Integer.parseInt(all[j])) && (Integer.parseInt(all[j]) <= B))
              {
                counter++;
              }
            }
        }
        return counter;
    }
            
    public static String[] getGenerated(String word)
    {
        String[] all = new String[word.length()-1];//changed frm len - 1
        for(int i = 0; i < all.length; i++)
        {
            all[i] = generate(word);
            word = generate(word);
        }
        return all;
    }
    public static String generate(String w)
    {
        String ans = w.substring(w.length()-1);
        for(int i = 0; i < w.length()-1; i++)  
        {
          ans += w.substring(i,i+1);
        }
        return ans;
    }
}
