
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;

public class ProblemB {

    public static void main(String[] args) {
        try {
            File input = new File("B-small-attempt1.in");
            Writer fin = null;
            File output = new File("b2.txt");
            fin = new BufferedWriter(new FileWriter(output));
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            DataInputStream dis = null;
            String out = "";
            fis = new FileInputStream(input);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            int t = Integer.parseInt(dis.readLine());
            for (int i = 0; i < t; i++) {
                out += "Case #" + (i + 1) + ": ";
                String h = dis.readLine();
                String[] a = h.split(" ");
                int result = 0;
                int n = Integer.parseInt(a[0]);
                int s = Integer.parseInt(a[1]);
                int p = Integer.parseInt(a[2]);
                for (int j = 3; j < a.length; j++) {
                    int v1 = Integer.parseInt(a[j]);
                    int v2 = v1 / 3;
                    int v3 = v1 % 3;
                    if ((v2 >= p) || (v3 >= 1 && v2 + 1 >= p)) {
                        result++;
                    } else if (v3 == 2 && v2 + 2 >= p && s > 0) {
                            result++;
                            s--;
                    } else if (v3 == 0 && v2 > 0  && v2 + 1 >= p && s > 0) {
                            result++;
                            s--;
                    }
                }
                out += result;
                fin.write(out);
                out = "\n";
            }
            fis.close();
            bis.close();
            dis.close();
            fin.close();
        } catch (Exception ex) {
        }
    }
}
