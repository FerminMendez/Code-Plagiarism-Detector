import java.util.*;
import java.io.*;

public class TripletGenerator
{
   private static Map<Integer, TripletPair> mapTotalScoreToGroup = new Hashtable<Integer, TripletPair> ();
   
   private int dancerScore[] = new int[] {15, 13, 11};
   
   private int surpriseCount = 1;
   
   private int pointMark = 5;
   
   private int finalValue = 0;
   
   public TripletGenerator (int dancerScore[], int surpriseCount, int pointMark)
   {
      this.dancerScore = dancerScore;
      this.surpriseCount = surpriseCount;
      this.pointMark = pointMark;
   }   
   
   public static void main (String arg[]) throws IOException
   {
      if (arg.length != 1)
      {
         System.out.println("Usage : java TripletGenerator <InputFile>");
         System.exit(1);
      }
      TripletGenerator.processInput(new File(arg[0]));
   }   
   
   public static void processInput (File fileName) throws IOException
   {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      PrintWriter out = new PrintWriter ("output.txt");
      
      TripletGenerator.populateMap();
      TripletGenerator.displayScoreMap();
      
      int caseCount = new Integer (in.readLine());
      for (int i = 0; i < caseCount; ++i)
      {
         String currLine = in.readLine();
         if (currLine == null)
            throw new IllegalArgumentException("Lesser Lines to complete case " + (i+1));

         String token[] = currLine.split(" ");
         int num[] = new int [token.length];
         
         for (int j= 0; j < token.length; ++j)
            num[j] = new Integer (token[j]);
         
         int dancerCount = num[0];
         int dancerScore[] = new int [dancerCount];
         int surpriseCount = num[1];
         int pointMark = num[2];
         System.arraycopy(num, 3, dancerScore, 0, dancerCount);
         
         TripletGenerator generator = new TripletGenerator(dancerScore, surpriseCount, pointMark);
         int finalValue = generator.getFinalValue();         
         out.println ("Case #" + (i+1) + ": " + finalValue);         
      }
      in.close();
      out.close();      
   }
   
   public int getFinalValue ()
   {
      recurCombination (0, new boolean[dancerScore.length], 0);
      return finalValue;
   }
   
   private void recurCombination (int dancerIndex, boolean comb[], int currSurpriseCount)
   {
      if (currSurpriseCount > surpriseCount)
         return;
      
      if (dancerIndex == dancerScore.length)
      {
         if (currSurpriseCount != surpriseCount)
            return;
         
         int currValue = getCombinationValue(comb);
         
         if (currValue > finalValue)
            finalValue = currValue;
         
         return;
      }
      
      for (boolean isSurprise : new boolean [] {false, true})
      {
         comb[dancerIndex] = isSurprise;
         
         if (isSurprise)
            recurCombination (dancerIndex + 1, comb, currSurpriseCount + 1);
         else
            recurCombination (dancerIndex + 1, comb, currSurpriseCount);
            
      }
   }
   
   private int getCombinationValue (boolean comb[])
   {
      Triplet triplet [] = new Triplet [dancerScore.length];
      
      System.out.println("---------------------------------");
      System.out.println("Combination = " + Arrays.toString(comb));
      
      int value = 0;
      for (int i = 0; i < dancerScore.length; ++i)
      {
         int currDancerScore = dancerScore [i];
         TripletPair tripletPair = mapTotalScoreToGroup.get(currDancerScore);
         triplet[i] = (comb[i]) ? tripletPair.tripletSurprise : tripletPair.tripletRegular;
         
         if (triplet[i] == null)
            return 0;
         
         System.out.println(triplet[i].totalScore +  " " + triplet[i]);
         if (triplet[i].maxScore >= pointMark)
            value++;
      }
      System.out.println("Value = " + value);
      return value;
         
   }
   
   private static void displayScoreMap ()
   {
      for (int i = 0; i <= 30; ++i)
      {
         TripletPair tripletPair = mapTotalScoreToGroup.get(i);
         System.out.println(String.format("%2d %s", i, tripletPair));
      }
   }
   
   public static void populateMap () 
   {
      for (int i = 0; i <= 10; ++i)
      {
         for (int j = 0; j <= 10; ++j)
         {
            if (Math.abs(i-j) > 2)
               continue;
            
            for (int k = 0; k <= 10; ++k)
            {
               if (Math.abs(i-k) > 2 || Math.abs(j-k) > 2)
                  continue;
               
               Triplet triplet = new Triplet(i, j, k);
               TripletPair tripletPair = mapTotalScoreToGroup.get(triplet.totalScore);
               
               if (tripletPair == null)
                  tripletPair = new TripletPair();
               tripletPair.set(triplet);
               mapTotalScoreToGroup.put(triplet.totalScore, tripletPair);
            }
         }
      }
   }

   private static Triplet max (Triplet tA, Triplet tB)
   {
      if (tA == null && tB == null)
         throw new IllegalStateException ("Both the triplets are null!");
      
      if (tA == null)
         return tB;
      
      if (tB == null)
         return tA;
      
      return (tB.maxScore > tA.maxScore) ? tB : tA;
   }   
   
   static class TripletPair
   {
      Triplet tripletSurprise = null;
      Triplet tripletRegular  = null;
      
      public void set (Triplet triplet)
      {
         if (triplet.isSurprise)
            tripletSurprise = (tripletSurprise == null) ? triplet : TripletGenerator.max (tripletSurprise, triplet);
         else
            tripletRegular  = (tripletRegular  == null) ? triplet : TripletGenerator.max (tripletRegular , triplet);
      }
      
      public String toString ()
      {
         String strRegular  = (tripletRegular == null)  ? "-" : tripletRegular.toString(); 
         String strSurprise = (tripletSurprise == null) ? "-" : tripletSurprise.toString();
         return String.format("%-20s %-20s", strRegular,  strSurprise);
      }
   }
   
   static class Triplet 
   {
      int x, y, z;
      
      boolean isSurprise = false;
      
      int maxScore, totalScore;
      
      public Triplet (int x, int y, int z)
      {
         this.x = x;
         this.y = y;
         this.z = z;
         this.totalScore = x + y + z;
         
         int min = Math.min (Math.min(x, y), z);
         int max = Math.max (Math.max(x, y), z);

         if (max - min < 0 || max - min > 2)
            throw new IllegalStateException ("Max=" + max + " Min=" + min);
         
         isSurprise = (max - min < 2) ? false : true;
         maxScore = max;
      }
      
      @Override
      public String toString ()
      {
         return String.format("%d,%d,%d,%s,%d", x, y, z, "" + isSurprise, maxScore);
      }
   }   
}
