package recyclednumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author Emmanuel JS Hoarau - Google Code Jam 2012
 */
public class RecycledNumbers {
    
    String executeLine(final String line) {
        String words[] = line.split(" ");
        String sa = words[0], sb = words[1];
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        
        int result = 0;
        for (int n = a; n <= b; ++n) {
            HashSet<String> matches = new HashSet<String>();
            String s = Integer.toString(n);
            String ss = s + s.substring(0, s.length()-1);
            int l = s.length();
            for (int j = 1; j < l; ++j) {
                if (ss.charAt(j) != '0') {
                    String r = ss.substring(j, j+l);
                    if ((r.compareTo(s) > 0) && (r.compareTo(sa) >= 0) && (r.compareTo(sb) <= 0) && !matches.contains(r)) {
                        matches.add(r);
                        ++result;
                    }
                }
            }
        }
        
        return Integer.toString(result);
    }

    void execute() {
        try {
            InputStreamReader stream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(stream);
        
            String line = reader.readLine();
            int lines = Integer.parseInt(line);
            for (int i = 1; i <= lines; ++i) {
                line = reader.readLine();
                StringBuilder out = new StringBuilder();
                out.append("Case #");
                out.append(i);
                out.append(": ");
                out.append(executeLine(line));
                System.out.println(out.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RecycledNumbers().execute();
    }
}

