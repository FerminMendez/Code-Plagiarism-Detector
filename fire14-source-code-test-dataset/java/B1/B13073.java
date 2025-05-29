package round1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
    public static Set<Integer>findRecycledNumbersBetween(int number, int start, int end) {
        if (number < 12) {
            return new HashSet<Integer>();
        }
        String num = "" + number;
        
        Set<Integer> nums = new HashSet<Integer>();
        for (int i = 1; i < num.length(); i++) {
            String firstPart = num.substring(0, i);            
            String lastPart = num.substring(i);
            if (lastPart.charAt(0) == '0') {
                continue;
            }
            
            int candidate = Integer.parseInt(lastPart + firstPart);
            if (candidate > number && (candidate >= start && candidate <= end)) {
                nums.add(candidate);
            }
        }
        
        return nums;
    }
    
    public static int findRecycledNumbersBetween(int start, int end) {
        int numbers = 0;
        for (int i = start; i <= end; i++) {
            Collection<Integer> recycles = findRecycledNumbersBetween(i, start, end);
            if (recycles.size() > 0) {
                //System.out.printf("found following recycles for %d => %s\n", i, recycles.toString());
            }
            numbers += recycles.size();
        }
        return numbers;
    }
    
    public static void findRecycledNumbersInFile(File input) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(input));
        BufferedReader br = new BufferedReader(reader);
        int numLines = Integer.parseInt(br.readLine());
        for (int i = 1; i <= numLines; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            
            System.out.printf("Case #%d: %d\n", i, findRecycledNumbersBetween(start, end));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: RecycledNumbers <InputFile>");
            System.exit(-1);
        }
        findRecycledNumbersInFile(new File(args[0]));
    }
}