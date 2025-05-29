/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gcj.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author jalves
 */
public class Console {

    static final String     defaultDelimiters = "\\s+";
    static final int        intRadix = 10;

    private BufferedReader  in = null;
    private PrintWriter     out = null;

    private String          delimiters = defaultDelimiters;
    private Pattern         splitter = null;
    private String          line = null;
    private String[]        tokens = null;
    private int             tokenIdx = 0;

    public Console(String inputName, String outputName, boolean overwrite) {
        File f;
        InputStreamReader isr;
        OutputStreamWriter osw;

        if ((inputName == null) || inputName.equals("-")) {
            isr = new InputStreamReader(System.in/*, charset*/);
        } else {
            f = new File(inputName);
            if (f.canRead()) {
                try {
                    isr = new FileReader(f);
                } catch (FileNotFoundException ex) {
                    throw new IllegalArgumentException("Error accessing input file '" + inputName + "': Exiting...", ex);
                }
            } else {
                throw new IllegalArgumentException("Error accessing input file '" + inputName + "': Exiting...");
            }
        }

        if ((outputName == null) || outputName.equals("-")) {
            osw = new OutputStreamWriter(System.out/*, charset*/);
        } else {
            f = new File(outputName);
            try {
                if (f.createNewFile()) {
                    // new file was created
                    osw = new FileWriter(f);
                } else {
                    // file already exists
                    if (overwrite && f.canWrite()) {
                        osw = new FileWriter(f);
                    } else {
                        throw new IllegalArgumentException("Output file '" + outputName + "' already exists: Exiting...");
                    }
                }

            } catch (IOException e) {
                throw new IllegalArgumentException("Error accessing output file '" + outputName + "': Exiting...", e);
            }
        }
        in = new BufferedReader( isr );
        out = new PrintWriter( osw , true);
        delimiters = defaultDelimiters;
        splitter = Pattern.compile(delimiters);
    }

    /*************************************************
     *  Read from input
     *************************************************/

    protected String readLine() throws IOException {
        line = in.readLine();
        tokenIdx = 0;
        tokens = null;
        return line;
    }

    public boolean newLine() throws IOException {
        if (readLine() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void changeDelimiters(String newDelims) {
        if (newDelims == null) {
            delimiters = defaultDelimiters;
        } else {
            delimiters = newDelims;
        }
        splitter = Pattern.compile(delimiters);
    }

    private String[] getTokens() throws IOException {
        if (line == null) {
            if ( ! newLine()) {
                return null;
            }
        }

        tokens = splitter.split(line);
        
        return tokens;
    }

    public String[] getStrings() throws IOException {
        return getTokens();
    }

    private long    toLong(String s) {
        return Long.parseLong(s, intRadix);
    }

    public long[]   getLongs() throws IOException {
        long[] result = null;
        if (getTokens() != null) {
            result = new long[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                result[i] = toLong(tokens[i]);
            }
        }
        return result;
    }

    private double  toDouble(String s) {
        return Double.parseDouble(s);
    }

    public double[] getDoubles() throws IOException {
        double[] result = null;
        if (getTokens() != null) {
            result = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                result[i] = toDouble(tokens[i]);
            }
        }
        return result;
    }

    public String getString() throws IOException {
        if (tokens == null) {
            getTokens(); // no check to wether it returns null
        }
        if (tokenIdx >= tokens.length) {
            newLine(); // no check to wether it returns false
            getTokens(); // no check to wether it returns null
        }

        return tokens[tokenIdx++];
    }

    public long getLong() throws IOException {
        if (tokens == null) {
            getTokens(); // no check to wether it returns null
        }
        if (tokenIdx >= tokens.length) {
            newLine(); // no check to wether it returns false
            getTokens(); // no check to wether it returns null
        }

        return toLong(tokens[tokenIdx++]);
    }

    public double getDouble() throws IOException {
        if (tokens == null) {
            getTokens(); // no check to wether it returns null
        }
        if (tokenIdx >= tokens.length) {
            newLine(); // no check to wether it returns false
            getTokens(); // no check to wether it returns null
        }

        return toDouble(tokens[tokenIdx++]);
    }

    public void cleanup() {
        try {
            in.close();
        } catch (IOException ex) {
            // do nothing
        }
        out.close();
    }

    /*************************************************
     *  Write to output
     *************************************************/
    public void print(String s) {
        out.print(s);
    }

    public void println(String s) {
        out.println(s);
    }

    /*************************************************
     *  Log to console
     *************************************************/
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private Date now = new Date();
    public void logt(String s) {
        now.setTime(System.currentTimeMillis());
        System.err.println(sdf.format(now) + ": " + s);
        System.err.flush();
    }

    public void log(String s) {
        System.err.print(s);
        System.err.flush();
    }

}
