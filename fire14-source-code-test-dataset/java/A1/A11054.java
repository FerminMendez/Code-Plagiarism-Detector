package bchang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: bchang
 * Date: 4/14/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemB {

    private static int process(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int counter = 0;
        for (int j = 0; j < n; j++) {
            int ti = Integer.parseInt(st.nextToken());
            int r = ti - p;
            if (r >= 0) {
                if (r >= p * 2 - 2) {
                    counter++;
                }
                else if (s > 0 && r >= p * 2 - 4) {
                    counter++;
                    s--;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {
                String line = reader.readLine();
                int result = process(line);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                }
            }
        }

    }
}
