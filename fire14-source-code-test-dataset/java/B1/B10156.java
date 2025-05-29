import java.util.*;
public class C {
    public static String shift(String a, int d) {
        String end = a.substring(d, a.length());
        String start = a.substring(0, d);
        return end + start;
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
        for (int ca = 0; ca < t; ca++) {
            long ct = 0;
            int A = s.nextInt(), B = s.nextInt();
            for (int a = A; a <= B; a++) {
                String astr = ""+a;
                HashSet<String> seen = new HashSet<String>();
                for (int l = 1; l < astr.length(); l++) {
                    String shift = shift(astr, l);
                    
                    int c = Integer.parseInt(shift);
                    if (!seen.contains(shift) && a < c && c <= B) {
                        seen.add(shift);
                        ct++;
                    }
                }
            }
            System.out.printf("Case #%d: %d\n",ca+1,ct);
        }
	}
}
