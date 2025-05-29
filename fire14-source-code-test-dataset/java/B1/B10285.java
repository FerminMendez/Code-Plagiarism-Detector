import java.util.*;

public class Recycled {
    public static void main(String[] args) throws Exception {


        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        for (int t = 0; t < T; t++) {
            int A = s.nextInt();
            int B = s.nextInt();
            long[] values = new long[B + 1];

            Set<Pair> set = new HashSet<Pair>();

            for (int i = A; i <= B; i++) {
                String istr = "" + i;
                for (int j = 1; j < istr.length(); j++) {
                    String prefix = istr.substring(istr.length() - j, istr.length());
                    String suffix = istr.substring(0, istr.length() - j);
//                    Set<Integer> set = new HashSet<Integer>();
                    if (prefix.charAt(0) != '0') {
                        String newNumber = prefix + suffix;
                        int newNumberInt = Integer.parseInt(newNumber);
//                        System.out.println(newNumberInt);
                        if (newNumberInt > i && newNumberInt <= B
                                && String.valueOf(i).length() == String.valueOf(newNumberInt).length()) {
//                            if (set.contains(newNumberInt))
//                                System.out.println(newNumberInt);
//                            set.add(newNumberInt);
                            values[newNumberInt] += 1;
                            Pair p = new Pair(i, newNumberInt);
                            set.add(p);
//                            System.out.println("(" + i + ", " + newNumberInt + ")");
                        }
                    }
                }
            }

            long sum = 0;
            for (int i = A; i <= B; i++) {
                sum += values[i];
            }
            System.out.println("Case #" + (t + 1) + ": " + set.size());
        }
    }
}

class Pair {

    int n;
    int m;

    public Pair(int n, int m) throws Exception {
        if (n >= m)
            throw new Exception();

        this.n = n;
        this.m = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (m != pair.m) return false;
        if (n != pair.n) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = n;
        result = 31 * result + m;
        return result;
    }
}