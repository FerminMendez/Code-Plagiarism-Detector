package com.qualification;

import com.qualification.ScoreCombo.Score;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Three {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("/Users/minerva/Desktop/input.txt");
        FileWriter fw = new FileWriter("/Users/minerva/Desktop/output.txt");
        
        BufferedReader br = new BufferedReader(fr);
        PrintWriter pr = new PrintWriter(fw);
        
        int numInputs = Integer.valueOf(br.readLine());
        
        for(int i=0;i<numInputs;i++) {
            String str = br.readLine();
            String values[] = str.split(" ");
            int[] numValues = new int[values.length];
            for (int j=0;j<values.length;j++) numValues[j] = Integer.parseInt(values[j]);
            pr.println("Case #" + (i + 1) + ": " + compute(numValues));
        }
        pr.flush();
    }
    
    public static int compute(int[] inputs) {
        int numInputs = inputs[0];
        int surprising = inputs[1];
        int best = inputs[2];
        
        List<Score> scores = new ArrayList<Score>();
        for (int indx = 3;numInputs > 0; numInputs--,indx++) {
            Score result = new ScoreCombo(inputs[indx]).testBest(best);
            if (result != null) scores.add(result);
        }
        
        int supCount = 0;
        int num = scores.size();
        
        for(Score item:scores) 
            if (item.isSurprising())
                supCount++;
        
        
        if (supCount > surprising) {
            num -= (supCount - surprising);
        }
        
        return num;
    }
}

class ScoreCombo {
    private Score normalScore;
    private Score surprisingScore;
    
    public ScoreCombo(int total) {
        int rem = total % 3;
        int avg = total / 3;
        
        if (total == 0) {
            normalScore = new Score(0,false);
        } else if (total == 1) {
            normalScore = new Score(1,false);
        } else if (total == 2) {
            normalScore = new Score(1,false);
            surprisingScore = new Score(2,true);
        } else {
            if(rem == 0) {
                normalScore = new Score(avg,false);
                surprisingScore = new Score(avg + 1,true);
            } else if(rem == 1) {
                normalScore = new Score(avg + 1,false);
                surprisingScore = new Score(avg + 1,true);
            } else if(rem == 2) {
                normalScore = new Score(avg + 1,false);
                surprisingScore = new Score(avg + 2,true);
            }
        }
    }
    
    public class Score {
        private int maxScore;
        private boolean flag;
        
        private Score(int maxScore, boolean flag) {
            this.maxScore = maxScore;
            this.flag = flag;
        }
        
        public boolean isSurprising() {
            return flag;
        }
        
        public boolean testBest(int testValue) {
            return maxScore >= testValue; 
        }
    }
    
    public Score testBest(int minScore) {
        if (normalScore.testBest(minScore)) 
            return normalScore;
        else if (surprisingScore != null && surprisingScore.testBest(minScore))
            return surprisingScore;
        else 
            return null;
    }
}
