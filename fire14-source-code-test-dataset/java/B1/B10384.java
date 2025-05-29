import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {


    public static void main(String[] args) throws IOException {
        File in = new File("c:\\temp\\input.txt");
        File out = new File("c:\\temp\\output.txt");
        BufferedWriter w = new BufferedWriter(new FileWriter(out));
        Scanner sc = new Scanner(in);
        int testCases = Utils.readIntegerLine(sc);
        for (int i = 1; i <= testCases; i++) {
            int min =  Utils.readInteger(sc);
            int max = Utils.readInteger(sc);
            long count = solve(min, max);
            String result = String.format("Case #%d: %d", i, count);
            w.write(result);
            System.err.println(result);
            w.newLine();
        }
        w.close();

    }

    private static long solve(int min, int max) {
        long count = 0;
        for(int n = min; n <= max; n++) {
            long countForN = countGreaterAnagrams(n, max);
            count += countForN;
       }
        return count;
    }

    private static long countGreaterAnagrams(int n, int max) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int length = chars.length;
        Set<Integer> numbers = new HashSet<Integer>();
        StringBuilder sb = new StringBuilder(length);
        for(int permStart = 1; permStart < chars.length; permStart++) {
            sb.setLength(0);
            for(int j = 0; j < length; j++) {
                sb.append(chars[(permStart + j) % length]);
            }
            int newN = Integer.parseInt(sb.toString());
            if (newN > n && newN <= max) {
                numbers.add(newN);
            }
        }
        return numbers.size();
    }
}

