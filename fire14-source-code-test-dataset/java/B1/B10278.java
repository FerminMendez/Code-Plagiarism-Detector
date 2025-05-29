package gcj_qr2012_a;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Fidel
 */
public class qr_problemB {
    public static void main(String args[]) throws FileNotFoundException{
        File f = new File("input.txt");
        java.util.Scanner sc = new java.util.Scanner(f);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int y = 0;
            
            for (int j = A; j <= B; j++) {
                for (int k = B; k > j; k--) {
                    String a = String.valueOf(j);
                    for (int l = 1; l < String.valueOf(k).length(); l++) {
                        String b = String.valueOf(k);
                        String tmp = b.substring(b.length()-l) + b.substring(0, b.length()-l);
                        
                        if(tmp.matches(a)){
                          
                            y++;
                            break;
                        }                        
                    }
                    
                }
            }
            System.out.println("Case #" + (i+1) + ": " + y);
        }
    }
}
