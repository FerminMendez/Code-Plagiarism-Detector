import java.util.Scanner;
class abc {
    public static void main (String argv []) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j=1;j<=t;j++) {
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            p=p*3;
            int ans=0;
            for (int i=0;i<n;i++) {
                int temp = in.nextInt();
                if (temp>=p-4) {
                    if (temp>p-3) {
                        ans++;
                    } else {
                        if (s>0 && (p!=3 || temp!=0)) {
                            s--; ans++;
                        }
                    }
                }
            }
            System.out.println("Case #"+j+": "+ans);
        }
    }
}