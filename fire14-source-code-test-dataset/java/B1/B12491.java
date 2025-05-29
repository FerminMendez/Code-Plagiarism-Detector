import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Csmall {
    
    private static String move(String n) {
        return n.substring(1) + n.charAt(0);
    }
    
    private static boolean recycled(int n, int m) {
        // Parte 1
        char[] cn = (n + "").toCharArray();
        char[] cm = (m + "").toCharArray();
        Arrays.sort(cn);
        Arrays.sort(cm);
        
        if (!Arrays.equals(cn, cm))
            return false;
        
        // Parte 2
        String cpy = n + "";
        
        while (!(cpy = move(cpy)).equals(n + ""))
            if (Integer.parseInt(cpy) == m)
                return true;
        
        return false;
    }
    
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(args[0]));
            
            int s = Integer.parseInt(br.readLine());
            
            for (int i = 0; i != s; ++i) {
                String x = br.readLine();
                String[] tokens = x.split(" ");
                
                int A = Integer.parseInt(tokens[0]);
                int B = Integer.parseInt(tokens[1]);
                int count = 0;
                
                System.out.print("Case #" + (i+1) + ": ");
                
                for (int n = A; n <= B; ++n)
                    for (int m = n + 1; m <= B; ++m)
                        if (recycled(n,m))
                            ++count;
                
                System.out.println(count);
            }

        } catch (IOException e) {
            System.out.println("Error :(");
        } finally {
            
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                System.out.println("Error :(");
            }
            
        }
    }
}