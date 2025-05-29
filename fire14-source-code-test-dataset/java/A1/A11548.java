   import java.io.*;
   import java.util.Scanner;
   import java.util.ArrayList;
   public class googler{
   
      public static void main(String[] args) throws IOException{
         Scanner fileScan = new Scanner(new File("infile.in"));
         Writer out = new OutputStreamWriter(new FileOutputStream("output.txt"));

         fileScan.nextLine();
         int i = 0;
         ArrayList<Integer> totals = new ArrayList<Integer>();
         while(fileScan.hasNext()){
            i++;
            int count = 0;
            totals.clear();
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            int n = lineScan.nextInt();
            int s = lineScan.nextInt();
            int p = lineScan.nextInt();
            while(lineScan.hasNext()){
               totals.add(lineScan.nextInt());
            }
         
            if (p == 0){
               count = totals.size();
            }
            else if (p == 1){
               for(int temp: totals){
                  if (temp > 0){
                     count++;
                  }
               }
            }
            else{
               int sureTotal = 3 * p -2;
               int surprisingTotal = 3 * p - 4;
               int surprise = 0;
               for (int temp: totals){
                  if (temp >= sureTotal){
                     count++;
                  }
                  else if (temp >= surprisingTotal){
                     surprise++;
                  }
               }
               count += ((s < surprise)? s: surprise);
            }
            out.write("Case #" + i + ": " + count + "\n");
         }
         out.close();
      }
   }