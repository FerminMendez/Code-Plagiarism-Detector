package qr1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shtratos
 * Date: 14/04/12
 * Time: 04:28
 */
public class DancingGooglers {


    public static void main(String[] args) {

        DancingGooglers dg = new DancingGooglers();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            int numOfTests = Integer.valueOf(br.readLine());
            for (int i = 0; i < numOfTests; i++) {
                System.out.println("Case #" + (i + 1) + ": " + dg.parseAndCalc(br.readLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    @Test
    public void testExamples() {
        DancingGooglers dg = new DancingGooglers();

        assertEquals(3, dg.parseAndCalc("3 1 5 15 13 11"));
        assertEquals(2, dg.parseAndCalc("3 0 8 23 22 21"));
        assertEquals(1, dg.parseAndCalc("2 1 1 8 0"));
        assertEquals(1, dg.parseAndCalc("2 1 2 8 1"));
        assertEquals(2, dg.parseAndCalc("2 1 2 8 2"));
        assertEquals(1, dg.parseAndCalc("2 0 2 8 2"));
        assertEquals(1, dg.parseAndCalc("1 0 0 26"));
        assertEquals(0, dg.parseAndCalc("1 0 10 26"));
        assertEquals(0, dg.parseAndCalc("2 0 5 5 11"));
        assertEquals(0, dg.parseAndCalc("3 3 8 17 13 4"));
        assertEquals(1, dg.parseAndCalc("2 0 9 7 27"));
        assertEquals(2, dg.parseAndCalc("2 0 0 30 30"));
        assertEquals(2, dg.parseAndCalc("2 1 10 30 30"));
        assertEquals(1, dg.parseAndCalc("1 1 6 27"));
        assertEquals(1, dg.parseAndCalc("1 0 10 30"));
        assertEquals(0, dg.parseAndCalc("3 0 9 24 24 21"));
        assertEquals(1, dg.parseAndCalc("3 1 9 24 24 21"));
        assertEquals(2, dg.parseAndCalc("3 2 9 24 24 21"));
        assertEquals(1, dg.parseAndCalc("1 1 10 27"));
        assertEquals(0, dg.parseAndCalc("1 1 9 6"));
        assertEquals(0, dg.parseAndCalc("3 0 9 17 23 23"));
        assertEquals(1, dg.parseAndCalc("3 1 9 17 23 23"));
        assertEquals(0, dg.parseAndCalc("2 0 7 18 16"));
        assertEquals(1, dg.parseAndCalc("1 1 10 26"));
        assertEquals(0, dg.parseAndCalc("1 0 10 26"));

        assertEquals(3, dg.parseAndCalc("6 2 8 29 20 8 18 18 21"));
    }

    private int parseAndCalc(String s) {
        potentialCounter = 0;
        guaranteedCounter = 0;
        String[] parts = s.split(" ", 4);
        int numOfGooglers = Integer.parseInt(parts[0]);
        int numOfSurprises = Integer.parseInt(parts[1]);
        int maxScore = Integer.parseInt(parts[2]);
        String[] totalScores = parts[3].split(" ");
        for (int i = 0; i < numOfGooglers; i++) {
            try {
                assessGoogler(Integer.valueOf(totalScores[i]), maxScore);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return guaranteedCounter + Math.min(numOfSurprises, potentialCounter);

    }

    private int potentialCounter = 0;
    private int guaranteedCounter = 0;

    private void assessGoogler(int totalScore, int maxScore) throws Exception {
        if (totalScore > 30 || totalScore < 0) throw new Exception();
        if (maxScore > 10 || maxScore < 0) throw new Exception();

        int base = totalScore / 3;
        if (base > 10 || base < 0) throw new Exception();
        int remain = totalScore % 3;
        if (remain > 2 || remain < 0) throw new Exception();

        if (remain == 0) {
            int best = base;
            if ((best-maxScore) >= 0) {
                if (best > 10 || best < 0) throw new Exception();
                if (best < maxScore) throw new Exception();
                guaranteedCounter++;
            } else if ((best-maxScore) == -1 && totalScore >= 3 ){// && best <= 9) {
                if (base+1 > 10 || base+1 < 0) throw new Exception();
                if (base-1 > 10 || base-1 < 0) throw new Exception();
                if (base+1 != maxScore) throw new Exception();
                potentialCounter++;
            }
        } else if (remain == 1) {
            int best = base + 1;
            if ((best-maxScore) >= 0) {
                if (best > 10 || best < 0) throw new Exception();
                if (best < maxScore) throw new Exception();
                guaranteedCounter++;
            }/* else if ((best-maxScore) == -1 && totalScore >= 4 && best <= 9) {
                if (base+1 > 10 || base+1 < 0) throw new Exception();
                if (base-1 > 10 || base-1 < 0) throw new Exception();
                if (base+1 != maxScore) throw new Exception();
                potentialCounter++;
            } */
        } else if (remain == 2) {
            int best = base + 1;
            if ((best-maxScore) >= 0) {
                if (best > 10 || best < 0) throw new Exception();
                if (best < maxScore) throw new Exception();
                guaranteedCounter++;
            } else if ((best-maxScore) == -1){// && best <= 9) {
                if (base+1 > 10 || base+1 < 0) throw new Exception();
                if (base+2 > 10 || base+2 < 0) throw new Exception();
                if (base+2 != maxScore) throw new Exception();
                potentialCounter++;
            }
        }

    }


}
