import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Puzzle3 {

    public static String parseString(int q, String A) {
        String tmp = A.substring(q+1, A.length()) + A.substring(0,q+1);
        return tmp;
    }
    
    public static boolean isReclycled(String A, String B) {
        for(int i=0; i<A.length(); i++) {
            if(parseString(i, A).equals(B)) {
                return true;
            }
        }
        return false;
    }

    //O(n*m)
    public static int countRecyclesBetween(int A, int B) {
        int count = 0;
        for (int i=A; i< B; i++) {
            for(int j = i+1; j<= B; j++) {
                if(i == j ) continue;
                if(isReclycled(String.valueOf(i), String.valueOf(j))) {
                    count++;
                }
            }
        }
        
        return count;
    }


    private static String executeTestCase(String input) {

        String strOutput = "";
        BufferedReader in = new BufferedReader(new StringReader(input));
        int testCases = 0;
        try {
            testCases = Integer.valueOf(in.readLine());
        } catch (IOException e) {
            return "Invalid test case input at line 1";
        }

        try {
            if (testCases > 0) {
                for (int i = 1; i <= testCases; i++) {
                    String lines[] = in.readLine().split(" ");
                    int n = Integer.valueOf(lines[0]);
                    int m = Integer.valueOf(lines[1]);
                    strOutput+="Case #" + i + ": " + countRecyclesBetween(n,m) + "\n";
                }
            }
        } catch (Exception e) {
            return "Invalid test case input";
        }

        return strOutput.toString();

    }

    public static void main(String[] args) {

        String input = "50\n" +
                "3 4\n" +
                "156 971\n" +
                "302 482\n" +
                "163 919\n" +
                "148 941\n" +
                "19 59\n" +
                "109 959\n" +
                "140 945\n" +
                "155 963\n" +
                "137 975\n" +
                "172 928\n" +
                "12 37\n" +
                "123 933\n" +
                "113 925\n" +
                "444 756\n" +
                "10 11\n" +
                "112 977\n" +
                "143 938\n" +
                "149 997\n" +
                "158 938\n" +
                "104 957\n" +
                "117 928\n" +
                "159 967\n" +
                "171 951\n" +
                "128 921\n" +
                "676 676\n" +
                "440 440\n" +
                "125 939\n" +
                "116 949\n" +
                "100 100\n" +
                "10 99\n" +
                "117 950\n" +
                "128 972\n" +
                "158 938\n" +
                "178 941\n" +
                "143 975\n" +
                "100 999\n" +
                "956 969\n" +
                "176 938\n" +
                "124 966\n" +
                "181 967\n" +
                "190 956\n" +
                "145 940\n" +
                "187 994\n" +
                "167 996\n" +
                "167 921\n" +
                "135 916\n" +
                "156 926\n" +
                "170 994\n" +
                "103 955\n";
        

        System.out.println(executeTestCase(input));

    }
}
