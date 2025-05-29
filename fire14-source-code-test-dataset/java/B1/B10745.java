package net.nickball.gcj.qual.recyclednumbers;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author nick
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            if(args.length != 2) 
                throw new IllegalArgumentException("Usage: RecycledNumbers <inputfile> <outputfile>");
            File inputFile = new File(args[0]);
            if (! inputFile.exists()) throw new FileNotFoundException("File not found! File: "+ args[0]);
            
            reader = new BufferedReader(new FileReader(inputFile));
            String cases = reader.readLine();
            
            String line;
            int caseCounter = 1; 
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int A = Integer.parseInt(parts[0]);
                int B = Integer.parseInt(parts[1]);
                System.out.println("Case #" + caseCounter + ": " + getRecycledPairs(A,B));
                caseCounter++;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(255);
        } finally {
            try {
                if(reader != null) reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            } 
        }
    }

    private static long getRecycledPairs(int A, int B) {
        long count = 0;
        Set<String> uniques = new HashSet<String>(); 
        for(int n = A; n <=B; n++) {
            String nStr = Integer.toString(n);
            
            for(int m = n+1; m <=B; m++) {
                String mStr = Integer.toString(m);
                if(mStr.length() > nStr.length()) break;
                
                for(int index = 1; index < nStr.length(); index++) {
                    String start = new StringBuffer(nStr.substring(0,index)).reverse().toString();
                    String end = new StringBuffer(nStr.substring(index)).reverse().toString();
                    String rotated = StringUtils.stripStart(new StringBuffer(start).append(end).reverse().toString(),"0");
                    
                    //System.out.println(start +"," + end + "," + rotated);
                    if(rotated.equals(mStr) && (! uniques.contains(n + "" + m))) {
                        //System.out.println(n + "," + m);
                        uniques.add(n + "" + m);
                        count++;
                    }
                }
                
            }
        }
        return count;
    }
}
