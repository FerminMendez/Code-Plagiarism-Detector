import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        C th = new C();
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int c = th.getAnswer(A, B);
            System.out.println("Case #" + (i+1) + ": " + c);
        }
    }
    public int getAnswer(int A, int B) {
        if (A == B) {
            return 0;
        }
        int count = 0;
        for (int i = A; i < B; i++) {
            String s = "" + i;
            int l = s.length();
            int[] it = new int[l];
            for (int j = 0; j < l; j++) {
                String t = getRotate(s, j+1);
                it[j] = Integer.parseInt(t);
                if (it[j] <= B && it[j] > i) {
                    boolean f = true;
                    for (int k = 0; k < j; k++) {
                        if (it[k] == it[j])
                            f = false;
                    }
                    if (f)
                        count++;
                }
            }
        }
        return count;
    }
    public String getRotate(String s, int r) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        char[] buf = new char[n];
        for (int i = 0; i < r; i++) {
            buf[n-r+i] = ch[i];
        }
        for (int i = 0; i < n-r; i++) {
            buf[i] = ch[r+i];
        }
        return new String(buf);
    }
}

