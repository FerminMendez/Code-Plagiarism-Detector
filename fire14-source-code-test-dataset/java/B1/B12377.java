import java.io.*;
import java.util.*; 

public class RecycledNumbers {

 public static void main(String[] args) {
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String s = in.readLine().trim();
         int t = Integer.parseInt(s);
 
         for (int i = 0; i < t; i++) {
            String[] input = in.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int total = 0;

           int n;
           int m;
           while (a <= b) {
              n = a;
              m = n+1; 
              while (m <= b) {
               //System.out.println("PAIR (n,m) = (" + n + "," + m + ")");
                StringBuffer strN = new StringBuffer(""+n);  
                //System.out.println("strN: " + strN);  
                for (int j = 0; j < strN.length()-1; j++) {
                  strN.append(strN.charAt(0));
                  strN.delete(0,1);
                  //System.out.println("shifted strN..." + strN ); 
                  //System.out.println("BUG" + strN.toString().equals(""+m));
                  if (Integer.parseInt(strN.toString()) == m) {
                     //System.out.println("^--------PAIR FOUND-------^");
                     total++;
                     break;
                  }
/*
                  if (a < Integer.parseInt(n.toString()) && Integer.parseInt(n.toString()) <= b) {
System.out.println("---------->found pair (n,m) = (" + a + "," + n + ")" );
                     total++;
                  } 
               else if (Integer.parseInt(n.toString()) == a && Integer.parseInt(n.toString()) == b ) {
                  total++; 
               }  
                  else if (Integer.parseInt(n.toString()) == b) {
System.out.println("---------->found pair (n,m) = (" + a + "," + n + ")" );
                     total++; 
                  }
                  else { System.out.println("*********>IS NOT a pair (n,m) = (" + a + "," + n + ")" ); } */
       /*           if (Integer.parseInt(n.toString()) == a) { total++; break; } */
                }  
                m++;
              }
              a++;
           }


/*
            while (a <= b) {
               if ( a < 10 ) {
                  break;
               }  
               StringBuffer n = new StringBuffer(""+a);  
System.out.println("n: " + n);  
               for (int j = 0; j < n.length()-1; j++) {
                  n.append(n.charAt(0));
                  n.delete(0,1);
                  System.out.println("shifted n..." + n ); /*
                  if (a < Integer.parseInt(n.toString()) && Integer.parseInt(n.toString()) <= b) {
System.out.println("---------->found pair (n,m) = (" + a + "," + n + ")" );
                     total++;
                  } 
               else if (Integer.parseInt(n.toString()) == a && Integer.parseInt(n.toString()) == b ) {
                  total++; 
               }  
                  else if (Integer.parseInt(n.toString()) == b) {
System.out.println("---------->found pair (n,m) = (" + a + "," + n + ")" );
                     total++; 
                  }
                  else { System.out.println("*********>IS NOT a pair (n,m) = (" + a + "," + n + ")" ); } */
       /*           if (Integer.parseInt(n.toString()) == a) { total++; break; }
               }*/
/*  
                  if (Integer.parseInt(n.toString()) < a || Integer.parseInt(n.toString()) > b) {
                   
                  } 
                  else if (n.charAt(0) == '0' || input[1].charAt(0) == '0' ) {

                  }
                  else if (Integer.parseInt(n.toString()) == a && Integer.parseInt(n.toString()) == b ) {
                     total++;                
                  } 
                  else if (Integer.parseInt(n.toString()) > a && Integer.parseInt(n.toString()) <= b ) {
                     total++;
                  }   
               } */  /*
              a++;
            }  
            System.out.println("Case #" + (i+1) + ": " + total);  */
            System.out.println("Case #" + (i+1) + ": " + total);  
         }   
         
      }
      catch (IOException e) {
         e.printStackTrace();
      }   	
 }
}
