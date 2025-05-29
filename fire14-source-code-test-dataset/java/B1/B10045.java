
package codejam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Ronak
 */
public class C {    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File f = new File("C-small-attempt1.in");
        FileInputStream fstream = new FileInputStream(f);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = "";
        int count = 0, T = 0;
        List<String> left = new ArrayList<String>();
        while ((strLine = br.readLine()) != null) {
            if (count == 0) {
                T = Integer.parseInt(strLine.trim());
            } else {
                strLine.trim();
                String[] l = strLine.split(" ");
                int min = Integer.parseInt(l[0]);
                int max = Integer.parseInt(l[1]);                
                System.out.print("Case #" + count + ": ");
                for (int n = min; n <= max; n++) {
                    String str = String.valueOf(n);
                    for (int i = 1; i < str.length(); i++) {
                        String temp = str.substring(i, str.length()) + str.substring(0, i);
                        if (temp.charAt(0) != '0') {
                            int m = Integer.parseInt(temp);
                            if (n < m && m <= max && n >= min) {
                                left.add(n + "" + m + "");
                            }
                        }
                    }
                }
                System.out.println(new ArrayList<String>(new HashSet<String>(left)).size());
                left.clear();
            }
            count++;
        }
    }
}
