import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Recycled {
  public static void main(String[] args) {
	try {
	  Scanner sc = new Scanner(new File("input.in"));
	  FileOutputStream output = new FileOutputStream("output.txt");
	  PrintStream p = new PrintStream(output);
	  int cases = Integer.parseInt(sc.nextLine());
	  for ( int i = 0; i < cases; i++ ) {
	    String aCase = sc.nextLine();
		int res = -1;
		int A = 0, B = 0;
		Scanner tmp = new Scanner(aCase);
		if(tmp.hasNextInt())
		  A = tmp.nextInt();
        if(tmp.hasNextInt())
		  B = tmp.nextInt();
		
        if(A >= B)
		  res = 0;		
		else
	      res = findRecycle(A,B);
		  
		int x = i+1;
        p.println("Case #" + x + ": " + res);		
	  }
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
  }
  
   public static int findRecycle(int A, int B) {
     System.out.println("Find recycle " + A +", " + B);
     int count = 0;
	 for (int n = A; n < B; n++) {
	   for (int m = n + 1; m <= B; m++) {
	     if(isRecycled(Integer.toString(n), Integer.toString(m)))
		   count++;
		   //System.out.println(count);
	   }
	 }
	 return count;
   }
   
   public static boolean isRecycled(String n, String m) {
     int suffixes = n.length();
	 for (int i = 1; i < suffixes; i++) {
	   String tmp = n.substring(i);
       String toComp = tmp;
       for (int x = 0; x < i; x++) {
	     toComp += n.charAt(x);
       }	   
	   if(toComp.equals(m))
	     return true;	
	 }
     return false;
   }
  }