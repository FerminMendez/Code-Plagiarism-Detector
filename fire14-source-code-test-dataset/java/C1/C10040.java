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
            double secs = (double) duration / (1000000000d);
            tc.setTime(secs);
            System.out.println("Thread " + ref + " solved testcase " + tc.getRef() + " in " + String.format("%.2f", secs) + " secs.");
        }
    }

    private void solve(TestCase tc) {
        int H = tc.getInteger("H");
        int W = tc.getInteger("W");
        int D = tc.getInteger("D");
        ArrayList<String> rows = tc.getStringList("rows");

        //find me
        Pair<Integer, Integer> myLoc = new Pair<>(0, 0);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (rows.get(i).substring(j, j + 1).equals("X")) {
                    myLoc.setO1(j - 1);
                    myLoc.setO2(H - i - 2);
                }
            }
        }
        Utils.sout("myLoc " + myLoc);

        int acrossBlockLimit = (D / (W - 2)) + 2;
        int downBlockLimit = (D / (H - 2)) + 2;

        //acrossBlockLimit = 1;
        //downBlockLimit = 1;

        ArrayList<Pair<Integer, Integer>> reflections = new ArrayList<>();
        for (int acrossBlock = -acrossBlockLimit; acrossBlock <= acrossBlockLimit; acrossBlock++) {
            for (int downBlock = -downBlockLimit; downBlock <= downBlockLimit; downBlock++) {
                if (acrossBlock == 0 && downBlock == 0) {
                    continue;
                }
                Pair<Integer, Integer> reflectedLoc = new Pair<>(0, 0);
                reflectedLoc.setO1(myLoc.getO1() + (W - 2) * acrossBlock);
                reflectedLoc.setO2(myLoc.getO2() + (H - 2) * downBlock);
                if ((acrossBlock % 2) != 0) {
                    reflectedLoc.setO1(reflectedLoc.getO1() + (W - 3 - 2 * myLoc.getO1()));
                }
                if ((downBlock % 2) != 0) {
                    reflectedLoc.setO2(reflectedLoc.getO2() + (H - 3 - 2 * myLoc.getO2()));
                }
                
                double dist = distance(myLoc, reflectedLoc);
                if (dist <= (double) D) {
                    //Utils.sout(reflectedLoc);
                    reflections.add(reflectedLoc);
                }
            }

        }
        System.out.println("ref size: " + reflections.size());

        Set<Double> angles = new HashSet<>();
        for (Pair<Integer, Integer> loc : reflections) {
            double angle = Math.atan2(loc.getO2().doubleValue() - myLoc.getO2().doubleValue(), loc.getO1().doubleValue() - myLoc.getO1().doubleValue());
            boolean isnew = angles.add(angle);
            if (isnew) {
                //Utils.sout("new " + loc + " " + angle);
            } else {
                //Utils.sout("skipping " + loc + " " + angle);
            }
        }
        System.out.println("angles size: " + angles.size());

        tc.setSolution(new Integer(angles.size()));
    }

    private double distance(Pair<Integer, Integer> loc1, Pair<Integer, Integer> loc2) {
        int x = Math.abs(loc1.getO1() - loc2.getO1());
        int y = Math.abs(loc1.getO2() - loc2.getO2());
        if (y == 0) {
            return (double) x;
        }
        if (x == 0) {
            return (double) y;
        }
        return Math.sqrt((double) (x * x + y * y));
    }
}
