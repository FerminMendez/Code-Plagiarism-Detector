/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.dancingwiththegooglers;

import uk.co.epii.codejam.common.AbstractProcessor;
import uk.co.epii.codejam.common.Processor;


/**
 *
 * @author jim
 */
public class DancingWithTheGooglersProcessor extends AbstractProcessor {
    
    public int[] getB(int t) {
        switch (t) {
            case 0: return new int[] {0,0};
            case 29: return new int[] {10,10};
            case 30: return new int[] {10,10};
        }
        switch (t % 3) {
            case 0:
                return new int[] {t /3, t / 3 + 1};
            case 1:
                return new int[] {(t + 2) / 3, (t + 2) / 3};
            case 2:
                return new int[] {(t + 1) / 3, (t + 4) / 3};
        }
        throw new IllegalArgumentException("Your t value has defied the "
                + "peano axioms");
    }

    @Override
    public String processLine(String line) {
        DataRow dr = new DataRow(line);
        int mustReach = 0;
        int canOnlyReachWithSurprisingResult = 0;
        for (int t : dr.t) {
            int[] b = getB(t);
            if (b[0] >= dr.p)
                mustReach++;
            else if (b[1] >= dr.p)
                canOnlyReachWithSurprisingResult++;
        }
        int surprisingContribution = Math.min(dr.S, 
                canOnlyReachWithSurprisingResult);
        return (mustReach + surprisingContribution) + "";
    }
    
    
}
