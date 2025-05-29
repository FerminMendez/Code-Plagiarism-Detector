import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String[] inputs = scanner.nextLine().split("\\s");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);
            int result = solve(A, B);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int solve(int A, int B) {
        int recycledPairs = 0;

        for (int n = A; n < B; n++) {
            for (int m = n + 1; m <= B; m++) {
//                System.out.println("Checking pair " + n + " " + m);
                if (isRecycledPairs(n, m)) {
                    recycledPairs++;
                }
            }
        }

        return recycledPairs;
    }

    private static boolean isRecycledPairs(int n, int m) {

        boolean result = false;

        String nString = String.valueOf(n);
        String mString = String.valueOf(m);
        String recycledString = null;

        for (int i = 0; i < nString.length(); i++) {
            recycledString = nString.substring(i, nString.length()) + nString.substring(0, i);
//            System.out.println(recycledString);

            if (mString.equals(recycledString)) {
                result = true;
            }
        }

        return result;
    }
}
