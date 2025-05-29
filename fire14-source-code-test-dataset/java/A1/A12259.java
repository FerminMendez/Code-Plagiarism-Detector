import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class B {
		
public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new FileReader("C:/Users/Disha/Desktop/codejam/B-small.in"));
  FileWriter fw = new FileWriter("C:/Users/Disha/Desktop/codejam/B-small.out");
  /*BufferedReader in = new BufferedReader(new FileReader("C:/Users/Disha/Desktop/codejam/B-large.in"));
  FileWriter fw = new FileWriter("C:/Users/Disha/Desktop/codejam/B-large.out");
*/
  int N = new Integer (in.readLine());
  for (int cases = 1; cases <= N; cases++) {
	  String[] ss = in.readLine().split(" ");
	  int nGoog = Integer.parseInt(ss[0]);
	  int nSur = Integer.parseInt(ss[1]);
	  int atleast = Integer.parseInt(ss[2]);
	  int count = 0;
	  int j = 3;
	  for(int i=0; i<nGoog ; i++){
		  int score = Integer.parseInt(ss[j]);
		  j++ ;
		  if (score == 0 && atleast == 0){
			  count++;
			  continue;
		  }
		  if (score < Math.abs(3 * atleast - 4)){continue;}
		  else if (score >= (3 * atleast - 2)) {count++ ;}
		  else {
			  if (nSur > 0)
			  {count ++;
			  nSur--;
			  }
		}
	}
    	fw.write ("Case #" + cases + ": " + count + "\n" );
      }
  fw.flush();
  fw.close();
  }}
