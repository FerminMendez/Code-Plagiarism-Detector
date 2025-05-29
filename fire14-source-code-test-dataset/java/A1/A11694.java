package dg.gcj.bdancing;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Dmitry
 * Date: 14.04.12
 * Time: 23:50
 * To change this template use File | Settings | File Templates.
 */
public class PossibleCombinations {

    private final Map<Integer,List<Triplet>> totalScoreToTriplets = new HashMap<Integer,List<Triplet>>();

    public PossibleCombinations() {
        int[] sorted = new int[3];
        for(int i = 0; i <= 10; i ++)
        {
            for(int j = 0; j <= 10; j ++)
            {
                for(int k = 0; k <= 10; k ++)
                {
                    sorted[0] = i;
                    sorted[1] = j;
                    sorted[2] = k;

                    Arrays.sort(sorted);

                    if (isPossibleTriplet(sorted))
                    {
                        this.addTriplet(new Triplet(sorted));
                    }
                }
            }
        }
    }

    private boolean isPossibleTriplet(int[] sorted) {
        return sorted[2] - sorted[0] <= 2;
    }

    private void addTriplet(Triplet triplet) {
        final int totalScore = triplet.getTotal();
        List<Triplet> triplets = this.totalScoreToTriplets.get(totalScore);
        if (triplets == null)
        {
            triplets = new ArrayList<Triplet>();
            this.totalScoreToTriplets.put(totalScore, triplets);
        }

        if (!triplets.contains(triplet))
        {
            triplets.add(triplet);
        }
    }

    public List<Triplet> findTripletsByTotalScore(int totalScore)
    {
        final List<Triplet> triplets = this.totalScoreToTriplets.get(totalScore);
        if (triplets == null)
        {
            throw new IllegalArgumentException("Impossible total score " + totalScore);
        }
        return triplets;
    }

}
