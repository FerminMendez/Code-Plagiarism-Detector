package y2012;

import java.io.*;
import java.util.Arrays;

public class Glob {

  /**
  * Fetch the entire contents of a text file, and return it in a String.
  * This style of implementation does not throw Exceptions to the caller.
  *
  * @param aFile is a file which already exists and can be read.
  */
  static public void IOwork() {
    //...checks on aFile are elided
    try {
      //use buffering, reading one line at a time
      //FileReader always assumes default encoding is OK!
      BufferedReader input =  new BufferedReader(new FileReader(new File("F:\\file.in")));
      Writer output = new BufferedWriter(new FileWriter(new File("F:\\file.out")));
      try {
        String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
        line = input.readLine();
        int NoOfCases = Integer.parseInt(line);
        for (int i = 0; i < NoOfCases; i++) {
        	line = input.readLine();
        	String[] v1 = line.split(" ");
        	int t = Integer.parseInt(v1[0]);
        	int s = Integer.parseInt(v1[1]);
        	int p = Integer.parseInt(v1[2]);
        	int answer = 0;
        	System.out.println(t);
        	System.out.println(s);
        	System.out.println(p);
        	for (int j = 3; j < v1.length; j++) {
        		int temp = Integer.parseInt(v1[j]);
        		if (temp > 0) {
        		switch (temp%3) {
        		case 0 : {
        			if (temp/3 >= p) answer++;
        			else if (temp/3+1 == p && s > 0) {
        				answer++;
        				s--;
        			}
        			break;
        		}
        		case 1 : {
        			if (temp/3+1 >= p) answer++;  	
        			break;
        		}
        		case 2 : {
        			if (temp/3+1 >= p) answer++;
        			else if (temp/3+2 == p && s > 0) {
        				answer++;
        				s--;
        			}
        			break;
        		}
        		}
        		}
        		else if (p == 0) answer++;
        	}
        	output.write("Case #"+(i+1)+": "+answer+"\n");
        }
      }
      finally {
        input.close();
        output.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
  }
  
  private static int rope(int[][] lines) {
	  int ans = 0;
	  for (int i = 0; i < lines.length-1; i++){
		  for (int j = i+1; j < lines.length; j++) {
			  if ((lines[i][0] > lines[j][0] && lines[i][1] < lines[j][1])||(lines[i][0] < lines[j][0] && lines[i][1] > lines[j][1]))
				  ans++;
		  }
	  }
	return ans;
  }
  
  public static void main (String[] aArguments) throws IOException {
	  IOwork();
	  }
}