import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class RecycledNumbers {

    public static int recycle(int source, int digits) {
        int pow = (int) Math.pow(10, digits - 1);
        int mod = source % 10;
        return pow * mod + source / 10;
    }

    public static class Range {
        public final int A;
        public final int B;

        public Range(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    public static Iterator<Range> iterator(Readable input) {
        final Scanner scanner = new Scanner(input);

        return new Iterator<Range>() {
            private int cases = scanner.nextInt();

            @Override
            public boolean hasNext() {
                return cases > 0;
            }

            @Override
            public Range next() {
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                cases--;
                return new Range(A, B);
            }

            @Override
            public void remove() {
                throw new AbstractMethodError();
            }
        };
    }

    public static int recycledPairs(Range scores) {
        int digits = Integer.toString(scores.A).length();
        HashSet<String> pairs = new HashSet<String>();
        for (int i = scores.A; i <= scores.B; i++) {
            int recycled = recycle(i, digits);
            while (recycled != i) {
                if (recycled >= scores.A && recycled <= scores.B) {
                    int first = i < recycled ? i : recycled;
                    int second = i > recycled ? i : recycled;

                    pairs.add(String.format("%d%d", first, second));
                }
                recycled = recycle(recycled, digits);
            }
        }

        return pairs.size();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader(args[0]);

        int caseId = 1;
        Iterator<Range> iterator = iterator(fileReader);

        while (iterator.hasNext()) {
            int result = recycledPairs(iterator.next());
            System.out.format("Case #%s: %s\n", caseId, result);
            caseId++;
        }
    }
}
