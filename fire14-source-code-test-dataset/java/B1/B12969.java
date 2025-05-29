public class A {
   public static void main(String[] a) {
       //System.out.println(a(1,9));
       //System.out.println(a(10,40));
       //System.out.println(a(100,500));
       //System.out.println(a(1111,2222));

       java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
       int i=0;
       String line = null;
       try {
       while((line=reader.readLine())!=null) {
          if(i>0) {
              System.out.println("Case #"+i+": "+parseLine(line));
          }
          i++;
       
       } 
       } catch(Exception e) {}
   }

   static int parseLine(String line) {
       String p[] = line.split(" ");
       return a(Integer.valueOf(p[0]), Integer.valueOf(p[1]));
   }

   public static int a(int a, int b) {
      if(a>=b) return 0;
      if(b<10) return 0; //1 digit. return 0

      java.util.HashMap<Integer, Byte> map = new java.util.HashMap<Integer, Byte>();
      int count=0;
      for(int i=a;i<=b;i++) {
          String x = String.valueOf(i);

          for(int j=1; j<x.length();j++) {
              String y1 = x.substring(j);
              String y2 = x.substring(0, j);
              if(y1.charAt(0)=='0') continue;

              String y = y1 + y2;
              int m = Integer.valueOf(y);

              //System.out.println(i+"m"+m+","+y+","+x+"j"+j);
              if(a<=m && m<=b) { 
                  //System.out.println(i+","+m);
                  if(i<m && map.get((i+","+m).hashCode())==null) {
                      //System.out.println(i+","+m);
                      map.put((i+","+m).hashCode(), (byte)0);
                      count++;
                  } /*else if(map.get(i+","+m)!=null){
                     System.out.println(i+","+m);
                  }*/
              }
          }
      }

      return count;
   }
}
