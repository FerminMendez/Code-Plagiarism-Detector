
import java.io.*;
import java.util.Scanner;

public class Dancers {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("D:/testing/B-small-attempt0.in"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("D:/testing/b.txt", false));

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N, S, p;
            int hscr = 0, mscr = 0;
            N = sc.nextInt();
            S = sc.nextInt();
            p = sc.nextInt();

            for (int j = 0; j < N; j++) {
                int scr = sc.nextInt();
                if (scr > 3 * (p - 1)) {
                    hscr++;
                } else if (p>1 &&  scr > 3 * (p - 2) + 1) {
                    mscr++;
                }
            }
            int max=hscr+ Math.min(S, mscr);
             System.out.println("Case #" + i+": "+max);
             bf.write("Case #" + i+": "+max+ "\n");
        }
        bf.close();
    }
}
