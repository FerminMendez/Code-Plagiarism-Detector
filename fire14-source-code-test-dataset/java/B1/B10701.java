import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class go3 {

    public static final String IN_FILE = "C-small-attempt0.in";
    public static final String OUT_FILE = "out.txt";


    public static void main(String[] args) throws Throwable {

        try (LineNumberReader reader = new LineNumberReader(new FileReader(IN_FILE))) {
            try (PrintWriter writer = new PrintWriter(OUT_FILE)) {

                int T = Integer.parseInt(reader.readLine());

                //Tests
                for (int t = 1; t <= T; t++) {

                    Scanner scanner = new Scanner(reader.readLine());
                    int LOW = scanner.nextInt();
                    int HIGH = scanner.nextInt();

                    HashSet<Pair> pairs = new HashSet<>();

                    for(int i = LOW; i <= HIGH ; i++) {

                        Set<Integer> set = validPermutations(i,LOW,HIGH);
                        Integer[] permutations = set.toArray(new Integer[0]);
                        Arrays.sort(permutations);

                        for(int n = 0; n < permutations.length ; n++){
                            for(int m = n+1; m < permutations.length; m++) {
                                pairs.add(new Pair(permutations[n],permutations[m]));
                            }
                        }
                    }
                    writer.printf("Case #%d: %s\n", t, pairs.size());
                }
            }
        }

    }

    public static Set<Integer> validPermutations (Integer n,int LOW, int HIGH){
        int lastIndex = n.toString().length() - 1;
        StringBuilder b = new StringBuilder(n.toString());
        Set<Integer> result = new HashSet<>();

        result.add(Integer.parseInt(b.toString()));

        for(int i = 1 ; i <= lastIndex; i++){

            char c = b.charAt(lastIndex);
            if (c == '0') continue;

            b = b.deleteCharAt(lastIndex).insert(0,c);

            int k = Integer.parseInt(b.toString());

            if(k >= LOW && k <= HIGH){
                result.add(k);
            }
        }

        return result;
    }
}

class Pair {
    int n;
    int m;

    Pair(int n, int m) {
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

    @Override
    public String toString() {
        return "(" + n + "," + m + ")";
    }
}