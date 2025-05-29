import java.util.*;
public class ProblemB {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            String ans="";
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int higher = 0;
            int border = 0;
            for (int n=0; n<N; n++) {
                int point = sc.nextInt();
                int ave   = (int)(Math.ceil(point/3.0));
                if ( ave >= p) higher++;
                else if (p-1 != 0 && ave == p-1 && point%3 != 1) border++;
            }
            if(border >= S){
              System.out.println("Case #" +t+ ": " +(higher+S));
            } else {
              System.out.println("Case #" +t+ ": " +(higher+border));
            }
        }
    }
}
