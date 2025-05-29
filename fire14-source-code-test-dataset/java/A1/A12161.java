
package codejam2012;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C:\\inputCodejame.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] l1 = reader.readLine().split(" ");
            int p = Integer.parseInt(l1[2]);
            int s = Integer.parseInt(l1[1]);
            int n = Integer.parseInt(l1[0]);
            int[] scores = new int[l1.length - 3];
            int u = 0;
            for (int j = 3; j < l1.length; j++) {
                scores[u++] = Integer.parseInt(l1[j]);
            }
            int outer = 0;
            for (int j = 0; j < n; j++) {
                int rate = scores[j];
                if (rate == 0 || rate == 30) {
                    if (rate / 3 >= p) {
                        outer++;
                    }
                } else if (rate % 3 == 0) {
                    if (rate / 3 >= p) {
                        outer++;
                    } else if ((rate / 3) + 1 >= p) {
                        if (s > 0) {
                            s--;
                            outer++;
                        }
                    }
                } else if (rate % 3 == 1) {
                    if ((rate / 3) + 1 >= p) {
                        outer++;
                    }
                }
                else if (rate % 3 == 2) {
                    if ((rate / 3)+1 >= p) {
                        outer++;
                    } else if ((rate / 3) + 2 >= p) {
                        if (s > 0) {
                            s--;
                            outer++;
                        }
                    }
                }               
            }
            System.out.println("Case #" + (i + 1) + ": " + outer);
        }
    }
}