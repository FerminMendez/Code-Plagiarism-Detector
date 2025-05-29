import java.util.HashSet;

public class Recycled {

    public static void main (String[] args) {
        In in = new In("input.txt");
        int N = in.readInt();
        
        for (int i = 1; i <= N; i++) {
            int A = in.readInt();
            int B = in.readInt();
            int result = 0;
            
            for (Integer j = A; j < B; j++) {
                HashSet<String> hs = new HashSet<String>();
                String s = j.toString();
                int length = s.length();
                for (int k = 1; k < length; k++) {
                    String t = s.substring(k, length) + s.substring(0, k);
                    int newValue = Integer.parseInt(t);
                    if (newValue > j && newValue <=B) {
                        if (!hs.contains(t)) {
                            hs.add(t);
                            result++;
                        }
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
        
    }
}