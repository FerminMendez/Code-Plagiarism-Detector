package com.bertramtruong.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class provides advanced reading capabilities to files.
 * @author Bertram
 */
public class DataReader {

    /**
     * Character codes that define whitespace characters.
     */
    private final int[] WHITESPACE_CODES = new int[]{-1, 10, 13, 32};
    /**
     * Stores the working file.
     */
    private File file;
    /**
     * Stores the active reader for the file.
     */
    private BufferedReader br;

    /**
     * Instantiate a new DataReader object.
     * @param fileName - the string containing the file path to the input file.
     */
    public DataReader(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.err.println("'" + fileName + "' does not exist.");
            return;
        }
        file = f;

        try {
            // create the bufferedreader
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException x) {
            System.err.println("File was not found...");
        }
    }

    /**
     * Reads a line from the file.
     * @param skipWS - whether to skip whitespace characters
     * @return - a string containing a line from the file
     * @throws IOException 
     */
    public String readLine(boolean skipWS) throws IOException {
        if (br != null) {
            if (skipWS) {
                this.skipWhitespace();
            }
            return br.readLine();
        } else {
            System.err.println("BufferedReader not initialized...");
            return "";
        }
    }

    public String readLine() throws IOException {
        return readLine(true);
    }

    /**
     * Reads the next integer from a file.
     * @param skipWS - whether to skip whitespace characters
     * @return - the next integer in the file
     * @throws IOException 
     */
    public int readInt(boolean skipWS) throws IOException {
        if (br != null) {
            if (skipWS) {
                this.skipWhitespace();
            }
            StringBuilder sb = new StringBuilder();
            int code = br.read();
            while (Arrays.binarySearch(WHITESPACE_CODES, code) < 0) {
                sb.append((char) code);
                code = br.read();
            }
            return Integer.parseInt(sb.toString());
        } else {
            System.err.println("BufferedReader not initialized...");
            return -1;
        }
    }

    public int readInt() throws IOException {
        return readInt(true);
    }

    /**
     * Reads the next character from the file.
     * @param skipWS - whether to skip whitespace characters
     * @return - the next character in the file
     * @throws IOException 
     */
    public char readChar(boolean skipWS) throws IOException {
        if (br != null) {
            if (skipWS) {
                this.skipWhitespace();
            }
            int code = br.read();
            char c = (char) code;
            return c;
        } else {
            System.err.println("BufferedReader not initialized...");
            return ' ';
        }
    }

    public char readChar() throws IOException {
        return readChar(true);
    }

    /**
     * Reads the next boolean in the file.
     * @param skipWS - whether to skip whitespace characters
     * @return - the next boolean in the file
     * @throws IOException 
     */
    public boolean readBoolean(boolean skipWS) throws IOException {
        if (br != null) {
            int n = readInt(skipWS);
            return (n >= 1 ? true : false);
        } else {
            System.err.println("BufferedReader not initialized...");
            return false;
        }
    }

    public boolean readBoolean() throws IOException {
        return readBoolean(true);
    }

    /**
     * Reads the next string from the file.
     * @param skipWS - whether to skip whitespace characters
     * @return - the next string from the file
     * @throws IOException 
     */
    public String readString(boolean skipWS) throws IOException {
        if (br != null) {
            if (skipWS) {
                skipWhitespace();
            }

            // holds the string
            StringBuilder sb = new StringBuilder();

            // read a char
            char c;
            while ((c = readChar(false)) != ' ') {
                sb.append(c);
            }

            // return
            return sb.toString();
        } else {
            System.err.println("BufferedReader not initialized...");
            return "";
        }
    }

    public String readString() throws IOException {
        return readString(true);
    }

    /**
     * Skip the following whitespace characters so that the pointer/caret goes to the next non-whitespace character.
     * @throws IOException 
     */
    public void skipWhitespace() throws IOException {
        if (br != null) {
            int counter = 0;
            br.mark(16); // marker so we can reset
            int code = br.read();
            while (Arrays.binarySearch(WHITESPACE_CODES, code) >= 0) {
                counter++;
                code = br.read();
            }
            // we know how many to skip now, so reset and skip
            br.reset();
            br.skip(counter);
        } else {
            System.err.println("BufferedReader not initialized...");
            return;
        }
    }
}
