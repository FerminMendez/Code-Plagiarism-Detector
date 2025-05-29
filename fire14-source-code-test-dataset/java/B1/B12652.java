package codejem;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RecycleNumber {
    public static void main(String[] args) throws IOException {
        InputStream is;
        if (args.length > 0) {
            is = new FileInputStream(args[0]);
        }else{
            is = System.in;
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(is));
        String firstLine = inputReader.readLine();
        int count_of_cases = Integer.parseInt(firstLine);

        for (int idx_of_case = 1; idx_of_case <= count_of_cases; idx_of_case++) {
            String caseLine = inputReader.readLine();
            String[] numbers = caseLine.split(" ");
            int start = Integer.parseInt(numbers[0]);
            int end = Integer.parseInt(numbers[1]);
            int count = count_of_recyclable(start, end);

            System.out.println(String.format("Case #%d: %d", idx_of_case, count));
        }

    }

    public static int count_of_recyclable(int start, int end) {
        int count = 0;

        for (int number = start; number <= end; number++) {
            char[] chars = int_to_char_array(number);
            char[] max_number = int_to_char_array(end);

            Set<String> matchNumbers = new HashSet<String>();
            for (int chars_to_move = 1; chars_to_move < chars.length; chars_to_move++) {
                char[] rotated_chars = rotated_chars(chars, chars_to_move);

                if (rotated_chars[0] != '0'
                        && not_greater_than_number(rotated_chars, max_number)
                        && less_than_number(chars, rotated_chars)) {

                    matchNumbers.add(String.valueOf(rotated_chars));
                }
            }
            count+= matchNumbers.size();
        }

        return count;
    }

    public static boolean not_greater_than_number(char[] rotated_chars, char[] max_number) {
        for (int i = 0; i < rotated_chars.length; i++) {
            if (max_number[i] > rotated_chars[i]) {
                return true;
            }

            if (rotated_chars[i] > max_number[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean less_than_number(char[] rotated_chars, char[] max_number) {
        for (int i = 0; i < rotated_chars.length; i++) {
            if (max_number[i] > rotated_chars[i]) {
                return true;
            }

            if (rotated_chars[i] > max_number[i]) {
                return false;
            }
        }

        return false;
    }

    private static char[] int_to_char_array(int number) {
        return String.valueOf(number).toCharArray();
    }

    public static char[] rotated_chars(char[] chars, int chars_to_move) {
        int length = chars.length;
        char[] result = new char[length];
        System.arraycopy(chars, length - chars_to_move, result, 0, chars_to_move);
        System.arraycopy(chars, 0, result, chars_to_move, length - chars_to_move);

        return result;
    }

}
