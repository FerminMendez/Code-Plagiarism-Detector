import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Bsmall {
    
    private static int[] triplet(int total, boolean special) {
        int[] scores =  {0, 0, 0};
        
        for (int i = 10; i != -1; --i) {
             
            for (int j = i; j != -1; --j) {
                
                // Si no hay mas especiales
                if ((special) ? i - j > 2 : i - j > 1)
                    break;
                
                for (int k = j; k != -1; --k) {
                    
                    // Si no hay mas especiales
                    if ((special) ? j - k > 2 || i - k > 2: j - k > 1 || i - k  > 1)
                        break;
                    
                    if (i + j + k == total) {
                        scores[0] = i;
                        scores[1] = j;
                        scores[2] = k;
                        
                        return scores;
                    }
                }
            }
        }
        
        return scores;
    }
    
    public static void main(String[] args) {
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(args[0]));
            
            int t = Integer.parseInt(br.readLine());
            
            for (int i = 0; i != t; ++i) {
                System.out.print("Case #" + (i+1) + ": ");
                
                String[] tokens = br.readLine().split(" ");
                
                int n = Integer.parseInt(tokens[0]);    // Num jugadores
                int s = Integer.parseInt(tokens[1]);    // Num especiales
                int p = Integer.parseInt(tokens[2]);    // Score a buscar
                int count = 0;
                
                for (int g = 0; g != n; ++g) {
                    int total = Integer.parseInt(tokens[g + 3]);
                    
                    if (triplet(total, false)[0] >= p) {
                        ++count;
                    } else if (s > 0 && triplet(total, true)[0] >= p) {
                        ++count;
                        --s;
                    }
                    
                }
                
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