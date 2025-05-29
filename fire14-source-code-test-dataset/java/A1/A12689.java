/**
 * Created by IntelliJ IDEA.
 * User: kingsto
 * Date: 4/14/12
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
// to be run with -Xmx1024m

import java.util.*;
import java.io.*;

public class DancingWithGooglers {

    class Testcase {
        int ans;
        int[][][] hello = new int[30][][];

        public Testcase() {
        }

        public Testcase(int seed) {
            Random rnd = new Random(seed);
        }

        int N, S, P;
        int[][] ns, s;
        int[] scores;
        boolean[] selected;
        public void loadInput(Scanner sc, int[][] _ns, int[][] _s) {
            N = sc.nextInt();
            S = sc.nextInt();
            P = sc.nextInt();
            scores = new int[N];
            selected = new boolean[N];
            ns = _ns;
            s = _s;
            
            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
            }
        }

        public void solveSlow() {
            int res = 0;
            if (S == 0) {
                for (int i = 0; i < N; i++) {
                    int[] sc = supporting[scores[i]];
                    if (sc[0] >= P || sc[1] >= P || sc[2] >= P)  res++;
                }
                ans = res;
            }
            if (S == 1) {
                for (int i = 0; i < N; i++) {
                    res = 0;
                    int[] nsc = nsupporting[scores[i]];
                    if (nsc[0] < 0) nsc = supporting[scores[i]];
                    if (nsc[0] >= P || nsc[1] >= P || nsc[2] >= P)  res++;
                    for (int j = 0; j < N ; j++ ) {
                        if (j != i) {
                            int[] sc = supporting[scores[j]];
                            if (sc[0] >= P || sc[1] >= P || sc[2] >= P)  res++;
                        }
                    }
                    ans = Math.max(res, ans);
                }
            }
            if (S == 2) {
                for (int i = 0; i < N; i++) {
                    res = 0;
                    int[] nsc = nsupporting[scores[i]];
                    if (nsc[0] < 0) nsc = supporting[scores[i]];
                    if (nsc[0] >= P || nsc[1] >= P || nsc[2] >= P)  res++;
                    for (int j = 0; j < N ; j++ ) {
                        if (j != i) {
                            int[] nsc2 = nsupporting[scores[j]];
                            if (nsc2[0] < 0) nsc2 = supporting[scores[j]];
                            if (nsc2[0] >= P || nsc2[1] >= P || nsc2[2] >= P)  res++;
                        }
                        for (int k = 0; k < N; k++) {
                            if (k != i && k != j) {
                                int[] sc = supporting[scores[k]];
                                if (sc[0] >= P || sc[1] >= P || sc[2] >= P)  res++;
                            }
                        }
                        ans = Math.max(res, ans);
                        res = 0;
                    }

                }
            }
            if (S == 3) {
                for (int i = 0; i < N; i++) {
                    int[] nsc = nsupporting[scores[i]];
                    if (nsc[0] < 0) nsc = supporting[scores[i]];
                    if (nsc[0] >= P || nsc[1] >= P || nsc[2] >= P)  res++;
                    for (int j = 0; j < N ; j++ ) {
                        if (j != i) {
                            int[] nsc2 = nsupporting[scores[j]];
                            if (nsc2[0] < 0) nsc2 = supporting[scores[j]];
                            if (nsc2[0] >= P || nsc2[1] >= P || nsc2[2] >= P)  res++;
                        }
                        for (int k = 0; k < N; k++) {
                            if (k != i && k != j) {
                                int[] nsc3 = nsupporting[scores[k]];
                                if (nsc3[0] < 0) nsc3 = supporting[scores[k]];
                                if (nsc3[0] >= P || nsc3[1] >= P || nsc3[2] >= P)  res++;
                            }
                            for (int l = 0; l < N; l++) {
                                if (l != i && l != j && l != k) {
                                    int[] sc = supporting[scores[l]];
                                    if (sc[0] >= P || sc[1] >= P || sc[2] >= P)  res++;
                                }
                            }
                            ans = Math.max(res, ans);
                            res = 0;
                        }

                    }

                }
            }
        }

        public void calculate (int supp, int a) {
            
            if (supp > S) return;
            if (supp == S) {
                ans = Math.max(ans, a);
                return;
            }
            for (int i = 0; i < N; i++) {
                selected[i] = true;
                int[] sc = supporting[scores[i]];
                boolean gr8 = false;
                if (sc[0] >= P || sc[1] >= P || sc[2] >= P) {
                    gr8 = true;
                }
                int[] nsc = nsupporting[scores[i]];
                if (nsc[0] < 0) nsc = sc;
                boolean nwgr8 = false;
                if (nsc[0] >= P || nsc[1] >= P || nsc[2] >= P)
                    nwgr8 = true;
                if (gr8) calculate(supp + 1, a);
                if (!gr8 && nwgr8) calculate(supp + 1, a + 1);
                selected[i] = false;
            }    
        }
        public void solveFast() {
            for (int i = 0; i < N; i++) {
                int[] sc = supporting[scores[i]];
                if (sc[0] >= P || sc[1] >= P || sc[2] >= P)  ans++;
            }
            calculate(0, ans);
        }

        public void printSelf(PrintWriter pw) {
            /*for (int sc : scores) {
                for (int j: s[sc])
                    pw.print(j + " ");
                pw.println();
                for (int j: ns[sc])
                    pw.print(j + " ");

            }             */
            pw.println(ans);
        }

        public boolean sameAnswers(Testcase other) {
            return false;
        }
    }

    final String AFTER_CASE = " ";
    
    int[][] supporting = new int[31][3];
    int[][] nsupporting = new int[31][3];

    int MAX_SCORE = 10;
    int NUM_JUDGES = 3;
    private void precalc() {
        for (int[] a: supporting)
            Arrays.fill(a, -1);
        for (int[] a: nsupporting)
            Arrays.fill(a, -1);
        for (int l = 0; l <= NUM_JUDGES * MAX_SCORE; l++) {
            for(int i = 0; i <= MAX_SCORE; i++) {
                for(int j = i; j < i + 3 && j <= MAX_SCORE; j++) {
                    for (int k = j;k < j + 3 && k < i + 3 && k <= MAX_SCORE; k++) {
                        if (i + j + k == l) {
                            if (Math.abs(i - j) <= 1 && Math.abs(i - k) <= 1 && Math.abs(j - k) <= 1) {
                                if (supporting[l][0] < 0) {
                                    supporting[l][0] = i;
                                    supporting[l][1] = j;
                                    supporting[l][2] = k;
                                }  else {
                                    int mE = Math.max(Math.max(supporting[l][0], supporting[l][1]),supporting[l][2]);
                                    int mC = Math.max(Math.max(i,j), k);
                                    if (mC > mE) {
                                        supporting[l][0] = i;
                                        supporting[l][1] = j;
                                        supporting[l][2] = k;
                                    }
                                    
                                }
                            } else {
                                if (nsupporting[l][0] < 0) {
                                    nsupporting[l][0] = i;
                                    nsupporting[l][1] = j;
                                    nsupporting[l][2] = k;
                                }  else {
                                    int mE = Math.max(Math.max(nsupporting[l][0], nsupporting[l][1]),nsupporting[l][2]);
                                    int mC = Math.max(Math.max(i,j), k);
                                    if (mC > mE) {
                                        nsupporting[l][0] = i;
                                        nsupporting[l][1] = j;
                                        nsupporting[l][2] = k;
                                    }

                                }
                            }
                        }    
                    }    
                }    
            }    
        }
    }
            
    public void go() throws Exception {

        precalc();
        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int caseCnt = sc.nextInt();
        
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("solving case " + caseNum);

            Testcase tc = new Testcase();

            tc.loadInput(sc, nsupporting, supporting);
            tc.solveSlow();

            pw.print("Case #" + (caseNum + 1) + ":");
            pw.print(AFTER_CASE);

            tc.printSelf(pw);
        }

        pw.flush();
        pw.close();
        sc.close();
    }

    public void stresstest() {
        int it = 0;
        Random rnd = new Random();
        while (true) {
            it++;
            if (it % 1000 == 0)
                System.out.println(it + " iterations");

            int seed = rnd.nextInt();

            Testcase tc1 = new Testcase(seed);
            tc1.solveFast();

            Testcase tc2 = new Testcase(seed);
            tc2.solveSlow();

            if (!tc1.sameAnswers(tc2)) {
                System.out.println("ERROR: it failed");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new DancingWithGooglers().go();
    }
}

