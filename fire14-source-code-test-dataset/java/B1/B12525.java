import java.util.*;

public class Recycled {

    private static int solve(int A, int B) {
        int count = 0;
        HashSet<Integer> s = new HashSet<Integer>();

        for (int n = A; n < B; n++) {
            String i = n + "";
            s.clear();
            int t = i.length();

            while (i.charAt(t-1) == '0')
                t--;
            
            for (int j = 1; j < t; j++) {
                int m = Integer.parseInt(i.substring(j) + i.substring(0, j));
                if (n < m && m <= B)
                    s.add(m);
            }
            
            count += s.size();
        }

        return count;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Case #" + (i+1) + ": " + 
                               solve(in.nextInt(), in.nextInt()));
        }
    }
}
