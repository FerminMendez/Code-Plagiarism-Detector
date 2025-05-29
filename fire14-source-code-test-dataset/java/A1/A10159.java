import java.util.*;
public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int ca = 1; ca <= T; ca++) {
            int N = s.nextInt(), S = s.nextInt(), p = s.nextInt();
            int good = 0, used =0;
            for (int j = 0; j < N; j++) {
                int t = s.nextInt();
                int x = t/3;
                if (t%3==0) {
                    if (p==x+1 && x>0 && x<10 && used<S) {
                        good++;
                        used++;
                    } else if (p<x+1) {
                        good++;
                    }
                } else if (t%3==1) {
                    if (p<=x+1) good++;
                } else {
                    if (p==x+2 && x<9 && used<S) {
                        good++;
                        used++;
                    } else if (p<x+2) {
                        good++;
                    }
                }
            }
            System.out.printf("Case #%d: %d",ca,good);
            System.out.println();
        }
    }
} 
