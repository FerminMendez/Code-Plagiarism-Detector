   import java.io.*;
   import java.util.*;

   public class rec {
      public static void main (String [] args) throws Exception {
         BufferedReader f = new BufferedReader(new FileReader("rec.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rec.out")));
         int N = Integer.parseInt(f.readLine());
         for(int ie = 0; ie<N; ie++){
            s.clear();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int i = a; i<=b; i++)
               cont(i, a, b);
             //   for(int j = i+1; j<=b; j++)
         //          if(o(""+i, ""+j)){
         //             if(!s.containsKey(""+i))
         //                s.put(""+i, new TreeSet<String>());
         //             s.get(""+i).add(""+j);
         //          }
            for(String e:s.keySet())
               count+=s.get(e).size();
            out.println("Case #"+(ie+1)+": "+count);
         }
         out.close();
         System.exit(0);
      }
      static Map<String, TreeSet<String>> s = new TreeMap<String, TreeSet<String>>();
      static int cont(int w, int a, int b){
         int c = 0;
         String e = w+"";
         if(e.charAt(0) == '0')
            return 0;
         for(int i = 1; i<e.length(); i++){
            String t = e.substring(i)+e.substring(0, i);
            if(t.charAt(0) == '0')
               continue;
            int q = Integer.parseInt(t);
            if(q>=a && q<= b && q<w){
               c++;
               if(!s.containsKey(""+q))
                  s.put(""+q, new TreeSet<String>());
               s.get(""+q).add(""+w);
            }
         }
         return c;
      }
      static boolean o(String a, String b){
         int pos = 0;
         while(pos<a.length())
         {
            int ind = b.indexOf(a.charAt(0), pos);
            if(ind == -1)
               return false;
            int e = b.length()-ind;
            pos = ind+1;
            boolean r = a.charAt(0) != '0' && b.charAt(0) != '0' &&a.substring(0, e).equals(b.substring(ind)) && a.substring(e).equals(b.substring(0, ind));
            if(r)
               return true;
         }
         return false;
      }
   }