import java.util.Scanner;
import java.io.*;
public class Tobi
{
    static String out="",output="";
    
    public static void main(String[] args) 
    {
        try
        {
             Scanner in = new Scanner(new File("recycle.in")); 
             int n = in.nextInt();                                               
             int count = 1;
             String out = "";
             while(in.hasNext())
             {              
               int a = in.nextInt();
               int b = in.nextInt();
               out += "Case #"+count+": "+ activity(a,b)+"\n";
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
                 System.out.println("ERROR");
                }             
             }
    }catch(Exception exception){
        System.out.println("ERROR");
    }
    System.out.println("DONE");       
    }
    
    public static int activity(int A, int B)
    {
        int counter = 0;
        
        //String all[] = myGenerator(Integer.toString(A));  
        for(int i = A; i <= B; i++)
        { 
            String all[] = myGenerator(Integer.toString(i));
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
            
    public static String[] myGenerator(String word)
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
