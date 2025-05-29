import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: Linkov Mikl
 * Date: 15.04.12
 * Time: 3:15
 * To change this template use File | Settings | File Templates.
 */
public class ProblemC {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int left =scanner.nextInt();
            int right = scanner.nextInt();
            int answer = 0;

            for (int value = left; value < right + 1; value++) {
                String str = String.valueOf(value);


                StringBuilder build = new StringBuilder(str);
                Set<Integer> set = new TreeSet<Integer>();
                for (int j = 1; j < str.length(); j++) {

                    build.append(build.charAt(0));
                    build.delete(0, 1);

                    if (build.charAt(0) == '0') {
                        continue;
                    }
                    int v1 = Integer.parseInt(build.toString());
                    int v2 = Integer.parseInt(str);

                    if ((v1 >= left) && (v1 <= right)) {
                        if ((v1 > v2)) {
                            if (!set.contains(v1)) {
                                answer++;
                                set.add(v1);
                            }
                        }
                    }
                }


            }
            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }
}
