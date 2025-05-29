
import java.io.*;
import java.util.*;

public class Recycled {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
    
    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int results = 0;
        for(int i = a; i <= b; i++) {
            //if(i%10000==0) out.println("looking at " + i);
            results += howManyCyclesGreaterThanMeButLessThanB(i,b);
        }
        out.println(results);
    }
    
    public int howManyCyclesGreaterThanMeButLessThanB(int i, int b) {
        int res = 0;
        int lastCycle = 0;
        for(int cycle : generateCycles(i)) {
            if(cycle==lastCycle) continue;
            if(cycle > i && cycle <= b) res++;
            lastCycle = cycle;
        }
        //if(i%10000==0) out.println("found good cycles " + res);
        return res;
    }
    
    public int[] generateCycles(int i) {
        int origi = i;
        int numDigits = numberOfDigits(i);
        int[] res = new int[numDigits-1];
        int pow = tenToThePower(numDigits-1);
        
        for(int j = 0; j < res.length; j++) {
            i = i / 10 + i % 10 * pow;
            res[j] = i;
        }
        Arrays.sort(res);
                
        //if(origi%10000==0) out.println("found cycles " + Arrays.toString(res));
        return res;
    }
    
    public static int tenToThePower(int i) {
        int res = 1;
        for(int j = 0; j < i; j++) {
            res *= 10;
        }
        return res;
    }
    
    public static int numberOfDigits(int i) {
        int res = 1;
        while(i/10 > 0) {
            i = i/10;
            res++;
        }
        return res;
    }
    
    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Recycled().run();
    }

}
