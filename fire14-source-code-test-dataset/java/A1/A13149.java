/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dance;
import java.io.*;
import java.util.*;
/**
 *
 * @author karam.yaaqna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String line ;
        StringTokenizer st ;
        try{
            int num = 0;
            int s = 0;
            int p = 0;
            int minLimit = 0;
            int maxLimit = 0;
            int score = 0;
            int out =0 ;
            BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt1.in"));
            PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));
            int testCase = Integer.parseInt(reader.readLine());
            line = reader.readLine();
            st = new StringTokenizer(line);
            for(int tc = 1;tc<=testCase;tc++){
                st = new StringTokenizer(line);
                num = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                minLimit = p * 3 - 4;
                maxLimit = p*3 - 2;
               // System.out.println("im here"+num);
                while(st.hasMoreTokens()){
                   score = Integer.parseInt(st.nextToken());
                    if(score>=maxLimit){
                         out++;
                       }else
                       {if (score>=minLimit )
                           if(p>1 && s>0){
                           out++;
                           s--;
                           }
                       }
                   
                }
             //   System.out.println(out);
               writer.println("Case #"+tc+": "+out);
                line = reader.readLine();
                out = 0;
                
            }
            writer.close();
        }catch(Exception e){
        }
        
    }

}
