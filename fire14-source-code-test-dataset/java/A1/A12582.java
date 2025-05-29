import util.CombinationGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SetUtil {
    public static long getOne(int n) {
        return 1<<n;
    }

    public static List<Integer> getList(long set, int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i=0;i<n; i++) {
            if ((set & getOne(i))!=0) {
                integers.add(i);
            }
        }
        return integers;
    }
    public static <T>long getForList(Map<T,Integer> positions, List<T> objs) {
        long res = 0L;
        for (T obj : objs) {
            int pos = positions.get(obj);
            res |= getOne(pos);
        }
        return res;
    }

    public static void cycleSubsets(int num, SubsetCallBack callBack) {
        callBack.run(0, 0);
        for (int i =  1; i<=num; i++) {
            CombinationGenerator generator = new CombinationGenerator(num,i);

            while (generator.hasMore()) {
                long n = 0;
                int[] next = generator.getNext();
                for (int i1 : next) {
                    n |= getOne(i1);
                }
                callBack.run(n,i);
            }
        }

    }

    public static interface SubsetCallBack {
        void run(long subset, int i);
    }
}
