import java.io.*;
import java.util.*;

public class RecycledNumbers {

private static ArrayList<String> A,B; 

public static void main(String[] args) throws Exception {

File in = new File("C-small-attempt0.in");
File out = new File("out.txt");
RecycledNumbers.read(in);
RecycledNumbers.print(out);


}
 

public static void read (File file) throws FileNotFoundException {
 Scanner scanner = new Scanner (file);
 int cases = scanner.nextInt();
 A = new ArrayList<String>(cases);
 B = new ArrayList<String>(cases);
 while (scanner.hasNext()) {
    A.add(scanner.next());
    B.add(scanner.next());    
 }
}
 
public static void print (File file) throws FileNotFoundException {
 PrintStream fileStream = new PrintStream (file);
 for (int i = 0; i < A.size(); i++) {
    //fileStream.println(A.get(i) + " " + B.get(i));
    fileStream.println("Case #" + (i+1) +": " + test(A.get(i),B.get(i)));
 }
fileStream.close();
}

public static int test(String A, String B) {

int returnThis = 0;

if (A.length() == 1) {
   return 0;
}

   int limit = Integer.valueOf(B); 
   int start = Integer.valueOf(A);
   for (int i = start; i <= limit; i++) {
      String base = Integer.toString(i);
      int count = 1;
      String m = "" + base.charAt(base.length() - count); 
      while (true) {                  
         String out = m + base.substring(0, base.length() - count);
         //System.out.println(base+": " + out);
         if (verify(base, out, limit)) {
           // System.out.println("A: "+A +" B: " + B + " base: " + base +" out: " + out);
            returnThis++;
         }
         count++;
         if (base.length() <= count) break;
         if (base.equals(out)) break;
         m = base.charAt(base.length() - count) + m;  
      }     
   }
//System.out.println(returnThis);
return returnThis;
}

public static boolean verify(String n, String m, int limit) {
   if (m.charAt(0) == '0') return false;
   if (Integer.valueOf(n) < Integer.valueOf(m) && Integer.valueOf(m) <= limit) {
      return true;
   }
return false;
}

}
