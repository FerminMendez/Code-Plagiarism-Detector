import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: elbek
 * Date: 4/13/12
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        int count = 0;
        Set<String> found = new TreeSet<String>();
        int t = 50;

        Scanner scanner = new Scanner(System.in);


        for (int q = 0; q <= t; q++) {
            count = 0;
            String str = scanner.nextLine();

            String []arg = str.split(" ");
            Integer a = Integer.parseInt(arg[0]);
            Integer b = Integer.parseInt(arg[1]);
            for (int i = a; i <= b; i++) {
                String input = String.valueOf(i);

                String changed;
                int len = input.length();

                for (int j = 1; j < len; j++) {

                    changed = input.substring(j, len) + input.substring(0, j);
                    if (Integer.valueOf(changed) <= Integer.valueOf(input)) continue;

                    if (Integer.valueOf(changed) <= b && Integer.valueOf(changed) >= a) {
                        found.add(input + " - " + changed);
//                    found.add(changed);
                        count++;
                    }
                }
            }
            System.out.println("Case #"+(q+1)+": "+count);
        }
    }
}
