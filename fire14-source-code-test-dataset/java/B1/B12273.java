import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: danghiskhan
 * Date: 4/14/12
 * Time: 11:44 PM
 */
public class Recycled {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Integer caseCount = 1;

        while (in.hasNextInt()) {
            Integer start = in.nextInt();
            Integer finish = in.nextInt();

            Integer count = 0;

            ArrayList<String> duplicates = new ArrayList<String>();

            for (Integer i = start; i < finish; i++) {
                for (Integer j = i + 1; j <= finish; j++) {

                    String n = i.toString();
                    String m = j.toString();

                    String nPerm;

                    if (n.length() > 1) {
                        for (Integer k = 1; k < n.length(); k++) {
                            nPerm = n.substring(k, n.length()) + n.substring(0, k);

                            Integer nPermInt = Integer.parseInt(nPerm);

                            String dupe = nPerm + ":" + n;

                            if (nPerm.equals(m) && nPermInt > i && !duplicates.contains(dupe)) {
                                //System.out.println("n:" + n + " nPerm: " + nPerm);

                                duplicates.add(dupe);

                                count++;
                            }
                        }
                    }

                }
            }

            System.out.println("Case #" + caseCount++ + ": " + count);
        }

    }
}
