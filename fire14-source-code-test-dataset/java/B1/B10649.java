/*
Original template used was test.java from USACO's training pages.

Name: Ante Qu
Problem: Recycled Numbers
Gmail Account: quante0

*/

import java.io.*;
import java.util.*;

class recycledNumbers {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("C-small-attempt2.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));


    int T=Integer.parseInt(f.readLine());
    for(int i=0;i<T;i++)
    {
      out.println("Case #" + (i+1) + ": " + solve(f.readLine()));                           // output result
    }
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
  public static String solve(String source)
  {
      // Use StringTokenizer vs. readLine/split -- lots faster
      StringTokenizer st = new StringTokenizer(source);
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int length = 1 + (int) Math.log10(B);
      int total = 0;
      for (int i = A; i <= B; i++)
      {
          int count = 0;
          int[] k = new int[length+1];
          for (int j = 1; j < length; j++)
              if (withInRange(shift(i, j, length),A,B, i))
                  {
                     k[count] = shift(i,j,length);
                    // System.out.println(shift(i,j,length) + " " + i);
                     count++;
                  }
          Arrays.sort(k, 0, count);
          int countcopy = count;
          for (int j = 1; j < countcopy; j++)
              if (k[j] == k[j-1]) 
                  {
                  count--;
                 // System.out.println("-1");
                  }
          total += count;
      }
      return String.valueOf(total / 2);
  }
  private static boolean withInRange(int x, int A, int B, int i)
  {
      if (x < A) return false;
      if (x > B) return false;
      if (x == i) return false;
      return true;
  }
  private static int shift(int current, int by, int length)
  {
      int power = (int) Math.pow(10, by);
      int shift = (int) Math.pow(10, length - by);
      return (current % power) * shift + current / power;
      
  }
  public static char translateChar(char current)
  {

      if (current == ' ') return ' ';
      if (current == 'a') return 'y';
      if (current == 'b') return 'h';
      if (current == 'c') return 'e';
      if (current == 'd') return 's';
      if (current == 'e') return 'o';
      if (current == 'f') return 'c';
      if (current == 'g') return 'v';
      if (current == 'h') return 'x';
      if (current == 'i') return 'd';
      if (current == 'j') return 'u';
      if (current == 'k') return 'i';
      if (current == 'l') return 'g';
      if (current == 'm') return 'l';
      if (current == 'n') return 'b';
      if (current == 'o') return 'k';
      if (current == 'p') return 'r';
      if (current == 'q') return 'z';
      if (current == 'r') return 't';
      if (current == 's') return 'n';
      if (current == 't') return 'w';
      if (current == 'u') return 'j';
      if (current == 'v') return 'p';
      if (current == 'w') return 'f';
      if (current == 'x') return 'm';
      if (current == 'y') return 'a';
      if (current == 'z') return 'q';
      return '.';
  }
}