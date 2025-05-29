/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leider.ken;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;




/**
 *
 * @author ken
 */
class DancingAlgorithm implements Callable<String> {
    private final int caseNumber;
    private final long surprises;
    private final long minScore;
    private final List<Long> totals;

    public DancingAlgorithm(int caseNumber, long surprises, long minScore, List<Long> totals) {
        this.caseNumber = caseNumber;
        this.surprises = surprises;
        this.minScore = minScore;
        this.totals = totals;

    }


    public String call() throws Exception {
        long meetsCount = 0;
        long meetsWithSurpriseCount = 0;
        
        for (Long total : totals) {
            double avgOther = (total - minScore)/ 2.0;
            long min = (long) Math.floor(avgOther);
            if (min < 0) continue;                    
            if (min + 1 >= minScore) {
                meetsCount++;
            } else if (min + 2 >= minScore) {
                meetsWithSurpriseCount++;
            }            
        }
        
        long retval = meetsCount + Math.min(meetsWithSurpriseCount, surprises);
        return String.format("Case #%d: %d", caseNumber, retval);
    }

    @Override
    public String toString() {
        return totals.toString();
    }
    
    
}
