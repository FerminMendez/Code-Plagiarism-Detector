package com.jagsaund.codejam.qualifcation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DancingWithGooglers {
  private List<List<Integer>> _sets;
  private int _numOfSurprisingTriplets;
  private int _minResult;
  
  public DancingWithGooglers() {
    _sets = new ArrayList<List<Integer>>();
  }
  
  public String run(String line) {
    int[] googlers = null;
    int numOfGooglers;
    
    int pos = 0;
    
    StringTokenizer tokenizer = new StringTokenizer(line);
    
    while (tokenizer.hasMoreElements()) {
      int v = Integer.parseInt(tokenizer.nextToken());
      if (pos == 0) {
        numOfGooglers = v;
        googlers = new int[numOfGooglers];
      } else if (pos == 1) {
        _numOfSurprisingTriplets = v;
      } else if (pos == 2) {
        _minResult = v;
      } else {
        googlers[pos-3] = v;
      }
      
      pos++;
    }
    
    int count = 0;
    
    for (int number : googlers) {
      getIntegerSet(number);
      
      if (_sets.size() > 0) {
        if (_sets.size() == 1) {
          List<Integer> set = _sets.get(0);
          
          int low = Integer.MAX_VALUE;
          int high = Integer.MIN_VALUE;
          
          for (int n : set) {
            if (n < low) low = n;
            if (n > high) high = n;
          }
          
          if ((high - low) == 2 && _numOfSurprisingTriplets > 0) {
            _numOfSurprisingTriplets--;
            count++;
          } else if ((high - low) < 2) {
            count++;
          }
        
        } else {
          count++;
        }
      }
      
      
//      if (number == 0 && _minResult == 0) count++;
      
      _sets.clear();
    }
    
    return count + "";
  }
  
  private void getIntegerSet(int x) {
    getIntegerSet(x, x, new ArrayList<Integer>());
  }
  
  private void getIntegerSet(int x, int max, List<Integer> prefix) {
    if (x == 0) {
      if (prefix.size() <= 3) {
        if (prefix.size() == 2) {
          prefix.add(0);
        }
        
        if (prefix.size() == 1) {
          prefix.add(0);
          prefix.add(0);
        }
        
        if (prefix.size() == 0) {
          prefix.add(0);
          prefix.add(0);
          prefix.add(0);
        }
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for (int n : prefix) {
          if (n < low) low = n;
          if (n > high) high = n;
        }
        
        if (high >= _minResult && (high - low) <= 2 && high <= 10) {
          _sets.add(prefix);  
        }
      }
      
      return;
    }
    
    for (int i=Math.min(x, max); i>=1; i--) {
      List<Integer> tmp = new ArrayList<Integer>(prefix);
      tmp.add(i);
      getIntegerSet(x-i, i, tmp);
    }
  }
}
