package com.codejam.two12.RecyledNumbers;

import java.util.HashSet;

import com.jp.common.Puzzle;

public class RecycledNumbers implements Puzzle {

  private HashSet<Integer> checkedElementSet = new HashSet<Integer>();
  private HashSet<Pair> ListOfPairs = new HashSet<Pair>();
  private int startNumber;
  private int endNumber;
  
  @Override
  public String[] solve(String[] dataSet) {
    processInput(dataSet);
    
    String result[] = new String[1];  
    result[0] = String.valueOf(ListOfPairs.size());
   // System.out.println(ListOfPairs);
    return result;
  
  }
  
  public void processInput(String[] dataSet){
      String data[] = dataSet[0].split(" ");
     startNumber = Integer.parseInt(data[0]);
     endNumber = Integer.parseInt(data[1]);
     
     for (int i = startNumber; i <= endNumber; i++){
       if(hasBeenProcessed(i)){
         continue;
       }
       
       if (i < 10 ){
         continue;
       }
       
       if (i >= 10 && i < 100 ){
         int reverse = reverseInt(i) ;
         checkedElementSet.add(i);
         checkedElementSet.add(reverse);
         
         checkAndCreatePair(i,reverse);
       }
       
       if (i >= 100 &&  i <= 1000 ){
         int reverse = reverseInt(i) ;
         int reverse1 = reverseInt(reverse);
         
         checkedElementSet.add(i);
         checkedElementSet.add(reverse);
         checkedElementSet.add(reverse1);
         
         checkAndCreatePair(i,reverse);
         checkAndCreatePair(i,reverse1);
         checkAndCreatePair(reverse,reverse1);
         checkAndCreatePair(reverse,i);
         checkAndCreatePair(reverse1,reverse);
         checkAndCreatePair(reverse1,i);
       }
       
       if (i > 1000 &&  i < 10000 ){
         int reverse = reverseInt(i) ;
         int reverse1 = reverseInt(reverse);
         int reverse2 = reverseInt(reverse1);
         
         checkedElementSet.add(i);
         checkedElementSet.add(reverse);
         checkedElementSet.add(reverse1);
         checkedElementSet.add(reverse2);
         
         checkAndCreatePair(i,reverse);
         checkAndCreatePair(i,reverse1);
         checkAndCreatePair(i,reverse2);
         checkAndCreatePair(reverse,i);
         checkAndCreatePair(reverse,reverse1);
         checkAndCreatePair(reverse,reverse2);
         checkAndCreatePair(reverse1,i);
         checkAndCreatePair(reverse1,reverse);
         checkAndCreatePair(reverse1,reverse2);
         checkAndCreatePair(reverse2,i);
         checkAndCreatePair(reverse2,reverse);
         checkAndCreatePair(reverse2,reverse1);
         
       }


     }
     
  }
  
  
  public void checkAndCreatePair(int i, int reverse){
    if(i>= startNumber && reverse >= startNumber && i <= endNumber && reverse <= endNumber && i < reverse){
      Pair p = new Pair(i,reverse);
      ListOfPairs.add(p);
    }
  }
  
  public int reverseInt(int input){
    String strInput = String.valueOf(input);
    char lastNum = strInput.charAt(strInput.length()-1);
    String strOutput = lastNum + strInput.substring(0, strInput.length() -1 );
    int output = Integer.parseInt(strOutput);
    return output;
  }
  
  public boolean hasBeenProcessed(int input){
    if (checkedElementSet.contains(input)){
      return true;
    }
    return false;
  }
  
}
