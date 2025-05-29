import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {
    static List<Integer> convertToBase (int num, int base) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (num == 0) {
            integers.add(0);
            return integers;
        }

        while (num!=0) {
            integers.add(num % base);
            num /= base;
        }

        return integers;
    }

    static int sumList(Iterable<Integer> iterable) {
        int sum = 0;
        for (Integer integer : iterable) {
            sum += integer;
        }
        return sum;
    }

    static int sumSquaredList(Iterable<Integer> iterable) {
        int sum = 0;
        for (Integer integer : iterable) {
            sum += integer * integer;
        }
        return sum;
    }
}
