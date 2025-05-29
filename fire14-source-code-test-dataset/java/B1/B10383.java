import java.util.Scanner;


public class Utils {

    public static int readIntegerLine(Scanner sc) {
        String s = readStringLine(sc);
        return Integer.parseInt(s);
    }

    public static String readStringLine(Scanner sc) {
        return sc.nextLine();
    }

    public static int readInteger(Scanner sc) {
        return sc.nextInt();
    }

}
