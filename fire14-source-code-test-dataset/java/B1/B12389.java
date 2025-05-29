/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
import java.util.*;

/**
 *
 * @author jgao
 */
public class CodeJamC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "C-small-attempt0.in";
        List<String> input;
        try {
            input = readFile(file);
        } catch(Exception e) {
            return;
        }
        
        boolean[][] mat = recycleMatrix(0,1000);
        
        for (int i=1; i<input.size(); i++) {
            System.out.print("Case #"+i+": ");
            
            String[] strs = input.get(i).split(" ");
            int A = Integer.parseInt(strs[0]);
            int B = Integer.parseInt(strs[1]);
            
            int count = 0;
            for (int n=A; n<B; n++) {
                for (int m=n+1; m<=B; m++) {
                    if (mat[n][m]) {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }
    
    public static List<String> readFile(String file) throws Exception {
        List<String> content = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        for (String line=in.readLine(); line!=null; line=in.readLine()) {
            content.add(line);
        }
        in.close();
        return content;
    }
    
    public static boolean[][] recycleMatrix(int n, int m) {
        boolean[][] res = new boolean[m-n+1][m-n+1];
        for (int i=n; i<m; i++) {
            for (int j=i+1; j<=m; j++) {
                res[i-n][j-n] = isRecycle(i,j);
            }
        }
        return res;
    }
    
    public static boolean isRecycle(int x, int y) {
        String strX = Integer.toString(x);
        String strY = Integer.toString(y);
        
        for (int i=1; i<strX.length(); i++) {
            String strXRotate = strX.substring(i)+strX.substring(0, i);
            if (strXRotate.compareTo(strY)==0)
                return true;
        }
        
        return false;
    }
}
