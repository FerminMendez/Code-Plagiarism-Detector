package com.google.codejam.qualification.recycled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RecycledNumbers {
   private static final List<Case> cases = new ArrayList<Case>();

   public static void main(String[] args) throws NumberFormatException, IOException {
      // String file = "src/resources/C-example";
      String file = "src/resources/C-small-attempt0";
      // String file = "src/resources/C-large";
      readInFile(file + ".in");
      FileWriter fstream = new FileWriter(file + ".out");
      BufferedWriter out = new BufferedWriter(fstream);

      for (int i = 0; i < cases.size(); i++) {
         String msg = "Case #" + (i + 1) + ": " + cases.get(i).getResult() + "\n";
         out.write(msg);
         System.out.print(msg);
      }
      out.close();

   }

   protected static void readInFile(String path) throws NumberFormatException, IOException {
      DataInputStream in = new DataInputStream(new FileInputStream(path));
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int lines = Integer.parseInt(br.readLine());
      for (int i = 0; i < lines; i++) {
         cases.add(new Case(br.readLine()));
      }
      in.close();
   }
}

class Case {
   int A, B;

   public Case(String line) {
      StringTokenizer tokenizer = new StringTokenizer(line);
      A = Integer.parseInt(tokenizer.nextToken());
      B = Integer.parseInt(tokenizer.nextToken());
   }

   protected int getResult() {
      int ctr = 0;
      System.out.print("\\b[--");
      for (int i = A; i < B; i++) {
         for (int j = i + 1; j <= B; j++) {
            if (isRecycledPair(String.valueOf(i), String.valueOf(j))) {
               ctr += 1;
            }
         }

      }
      return ctr;
   }

   boolean isRecycledPair(String n, String m) {
      if (n.length() != m.length()) {
         return false;
      }

      char[] narr = n.toCharArray();
      Arrays.sort(narr);
      char[] marr = m.toCharArray();
      Arrays.sort(marr);
      if (!new String(narr).equals(new String(marr))) {
         return false;
      }

      for (int displacement = 1; displacement < n.length(); displacement++) {
         boolean recycled = true;
         for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != m.charAt(mod(i + displacement, n.length()))) {
               recycled = false;
               break;
            }
         }
         if (recycled) {
            // System.out.println("   " + n + " -> " + m + " : " + displacement);
            return true;
         }
      }

      return false;
   }

   protected static int mod(int a, int b) {
      int r = a % b;
      if (r < 0) {
         r += b;
      }
      return r;
   }
}
