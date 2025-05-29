package com.codejam.two12.GooglerDance;

import java.util.ArrayList;
import java.util.Arrays;

import com.jp.common.Puzzle;

public class GooglerDance implements Puzzle{

  private int numberOfGooglers;
  private int surprisingTriplets;
  private int parValue;
  private int[] totalPointArray;
  private int currentNumberOfSurprises;
  private ArrayList<Integer> ResultList;
  
  @Override
  public String[] solve(String[] dataSet) {
    // TODO Auto-generated method stub
    ResultList = new ArrayList<Integer>();
    processInput( dataSet);
    calculateResult();
    
    String result[] = new String[1];  
    result[0] = String.valueOf(ResultList.size());
    return result;
  }
  
  public void processInput(String[] dataSet){
    String data[] = dataSet[0].split(" ");
    numberOfGooglers = Integer.parseInt(data[0]);
    surprisingTriplets = Integer.parseInt(data[1]);
    parValue = Integer.parseInt(data[2]);
    
    totalPointArray = new int[numberOfGooglers];
    
    for(int i = 0; i < totalPointArray.length; i++){
      totalPointArray[i] = Integer.parseInt(data[ 3 + i]);
    }
    
    Arrays.sort(totalPointArray);
    
   }
  
  public void calculateResult(){
    
    for (int i = 0; i < totalPointArray.length; i++){
      int total = totalPointArray[i];
      int remainder = total / 3;
      int quotient = total % 3;
      
      int diff = parValue - remainder;
      
      // This cant be part of result. so skip and continue
      if(diff > 2 || (total == 0 && parValue != 0) ){
        continue;
      }
      else if(diff <= 0 ){
        ResultList.add(total);
        continue;
      }
      
      if(diff == 1 && quotient == 0 && currentNumberOfSurprises < surprisingTriplets){
        ++ currentNumberOfSurprises;
        ResultList.add(total);
      }
      else if(diff == 1 && quotient == 1 ){
        if(currentNumberOfSurprises < surprisingTriplets)
          ++ currentNumberOfSurprises;
        
        ResultList.add(total);
      }
      else if(diff == 1 && quotient == 2){
        ResultList.add(total);
      }
      else if(diff == 2 && quotient == 2 && currentNumberOfSurprises < surprisingTriplets){
        ++ currentNumberOfSurprises;
        ResultList.add(total);
      }
    }
    
    
  }
  
}
