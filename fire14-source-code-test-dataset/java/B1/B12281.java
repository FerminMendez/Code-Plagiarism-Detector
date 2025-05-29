import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class C {
		
public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new FileReader("C:/Users/Disha/Desktop/codejam/C-small.in"));
  FileWriter fw = new FileWriter("C:/Users/Disha/Desktop/codejam/C-small.out");
  /*BufferedReader in = new BufferedReader(new FileReader("C:/Users/Disha/Desktop/codejam/C-large.in"));
  FileWriter fw = new FileWriter("C:/Users/Disha/Desktop/codejam/C-large.out");*/

  int N = new Integer (in.readLine());
  int count = 0;
  for (int cases = 1; cases <= N; cases++) {
	  count = 0;
	  String[] ss = in.readLine().split(" ");
	  int a = Integer.parseInt(ss[0]);
	  int b = Integer.parseInt(ss[1]);
      for (int here = a; here <= b; here++) {
		  int len = Integer.toString(here).length();   	  
		  int len2 = (int) (Math.pow(10, (len-1)));
    	  int num2 = 0;    	  
    	  int num1 = here;
    	  for(int i=0; i<= (len - 1) ; i++){
    		  num2 = (10 * (num1 % len2)) + (num1 / len2);
    		  while(Integer.toString(num2).length() < len){
    			  num2 = num2*10;
    			  i++;
    		  }
    		  
    		  if (num2 == here){
    			  break;
    		  }
    		  if ((num2 <= b) && (num2 > here)){
    		  count ++;
    		  }
    		  num1 = num2;
    	  }
      }
    	  fw.write ("Case #" + cases + ": " + count + "\n" );
      }
  fw.flush();
  fw.close();
  }}
