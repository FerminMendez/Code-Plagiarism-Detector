import java.util.ArrayList;
import java.util.List;

public class JamUtil {
    static int[] parseIntList(String str, int count) {
        int[] res = new int[count];
        String[] parts = str.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            res[i] = Integer.parseInt(part);
        }
        return res;
    }

    static List<Integer> parseIntList(String str) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        String[] parts = str.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            res.add(Integer.parseInt(part));
        }
        return res;
    }

    static<T> String printTable(T[][] t) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            T[] ts = t[i];
            for (int j = 0; j < ts.length; j++) {
                T t1 = ts[j];
                res.append(t1+ " ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
