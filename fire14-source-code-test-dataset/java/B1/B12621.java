import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class MBHappy extends JamProblem {


    Map<Integer, Integer> baseMap;
    Map<Long, Integer> minMap = new HashMap<>();
    int ile = 0;

    void prepare() {

        SetUtil.cycleSubsets(bases.size(), new SetUtil.SubsetCallBack() {
            @Override
            public void run(long subset, int size) {
                clearCache();
                System.out.println(minMap.size());
                if (size == 0) {
                    return;
                }
                List<Integer> list = SetUtil.getList(subset, bases.size());
                List<Integer> bas = ArrayUtil.fromIndexList(list, bases);
                long forList = SetUtil.getForList(baseMap, bas);
                int max = 2;
                for (int j = 0; j < bases.size(); j++) {
                    long without = subset ^ SetUtil.getOne(j);
                    Integer withMin = minMap.get(without);
                    if (withMin != null) {
                        max = Math.max(max, withMin);
                    }
                }
                int num = max;
                while (true) {
                    int tested = 0;
                    for (Integer base : bas) {
                        System.out.println("" + ca + "\t" + base + "\t" + num);
                        if (!isHappy(num, base)) {
                            break;
                        }
                        tested++;
                    }
                    if (tested == bas.size()) {
                        ca++;
                        minMap.put(subset, num);
                        return;
                    }
                    if (cache.size() > 100000) {
                        clearCache();
                    }
                    num++;
                }
            }

        });
    }

    private void clearCache() {
        cache.clear();
        for (Integer base : bases) {
            cache.put(new MBAddr(1, base), Happy.HAPPY);
        }
    }

    public MBHappy() {
        for (int i = 2; i <= 10; i++) {
            bases.add(i);
        }
        baseMap = ArrayUtil.listToMap(bases);
    }

    Map<MBAddr, Happy> cache = new HashMap<>();

    List<Integer> bases = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        MBHappy h = new MBHappy();
        h.prepare();
        h.go();
    }

    boolean isHappy(int num, int base) {
        MBAddr addr1 = new MBAddr(num, base);
        Happy isHappy = cache.get(addr1);
        if (isHappy != null) {
            if (isHappy == Happy.HAPPY) {
                return true;
            }

            if (isHappy == Happy.UNHAPPY) {
                return false;
            }
        }

        List<Integer> integers = MathUtil.convertToBase(num, base);
        int sum = MathUtil.sumSquaredList(integers);

        isHappy = cache.get(new MBAddr(sum, base));
        if (isHappy != null) {
            if (isHappy == Happy.HAPPY) {
                cache.put(addr1, Happy.HAPPY);
                return true;
            }

            if (isHappy == Happy.UNHAPPY) {
                cache.put(addr1, Happy.UNHAPPY);
                return false;
            }

            if (isHappy == Happy.UNKNOWN) {
                cache.put(addr1, Happy.UNHAPPY);
                return false;
            }
        }
        cache.put(addr1, Happy.UNKNOWN);
        boolean happy = isHappy(sum, base);
        if (happy) {
            cache.put(addr1, Happy.HAPPY);
            return true;
        } else {
            cache.put(addr1, Happy.UNHAPPY);
            return false;
        }

    }

    int ca = 0;

    @Override
    String solveCase(JamCase jamCase) {
        int num = 2;
        MBHCase cas = (MBHCase) jamCase;

        return "" + minMap.get(SetUtil.getForList(baseMap, cas.bases));
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        MBHCase cas = new MBHCase();
        cas.lineCount = 1;
        cas.bases = JamUtil.parseIntList(file.get(line));
        return cas;
    }
}

class MBHCase extends JamCase {
    List<Integer> bases;
}

class MBAddr {
    int number;
    int base;

    MBAddr(int number, int base) {
        this.number = number;
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MBAddr mbAddr = (MBAddr) o;

        if (base != mbAddr.base) return false;
        if (number != mbAddr.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + base;
        return result;
    }
}

class MBNum {
    int number;
    int base;
    boolean isHappy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MBNum mbNum = (MBNum) o;

        if (base != mbNum.base) return false;
        if (isHappy != mbNum.isHappy) return false;
        if (number != mbNum.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + base;
        result = 31 * result + (isHappy ? 1 : 0);
        return result;
    }
}

enum Happy {
    HAPPY, UNHAPPY, UNKNOWN;
}


