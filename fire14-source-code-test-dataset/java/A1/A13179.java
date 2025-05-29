/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancing.with.the.googlers;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Abhishek
 */
public class DancingWithTheGooglers {

    /**
     * @param args the command line arguments
     */
    
    static int NoOfGooglers;
    static int surprisingResults;
    static int pi;
    static int count;
    private static String  inputFile = "F:/B-small-attempt0.in";

    private static String outputFile = "F:/Output.txt";
    
    public static void main(String[] args) {
        // TODO code application logic here
         count = 0;
         readFile();
    }
    
     public static void readFile()
    {
        int totalLines =0;
        try 
        {
            FileInputStream fis = new FileInputStream(inputFile);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            ArrayList<Integer> scores = new ArrayList<Integer>();
            String str;
            StringTokenizer st;
            
            while( (str = br.readLine()) != null) 
            {
                NoOfGooglers = -1;
                surprisingResults = -1;
                pi = -1;
                scores.clear();
                st = new StringTokenizer(str, " \n");
                scores.clear();
                while( st.hasMoreTokens())
                {
                    if( totalLines == 0 )
                    {
                        totalLines = Integer.parseInt(str);
                        break;
                    }
                    if( NoOfGooglers == -1)
                    {
                        NoOfGooglers = Integer.parseInt(st.nextToken());
                        continue;
                    }
                    if(surprisingResults == -1)
                    {
                        surprisingResults = Integer.parseInt(st.nextToken());
                        continue;
                    }
                    if(pi == -1)
                    {
                        pi = Integer.parseInt(st.nextToken());
                        continue;
                    }
                    scores.add(Integer.parseInt(st.nextToken()));
                }
                if ( pi != -1)
                {
                    int passPi = findProbabilityPi(NoOfGooglers, surprisingResults, pi, scores);
                    writeFile(passPi);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("error is " +e.getMessage());
        }
    }
     
     public static void writeFile(int passPi)
    {
        String line="";
        try{
            // Create file 
            FileWriter fstream = new FileWriter(outputFile,true);
            count++;
          
                    BufferedWriter out = new BufferedWriter(fstream);
                line = "Case #"+count+": "+passPi;
                out.write(line);
                out.newLine();
                out.close();
        }
        catch(Exception e)
        {
            System.out.println("error is " +e.getMessage());
        }
    }
     
     public static int findProbabilityPi(int NoOfGooglers, int surprisingResults,int pi,ArrayList<Integer>scores)
     {
         int passPi = 0;
         NoOfGooglers = 3;
         for(int sc : scores)
         {
             if( sc % NoOfGooglers == 0)
             {
                  if( (sc/3) == 0 && pi != 0)
                      continue;
                 if( sc/NoOfGooglers >= pi)
                 {    passPi++;
                      continue;
                 }
                 if( surprisingResults>0 )
                 {
                       
                        if( (sc/NoOfGooglers)+1 >= pi)
                        {    passPi++;
                             surprisingResults--;
                             continue;
                        }
                     
                 }
                 
             }
             else if( (sc+1) % NoOfGooglers == 0)
             {
                  if( (sc+1)/NoOfGooglers >= pi)
                  {
                      passPi++;
                      continue;
                  }
             }
             else if( (sc-1) % NoOfGooglers == 0)
             {
                  if( (((sc-1)/NoOfGooglers)+1) >= pi)
                  {
                      passPi++;
                      continue;
                  }
             }
             
             if(surprisingResults > 0)
             {
                    if( (sc+2) % NoOfGooglers == 0)
                    {
                        if( (sc+2)/NoOfGooglers >= pi)
                        {
                            passPi++;
                            surprisingResults--;
                            continue;
                        }
                    }
                    else if( (sc-2) % NoOfGooglers == 0)
                    {
                        if( (((sc-2)/NoOfGooglers)+2) >= pi)
                        {
                            passPi++;
                            surprisingResults--;
                            continue;
                        }
                    }
             }
         }
         return passPi;
     }
     
}
