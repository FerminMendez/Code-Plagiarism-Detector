import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Case {
    public int A;
    public int B;

    public Case(int a, int b)
    {
        A = a;
        B = b;
    }
}

class ProblemC {
    private String mInputFilename;
    private int T;
    private ArrayList<Case> mCases;
    
    private BufferedReader mReader;
    private BufferedWriter mWriter;
    
    public ProblemC(String inputFilename)
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
                    
                    int A = Integer.valueOf(tokens[0]);
                    int B = Integer.valueOf(tokens[1]);
                    Case item = new Case(A, B);
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

    private int getDigit(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    private int getDigitInt(int digit) {
        int num = 1;
        while (digit-1 > 0) {
            num *= 10;
            digit--;
        }
        return num;
    }

    private int getShiftedNum(int num, int digit) {
        int ret = 0;
        int digitNum = getDigitInt(digit);
        
        int top = num / digitNum;
        ret = (num%digitNum)*10 + top;
        
        return ret;
    }

    private void findWay(int seq, Case item) {
        Case in = item;

        int A = in.A;
        int B = in.B;
        
        int result = 0;
        for (int num = A; num<=B; num++) {
            int digit = getDigit(num);
//            System.out.println("num: " + num + ", digit: " + digit);
            int n = num;
            int m = n;
            for (int j = 0; j < digit-1; j++) {
               m = getShiftedNum(m, digit);
//               System.out.println("num: " + num + ", m: " + m);
                if (m > n && m <= B) {
                    System.out.println("found: (" + n + ", " + m + ")");
                    result++;
                }
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

        ProblemC solve = new ProblemC(inputFilename);
        solve.run();
   }
}
