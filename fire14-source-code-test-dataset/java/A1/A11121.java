package code_jam_quali;

import java.util.Scanner;

/**
 *
 * @author sansarun
 */
public class Dancing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();

        for (int currentCase = 1; currentCase <= caseNum; currentCase++) {
            int googlers = sc.nextInt();
            int surprise = sc.nextInt();
            int p = sc.nextInt();

            int alreadyPass = 0;
            int canHelp = 0;

            for (int i = 0; i < googlers; i++) {
                int totalScore = sc.nextInt();
                int maxCompound = findMaxCompound(totalScore);
                int fragment = totalScore % 3;

                if (totalScore < 3) {
                    if(findMaxCompound(totalScore) >= p) {
                        alreadyPass++;
                    }
                } else {
                    switch (fragment) {
                        case 1:
                            if (maxCompound >= p) {
                                alreadyPass++;
                            }
                            break;
                        case 0:
                        case 2:
                            if (maxCompound >= p) {
                                alreadyPass++;
                            } else if (maxCompound + 1 >= p) {
                                canHelp++;
                            }
                            break;
                    }
                }
            }
            int totalPass = alreadyPass + (canHelp > surprise ? surprise : canHelp);
            System.out.println(String.format("Case #%d: %d", currentCase, totalPass));
        }
    }

    private static int findMaxCompound(int n) {
        return (int) Math.round(Math.ceil(n / 3.0));
    }
}
