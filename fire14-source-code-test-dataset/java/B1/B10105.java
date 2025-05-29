import java.io.FileInputStream;
import java.util.*;

public class Q_C {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileInputStream("C:\\C-small-attempt0.in"));
        Set<String> set = new HashSet<String>();
        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j < b; j++) {
                List<Integer> list = getRecycledNumbers(j);
                for (int k : list) {
                    if (k > j && k <= b) {
                        set.add(j + " " + k);
                    }
                }
            }

            System.out.println("Case #" + (i+1) + ": " + set.size());
            set.clear();

        }

    }

    private static List<Integer> getRecycledNumbers(int num) {
        List<Integer> list = new ArrayList<Integer>();
        String s = String.valueOf(num);
        for (int i = s.length() - 1; i > 0; i--) {
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            if (!temp.startsWith("0")) {
                int cur = Integer.valueOf(temp);
                list.add(cur);
            }
        }
        return list;
    }

}
