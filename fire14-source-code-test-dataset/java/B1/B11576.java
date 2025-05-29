package recyclednumbers;

import java.util.ArrayList;


public class RecycledNumbers {

    static SimpleReader reader;
    static SimpleWriter writer;
    
    static int low;
    static int high;

    public static void main(String[] args) {
        if (args.length != 1) {
            reader = new SimpleReader();
            writer = new SimpleWriter();
        } else {
            reader = new SimpleReader(args[0]);
            writer = new SimpleWriter(args[1]);
        }
        int cases = reader.readInt();
        int[] lohi;
        for (int i = 0; i < cases; i++) {
            lohi = reader.readIntArray();
            low = lohi[0];
            high = lohi[1];
            solve(i + 1);
            System.out.println("Case " + (i + 1) + " done");
        }
        writer.flush();
        System.out.println("Done");
    }
    
    private static void solve(int caseNo) {
        int ans = 0;
        int length = Integer.toString(low).length();
        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            ArrayList<Integer> seen = new ArrayList<>();
            for (int j = 1; j < length; j++) {
                int cycle = Integer.parseInt(s.substring(j, length) + 
                                             s.substring(0, j));
                if (!seen.contains(cycle) && cycle <= high && cycle > i) {
                    ans++;
                    //System.out.println(Integer.toString(i) + " " + Integer.toString(cycle));
                }
                seen.add(cycle);
            }
        }
        writer.writeLine("Case #" + caseNo + ": " + ans);
    }
    
    private static boolean isRecycled(int n, int m) {
        String ns = Integer.toString(n);
        String ms = Integer.toString(m);
        if (ns.length() != ms.length()) {
            return false;
        }
        for (int i = 1; i < ns.length(); i++) {
            if (ns.equals(ms.substring(i, ms.length()) + ms.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
