import java.io.*;
import java.util.*;
import java.math.*;

//4/14/12 11:29 PM
//by Abrackadabra

public class RecycledNumbers {
    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("Abra")) debugMode = true;
        new RecycledNumbers().run();
        /*new Thread(null, new Runnable() {
            public void run() {
                try {
                    new RecycledNumbers().run();
                } catch (IOException e) {
   #                 e.printStackTrace();
                }
            }
        }, "1", 1 << 24).start();*/
    }

    int IOMode = 0; //0 - consoleIO, 1 - <taskName>.in/out, 2 - input.txt/output.txt, 3 - test case generator
    String taskName = "";

    void solve() throws IOException {
        int T = nextInt();
        for (int Ti = 1; Ti <= T; Ti++) {
            int a = nextInt(), b = nextInt();
            int res = 0;
            for (int i = a; i <= b; i++) {
                String q = Integer.toString(i);
                if (q.length() == 1) continue;
                for (int j = 0; j < q.length(); j++) {
                    q = q.substring(1) + q.charAt(0);
                    if (q.charAt(0) == '0') continue;
                    if (Integer.parseInt(q) == i) break;
                    if (Integer.parseInt(q) > i && Integer.parseInt(q) <= b)
                        res++;
                }
            }
            out.println("Case #" + Ti + ": " + res);
        }
    }

    long startTime = System.nanoTime(), tempTime = startTime, finishTime = startTime;
    long startMem = Runtime.getRuntime().totalMemory(), finishMem = startMem;

    void run() throws IOException {
        init();
        if (debugMode) {
            con.println("Start");
            con.println("Console:");
        }
        solve();
        finishTime = System.nanoTime();
        finishMem = Runtime.getRuntime().totalMemory();
        out.flush();
        if (debugMode) {
            int maxSymbols = 1000;
            BufferedReader tbr = new BufferedReader(new FileReader("input.txt"));
            char[] a = new char[maxSymbols];
            tbr.read(a);
            if (a[0] != 0) {
                con.println("File input:");
                con.println(a);
                if (a[maxSymbols - 1] != 0) con.println("...");
            }
            tbr = new BufferedReader(new FileReader("output.txt"));
            a = new char[maxSymbols];
            tbr.read(a);
            if (a[0] != 0) {
                con.println("File output:");
                con.println(a);
                if (a[maxSymbols - 1] != 0) con.println("...");
            }
            con.println("Execution time: " + (finishTime - startTime) / 1000000000.0 + " sec");
            con.println("Used memory:    " + (finishMem - startMem) + " bytes");
            con.println("Total memory:   " + Runtime.getRuntime().totalMemory() + " bytes");
        }
    }

    boolean tick(double x) {
        if (System.nanoTime() - tempTime > x * 1e9) {
            tempTime = System.nanoTime();
            con.println("Tick at " + (tempTime - startTime) / 1000000000 + " sec");
            con.print("   ");
            return true;
        }
        return false;
    }

    static boolean debugMode = false;
    PrintStream con = System.out;

    void init() throws IOException {
        if (debugMode && IOMode != 3) {
            br = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
        } else
            switch (IOMode) {
                case 0:
                    br = new BufferedReader(new InputStreamReader(System.in));
                    out = new PrintWriter(System.out);
                    break;
                case 1:
                    br = new BufferedReader(new FileReader(taskName + ".in"));
                    out = new PrintWriter(new FileWriter(taskName + ".out"));
                    break;
                case 2:
                    br = new BufferedReader(new FileReader("input.txt"));
                    out = new PrintWriter(new FileWriter("output.txt"));
                    break;
                case 3:
                    out = new PrintWriter(new FileWriter("input.txt"));
                    break;
            }
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer in;

    boolean hasMoreTokens() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return false;
            in = new StringTokenizer(line);
        }
        return true;
    }

    String nextString() throws IOException {
        return hasMoreTokens() ? in.nextToken() : null;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }
}