import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bunyod Xalilov
 * Date: 4/14/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaskC {
    BufferedReader stdin;
    PrintWriter out;
    Integer n, iii, t;
    Integer[] nm, nn, mm;
    Boolean[] array;
    String str;
    List<Integer> listOfCases;


    public TaskC() {
        stdin = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public void solve() throws IOException {
        Integer[] in = readInt(1);
        n = in[0];
        nn = new Integer[n];
        mm = new Integer[n];
        array = new Boolean[1000001];
        listOfCases = new ArrayList<Integer>();
        Arrays.fill(array, true);
        for (int i = 0; i < n; i++) {
            nm = readInt(2);
            nn[i] = nm[0];
            mm[i] = nm[1];
        }

        for (int i = 0; i < n; i++) {
            iii = 0;
            for (int j = nn[i]; j <= mm[i]; j++) {
                str = String.valueOf(j);
                for (int k = 1; k < str.length(); k++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(str.substring(k, str.length()));
                    sb.append(str.substring(0, k));
                    if (!sb.toString().startsWith("0")) {
                        t = Integer.parseInt(sb.toString());
                        if (array[t] && (j < t && t <= mm[i])) {
                            array[t] = false;
                            iii++;
                        }
                    }
                }
                Arrays.fill(array, true);
            }
            out.println("Case #" + (i + 1) + ": " + iii);
        }

        out.flush();
    }

    public Integer[] readInt(int size) throws IOException {
        Integer[] result = new Integer[size];
        String[] params = stdin.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(params[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        TaskC obj = new TaskC();
        obj.solve();
        obj.stdin.close();
        obj.out.close();
    }
}
