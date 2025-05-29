import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Solver {
    
    private final static String DIR_PATH = "e:\\jam\\"; 
    private final static String IN_FILE_NAME = "B-small-attempt2.in";
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
            int participants = mScanner.nextInt();
            int surprises = mScanner.nextInt();
            int minBestScore = mScanner.nextInt();
            List<Integer> scores = new LinkedList<Integer>();
            for(int s = 0; s < participants; s++) {
                scores.add(mScanner.nextInt());
            }
            String solution = Integer.toString(solve(scores, minBestScore, surprises));
            printSolution(i + 1, solution);
        }
    }
    
    private int solve(List<Integer> scores, int minBestScore, int surprises) {
        int totalPassed = 0;
        int almostPassed = 0;
        for(Integer score : scores) {
            int maxOk = 0;
            int maxSurprise = 0;
            
            if(score > 0) {
                int scoreCase = score % 3;
                switch(scoreCase) {
                    case 0:
                        maxOk = score / 3;
                        maxSurprise = score / 3 + 1;
                        break;
                    case 1:
                        maxOk = maxSurprise = score / 3 + 1;
                        break;
                    case 2:
                        maxOk = score / 3 + 1;
                        maxSurprise = score / 3 + 2;
                        break;
                }
            } else {
                maxOk = 0;
                maxSurprise = 0;
            }
            
            if(maxOk >= minBestScore) {
                totalPassed++;
            } else if(maxSurprise >= minBestScore) {
                almostPassed++;
            }
        }
        totalPassed += Math.min(surprises, almostPassed);
        return totalPassed;
    }
}
