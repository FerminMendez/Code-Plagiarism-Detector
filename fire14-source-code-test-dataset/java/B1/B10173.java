package qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecycledNumbers {
    static int T;
    static int[] result;

    public static void main(String[] args) throws IOException {
        read();
        write();
    }

    static void read() throws IOException {
        File input = new File("input.txt");
        Scanner scanner = new Scanner(input);
        T = scanner.nextInt();
        result = new int[T];
        for (int t=0; t<T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            result[t] = process(A,B);
        }
    }

    static int process(int A, int B) {
        String bs = Integer.toString(B);
        List<String> existing = new ArrayList<String>(bs.length());
        int result = 0;
        for (int n=A; n<B; n++) {
            String ns = Integer.toString(n);
            existing.clear();
            for (int i=1; i<ns.length(); i++) {
                String ms = ns.substring(i)+ns.substring(0,i);
                if (ms.charAt(0) != '0' && ms.compareTo(ns) > 0 && ms.compareTo(bs) <= 0) {
                    if (!existing.contains(ms)) {
                        existing.add(ms);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    static void write() throws IOException {
        File output = new File("output.txt");
        PrintWriter pw = new PrintWriter(output);

        for (int t=0; t<T; t++) {
            pw.println("Case #"+(t+1)+": "+result[t]);
        }

        pw.close();
    }

}
