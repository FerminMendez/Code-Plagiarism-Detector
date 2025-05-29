package dg.gcj.bdancing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dmitry
 * Date: 14.04.12
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class Solver {

    private PossibleCombinations possibleCombinations = new PossibleCombinations();

    public int solve(World world) {
        // DEBUG
//        System.out.println("---------------------------");
//        System.out.println("Googlers number: " + world.getGooglersNumbers());
//        System.out.println("Surprising number: " + world.getSurprising());
//        System.out.println("Boundary score: " + world.getBoundaryScore());
//        System.out.println("Scores: " + world.getScores());
//        System.out.println("---------------------------");

        final List<Integer> scores = world.getScores();
        final int[] selectedTripletsSizes = new int[scores.size()];
        for(int i = 0; i < scores.size(); ++ i)
        {
            int score = scores.get(i);
            selectedTripletsSizes[i] = this.possibleCombinations.findTripletsByTotalScore(score).size();
        }

        int[] selectedTripletsIndexes = new int[scores.size()];
        int maximumMatchedGooglers = 0;

        do
        {
            int actualSurprisingCount = 0;
            int actualMatchedGooglers = 0;
            List<Triplet> selectedTriplets = new ArrayList<Triplet>();

            for(int i = 0; i < scores.size(); ++ i)
            {
                int score = scores.get(i);
                final List<Triplet> tripletsByTotalScore = this.possibleCombinations.findTripletsByTotalScore(score);
                final int selectedTripletIndex = selectedTripletsIndexes[i];
                final Triplet triplet = tripletsByTotalScore.get(selectedTripletIndex);

                selectedTriplets.add(triplet);

                if (triplet.isSurprising())
                {
                    actualSurprisingCount ++;
                }

                if (triplet.getMaximumScore() >= world.getBoundaryScore())
                {
                    actualMatchedGooglers ++;
                }
            }

            // DEBUG
//            System.out.println("**************************************");
//            System.out.println("Triplets " + selectedTriplets);
//            System.out.println("Surprising Count " + actualSurprisingCount);
//            System.out.println("Matched Googlers Count " + actualMatchedGooglers);

            if (world.getSurprising() == actualSurprisingCount && maximumMatchedGooglers < actualMatchedGooglers)
            {
                maximumMatchedGooglers = actualMatchedGooglers;
            }
        }
        while (this.nextCombination(selectedTripletsIndexes, selectedTripletsSizes));

        return maximumMatchedGooglers;
    }

    private boolean nextCombination(int[] selectedTripletsIndexes, int[] selectedTripletsSizes) {
        for(int i = 0; i < selectedTripletsIndexes.length; ++ i)
        {
            selectedTripletsIndexes[i] ++;
            if (selectedTripletsIndexes[i] >= selectedTripletsSizes[i])
            {
                selectedTripletsIndexes[i] = 0;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}
