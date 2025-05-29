package codejam2012.qualification.b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;

public final class Memory {

    private static Logger log = LoggerFactory.getLogger(Memory.class);

    public ArrayListMultimap<Integer, Triplet> data = ArrayListMultimap.create();

    private static int startFor(int a) {
        return a < 2 ? 0 : a - 2;
    }

    private static int endFor(int a) {
        return a > 8 ? 10 : a + 2;
    }

    public void init() {
        log.debug("init: start");
        for (int a = 0; a <= 10; ++a) {
            int bStart = startFor(a);
            int bEnd = endFor(a);
            for (int b = bStart; b <= bEnd; ++b) {
                int cStart = startFor(b);
                int cEnd = endFor(b);
                for (int c = cStart; c <= cEnd; ++c) {
                    int total = a + b + c;
                    data.put(total, Triplet.of(a, b, c, total));
                }
            }
        }
        log.debug("init: finished");
    }
}
