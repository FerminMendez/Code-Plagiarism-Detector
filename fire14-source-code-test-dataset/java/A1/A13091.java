
package codejam2012.B;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rymbu VV
 */
public class DancingWithGooglers {

    private Scanner sc;
    private PrintWriter pw;
    private int CASES;
    
    public static void main(String[] args) {
        DancingWithGooglers suk = new DancingWithGooglers("c:\\b.in", "c:\\b.out");
        suk.execute();
    }
    
    public DancingWithGooglers(String fileIn, String fileOut) {
        try{
            sc = new Scanner(new File(fileIn));
            pw = new PrintWriter(new FileWriter(fileOut));
            CASES = sc.nextInt();
        }catch(Exception e){System.out.println("In Constructor "+e);}
    }
    
    public void execute(){
        int N, S, p, count;
        for(int ncase = 1; ncase <= CASES; ncase++){
            pw.print("Case #"+ncase+": ");
            
            N = sc.nextInt();
            S = sc.nextInt();
            p = sc.nextInt();
            count = 0;
            for (int i=0; i<N; i++){
                int t = sc.nextInt();
                if (t>=p && (t/3) >= p ){
                    count++;
                    continue;
                }
                int tmp = t-p;
                if (t>=p && (p-(tmp/2)) <= 1){
                    count++;
                    continue;
                }
                if (S>0 && t>=p && (p-(tmp/2)) <= 2){
                    count++;
                    S--;
                }
            }
            
            pw.println(count);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
