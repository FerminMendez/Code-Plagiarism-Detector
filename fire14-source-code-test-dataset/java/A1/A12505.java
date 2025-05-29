
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xeyyam
 */
public class DancingWiththeGooglers {

    boolean[][] ansNoS = new boolean[31][11];
    boolean[][] ansS = new boolean[31][11];

    public static void main(String args[]) throws Exception {
        new DancingWiththeGooglers().solve();
    }

    public void solve() throws Exception {
        generate();

        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter("B-small-attempt0.out");
        int t, n, s, p;

        t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            s = sc.nextInt();
            p = sc.nextInt();
            int ans = 0;
            int temp = 0;
            
            for(int j = 1 ; j<=n ; j++ ){
                temp = sc.nextInt();
                if( check(temp , p , false) ) ans++;
                else if( s>0 && check(temp , p , true ) ){ ans++ ; s--;}
                
            }
            
            pw.println("Case #"+i+": "+ans);
        }

        pw.flush();
        pw.close();

    }
    
    public boolean check(int sum , int p , boolean surprise){
        
        if( !surprise )
        for(int i = p ; i<=10 ; i++){
            if( ansNoS[sum][i]  )
                return true;
        }
        else{
            
        for(int i = p ; i<=10 ; i++){
            if( ansS[sum][i]  )
                return true;
        }
        }
        
        return false;
    }

    public void generate() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (Math.abs(j - i) <= 1 && Math.abs(k - j) <= 1 && Math.abs(i - k) <= 1) {
                        ansNoS[i + j + k][i] = true;
                        ansNoS[i + j + k][j] = true;
                        ansNoS[i + j + k][k] = true;
                    } else if (Math.abs(j - i) <= 2 && Math.abs(k - j) <= 2 && Math.abs(i - k) <= 2) {
                        ansS[i + j + k][i] = true;
                        ansS[i + j + k][j] = true;
                        ansS[i + j + k][k] = true;
                    }
                }
            }
        }
    }
}
