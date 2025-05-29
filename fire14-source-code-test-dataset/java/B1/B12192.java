import java.util.Scanner;

public class RecycledNumbers {
    public static void main(String[] args) {
        new RecycledNumbers().go();
    }

    private void go() {
        Scanner sc = new Scanner(System.in);

        int numTestCases = Integer.parseInt(sc.nextLine());

        for (int caseNum = 1; caseNum <= numTestCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            int A = sc.nextInt();
            int B = sc.nextInt();

            int sum = 0;
            for (int n = A; n < B; n++)
                for (int m = n + 1; m <= B; m++)
                    if (isRecycled(n, m))
                        sum++;
            System.out.println(sum);
        }
    }

    private boolean isRecycled(int n, int m) {
        String N = String.valueOf(n);
        String M = String.valueOf(m);

        for(int i = 1; i < N.length(); i++) {
            String reCycled = rotate(N, i);
            if(reCycled.equals(M)) {
                return true;
            }
        }
        return false;
    }

    public static String rotate(String n, int i) {
        String lastIChars = n.substring(n.length() - i);
        String firstIChars = n.substring(0, n.length() - i);

        return lastIChars + firstIChars;
    }
}
