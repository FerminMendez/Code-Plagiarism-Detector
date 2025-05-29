
import java.io.*;
import java.util.*;

public class codejam3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("B-small-attempt0.in");
        FileReader fr = new FileReader(file);
        Scanner ob = new Scanner(fr);
        File outFile = new File("outFile3.txt");
        FileWriter outFilew = new FileWriter(outFile);
        int t, r = 1;
        t = ob.nextInt();
        while (t != 0) {
            int n, s, p, count = 0;
            n = ob.nextInt();
            s = ob.nextInt();
            p = ob.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ob.nextInt();
                if (a[i] >= p) {
                    if (a[i] >= 3 * p - 2) {
                        count++;
                    } else if ((a[i] == 3 * p - 4 || a[i] == 3 * p - 3) && s != 0) {
                        s--;
                        count++;
                    }
                }
            }
            System.out.println(count);
            outFilew.append("Case #"+r+": "+count+"\n");
            t--;
            r++;
        }
        outFilew.close();
    }
}
