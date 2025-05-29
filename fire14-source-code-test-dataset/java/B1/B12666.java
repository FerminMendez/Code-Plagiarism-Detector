package C;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("c:\\c.in"));
        PrintWriter out = new PrintWriter(new File("c:\\c.out"));
        int t = in.nextInt();
        for (int j = 1; j <= t; j++) {
            int a = in.nextInt();
            int b = in.nextInt();
            Set<String> s = new HashSet<>();
            for (int i = a; i <= b; i++) {
                String n = i + "";
                int len = n.length();
  
                for (int k = 1; k < len; k++) {
                    String n2 = n.substring(k) + n.substring(0,k);
                    int nn = Integer.parseInt(n2);
                    if (n2.charAt(0)!='0' && nn > i && nn <= b && nn >= a) {
                        s.add(n+nn);
                    }
                }
                
            }
            
            out.println("Case #"+j+": "+s.size());
        }
        
        out.flush();
        out.close();
        in.close();
    }
}
