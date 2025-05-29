package qualification.Dancing;

import java.io.*;

public class IO {

    /**
     * Reads a line of text from the input.
     *
     * @return The text entered. @comp Best and worst case are O(U) where U is
     * the complexity of BufferedReader.readLine method for the input.
     */
    public static String readln() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);

        try {
            return keyboard.readLine();
        } catch (IOException e) {
            println("Unexpected exception while reading input.");
        }
        return null;
    }

    /**
     * Terminates the current line by writing the line separator string. The
     * line separator string is defined by the system property line.separator,
     * and is not necessarily a single newline character ('\n').
     *
     * @pre none @post none @complexity Best and worst case are the same. Time
     * complexity is U where U is the complexity for System.out.println()
     * method.
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Prints a string. If the argument is null then the string "null" is
     * printed. Otherwise, the string's characters are converted into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the write(int) method.
     *
     * @param s The string to print. @complexity Best and worst case are the
     * same. Time complexity is U where U is the complexity for
     * System.out.print(String) method. @pre none @post none
     */
    public static void print(String s) {
        System.out.print(s);
    }

    /**
     * Prints a String and then terminate the line. This method behaves as
     * though it invokes print(String) and then println().
     *
     * @param s The string to print. @complexity Best and worst case are the
     * same. Time complexity is U where U is the complexity for
     * System.out.print(String) method. @pre none @post none
     */
    public static void println(String s) {
        print(s);
        println();
    }

    public static int readInt() {
        try {
            int val = Integer.parseInt(readln());

            return val;
        } catch (NumberFormatException ex) {
            println("Not an integer.");
        }

        return -1;
    }
}