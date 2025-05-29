
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) throws IOException {
        Numbers numbers = new Numbers();
        numbers.findNumbers();
    }

    public void findNumbers() throws IOException {
        Scanner sc = new Scanner(new File("D:/testing/a.txt"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("D:/testing/b.txt", false));
        HashSet<String> hs = new HashSet<String>();

        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            hs.clear();
            
            int digits = (int) Math.log10(a);

            for (int n = a; n <= b; n++) {
                for (int j = 1; j <= digits; j++) {
                    int m = swapDigits(n, j);
                    if (n < m && m <= b) {
                        hs.add(String.valueOf(m) + String.valueOf(n));
                    }
                }
            }
            int val=hs.size();
            System.out.println("Case #" + i+": "+val);
            bf.write("Case #" + i+": "+val+ "\n");
        }
        bf.close();
    }

    public int swapDigits(int val, int d) {
        int power=(int)Math.pow(10, d);
        int x = val/power;
        int y = val % power;
        return y * (int) Math.pow(10, (int) Math.log10(x) + 1) + x;
    }
}
