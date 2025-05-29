/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancing.with.the.googlers;

/**
 *
 * @author Optee
 */
public class ScoreCounter {

    int numberOfGooglers;
    int surpriseCount;
    int minScore;
    int[] scores;

    public ScoreCounter(String line) {
        String[] numbers = line.split(" ");
        this.numberOfGooglers = Integer.valueOf(numbers[0]);
        this.surpriseCount = Integer.valueOf(numbers[1]);
        this.minScore = Integer.valueOf(numbers[2]);
        this.scores = new int[numbers.length-3];
        int j = 0;
        for (int i = 3; i < numbers.length; i++) {
            scores[j++] = Integer.valueOf(numbers[i]);
        }
    }
    
    int Count2() {
        int winners = 0;
        Integer surprise = surpriseCount;
        
        for (int i = 0; i < numberOfGooglers; i++) {
            int score = this.scores[i];
            int minCount = minScore * 3;
            if(score == 0 && minScore > 0) continue;
            if (score + 2 >= minCount) {
                winners++;
            }
            else if (score + 4 >= minCount && surprise > 0) {
                surprise--;
                winners++;
            }
        }
        return winners;
    }
    
    int Count() throws Exception {
        int winners = 0;
        Integer surprise = surpriseCount;
        Integer possibleSurprises = 0;
        
        for (int i = 0; i < numberOfGooglers; i++) {
            int score = this.scores[i];
            int tail = score - minScore;
            
            if (tail <= 0) continue;
            
            int divTileOne = tail/2;
            int divTileTwo = tail - divTileOne;
            
            if (Math.max(divTileOne, divTileTwo) >= minScore){
                if (Math.max(divTileOne, divTileTwo) - minScore >=2)
                    possibleSurprises++;
                winners++;
            }
            else if (minScore - Math.min(divTileOne, divTileTwo) < 2) {
                winners++;
            }
            else if (minScore - Math.min(divTileOne, divTileTwo) == 2) {
                if (surprise > 0) {
                    surprise--;
                    winners++;
                }
            }
        }            
        return winners;
    }
    
}
