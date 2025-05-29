/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author Tareq:
 * I want to dance with a googler too! ;(
 */
public class Dance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line;
        StringTokenizer st;
        int T;
        int N,S,p;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt0.in"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("Dance.out"));
            T = Integer.parseInt(reader.readLine());
            for(int k=1;k<=T;k++)
            {
                int numOfBest =0;
                int minScore;
                line = reader.readLine();
                st = new StringTokenizer(line);
                N = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                minScore = p*3;
                for(int i=0;i<N;i++)
                {
                    int tscore = Integer.parseInt(st.nextToken());

                        if(tscore>=minScore-2)
                            numOfBest++;
                        else if(tscore>=minScore-4)
                            if(S>0 && p>1)
                            {   numOfBest++;
                                S--;
                            }
                }
                pw.println("Case #"+k+": "+numOfBest);
            }
            
            pw.close();
        }catch(Exception e){System.out.println("hmm"+e);}            
    }
}
