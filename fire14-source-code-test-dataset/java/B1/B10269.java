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
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Allegea
 */
public class RecycledNumbers {
 
    public static void main(String[] args) throws IOException,FileNotFoundException{
        
       String name = "C-small-attempt0";
        
        BufferedReader in   = new BufferedReader(new FileReader(name+".in"));
        
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        FileWriter archivo = new FileWriter(name+".out");
        PrintWriter out = new PrintWriter(archivo);
        out.flush();

         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                StringTokenizer x = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(x.nextToken());
                int b = Integer.parseInt(x.nextToken());
                HashSet<String> set = new HashSet<String>();
                
                for(int i=a;i<=b;i++){
                    String w = String.valueOf(i);
                    for(int j=1;j<w.length();j++){
                         String ans = w.substring(j,w.length())+w.substring(0, j);
                         if(!ans.equals(w)){
                             int q = Integer.parseInt(ans);
                             if(q<=b && q>=a)
                             {
                                 String other = Math.min(i, q)+"-"+Math.max(i, q);
                                 set.add(other);
                             }
                         }
                    }
                    
                }
                
               // System.out.println(set.size()+" - "+set);
                
                
                System.out.println("Case #"+act+": "+set.size());
               out.println("Case #"+act+": "+set.size());
              // System.out.println(line); 
                
            }


        in.close();
        out.close();
        System.exit(0);

        

        
        
    }
   


}

