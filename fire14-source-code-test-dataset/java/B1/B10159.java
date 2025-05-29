
import java.util.*;
import java.io.*;

public class CodeJam {
	  public static void main (String[] args){
        try{
          //recycleLarge(1000000, 2000000);
	      // read
	      FileInputStream instream = new FileInputStream("A-small.in");
	      DataInputStream in = new DataInputStream(instream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));

	      // write
	      FileOutputStream outstream = new FileOutputStream("A-small.out");
	      DataOutputStream out = new DataOutputStream(outstream);
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

	      // reading file information
	      int testcases = Integer.parseInt(br.readLine());
	      for(int i=0; i < testcases; i++){
	        // -------------------------------------------------------------------------------------------------------------
	        String line = br.readLine();
            String[] items = line.split(" ");
            int A = Integer.parseInt(items[0]);
            int B = Integer.parseInt(items[1]);
	        // -------------------------------------------------------------------------------------------------------------
	        bw.write("Case #" + (i + 1) + ": " + recycle(A, B) + "\r\n");
	      }

	      // close input file
	      in.close();
	      // close output file
	      bw.flush();
	      out.close();
	    }catch(Exception e)
	    {
	      System.err.println("Error: " + e.getMessage());
	    }
	  }

      private static int eval(int i){
          if ( i < 0)
              return 0;
          else
              return i;
      }

      private static void printArray(Object [] array){
          for(Object ch : array)
            System.out.print(ch);
      }

      private static boolean isRecycled(String str, String m){
        for(int i = 1; i <str.length(); i++){
          String digits = str.substring(i) + str.substring(0, i);
          if (digits.equals(m)) return true;
        }
        return false;
      }

      private static String convertTo(int n){
          String str = "";
          while(n != 0){
            str = (n%10) + str;
            n = n/10;
          }
          return str;
      }

      private static long recycle(int A, int B){
          long count = 0;
          for(int n=A; n <B; n++){
              for(int m=n+1; m <=B; m++){
                 String nstr = convertTo(n);
                 String mstr = convertTo(m);
                 if(isRecycled(nstr, mstr))
                    count++;
              }
          }
          return count;
      }

    private static long recycleLarge(int A, int B) {
        long count = 0;
        Set<String> set = new HashSet<String>();
        String bstr = convertTo(B-1);
        for (int n = A + 1; n < B - 1; n++) {
            String nstr = convertTo(n);
            for (int i = 1; i < nstr.length(); i++) {
                String digits = nstr.substring(i) + nstr.substring(0, i);
                if (isGreater(digits, nstr) && isLess(digits, bstr)){
                    set.add(digits);

                }
            }
        }
        return set.size();
    }


    private static boolean isLess(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) < B.charAt(i)) return true;
            else if (A.charAt(i) > B.charAt(i)) return false;
        }
        return false;
    }

    private static boolean isGreater(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) > B.charAt(i)) return true;
            else if (A.charAt(i) < B.charAt(i)) return false;
        }
        return false;
    }

}

