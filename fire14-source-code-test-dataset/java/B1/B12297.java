/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Recycling (Numbers)
 * Jason Bradley Nel
 * 16287398
 */
import java.util.*;

public class Recycling {
    
    public static void main(String[] args) {
        
        In input = new In("input.txt");

        int T = input.readInt();

        for (int t = 0; t < T; t++){
            int min = input.readInt();
            int max = input.readInt();
            int N = max - min + 1;
            Set<String> set = new HashSet<String>();
            //if (set.isEmpty()) System.out.print("\nSET IS EMPTY");
            for (int i = min; i <= max; i++) {
                String s = "" + i;
                for (int r = 1; r < s.length(); r++) {
                    String m = returnM(s, r);
                    int num = Integer.parseInt(m);
                    String mn = s + m;
                    //System.out.printf("%d(%s)(*%d*), ", i, m, num);
                    if((num >= min) && (num <= max) && (num != i)) set.add(mn);
                }
            }
            
            //if (set.isEmpty()) System.out.print("\nSET IS EMPTY");
            int c = set.size()/2;
            System.out.printf("Case #%d: %d\n", t+1, c);
        }
    }
    
    public static String returnM(String s, int r){
        int N = s.length();
        if(r != N){
        String i = s.substring(0, N - r);
        i = s.substring(N - r, N) + i;
        return i;
        }
        else return s;
    }
}
