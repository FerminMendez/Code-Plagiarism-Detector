package com.jam.google;

import java.util.List;

public class RecycledNumbers {

  public int count(int a, int b) {
    int pairCount = 0;
    for (int i = a; i <= b; i++) {
      int candidate = i;
      int j = 1;
      while( (candidate = recycle(i,j++) ) != i) {
        if (candidate > i && candidate <=b)
          pairCount++;
      }
    }
    return pairCount;
  }

  public int recycle(int i, int offset) {
    String string = String.valueOf(i);
    int answer = i;
    if (string.length()>1) {
      String recycledString = string.substring(string.length()-offset) + string.substring(0, string.length()-offset);
      answer = Integer.parseInt(recycledString);
    }
    return answer;
  }

  public void test() {
    InputUtil util = new InputUtil();
//    List<String> lines = util.readFile("test1.txt");
    List<String> lines = util.readFile("C-small-attempt2.in");
//    int N = Integer.parseInt(lines.remove(0));
    int i = 1;
    for (String string : lines) {
      String[] split = string.split(" ");
      int count = count(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
      System.out.println("Case #"+(i++)+": "+count);
    }
    
  }

  
}
