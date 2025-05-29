import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class DancingWithGooglers {

    public static class Scores {
        public final int S;
        public final int p;
        public final int[] t;

        public Scores(int S, int p, int[] t) {
            this.S = S;
            this.p = p;
            this.t = t;
        }
    }

    public static Iterator<Scores> iterator(Readable input) {
        final Scanner scanner = new Scanner(input);

        return new Iterator<Scores>() {
            private int cases = scanner.nextInt();

            @Override
            public boolean hasNext() {
                return cases > 0;
            }

            @Override
            public Scores next() {
                int N = scanner.nextInt();
                int S = scanner.nextInt();
                int p = scanner.nextInt();

                int[] t = new int[N];
                for (int i = 0; i < N; i++) {
                    t[i] = scanner.nextInt();
                }

                cases--;
                return new Scores(S, p, t);
            }

            @Override
            public void remove() {
                throw new AbstractMethodError();
            }
        };
    }

    public static int maxTuples(Scores scores) {
        int tuples = 0;
        int s = scores.S;

        for (int i : scores.t) {
            int[] tuple = tuplesWithMax(i, scores.p);

            if (tuple.length == 3) {
                if (tuple[0] - tuple[2] == 2 && s > 0) {
                    tuples++;
                    s--;
                } else if (tuple[0] - tuple[2] <= 1) {
                    tuples++;
                }
            }
        }

        return tuples;
    }

    public static int[][] tuples(int total) {
        if (total == 0) {
            return new int[][]{{0, 0, 0}};
        }

        if (total == 30) {
            return new int[][]{{10, 10, 10}};
        }

        int max = total / 3;

        if (total % 3 == 0) {
            return new int[][]{{max, max, max}, {max + 1, max, max - 1}};
        }

        if (total % 3 == 1) {
            return new int[][]{{max + 1, max, max}, {max + 1, max + 1, max - 1}};
        }

        if (max < 9) {
            return new int[][]{{max + 1, max + 1, max}, {max + 2, max, max}};
        }

        return new int[][]{{max + 1, max + 1, max}};
    }


    public static int[] tuplesWithMax(int t, int max) {
        for (int[] tuple : tuples(t)) {
            if (tuple[0] >= max)
                return tuple;
        }
        return new int[]{};
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader(args[0]);

        int caseId = 1;
        Iterator<Scores> iterator = iterator(fileReader);

        while (iterator.hasNext()) {
            int result = maxTuples(iterator.next());
            System.out.format("Case #%s: %s\n", caseId, result);
            caseId++;
        }
    }
}
