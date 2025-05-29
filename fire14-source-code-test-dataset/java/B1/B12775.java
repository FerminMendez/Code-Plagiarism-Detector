
import java.util.HashSet;
import java.util.Scanner;

public class C {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = 0;
            int bten = 1;
            for (int j = a; j <= b; j++) {
                while (j/bten*10!=0) bten*=10;
                int l = 0;
                HashSet<Integer> aa = new HashSet<Integer>();
                for (int ten = 10;j/ten>0;ten*=10) {
                    int f = j / ten;
                    int s = j % ten;
                    int m =s * (bten/ten) + f;
                    
                    if (m>j && m<=b) {
                        aa.add(m);
                    }
                }
                ans+=aa.size();
            }
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}
