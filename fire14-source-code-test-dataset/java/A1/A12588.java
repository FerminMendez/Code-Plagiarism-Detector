import java.lang.reflect.Array;
import java.util.*;

public class ArrayUtil {
    static<T> T[] revers (T[] t){
        List<T> list = Arrays.asList(t);
        Collections.reverse(list);
        return (T[]) list.toArray();
    }

    static<T> Map<T,Integer> listToMap(List<T> list) {
        HashMap<T, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            map.put(t,i);
        }
        return map;
    }

    static <T> List<T> fromIndexList(List<Integer> inds, List<T> values) {
        ArrayList<T> ts = new ArrayList<>();
        for (Integer ind : inds) {
            ts.add(values.get(ind)) ;
        }
        return ts;
    }
}
