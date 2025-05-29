import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solver {
    
    private final static String DIR_PATH = "e:\\jam\\"; 
    private final static String IN_FILE_NAME = "C-small-attempt0.in";
    private final static String OUT_FILE_NAME = IN_FILE_NAME.replaceAll("\\..*$", ".out");
    
    private final static File sInFile = new File(DIR_PATH, IN_FILE_NAME);
    private final static File sOutFile = new File(DIR_PATH, OUT_FILE_NAME);
        
    private final PrintStream mOut;
    private final Scanner mScanner;
    
    private static class ProxyOutputStream extends FilterOutputStream {
        public ProxyOutputStream(OutputStream out) {
            super(out);
        }
        
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            System.out.write(b, off, len);
            super.write(b, off, len);
        }        
    }
    
    public static void main(String[] args) {        
        try {
            Solver solver = new Solver(sInFile, sOutFile);
            solver.solve();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    public Solver(File inFile, File outFile) throws IOException {
        mScanner = new Scanner(inFile);
        mOut = new PrintStream(new ProxyOutputStream(new FileOutputStream(outFile)));
    }
    
    private void printSolution(int no, String solution) {
        if(no == 0) {
            throw new IllegalArgumentException("Solution number is 0! Should start with 1!");
        }
        mOut.println(String.format("Case #%d: %s", no, solution));
    }
    
    private void solve() throws IOException {
        int problemsCount = mScanner.nextInt();
        mScanner.nextLine();
        for(int i = 0; i < problemsCount; i++) {
            long min = mScanner.nextLong();
            long max = mScanner.nextLong();
            String solution = Long.toString(solve(min, max));
            printSolution(i + 1, solution);
        }
    }
    
    int convert(int [] digits, int d0, long number) {
        while(number > 0) {
            digits[d0] = (int)(number % 10);
            d0--;
            number /= 10;
        }
        return d0 + 1;
    }
    
    long convertToInt(int [] digits, int d0, int dlen) {
        long number = 0;
        for(int i = 0; i < dlen; i++) {
            number = number * 10 + digits[d0 + i]; 
        }
        return number;
    }
    
    //true if r > d
    boolean isGreater(int [] r, int r0, int [] d, int d0, int len) {
        for(int i = 0; i < len; i++) {
            int delta = r[r0 + i] - d[d0 + i];
            if(delta > 0) {
                return true;
            } else if(delta < 0) {
                return false;
            }
        }
        return false;
    }
    
    private long solve(long min, long max) {
        if(max < 10) {
            return 0;
        }
        
        long counter = 0;
        
        int [] max_digits = new int[8];
        int max_d0 = convert(max_digits, max_digits.length - 1, max);
        
        int [] digits = new int [7 + 1 + 7];
        int d0 = 7;//points to least significant digit in array
                
        Set<Long> unique = new HashSet<Long>();
        for(long number = min; number <= max; number++) {
            unique.clear();
            
            /* convert number to array */
            int n0 = convert(digits, d0, number);
            int dlen = d0 - n0 + 1; 
            
            /* duplicate digits */
            for(int i = 0; i < dlen - 1; i++) {
                digits[d0 + i + 1] = digits[n0 + i];
            }
                        
            /* count recycled numbers */
            boolean printed = false;
            for(int i = 0; i < dlen - 1; i++) {
                
                int r0 = n0 + i + 1;//r0 for current recycled number
                //print(digits, r0, dlen);
                if(digits[r0] == 0) {
                    //System.out.println(" - nope, leading zero.");
                    continue;//invalid case 
                }
                
                /* is recycled number greater than original one? */
                boolean greater = isGreater(digits, r0, digits, n0, dlen);
                /* is recycled number grater than max? */
                boolean valid = !isGreater(digits, r0, max_digits, max_d0, dlen);
                
                if(greater && valid) {
                    //System.out.println(" - yes.");
                    if(!printed) {
                        //print(digits, n0, dlen);
                        //System.out.println(" => ");
                        printed = true;
                    }
                    //System.out.print("  ");
                    //print(digits, r0, dlen);
                    
                    unique.add(convertToInt(digits, r0, dlen));
                } else {
                    if(!greater) {
                        //System.out.println(" - nope, not greater than original.");
                    } else {
                        //System.out.println(" - nope, greater than max.");
                    }
                }
            }
            if(printed) {
                //System.out.println();
            }
            counter+=unique.size();
            //System.out.println("----");
        }        
        return counter;
    }
    
    void print(int [] digits, int d0, int dlen) {
        for(int i = d0; i < d0 + dlen; i++) {
            System.out.print(digits[i]);
        }
    }
    
    void println(int [] digits, int d0, int dlen) {
        print(digits, d0, dlen);
        System.out.println();
    }
}
