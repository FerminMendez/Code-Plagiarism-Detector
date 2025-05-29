package com.jagsaund.codejam.qualifcation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycledNumbers {
  public RecycledNumbers() {
    
  }
  
  public String run(String line) {
    int m;
    int n;
    
    StringTokenizer tokenizer = new StringTokenizer(line);
    
    n = Integer.parseInt(tokenizer.nextToken());
    m = Integer.parseInt(tokenizer.nextToken());
    
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    
    for (int i=0; i<=(m-n); i++) {
      String value = Integer.toString((i+n));
//      System.out.println("current value: " + value);
      
      if (!map.containsKey((i+n))) {
        map.put((i+n), new HashSet<Integer>());
      }
      
      for(int j=1; j<value.length(); j++) {
        value = value.substring(1) + value.charAt(0);
//        System.out.println("rotated value: " + value);
        
        int rotatedNumber = Integer.parseInt(value);
        
        if (rotatedNumber >= n && rotatedNumber <= m && rotatedNumber != (i+n)) {
          if (map.containsKey(rotatedNumber)) {
            
          } else {
            Set<Integer> set = map.get((i+n));
            set.add(rotatedNumber);
            map.put((i+n), set);
            
//            System.out.println("Added: " + rotatedNumber);
//            System.out.println("Current pairs: " + set.size());
          }
        }
    
      }
    }
    
    int count = 0;
    Set<Integer> keys = map.keySet();
    for (Iterator<Integer> it = keys.iterator(); it.hasNext();) {
      count += map.get(it.next()).size();
    }
    
    return count + "";
  }
}
