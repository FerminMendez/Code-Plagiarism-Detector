package com.jp.common;

import java.util.HashMap;

import com.codejam.two12.GooglerDance.GooglerDance;
import com.codejam.two12.RecyledNumbers.RecycledNumbers;
import com.codejam.two12.tongue.SpeakingTongues;
import com.jp.storeCredit.StoreCredit;

public class PuzzleFactory {
  
  public static Puzzle getPuzzleSolution(String puzzleName){
    
    HashMap<String,Puzzle> hmPuzzleSolvers = new HashMap<String,Puzzle>();
    hmPuzzleSolvers.put("StoreCredit", new StoreCredit());
    hmPuzzleSolvers.put("SpeakingTongues", new SpeakingTongues());
    hmPuzzleSolvers.put("GooglerDance", new GooglerDance());
    hmPuzzleSolvers.put("RecycledNumbers", new RecycledNumbers());
    
    return hmPuzzleSolvers.get(puzzleName);
      
  }
}
