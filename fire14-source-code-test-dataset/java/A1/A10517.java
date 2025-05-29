

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Dancers {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File("Bsmall.in"));
        int t = scanner.nextInt();
        for (int i = 1; i < t+1; i++) {
            System.out.print("Case #" + i + ": ");
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int ace = 3*p;
            int cont = 0;
            for (int j = 0; j < n; j++) {
                int score = scanner.nextInt();
                if ((((score >= ace-4) && (ace-4>0)) && (score < ace-2))  && (s>0)) {
                    cont++;
                    s--;
                }
                if (((score >= ace-2) /*&& (score <= (3*p)+2)) || ((score > (3*p)+2)*/) )
                {
                    cont++;
                }
            }
            System.out.println(cont);
        }
    }
}
