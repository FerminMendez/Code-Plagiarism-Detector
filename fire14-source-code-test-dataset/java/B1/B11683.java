/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.recyclednumbers;

import java.util.TreeSet;
import uk.co.epii.codejam.common.AbstractProcessor;

/**
 *
 * @author jim
 */
public class RecycledNumbersProcessor extends AbstractProcessor {

    @Override
    public String processLine(String line) {
        DataRow dr = new DataRow(line);
        if (dr.A > dr.B) return "0";
        int count = 0;
        for (int n = dr.A; n < dr.B; n++) {
            String nStr = n + "";
            TreeSet<Integer> m = new TreeSet<>();
            for (int c = 1; c < nStr.length(); c++) {
                int value = cycle(nStr, c);
                if (value > n && value <= dr.B)
                    m.add(value);
            }
            count += m.size();
        }
        return count + "";
    }
    
    public int cycle(String n, int c) {
        String cycled = n.substring(c, n.length()) + n.substring(0, c); 
        return Integer.parseInt(cycled);
    }
    
    
    
}
