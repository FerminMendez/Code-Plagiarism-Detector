package com.jam.google;

public class DancingWithTheGooglers {

  public int count(int n, int s, int p, String ts) {
    int count = 0;
    String[] split = ts.split(" ");
    for (String st : split) {
      int t = Integer.parseInt(st);
      int base = t / 3;
      if (base < p-2) continue;
      if (base>=p || 
          (base>= p-1 && t > 3*base) ||
          (base>= p-1 && (t > 3*base || (base > 0 && s-- >0))) ||
          (base>= p-2 && t-1 > 3*base && s-- >0) )
      count++;
    }
    return count;
  }
  
}
