import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class QualCRecycledNumbers
{
   static boolean debug = false;
   static int MIN = 1, MAX = 2500;
   //static int MIN = 1, MAX = 2000000;

   static void print(String str) { if (debug) System.out.print(str); }
   static void println(String str) { if (debug) System.out.println(str); }
   static void println(int str) { if (debug) System.out.println(str); }
   static void println() { if (debug) System.out.println(); }

   public static void main(String[] args)
   {
      Utils.openInFile("C-small-attempt0.in");
      Utils.openOutFile("out.txt", debug);
      String input = Utils.readFromFile();
      int lineCount = Integer.parseInt(input);

      HashMap<Integer, ArrayList<Integer>> recyclable = new HashMap<Integer, ArrayList<Integer>>();
      HashSet<Integer> cleared = new HashSet<Integer>(MAX);

      for (int i = MIN; i < MAX; i++)
      {
         if (i % 100000 == 0)
            System.out.println(i);
         if (cleared.contains(i))
            continue;
         int newVal = i;
         String iStr = ""+i;
         ArrayList<Integer> array = new ArrayList<Integer>();
         print("i="+i+": ");
         do
         {
            String numStr = ""+newVal;
            while (numStr.length() < iStr.length())
               numStr = "0"+numStr;
            numStr = numStr.charAt(numStr.length()-1) + numStr.substring(0, numStr.length()-1);
            newVal = Integer.parseInt(numStr);
            if ((""+newVal).length() < iStr.length())
               continue;
            cleared.add(newVal);
            print(newVal + " ");
            array.add(newVal); // adds itself at the end
         }
         while (newVal != i);
         println();
         if (!array.isEmpty())
         {
            Collections.sort(array);
            recyclable.put(i, array);
         }
      }

      for (int line = 1; line <= lineCount; line++)
      {
         println();
         input = Utils.readFromFile();
         String[] split = input.split(" ");
         int AMin = Integer.parseInt(split[0]),
             BMax = Integer.parseInt(split[1]);

         ArrayList<Integer> array;
         int count = 0;
         for (int i = 0; i <= BMax; i++)
         {
            if ((array = recyclable.get(i)) != null)
            {
               // min is implicitly enforced from structure
               int tempcount = 0;
               int stop = array.size(),
                   start = array.size();
               for (int k = 0; k < array.size(); k++)
               {
                  if (start == array.size() && array.get(k) >= AMin)
                     start = k;
                  if(array.get(k) > BMax)
                     { stop = k; break; }
               }
               if (stop == 1) continue;
               int diff = stop-start;
               //tempcount += stop*(stop-1)/2;
               tempcount += diff*(diff-1)/2;
               count += tempcount;
               print("i="+i+" count="+tempcount+", diff="+(stop-start));
               for (int j = start; j < stop; j++)
               {
                  print(" "+array.get(j));
               }
               println();
            }
         }
         println("input="+input);
         String output = "Case #" + line + ": ";
         output += count;
         Utils.writeToFile(output);
         //if (line == 3) break;
      }
      Utils.closeInFile();
      Utils.closeOutFile();
   }
}
