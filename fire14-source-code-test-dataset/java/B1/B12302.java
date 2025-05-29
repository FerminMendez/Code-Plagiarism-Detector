package codejam;

import java.io.*;
import java.util.*;

//out.println("Case #"+(tt++)+": "+line.trim());
public class Plantilla2 {
    
    public static class pair implements Comparable<pair> {
        
        int a;
        int b;
        
        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(pair o) {
            if (this.a == o.a && this.b == o.b) {
                return 0;
            }
            
            return this.toString().compareTo(o.toString());
        }
        
        public String toString() {
            return this.a + " " + this.b;
        }
    }
    
    public static String girar(String str) {
        return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("in.in")));
        PrintWriter out = new PrintWriter(new File("out.out"));
        
        

//        System.out.println(girar("5600070"));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            
            String ss[] = br.readLine().split("[ ]+");
            int A = Integer.parseInt(ss[0]);
            int B = Integer.parseInt(ss[1]);
            TreeSet<pair> ts = new TreeSet<pair>();
            String yy;
            for (int j = A; j < B; j++) {
                String xx = "" + j;                
                for (int k = 0; k < String.valueOf(j).length(); k++) {
                    yy = girar(xx);
                    if (A <= j && j < Integer.parseInt(yy) && Integer.parseInt(yy) <= B) {
                        ts.add(new pair(j, Integer.parseInt(yy)));
                    }
                    xx = yy;
                }
                
            }
            
            
            
            out.println("Case #" + i + ": " + ts.size());
            
            
            
        }
        
        out.close();
        br.close();
        System.exit(0);
    }
}
