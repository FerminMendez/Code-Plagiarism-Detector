package gcj_qr_b;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author amahdy
 */
public class GCJ_QR_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new GCJ_QR_B().start();
    }
    
    private void start() throws FileNotFoundException, IOException {

        Scanner in = new Scanner(
                new FileReader("/home/amahdy/b-small.in"));
        int x = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < x; ) {
            
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int[] t = new int[N];
            for(int j=0; j<N; j++) {
                t[j] = in.nextInt();
            }
            int max=0;
            for(int j=0; j<N; j++) {
                if(t[j]==0) {
                    if(p==0) {
                        max++;
                    }
                    continue;
                }
                int min = t[j]/3;
                int diff = t[j] - (3*min);
                
                switch (diff) {
                    case 0:
                        if(min>=p) {
                            max++;
                        }else if(min+1==p && S>0) {
                            S--;
                            max++;
                        }
                        break;
                    case 1:
                        if(min<10 && min+1>=p) {
                            max++;
                        }
                        break;
                    case 2:
                        if(min<10 && min+1>=p) {
                            max++;
                        }else if(min<9 && min+2==p && S>0) {
                            S--;
                            max++;
                        }
                        break;
                }
            }
            System.out.println("Case #" + ++i + ": " + max);
        }
    }
}
