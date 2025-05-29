import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jack Man
 * Date: Apr 13, 2012
 * Time: 9:12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecycledNum {
    public static void main(String[] args) {


        try {
            String filePath = "c:\\projects\\codejam\\input\\recycled.txt";
            StringBuffer fileData = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String strLine;

            Integer inputNum = 0;
            List<String> googlereseList = new ArrayList<String>();
            int line = 0;
            Integer cases = null;
            ArrayList<String> solutions = new ArrayList<String>();
            while ((strLine = reader.readLine()) != null) {
                if (line == 0) {
                    line++;
                    continue;
                }
                //
                String[] inputs = strLine.split(" ");
                int start = Integer.parseInt(inputs[0]);
                int end = Integer.parseInt(inputs[1]);

                int found = 0;
                HashMap<String, Boolean> dupeMap = new HashMap<String, Boolean>();
                for (int i = start; i <= end; i++) {
                    String s = i + "";
                    for (int y = 1;y< s.length();y++) {

                        //System.out.println((s.length()-y);
                        String right = s.substring(s.length()-y);
                        String left = s.substring(0, s.length()-y);
                        //System.out.println("Attempt to shift " + y + " digits from the right of " + s + " (" + left + ")(" + right + ")");
                        String mirror = right + left;
                        //remove leading zeros
                        boolean foundZero = false;
                        char[] chars = mirror.toCharArray();
                        String mirrorEnd = "";
                        for (char c : chars) {
                            if (c == '0' && !foundZero) {
                                continue;
                            }
                            foundZero = true;
                            mirrorEnd+=c;

                        }
                        if (s.length() != mirrorEnd.length()) continue;
                        Integer n = Integer.parseInt(s);
                        Integer m = Integer.parseInt(mirrorEnd);

                        if (n.equals(m)) continue;
                        if (start <= n && n < m && m <= end) {
                            if (dupeMap.get(n + "-" + m) != null) {
                                continue;
                            }
                            found++;
                            //System.out.println("\t[" + found + ":MARK] set of " + n + ", " + m);
                            dupeMap.put(n + "-" + m, true);
                        }


                    }


                }
                  System.out.println("Case #" + line + ": " + found);
                //
                line++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
