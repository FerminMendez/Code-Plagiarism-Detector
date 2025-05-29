/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leider.ken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 *
 * @author ken
 */
public class DancingParser implements Parser {

    public Map<Integer, Callable<String>> parse(String fileName) throws IOException {
        Map<Integer, Callable<String>> retval = new HashMap<Integer, Callable<String>>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            
            long surprises = Long.parseLong(tokens[1]);
            long minScore = Long.parseLong(tokens[2]);
            
            List<Long> totals = new ArrayList<Long>();
            for (int j = 3; j < tokens.length; j++) {
                totals.add(Long.parseLong(tokens[j]));
                
            }
            retval.put(i, new DancingAlgorithm(i, surprises, minScore, totals));
        }
        
        return retval;

    }
    
}
