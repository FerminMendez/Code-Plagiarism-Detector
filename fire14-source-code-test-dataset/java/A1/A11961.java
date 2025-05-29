import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Case {
    public int N;
    public int[] t;
    public int S;
    public int P;

    public Case(int n, int s, int p)
    {
        N = n;
        t = new int[n];
        S = s;
        P = p;
    }
    
    public void sort()
    {
        if (t == null) {
            System.out.println("no init yet");
            return;
        }
        
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (t[i] > t[j]) {
                    int tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                }
            }
        }
    }
}

class ProblemB {
    private String mInputFilename;
    private int T;
    private ArrayList<Case> mCases;
    
    private BufferedReader mReader;
    private BufferedWriter mWriter;
    
    public ProblemB(String inputFilename)
    {
        T = 0;
        mCases = null;
        mInputFilename = inputFilename;
    }

    private boolean openFiles() {
        if (mInputFilename != null) {
            try {
                mReader = new BufferedReader(new FileReader(mInputFilename));
                mWriter = new BufferedWriter(new FileWriter(mInputFilename.replace("in", "out")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }
    
    private void closeFiles() {
        try {
            mReader.close();
            mWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean readInput()
    {
        if (mReader != null) {
            try {
                String line;
                
                // number of test cases
                line = mReader.readLine();
                T = Integer.valueOf(line);
                System.out.println("Cases: " + T);
                mCases = new ArrayList<Case> ();

                // read input cases
                for (int i = 0; i<T; i++) {
                    line = mReader.readLine();
                    String[] tokens = line.split(" ");
                    
                    int N = Integer.valueOf(tokens[0]);
                    int S = Integer.valueOf(tokens[1]);
                    int P = Integer.valueOf(tokens[2]);
                    Case item = new Case(N, S, P);
                    for (int j = 3; j<tokens.length; j++)
                        item.t[j-3] = Integer.valueOf(tokens[j]);
                    mCases.add(item);
                }
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
    private int writeOutput(int caseNum, int  result)
    {
        try {
            mWriter.write("Case #" + (caseNum+1) + ": " + result + "\n");
            System.out.print("Case #" + (caseNum+1) + ": " + result + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void findWay(int seq, Case item) {
        Case in = item;

        in.sort();
        int S = in.S;
        int P = in.P;
        
        int result = 0;
        for (int i = 0; i<in.N; i++) {
            int base = in.t[i] / 3;
            int remains = in.t[i] % 3;
            int max = base;
            int available = 0;

            if (S > 0) {
                if (base > 0)
                    available = (remains == 2? 2: 1);
            } else {
                available = remains > 0? 1: 0;
            }

            max += available;
            if (max >= in.P) {
                result++;
                if (S>0)
                    S--;
            }
        }
        writeOutput(seq, result);
    }

    // test run main
    public void run()
    {
        openFiles();
        readInput();
        
        for (int i = 0; i<T; i++) {
            Case item = mCases.get(i);
            findWay(i, item);
        }
        
        closeFiles();
    }
}

public class MainRunner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String inputFilename;
        if (args.length > 0)
            inputFilename = new String(args[0]);
        else 
            inputFilename = new String("sample.in");

        ProblemB solve = new ProblemB(inputFilename);
        solve.run();
   }
}
