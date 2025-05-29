import java.io.FileInputStream;
import java.util.Scanner;

public class Q_B {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new FileInputStream("C:\\B-small-attempt3.in"));
        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {

            int num = sc.nextInt();
            int surprise = sc.nextInt();
            int baseMark = sc.nextInt();
            int count = 0;

            for (int j = 0; j < num; j++) {

                int totalMark = sc.nextInt();
                Double tmp = Math.ceil( (float) totalMark / 3 );
                int maxMark = tmp.intValue();

                // baseMark shouldn't be more than total
                if (baseMark > totalMark) continue;

                if (maxMark >= baseMark) {
                    count++;
                } else {
                    int a = totalMark - baseMark;
                    int b = a / 2;
                    if ((baseMark - b <= 2) && surprise > 0) {
                        surprise--;
                        count++;
                    }
                }
            }

            System.out.println("Case #" + (i+1) + ": " + count);
            count = 0;

        }

//        Double tmp = Math.ceil( (float) 0 / 3 );
//        System.out.println(tmp.intValue());

    }

}