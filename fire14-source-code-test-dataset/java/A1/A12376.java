import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: elbek
 * Date: 4/13/12
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task2 {

    static Map<Character, Character> map = new HashMap<Character, Character>();

    public static void main(String[] args) {

        int t = 100;

        Scanner scanner = new Scanner(System.in);
        for (int q = 0; q <= t; q++) {
            String str = scanner.nextLine();
            String[] arg = str.split(" ");
            int googler = Integer.valueOf(arg[0]);
            int suprising = Integer.valueOf(arg[1]);
            int condition = Integer.valueOf(arg[2]);
            int found = 0;

            for (int i = 3; i < googler + 3; i++) {
                int sum = Integer.valueOf(arg[i]);
                int del = sum / 3;

                if (condition == 0) {
                    found++;
                    continue;
                }

                if (condition == 1 && sum >= 1) {
                    found++;
                    continue;
                }

                if (sum < 2)
                    continue;

                if (3 * condition - 4 <= sum && sum < 3 * condition - 2) {

                    if (suprising == 0)
                        continue;

                    suprising--;
                    found++;
                } else {
                    if (sum >= 3 * condition - 2)
                        found++;
                }
            }
            System.out.println("Case #" + (q + 1) + ": " + found);
        }
    }
}
