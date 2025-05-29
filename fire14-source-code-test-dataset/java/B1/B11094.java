import java.io.*;
import java.util.*;

public class C {
    BufferedReader ins;
    PrintStream outs;

    static String INPUT = "C-small-attempt0.in";
    static String OUTPUT;

    static {
        OUTPUT = "C.out";
    }

    Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    
    public C(BufferedReader ins, PrintStream outs) {
        this.ins = ins;
        this.outs = outs;
    }

    public void preprocess() {
        for(int j = 1; j<=2000000; j++) {
            String k = new Integer(j).toString();
            Set<String> set = new HashSet<String>();
            int sz = k.length();
            for(int i = 1; i<sz; i++) {
                set.add(k.substring(i) + k.substring(0,i));
            }
            map.put(k, set);
        }
    }
    
    public int permuteK(int k, int b) {
        int sz = new Integer(b).toString().length();
        int ret = 0;

        Set<String> set = new HashSet<String>();
        for(int i = 0; i<sz; i++) {
            String x = new Integer(k).toString();
            String sb = x.substring(i) + x.substring(0,i);
            
            assert(sb.length() == sz);
            
            int newk = Integer.parseInt(sb);
            if(newk > k && newk <=b) {
                if(!set.contains(x+"-"+sb)) {
                    set.add(x+"-"+sb);
                }
                ret++;
            }
        }
        return set.size();
    }
   
    public int permuteL(int k, int b) {
        String m = new Integer(k).toString();
        int count = 0;
        for(String r : map.get(m)) {
            int newk = Integer.parseInt(r);
            if(newk>k && newk<=b) count++;
        }
        return count;
    }
    public int go(int a, int b) {
        int count = 0;
        for(int k = a; k < b; k++) {
            count += permuteK(k, b);
        }
        return count;
    }

    public void process() throws Exception {
//        preprocess();
 //       System.out.println("Hi");
       //Read input
       int t = Integer.parseInt(ins.readLine());

       for(int T=1; T<=t;T++) {
            String x = ins.readLine().trim().replaceAll(" +", " ");
            String[] tokens = x.split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            
            outs.println("Case #" + T + ": " + go(a,b));
        }
    }

    public static void main(String args[]) throws Exception {
        //Input
        InputStreamReader fis = new FileReader(INPUT);
        BufferedReader bis = new BufferedReader(fis);

        //Output
        PrintStream ps = OUTPUT!=null ? new PrintStream(OUTPUT) : System.out;
        
        C c = new C(bis, ps);

        c.process();
        return;
    }
}
