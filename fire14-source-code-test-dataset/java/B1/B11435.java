package gcj_qr_c;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author amahdy
 */
public class GCJ_QR_C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new GCJ_QR_C().start();
    }
    
    private void start() throws FileNotFoundException, IOException {

        Scanner in = new Scanner(
                new FileReader("/home/amahdy/c-small.in"));
        int x = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < x; ) {
            
            int A = in.nextInt();
            int B = in.nextInt();
            int val = 0;
            for(int j=A; j<B; j++) {
                
                char[] zz = (j + "").toCharArray();
                int m = zz.length-1;
                for(int k=0; k<m; k++) {
                    char t = zz[m];
                    for(int n=m; n>0;) {
                        zz[n]=zz[--n];
                    }
                    zz[0] = t;
                    if(t=='0') {
                        continue;
                    }else {
                        int f = Integer.parseInt(String.valueOf(zz));
                        if(f > j && f <= B) {
                            val++;
                        }
                    }
                }
            }
            System.out.println("Case #" + ++i + ": " + val);
        }
    }
}
