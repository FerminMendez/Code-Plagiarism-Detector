import java.io.*;
import java.util.InputMismatchException;

public class qualifierQ2 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = null;
        File file = null;
        try {
            if (Boolean.getBoolean("toFile")) {
                file = new File("solQualifierQ2.out");
                printStream = new PrintStream(file);
            } else
                printStream = System.out;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.setOut(printStream);
        InputStream is;
        if (args.length != 0)
            is = new FileInputStream(args[0]);
        else
            is = System.in;

        InputReader in = new StreamInputReader(is);
        PrintWriter out = new PrintWriter(System.out);
        run(in, out);

        if (Boolean.getBoolean("toFile")) {
            out.println("wrote to:\n" + file.getAbsolutePath());
        }
    }

    public static void run(InputReader in, PrintWriter out) {
        qualifierQ2 solver = new qualifierQ2();
        int testCount = in.readInt();
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        exit(in, out);
    }

    public static void exit(InputReader in, PrintWriter out) {
        in.setFinished(true);
        in.close();
        out.close();
    }


    abstract static class InputReader {
        private boolean finished = false;

        public abstract int read();

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

        public String readWord() {
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

        public String readNextLine() {
            int c = read();
            while (isSpaceChar(c) /*&& !isNewLine(c)*/)
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (isNewLine(c));
            return res.toString();
        }

        private boolean isNewLine(int c) {
            return (c != '\n' && c != '\r');
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public abstract void close();
    }

    static class StreamInputReader extends InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar, numChars;

        public StreamInputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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

        public void close() {
            try {
                stream.close();
            } catch (IOException ignored) {
            }
        }
    }

    static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;

        public static <U, V> Pair<U, V> makePair(U first, V second) {
            return new Pair<U, V>(first, second);
        }

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            return !(first != null ? !first.equals(pair.first) : pair.first != null) && !(second != null ? !second.equals(pair.second) : pair.second != null);

        }

        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public String toString() {
            return "(" + first + "," + second + ")";
        }

        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) first).compareTo(o.first);
            if (value != 0)
                return value;
            return ((Comparable<V>) second).compareTo(o.second);
        }
    }
    /*******************************************************************/
    /*******************************************************************/
    /**
     * ***************************************************************
     */
    public void solve(int testNumber, InputReader in, PrintWriter out) {


        int N = in.readInt();
        int sup = in.readInt();
        int P = in.readInt();//the target

        int found = 0;

        int[] sti = new int[N];
        for (int indx = 0; indx < N; indx++) {
            int currNum = in.readInt();
            sti[indx] = currNum;
            if (currNum / 3 >= P)
                found++;
            else {
                if (currNum / 3 == (P - 1)) {
                    if (currNum % 3 >= 1)
                        found++;//just different
                    else
                    //iv      currNum%3!=0

                    {//could be suprizing! like 4 5 6
                        if (sup > 0 && P > 1) {
                            sup--;
                            found++;
                        }
                    }
                } else if (currNum / 3 == (P - 2) && currNum % 3 == 2 && P > 1)//could be supprizing like 4 4 6
                {
                    if (sup > 0) {
                        sup--;
                        found++;
                    }
                }
            }
        }


        out.format("Case #%d: %d\n", testNumber, found);
    }
    /*******************************************************************/
    /*******************************************************************/
    /*******************************************************************/
}
