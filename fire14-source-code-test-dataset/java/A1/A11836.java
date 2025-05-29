public class QualBDancingWithTheGooglers
{
   static boolean debug = false;

   public static void main(String[] args)
   {
      Utils.openInFile("B-small-attempt0.in");
      Utils.openOutFile("out.txt", debug);
      String input = Utils.readFromFile();
      int lineCount = Integer.parseInt(input);

      //while ((input = Utils.readFromFile()) != null)
      for (int line = 1; line <= lineCount; line++)
      {
         if (debug) System.out.println();
         input = Utils.readFromFile();
         String[] split = input.split(" ");
         int Number = Integer.parseInt(split[0]),
             Surprising = Integer.parseInt(split[1]),
             points = Integer.parseInt(split[2]);
         int[] allPoints = new int[Number];
         for (int j = 0; j < Number; j++)
            allPoints[j] = Integer.parseInt(split[j+3]);
         String output = "";

         int mustBeSurprisingCount = 0, count = 0;
         
         for (int sumP: allPoints)
         {
            int mod = sumP%3;
            int third = sumP/3;
            int minP = third, maxP = third, minPSup = third, maxPSup = third;
            switch (mod)
            {
               case 0: minPSup--; maxPSup++; break;
               case 1: maxP++; minPSup--; maxPSup++; break;
               case 2:
               default:maxP++; maxPSup+=2;
            }
            if (debug) System.out.println("third="+third);
            if (points <= maxP)
               count++;
            else if (2 <= sumP && sumP <= 28 && points <= maxPSup)
               mustBeSurprisingCount++;
         }

         if (debug)
         {
            System.out.println("input="+input);
            System.out.println("count="+count);
            System.out.println("mustBeSurprisingCount="+mustBeSurprisingCount);
         }
         output = "Case #" + line + ": ";
         output += (count + Math.min(mustBeSurprisingCount, Surprising));
         Utils.writeToFile(output);
      }
      Utils.closeInFile();
      Utils.closeOutFile();
   }
}
