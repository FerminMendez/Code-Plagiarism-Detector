import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B implements Runnable {
    private static BufferedReader reader;
    private static StreamTokenizer st;
    private static PrintWriter writer;

    public static void main(String[] args) {
        new Thread(new B()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {}
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new FileReader("b.in"));
        st = new StreamTokenizer(reader);
        writer = new PrintWriter(new FileWriter("b.out"));

        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            int temp = countAns();
            writer.println("Case #" + i + ": " + temp);
        }

        reader.close();
        writer.close();
    }

    static String nextToken() throws IOException {
        st.nextToken();
        return st.sval;
    }

    static int nextInt() throws NumberFormatException, IOException {
        st.nextToken();
        return (int)st.nval;
    }

    private static int countAns() throws IOException{
        int n = nextInt();
        int s = nextInt();
        int p = nextInt();
        //writer.print(String.valueOf(n) + " " + String.valueOf(s) + " " + String.valueOf(p) + " ");

        ArrayList<Integer> num = new ArrayList<Integer>(n);
        int nonSurprisingNum = 0;
        for (int i = 0; i < n; i++) {
            int temp = nextInt();
            //writer.print(String.valueOf(temp) + " ");
            num.add(temp);
        }

        if (p == 0) return n;

        int nonSurprisingFrame = p + 2 * (p - 1);
        for (int i = 0; i < num.size(); i++) {
            int curNum = num.get(i);
            if (curNum >= nonSurprisingFrame) {
                nonSurprisingNum++;
                num.remove(i);
                i--;
            }
        }
        if (s == 0) return nonSurprisingNum;

        int surprisingFrame = Math.max(0, p + 2 * (p - 2));
        int len = num.size();
        int cnt = 0;
        while (s > 0 && cnt < len) {
            int curNum = num.get(cnt);
            if (curNum > 0 && curNum >= surprisingFrame) {
                s--;
                nonSurprisingNum++;
            }
            cnt++;
        }

        return nonSurprisingNum;
    }

}