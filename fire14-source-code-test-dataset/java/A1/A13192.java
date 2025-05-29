package problemb;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class ProblemB {
    
    public static void main(String args[]){
      List<String> inputs = readInput();
      int googlers = 0;
      int specialCases = 0;
      int bestScore = 0;
      List<Integer> googlerScores = new ArrayList<Integer>();
      int count = 0;
      for(String input : inputs){
          googlerScores = new ArrayList<Integer>();
          count++;
        String[] inputArray = input.split(" ");
          googlers = Integer.parseInt(inputArray[0]);
          specialCases = Integer.parseInt(inputArray[1]);
          bestScore = Integer.parseInt(inputArray[2]);
          
          for(int i=3; i<(3+googlers); i++){
            googlerScores.add(Integer.parseInt(inputArray[i]));
          }
          
          output(count, bestResult(googlerScores, specialCases, bestScore));
          
      }
    }
    

    private static int bestResult(List<Integer> googlerScores, int specialCases, int bestScore){
        int bestResults = 0;
        int scoreMinusMax  = 0;
        int avgScore = 0;
        for(Integer googlerScore : googlerScores){
            scoreMinusMax = googlerScore - bestScore;
            avgScore = scoreMinusMax / 2;
            
//            System.out.println("AVG SCORE: " + avgScore);
//            System.out.println("BEST SCORE: " + bestScore);
//            System.out.println("SPECIAL CASES: " + specialCases);
            if(googlerScore == 0 && bestScore > 0)
                continue;
            if(avgScore >= bestScore || (bestScore - avgScore) < 2){
              bestResults++;
            }else if((bestScore - avgScore) == 2 && specialCases > 0){                
                  specialCases--;
                  bestResults++;                
            }
        }
        
        
        return bestResults;
    }
    
  private static List<String> readInput(){
    List<String> untranslatedStrings = new ArrayList<String>();
    try{
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        Long numTestCases = Long.parseLong(in.readLine());
        for(int i=0; i<numTestCases.intValue(); i++){
            untranslatedStrings.add(in.readLine());
        }          
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return untranslatedStrings;
  }
  
  private static void output(int input, int bestResults){
    System.out.println("Case #"+input+": "+bestResults);
  }
}
