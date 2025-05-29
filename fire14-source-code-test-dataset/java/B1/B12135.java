
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumber {

    private int numCase;

    public void calc() throws FileNotFoundException, IOException {

        FileReader reader = new FileReader("D:/C-small-attempt0.in");
        BufferedReader bf = new BufferedReader(reader);

        FileWriter writer = new FileWriter("D:/output.txt");
        BufferedWriter bw = new BufferedWriter(writer);

        numCase = Integer.parseInt(bf.readLine());
        int n, m;
        for (int all = 1; all <= numCase; all++) {
            String[] inp = bf.readLine().split(" ");
            n = Integer.parseInt(inp[0]);
            m = Integer.parseInt(inp[1]);
            int count = 0;
            if (n < 10) {
                count = 0;
            } else if (n < 100) {
                for (int i = n; i <= m; i++) {
                    String temp = i + "";
                    String rv = temp.charAt(1) + "" + temp.charAt(0);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                }
            } else if (n >= 100 && n <= 999) {
                for (int i = n; i <= m; i++) {
                    String temp = i + "";
                    String rv = temp.charAt(2) + "" + temp.charAt(0) + "" + temp.charAt(1);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                    rv = temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(0);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                }
            } else if (n >= 1000 & n <= 9999) {
                for (int i = n; i <= m; i++) {
                    String temp = i + "";
                    String rv = temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(3) + "" + temp.charAt(0);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                    rv = temp.charAt(2) + "" + temp.charAt(3) + "" + temp.charAt(0) + "" + temp.charAt(1);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                    rv = temp.charAt(3) + "" + temp.charAt(0) + "" + temp.charAt(1) + "" + temp.charAt(2);
                    if (Integer.parseInt(rv) >= n && Integer.parseInt(rv) <= m && Integer.parseInt(rv) != i) {
//                        System.out.println("I : " + i + " RV : " + rv);
                        count++;
                    }
                }
            }
            System.out.println("Case #" + all + ": " + count / 2);
            bw.write("Case #" + all + ": " + count / 2+"\r\n");
        }
        bw.close();
        writer.close();
        bf.close();
        reader.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RecycledNumber rn = new RecycledNumber();
        rn.calc();
    }
}