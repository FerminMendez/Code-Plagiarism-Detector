/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancing;
import java.io.*; 
import java.util.*; 

/**
 *
 * @author Ewka
 */
public class Dancing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader fr=null;
        PrintWriter fw=null;
        BufferedReader br;
        int noOfLines=0;  
        int noOfGooglers=0;
        int noOfSurprising=0;
        int noOfOut=0;
        int p=0;
        int noOfUsedSurp=0;
        
        String[] temp;
        
        try
        {
            fw = new PrintWriter ("outputDancing.txt");
        }
        catch(Exception e)
        {
            System.out.print("nie udalo sie");
        }
        
        try
        {
            fr = new FileReader("B-small-attempt1.txt");            
        }
        catch(FileNotFoundException e)
        {
               System.out.println(e.getMessage());
        }
        br = new BufferedReader(fr);
        String s;
        try{
                s=br.readLine();            
                noOfLines = Integer.parseInt(s);           
                for (int i=0;i<noOfLines;i++)
                {        
                     System.out.print("Case #"+(i+1)+": ");
                     fw.print("Case #"+(i+1)+": ");
                     noOfOut = 0;
                     noOfUsedSurp=0;
                     s=br.readLine();
                     temp = s.split(" ");
                     noOfGooglers = Integer.parseInt(temp[0]);
                     int[] Scores = new int[noOfGooglers];
                     noOfSurprising = Integer.parseInt(temp[1]);
                     p = Integer.parseInt(temp[2]);
                     for (int j=0;j<noOfGooglers;j++)
                     {
                         Scores[j] = Integer.parseInt(temp[j+3]);
                     }
                     
                     Arrays.sort(Scores);
                     for (int j=0;j<noOfGooglers;j++)
                     {
                        if (Scores[j]/3 >= p)
                        {
                                noOfOut++;
                        }
                        else if (Scores[j] > p)
                        {
                              if ((p+(p-1)+(p-1) == Scores[j]) ||  (p+(p)+(p-1) == Scores[j]))
                              {
                                  noOfOut++;
                              }
                              else if (noOfUsedSurp < noOfSurprising)
                              {
                                  if ((p+(p-2)+(p-2) == Scores[j]) ||  (p+(p-2)+(p-1) == Scores[j]))
                                  {
                                        noOfOut++;
                                        noOfUsedSurp++;
                                  }
                              }
                        }
                     }
                     System.out.println(noOfOut);
                     fw.print(noOfOut);
                     fw.println();
                     
                }
                fr.close();
                fw.close();
        }
        catch(Exception e)
        {
            
        }
            
    }
}
