package google.codejam;

public class DanceGoogler implements GoogleSolver {

  @Override
  public String solve(String str) {
    String[] input = str.split(" ");
    int dancerNumber = Integer.parseInt(input[0]);
    int surprisingCount = Integer.parseInt(input[1]);
    int bestResult = Integer.parseInt(input[2]);
    
    int surpriseingScore = (bestResult*3-4)>0?(bestResult*3-4):0;
    int minScore = bestResult*3-2>0?((bestResult*3-2)):0;

    //int[] scores = new int[dancerNumber];

    int bestCount = 0;
    for(int i=0; i<dancerNumber ; i++){
      int scores = Integer.parseInt(input[i+3]);
      //System.out.print(scores[i]+",");
      
      if(scores<bestResult){
        continue;
      }
      
      if(scores>=minScore){
        bestCount++;
        continue;
      }
      if(scores>=surpriseingScore && surprisingCount>0){
        bestCount++;
        surprisingCount--;
        continue;
      }
      
    }
    
    return bestCount+"";
  }

}
