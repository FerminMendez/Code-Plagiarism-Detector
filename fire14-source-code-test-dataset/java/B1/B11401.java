import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("t.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("out.txt")));
        int num = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < num; i++) {
            String orig = reader.readLine();
            writer.write("Case #" + (i + 1) + ": ");
            String[] strs = orig.split(" +");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int res = 0;
            for (int j = a; j < b + 1; j++) {
                String org = Integer.toString(j);
                String newStr = Integer.toString(j);
                int ind = 0;
                while (org.length() - 1 > ind) {
                    ind++;
                    newStr = newStr.substring(1) + newStr.charAt(0);
                    if (Integer.valueOf(newStr) >= a && Integer.valueOf(newStr) <= b && (Integer.valueOf(org) < Integer.valueOf(newStr))) {
                        res++;
                    }
                }
            }
            writer.write("" + res);
            if (i < num - 1) {
                writer.write('\n');
            }
        }
        writer.close();
        reader.close();
    }
}
