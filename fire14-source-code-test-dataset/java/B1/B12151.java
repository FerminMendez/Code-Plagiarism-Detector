/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejamqualfication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class QualificationC {
    
    public static void main(String[] args) {
        File file = new File("C:\\codejam\\plik.txt");
        File result = new File("C:\\codejam\\result.txt");


        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter(result);

            int i = -1;
            String line;

            while ((line = input.readLine()) != null) {

                if (i == -1) {
                    i = 0;
                } else {
                    i++;
                    writer.write(processLine(line, i));
                    writer.write("\n");
                }
            }

            input.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static final Pattern LINE_PATTERN = Pattern.compile("(\\d+)\\s(\\d+)");

    private static String processLine(String line, int i) {
        StringBuilder sb = new StringBuilder("Case #");
        sb.append(i);
        sb.append(": ");
        Matcher m = LINE_PATTERN.matcher(line);
        if(m.matches()){
            sb.append(generateAndCountPairs(m.group(1), m.group(2)));
        }                    
        
        return sb.toString();
    }

    private static int generateAndCountPairs(String a, String b) {
        int successCounter = 0;
        int aInt = Integer.valueOf(a);
        int bInt = Integer.valueOf(b);
        for (int nInt = aInt; nInt <= bInt; nInt++) {
            String n = String.valueOf(nInt);
            Set<Integer> obtainedMs = new HashSet<Integer>();
            for (int i = 1; i <= n.length(); i++) {
                String m = n.substring(i, n.length()) + n.substring(0, i);
                int mInt = Integer.valueOf(m);
                if (mInt > nInt && mInt <= bInt && !m.startsWith("0") && !obtainedMs.contains(mInt)) {
                    successCounter++;
                    obtainedMs.add(mInt);
                }
            }
        }
        return successCounter;
    }
}
