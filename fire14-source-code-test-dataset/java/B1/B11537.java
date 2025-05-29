package template;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class TestCaseSolver implements Runnable {

    private ArrayList<TestCase> testCases;
    private int ref;

    public TestCaseSolver(ArrayList<TestCase> tcs, int ref) {
        testCases = tcs;
        this.ref = ref;
    }

    public TestCaseSolver(TestCase tc, int ref) {
        ArrayList<TestCase> tcs = new ArrayList<>();
        tcs.add(tc);
        testCases = tcs;
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    @Override
    public void run() {
        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            solve(tc);
            long duration = System.nanoTime() - startTime;
            double secs = (double)duration / (1000000000d);
            tc.setTime(secs);
            System.out.println("Thread " + ref + " solved testcase " + tc.getRef() + " in " + String.format("%.2f", secs) + " secs.");
        }
    }

    private void solve(TestCase tc) {
        ArrayList<Integer> a_b = tc.getIntegerList("a_b");
        int A = a_b.get(0);
        int B = a_b.get(1);
        int count = 0;
        for (int i = A; i <= B; i++) {
            ArrayList<Integer> digs = Utils.splitToDigits(i);
            int l = digs.size();
            Set<Integer> solns = new HashSet<>();
            for (int r = 1; r < l; r++) {
                int rec = recombine(digs, r);
                if (valid(digs, r) && rec <= B) {
                    //System.out.println(digs + " " + r);
                    solns.add(new Integer(rec));
                }
            }
            count += solns.size();
        }
        
        
        tc.setSolution(new Integer(count));
    }
    
    private boolean valid(ArrayList<Integer> digits, int startRotation) {
        if (digits.get(startRotation).intValue() == 0) {return false;}
        int len = digits.size();
        for (int origLoc = 0; origLoc < len; origLoc++) {
            int rotLoc = (origLoc + startRotation) % len;
            int origDig = digits.get(origLoc);
            int rotDig = digits.get(rotLoc);
            if (rotDig > origDig) {return true;}
            if (rotDig < origDig) {return false;}
        }
        return false;
        
    }
    
    private int recombine(ArrayList<Integer> digs, int start) {
        int tot = 0;
        for (int i = 0; i < digs.size(); i++) {
            int loc = (i + start) % digs.size();
            tot += digs.get(loc).intValue() * (int)(Math.pow(10d, (double)(digs.size() - i - 1)));
        }
        return tot;
    }
}
