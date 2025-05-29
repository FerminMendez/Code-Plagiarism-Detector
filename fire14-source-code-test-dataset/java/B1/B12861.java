package google.codejam;

import java.util.HashMap;

public class RecycledNumberSolver implements GoogleSolver {

  @Override
  public String solve(String str) {
    String [] numbers = str.split(" ");
    int min = Integer.parseInt(numbers[0]);
    int max = Integer.parseInt(numbers[1]);
    int digits = numbers[0].length();
    System.out.println("min:"+min + " max:"+ max);
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    int count = 0;
    for(int i=min; i<=max ; i++){
      for(int move=1 ; move<digits ; move++){
        String temp = i+"";
        String test = temp.substring(temp.length()-move) + temp.substring(0, temp.length()-move);
        
        int testNum = Integer.parseInt(test);
        if(testNum>i && testNum>=min && testNum<=max){
          //System.out.println("("+temp + " , " +  testNum+ ")");
          if(map.get(i)==null || map.get(i)!=testNum){
            map.put(i, testNum);
            count++;
          }
        }
      }
      map.clear();
    }
    return count+"";
  }

}
