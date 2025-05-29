package googlecodejam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GoogleCodeJam {
    
    public static int calcGooglers(int p, int s, int[] g) {
        int avg = p*3;
        int n = g.length;
        int cont = 0;
        for (int i = 0; i< n; i++) {
            if (g[i] >= avg ) {
                cont++;
            } else if (avg == 0){
                cont++;
            } else if (g[i] >= avg-2 && avg-2 >= p) {
                cont++;
            } else if (g[i] >= avg-4 && avg-4 >= p) {
                if (s > 0) {
                    cont++;
                    s--;
                }
            }
        }
        return cont;
    }
    
    public static void doIt() throws Exception {
        Scanner sc = new Scanner(new FileReader("/home/fuelusumar/input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("/home/fuelusumar/output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            /***********************************************/
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int[] g = new int[n];
            for (int googler = 0; googler < n; googler++) {
                g[googler] = sc.nextInt();
            }
            /***********************************************/
            pw.println(calcGooglers(p,s,g));
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        doIt();
    }
}
