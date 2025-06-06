import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 * Created by César Passoni
 */
public class TaskB implements Runnable
{
    private InputReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Thread(new TaskB()).start();
    }

    public TaskB() {
        try {
            String fileName;
//            fileName = "sampleB.in";
            fileName = "B-small-attempt9.in";
            //fileName = "B-large.in";

            System.setIn(new FileInputStream(fileName));
            System.setOut(new PrintStream(new FileOutputStream(fileName.replace("in", "out"))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
    }

    public void run() {
        int numTests = in.readInt();
        for (int testNumber = 0; testNumber < numTests; testNumber++) {
            out.print("Case #" + (testNumber + 1) + ": ");
            int n = in.readInt();
            int s = in.readInt();
            int p = in.readInt();

            boolean surprise = s!=0;
            int count = 0;
            int countSurprise = 0;
            for (int i = 0 ; i < n ; i ++)
            {
                int testCase = in.readInt();

                if (testCase == 0)
                {
                    if (p == 0)
                    {
                        count ++;
                    }
                }
                else if (testCase >= (p*3-2))
                {
                    count ++;
                }

                else if (testCase >= (p*3-4) && surprise)
                    {
                        count ++;
                        countSurprise ++;
                        if (countSurprise >= s)
                        {
                            surprise = false;
                        }
                    }

//                if (testCase == 0)
//                {
//                    if (s == 0)
//                    {
//                        count ++;
//                    }
//                }
//
//                else if (testCase%3 == 0)
//                {
//                    if ((testCase/3 ) >= p)
//                    {
//                        count ++;
//                    }
//                    else if ((testCase/3 + 1) >= p && surprise)
//                    {
//                        count ++;
//                        countSurprise ++;
//                        if (countSurprise >= s)
//                        {
//                            surprise = false;
//                        }
//                    }
//
//                }
//                else
//                {
//                    if ((testCase/3 + 1) >= p)
//                    {
//                        count ++;
//
//                    }
//                    else if ((testCase/3 + 2) >= p && surprise)
//                    {
//                        count ++;
//                        countSurprise ++;
//                        if (countSurprise >= s)
//                        {
//                            surprise = false;
//                        }
//                    }
//                }

            }
//            System.out.println("CASE " + (testNumber + 1) +"countSurprise " +countSurprise + " s  " + s);
            out.println(count);

        }
        out.close();
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1000];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0)
                s = readLine0();
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines)
                return readLine();
            else
                return readLine0();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
    }
}
