/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.io.*;
import java.util.*;
public class DanceWithGooglers {
    public static void main (String[] args)
    {
        BufferedReader br = null;
        PrintStream ps = null;
       
        try
        {
            int t;
            int n;
            int s;
            int p;
           
            int count;
            int countsurprisingoblig;
            int countimp;
           
            ArrayList<Integer> scores;

            String line;
            StringTokenizer st;
                       
            br = new BufferedReader (new FileReader("B.in"));
            ps = new PrintStream (new FileOutputStream ("B-samll1.out"));
                       
            line = br.readLine ();
            t = Integer.parseInt (line);
           
            for (int testCase = 0; testCase < t; testCase++)
            {
                count = 0;
                countsurprisingoblig = 0;
                countimp = 0;
               
                line = br.readLine ();
                st = new StringTokenizer (line);
               
                n = Integer.parseInt (st.nextToken ());
                s = Integer.parseInt (st.nextToken ());
                p = Integer.parseInt (st.nextToken ());

                scores = new ArrayList ();
               
                for (int scoreInputIndex = 0; scoreInputIndex < n; scoreInputIndex++)
                {
                    scores.add (Integer.parseInt (st.nextToken ()));
                }
               
                for (int score : scores)
                {
                    int diff = (int) Math.abs (score - (3*p));
                   
                    if ((score < (3 * p)) && ((diff == 3 || diff == 4)) && (score != 0) && (p > 0))
                    {
                        countsurprisingoblig++;
                    }
                    else if (((score < (3 * p)) && (diff > 4)) || ((score == 0) && (p > 0)))
                    {
                        countimp++;
                    }
                }
               
                count = scores.size () - countimp - countsurprisingoblig;
               
                if (countsurprisingoblig > s)
                {
                    count += s;
                }
                else
                {
                    count += countsurprisingoblig;
                }
               
//                System.out.println (count);
//                System.out.println (n + " " + s + " " + p + " " + scores.toString ());
//                System.out.println ("Case #" + (testCase + 1) + ": " + s);               
                System.out.println("Case #" + (testCase + 1) + ": " + count);
                ps.println ("Case #" + (testCase + 1) + ": " + count);
            }
                       

//            ps.println ("test1 test1 test1");
           
//            System.out.println ("Hola Mundo!!!");           
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace ();
        }
        catch (NumberFormatException nfe)
        {
            nfe.printStackTrace ();
        }
        finally
        {
            if (ps != null)
            {
                ps.close ();
            }
            if (br != null)
            {
                try
                {
                    br.close ();                   
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace ();
                }
            }
        }
    }    
}
