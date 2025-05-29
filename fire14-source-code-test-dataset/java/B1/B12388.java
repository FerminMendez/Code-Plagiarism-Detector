import java.util.ArrayList;
import java.util.Collection;

/**
 * User: avokin
 * Date: 4/14/12
 */
public class ProblemC {
    private static int[] deg = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};

    private static int recycled(int a, int b, int n) {
        int result = 0;
        int i = 1;
        Collection<Integer> counted = new ArrayList<Integer>();
        while (i < n) {
            int a1 = a / deg[i];
            int a2 = a % deg[i];
            int a3 = a2 * deg[n - i] + a1;
            if (a < a3 && a3 <= b) {
                if (!counted.contains(a3)) {
                    result++;
                }
                counted.add(a3);
            }
            i++;
        }
        return result;
    }

    private static int solve(int a, int b) {
        int result = 0;
        int n = ("" + a).length();
        for (int i = a; i < b; i++) {
            result += recycled(i, b, n);
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "50\n" +
                "173 996\n" +
                "166 983\n" +
                "130 970\n" +
                "172 382\n" +
                "15 28\n" +
                "150 943\n" +
                "10 11\n" +
                "116 976\n" +
                "100 999\n" +
                "158 918\n" +
                "142 946\n" +
                "178 963\n" +
                "147 923\n" +
                "167 965\n" +
                "28 28\n" +
                "174 362\n" +
                "100 914\n" +
                "164 982\n" +
                "104 990\n" +
                "185 990\n" +
                "114 940\n" +
                "3 4\n" +
                "147 980\n" +
                "100 999\n" +
                "104 993\n" +
                "146 967\n" +
                "138 916\n" +
                "10 10\n" +
                "163 983\n" +
                "76 99\n" +
                "917 917\n" +
                "155 994\n" +
                "562 858\n" +
                "162 933\n" +
                "164 913\n" +
                "162 947\n" +
                "113 928\n" +
                "164 911\n" +
                "140 995\n" +
                "167 927\n" +
                "137 974\n" +
                "142 953\n" +
                "156 922\n" +
                "104 999\n" +
                "162 965\n" +
                "124 962\n" +
                "175 919\n" +
                "141 960\n" +
                "168 982\n" +
                "109 920\n";

        String[] lines = input.split("\n");
        int T = Integer.parseInt(lines[0]);
        for (int i = 1; i <= T; i++) {
            String line = lines[i];
            String[] items = line.split(" ");
            int a = Integer.parseInt(items[0]);
            int b = Integer.parseInt(items[1]);
            int solution = solve(a, b);
            System.out.println("Case #" + i + ": " + solution);
        }

    }
}
