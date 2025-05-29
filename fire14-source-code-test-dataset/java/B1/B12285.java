
   import java.io.*;
   import java.util.*;
   
    public class ProblemB {
   
       public static void main(String[] args) throws Exception {
      
         String filename = "C-small-attempt0.in";
         Scanner sc = new Scanner(new File(filename) );
      
         System.setOut(new PrintStream(new FileOutputStream("BSolution.txt")));
         int cases = Integer.parseInt(sc.next());
         sc.nextLine();
         
         for(int l = 1; l <= cases; l++) {
          	  
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            int counter = 0;	
            
            for(int m = B; m > A; m--) {
            
               for(int n = A; n < m; n++) {
               
                  if(isRecycled(n,m))
                     counter++;
               }
            }
         	
            System.out.print("Case #" + l + ": " + counter);
            System.out.println();
         }
      }
       public static boolean isRecycled(int n, int m) {
      
         String str = Integer.toString(n);
      	
         if(Integer.toString(n).length() != Integer.toString(m).length()) 
            return false;
         else {
            for(int k = 1; k < str.length(); k++) {
               String temp = "";
                  
               temp = str.substring(str.length() - k, str.length()) + str.substring(0, str.length() - k);
                 
               if(m == Integer.parseInt(temp))
                  return true;
               
            } 
         }
         return false;
      }
   }