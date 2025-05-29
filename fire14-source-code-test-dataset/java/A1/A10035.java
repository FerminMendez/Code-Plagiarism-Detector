import java.io.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    private static int count = 1;  

    public static void main()
    {
       try{
          FileInputStream fstream = new FileInputStream("B-small-attempt2.in");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          PrintWriter out = new PrintWriter(new FileWriter("B_small-attempt2_result.txt"));
          String a = br.readLine();
          String strLine = null;
          while ((strLine = br.readLine()) != null)
          {
              //System.out.println("Case #"+(count)+": "+count(strLine));
              out.println("Case #"+(count++)+": "+count(strLine));
          }
          in.close();
          out.close();
       }catch (Exception e){e.printStackTrace();}
    }
    
    //private int n = 1;
    
    public static int count(String input)
    {
        int yes = 0;
        int maybe = 0;
        int del = 0;
        int num = Integer.parseInt(input.substring(del,input.indexOf(" ", del)));
        del = input.indexOf(" ", del)+1;
        int surprising = Integer.parseInt(input.substring(del,input.indexOf(" ", del)));
        del = input.indexOf(" ", del)+1;
        int bestMark = Integer.parseInt(input.substring(del,input.indexOf(" ", del)));
        del = input.indexOf(" ", del)+1;
        int limit1 = bestMark*3-2;
       
        //System.out.println("riadok "+(n++)+" : " + input);
        for (int i = 0; i < num; i++)
        {
            int value = 0;
            if (i <num-1)
            {
                //System.out.println(input.substring(del,input.indexOf(" ", del)));
                value = Integer.parseInt(input.substring(del,input.indexOf(" ", del)));
            }
            else
            {
                //System.out.println(input.substring(del, input.length()));
                value = Integer.parseInt(input.substring(del,input.length()));
            }
            
            if (value >= bestMark)
                if(value >= limit1)
                    yes++;
                else if (value >= limit1-2)
                    maybe++;
            
            del = input.indexOf(" ", del)+1;
        } 
        return yes + Math.min(maybe, surprising);
    }
}