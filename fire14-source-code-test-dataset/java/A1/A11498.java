package template;

import java.util.ArrayList;

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
        ArrayList<Integer> totals = tc.getIntegerList("props");
        int num = totals.remove(0);
        int surp = totals.remove(0);
        int p = totals.remove(0);
        
        if (num != totals.size()) {Utils.die("err count");}
        
        int deffo = 0;
        int maybe = 0;
        for (Integer i : totals) {
            if (i >= (3 * p - 2)) {
                deffo++;
                continue;
            }
            if (i >= (3 * p - 4) && i > 0) {
                maybe++;
            }
        }
        
        if (maybe > surp) {maybe = surp;}
        
        

        tc.setSolution(new Integer(deffo + maybe));
    }
}
