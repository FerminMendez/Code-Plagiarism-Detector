import java.io.*;
import java.util.*;

public class B {
    BufferedReader ins;
    PrintStream outs;

    static String INPUT = "B-small-attempt0.in";
    static String OUTPUT;

    static {
        OUTPUT = "B.out";
    }

    public B(BufferedReader ins, PrintStream outs) {
        this.ins = ins;
        this.outs = outs;
    }

    public int go(List<Integer> list, int sr, int p) {
        //Collections.sort(list);
        //Collections.reverse(list);
//        System.out.println("List = " + list);
 //       System.out.println("Surprises = " + sr);
   //     System.out.println("P = " + p);

        int count = 0;
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i) >= p + 2 * Math.max(p-1,0)) {
   //             System.out.println("Easy case = " + list.get(i));
                count++;
            }
            else if((list.get(i) >= p + 2* Math.max(p-2,0)) && (sr > 0)) {
                count++;
                sr--;
//                System.out.println("Tough case = " + list.get(i));
            } else {
  //              System.out.println("Oops case = " + list.get(i));
            }
        }
        return count;
    }

    public void process() throws Exception {
       //Read input
       int t = Integer.parseInt(ins.readLine());

       for(int T=1; T<=t;T++) {
            String x = ins.readLine().trim().replaceAll(" +", " ");
            String[] tokens = x.split(" ");
            int n = Integer.parseInt(tokens[0]);
            int sum = Integer.parseInt(tokens[1]);
            int p = Integer.parseInt(tokens[2]);
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i<n; i++) {
                list.add(Integer.parseInt(tokens[i+3]));
            }

            
            
            outs.println("Case #" + T + ": " + go(list, sum, p));
        }
    }

    public static void main(String args[]) throws Exception {
        //Input
        InputStreamReader fis = new FileReader(INPUT);
        BufferedReader bis = new BufferedReader(fis);

        //Output
        PrintStream ps = OUTPUT!=null ? new PrintStream(OUTPUT) : System.out;
        
        B b = new B(bis, ps);

        b.process();
        return;
    }
}
