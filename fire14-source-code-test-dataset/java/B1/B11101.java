import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

public class CodeJam2 {

    private static Map<Character, Character> stat = new HashMap<Character, Character>();
    private static final int range = 1005;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(
                "/home/girsh/Desktop/coding/codejam/input")));

        int[][] x = init();
        int t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; i++) {
            String input = reader.readLine();
            String[] f = input.split(" ");
            Integer A = Integer.parseInt(f[0]);
            Integer B = Integer.parseInt(f[1]);
            int ans  = 0;
            for(int g = A;g<B;g++){
                for(int h = g+1;h<=B;h++){
                    ans += x[g][h];
                }
            }
            
            System.out.print("Case #" + i + ": "+ans);
            System.out.println();

        }
    }

    private static int[][] init() {
        
        
        int[][] a = new int[range][range];
        for (Integer i = 1; i <= range-1; i++) {
            for (Integer j = i + 1; j <= range-1; j++) {

                boolean conv = compareStr(i, j);
                if (conv)
                    a[i][j] = 1;
                else
                    a[i][j] = 0;

            }
        }
        return a;
    }

    private static boolean compareStr(Integer i, Integer j) {

        String s1 = i.toString();
        String s2 = j.toString();

        for (int p = 1; p < s1.length(); p++) {

            String str = getRotatedString(s1, p);
            if (str.equalsIgnoreCase(s2))
                return true;

        }

        return false;
    }

    private static String getRotatedString(String s1, int p) {

        String fir = s1.substring(p, s1.length());
        String sec = s1.substring(0, p);
        return fir + sec;
    }

}
