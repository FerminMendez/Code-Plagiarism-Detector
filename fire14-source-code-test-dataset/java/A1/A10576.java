package codejam2012.qualification.b;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Round {

    private static Logger log = LoggerFactory.getLogger(Round.class);

    private final List<Integer> totals;
    private final Memory memory;

    public Round(List<Integer> totals, Memory memory) {
        this.totals = totals;
        this.memory = memory;
    }

    public int run(int s, int p) {
        int count = 0;

        for (Integer total : totals) {
            List<Triplet> triplets = memory.data.get(total);
            if (triplets.isEmpty()) {
                throw new IllegalStateException();
            }

            log.debug("for total: {} triplets are: {}", total, triplets);
            boolean has = false;
            boolean hasNotSurprising = false;

            for (Triplet triplet : triplets) {
                if (triplet.hasAtLeast(p)) {
                    has = true;
                    if (!triplet.surprising) {
                        hasNotSurprising = true;
                    }
                }
            }

            log.debug("--> has: {} hasNotSurprising: {}", has, hasNotSurprising);

            if (has) {
                if (hasNotSurprising) {
                    ++count;
                } else {
                    if (s > 0) {
                        --s;
                        ++count;
                    }
                }
            }
        }

        return count;
    }

}
