/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj2012;

/**
 *
 * @author allegea
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Allegea
 */
public class DancingWiththeGooglers {
 
    public static void main(String[] args) throws IOException,FileNotFoundException{
        
        
        
        String name = "B-small-attempt0";
        
        BufferedReader in   = new BufferedReader(new FileReader(name+".in"));
        
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        FileWriter archivo = new FileWriter(name+".out");
        PrintWriter out = new PrintWriter(archivo);
        out.flush();

       
         
           String line;
           StringBuilder buil = new StringBuilder();
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                
                StringTokenizer x = new StringTokenizer(in.readLine());
                int n= Integer.parseInt(x.nextToken());
                int p = Integer.parseInt(x.nextToken());
                int max = Integer.parseInt(x.nextToken());
                int[] s = new int[n];
                for(int i=0;i<n;i++)
                    s[i] = Integer.parseInt(x.nextToken());
                

                int count=0;
                int sup = 0;
                for(int i=0;i<n;i++){
                    int avg = s[i]/3;
                    int res = s[i]-avg*3;
                    //System.out.println(avg+" - "+res+" - "+s[i]);
                    
                    if(avg==0){
                        if(s[i]>=max)count++;
                        continue;
                    }
                    if(avg>=max)
                    {
                        count++;
                        continue;
                    }
                    
                    if(res==0)
                    {
                        if(avg+1==max)sup++;
                    }else if (res ==1){
                        if(avg+1==max)count++;
                    }else{
                        if(avg+1==max)count++;
                        else if(avg+2==max)sup++;
                    }

                }
                //System.out.println(sup+" - "+count);
                count+=Math.min(p, sup);
                
                
                
                System.out.println("Case #"+act+": "+count);
               out.println("Case #"+act+": "+count);
              // System.out.println(line); 
                
            }


        in.close();
        out.close();
        System.exit(0);

        

        
        
    }
   


}

