/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class RecycledNumbers {

    static int caseNum = 0;
    static BufferedReader reader;
    static BufferedWriter writer;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("./in")));
        
        new File("./out").createNewFile();
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./out")));
        
        reader.readLine();  // Skip numberofcases
        String input;
        while ((input = reader.readLine()) != null) {
            input = input.trim();
            String[] numbers = input.split(" ");
            write(getPairCount(numbers[0], numbers[1]));
        }
    }
    
    static int getPairCount(String aStr, String bStr) {
        
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        
        if (a < 10 || a == b) {
            return 0;
        }
        
        HashMap<Integer, Set<Integer>> pairs = new HashMap<Integer, Set<Integer>>();
        
        for (int i = a; i <= b; i++) {
            String iStr = Integer.toString(i);
            for (int swaplength = 1; swaplength < iStr.length(); swaplength++) {
                
                int indexToSwap = iStr.length() - swaplength;
                
                if (iStr.charAt(indexToSwap) != '0' && Integer.parseInt("" + iStr.charAt(indexToSwap)) <= Integer.parseInt("" + bStr.charAt(0))) {
                    
                    String newString = iStr.substring(indexToSwap) + iStr.substring(0, indexToSwap);
                    
                    int newInt = Integer.parseInt(newString);
                    if (newInt <= b && newInt > i) {
                        
                        if (pairs.containsKey(newInt)) {
                            
                           if (pairs.get(newInt).contains(i)) {
                               continue;
                           }
                        }
                        
                        Set<Integer> values = pairs.get(i);
                        if (values == null) {
                            
                            values = new HashSet<Integer>();
                            pairs.put(i, values);
                        }
                        
                        values.add(newInt);
                        
                        /*boolean alreadyFound = false;
                        for (int[] pair: pairs) {
                            
                            if ((pair[0] == newInt || pair[1] == newInt) && (pair[0] == i || pair[1] == i)) {
                                
                                alreadyFound = true;
                                break;
                            }
                        }
                        
                        if (!alreadyFound) {
                            pairs.add(new int[]{i, newInt});
                            count++;
                        }*/
                    }
                }
            }
        }
        
        return countEntries(pairs);
    }
    
    public static int countEntries(Map<Integer, Set<Integer>> map) {
        
        int count = 0;
        for (Set set: map.values()) {
            
            count += set.size();
        }
        
        return count;
    }
    
    public static void write(Object out) throws IOException {
        
        caseNum += 1;
        writer.write(String.format("Case #%s: %s%n", caseNum, out));
        writer.flush();
    }
}
