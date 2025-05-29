public class P {

   public static void main(String[] arg) { 

      //greedyPossibleTuple(new int[] {29,20,8,18, 18,21},8,2);
      //greedyPossibleTuple(new int[] {8,0}, 1,1);
      //greedyPossibleTuple(new int[] {23, 22, 21, 20, 29}, 8, 0);
      //System.out.println(parseLine("6 2 8 29 20 8 18 18 21"));

      java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
      try {
         String line;
         java.util.ArrayList<String> lines = new java.util.ArrayList<String>();
         while((line = in.readLine())!=null) {
              lines.add(line);
         }

         for(int i=1;i<lines.size();i++) {
              line = lines.get(i);
              System.out.println("Case #"+i+": "+parseLine(line));
         }

      } catch(Exception e) {
      }      
   }

   public static String parseLine(String l) {
      String[] pt = l.split(" "); 
      int N = Integer.valueOf(pt[0]);
      int S = Integer.valueOf(pt[1]);
      int p = Integer.valueOf(pt[2]);

      int t[] = new int[N];
      for(int i=3;i<pt.length;i++) {
          t[i-3]=Integer.valueOf(pt[i]); 
      }

      //System.out.println("AAA:"+p + "," +S+","+N); 
      return ""+greedyPossibleTuple(t, p, S); 
   }

   public static int greedyPossibleTuple(int[] data, int least, int maxsup) {
      boolean marker[] = new boolean[data.length];

      int scount = 0;
      for(int i=0;i<data.length;i++) {
           marker[i] = false;
           int m = computeTuple(data[i], true);
           if(m>=least) {
              scount++;
              marker[i]=true;
              //System.out.println("S:"+data[i]+","+m);
           }
      }

      int count = scount;
      for(int i=0;i<data.length;i++) {
           int m = computeTuple(data[i], false);
           if(m >= least) {
               //System.out.println("A:"+data[i]);
               if(marker[i]) {
                  scount--;
               } else {
                  marker[i] = true;
                  count++;
               }
           }
      }

      if(scount > maxsup) {
          count -= (scount - maxsup );
      }
      //System.out.println(count + "," +scount + "," + maxsup);

      //System.out.println("....");

      return count;
   }

   public static int computeTuple(int a, boolean s) {
      int min = (int)Math.floor((double)a/3);

      int g = s?2:1;
      int[] mines = {min, min, min};

      int i=0;
      int j=1;
     
      if(mines[0]+mines[1]+mines[2] == a && g<a) {
         mines[0]+=g-1;
         mines[2]-=g-1;
      }
 
      while(mines[0] + mines[1] + mines[2] < a) {
         mines[i]++;
         if(j%g==0) {
             i++;

             if(i>g) i=0;
         }
         j++;
      } 

      //System.out.println(mines[0]); 
      return mines[0];
   }
}
