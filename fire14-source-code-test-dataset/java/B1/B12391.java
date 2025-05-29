import java.io.*;
import java.util.*;

/**
 * @author: Ignat Alexeyenko
 * Date: 4/14/12
 */
public class RecycledNumbersMain {

    public static final int MAX_LENGTH = 80;

    public static void main(String[] args) {
        RecycledNumbersMain main = new RecycledNumbersMain();
        main.runConsoleApp(System.in, System.out);
    }

    public void runConsoleApp(InputStream inputStream, OutputStream outputStream) {
        final String s = readLn(inputStream, MAX_LENGTH);
        Integer cases = Integer.valueOf(s);
        Writer writer = new OutputStreamWriter(outputStream);
        for (int i= 0; i < cases; i++) {
            String edgesRaw = readLn(inputStream, MAX_LENGTH);
            String[] edgesArr = edgesRaw.split(" ");

            long low = Long.valueOf(edgesArr[0]);
            long hi = Long.valueOf(edgesArr[1]);
            try {
                writer.write("Case #" + (i + 1) + ": " + recycledNumbersInterval(low, hi) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    long recycledNumbersInterval(final long low, final long hi) {
        Map<Long, Set<Long>> resultMap = recycledNumbersInternalCollection(low, hi);
        long counter = 0;
        
        for (Long num : resultMap.keySet()) {
            Set<Long> permutations = resultMap.get(num);
            if (permutations.size() > 0) {
                counter += permutations.size();
            }
        }
        
//        return resultMap.size();
        return counter;
    }

    Map<Long, Set<Long>> recycledNumbersInternalCollection(long low, long hi) {
        // number -> permutations
        Map<Long, Set<Long>> resultMap = new HashMap<Long, Set<Long>>(1024);

        long i = hi;
        while (i >= low) {

            Set<Long> permutations = permute(i, low, hi);
            resultMap.put(i, permutations);
            i--;
        }
        return resultMap;
    }

    Set<Long> permute(long number, final long low, final long hi) {
        if (number < 10) {
            return Collections.emptySet();
        }

        Set<Long> resultSet = new HashSet<Long>();
        
        // for input 1204 create a string 12041204
        String permBasic = "" + number + "" + number;
        final int numberSize = permBasic.length() / 2;
        // start from 1, as we don't want to include original to set of permutations
        for (int i = 1; i <= numberSize; i++) {
            String substring = permBasic.substring(i, i + numberSize);
            if (substring.startsWith("0")) {
                // skip trailing zeroes
                continue;
            }
            Long thePermutation = Long.valueOf(substring);
            if (thePermutation < number && (thePermutation >= low && thePermutation <= hi)) {
                resultSet.add(thePermutation);
            }
        }
        return resultSet;
    }


    private String readLn(InputStream inputStream, int maxLength) {  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte[maxLength];
        int length = 0;
        int input = -1;
        try {
            while (length < maxLength) {//Read untill maxlength
                input = inputStream.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line[length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        } catch (IOException e) {
            return null;
        }
    }
}
