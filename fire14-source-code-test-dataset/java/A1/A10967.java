import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        B th = new B();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int[] t = new int[n];
            for (int j = 0; j < n; j++) {
                t[j] = sc.nextInt();
            }
            int c = th.getAnswer(s,p,t);
            System.out.println("Case #" + (i+1) + ": " + c);
        }
    }
    public int getAnswer(int s, int p, int[] t) {
        int A1 = p + p-1+p-1;
        int A2 = p + p-2+p-2;
        if (A1 < 0)
            A1 = 0;
        if (A2 < 0)
            A2 = 1;
        int remain = s;
        int count = 0;
        int n = t.length;
        for (int i = 0; i < n; i++) {
            if (t[i] >= A1) {
                count++;
            } else if (t[i] < A1 && t[i] >= A2) {
                if (remain > 0) {
                    remain--;
                    count++;
                }
            }
        }
        return count;
    }
}

