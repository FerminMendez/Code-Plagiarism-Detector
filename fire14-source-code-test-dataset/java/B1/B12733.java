/**
 * Created by IntelliJ IDEA.
 * User: kingsto
 * Date: 4/15/12
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
// to be run with -Xmx1024m

import java.util.*;
import java.io.*;

public class RecycledNumbers {

    class Testcase {
        int ans;

        public Testcase() {
        }

        public Testcase(int seed) {
            Random rnd = new Random(seed);
        }

        int A, B;

        public void loadInput(Scanner sc) {
            A = sc.nextInt();
            B = sc.nextInt();
        }

        public void solveSlow() {
        }

        private int numRecycled(int num, int a , int b) {
            LinkedList<Integer> number = new LinkedList<Integer>();
            int temp = num;
            while(temp != 0) {
                int c = temp % 10;
                temp /= 10;
                number.addFirst(c);
            }
            int res = 0;
            while (temp != num) {
                temp = 0;
                int last = number.pollLast();
                number.addFirst(last);
                for (Integer e: number) temp = 10*temp + e.intValue();
                if (temp > num && temp >= a && temp <= b) res++;
            }
            return res;
        }
        public void solveFast() {
            for (int i = A; i <= B; i++) { 
                ans += numRecycled(i, A, B);
            }
        }

        public void printSelf(PrintWriter pw) {
            pw.println(ans);
        }

        public boolean sameAnswers(Testcase other) {
            return false;
        }
    }

    final String AFTER_CASE = " ";

    public void go() throws Exception {

        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int caseCnt = sc.nextInt();

        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("solving case " + caseNum);

            Testcase tc = new Testcase();

            tc.loadInput(sc);
            tc.solveFast();

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
        new RecycledNumbers().go();
    }
}

