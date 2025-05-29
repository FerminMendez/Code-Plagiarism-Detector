package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DancingWithGooglers {
	static List<String> fullList = new ArrayList<String>();
	
	public static void main(String[] args) {
		String pathIn = "D://B-small-attempt0.in";
		String pathOut = "D://B-small-attempt0.out";
		String line;
		
	    try {
	       BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(pathIn)));
	       while( (line = input.readLine()) !=null) {
	    	   fullList.add(line);
	       }
	       
	       BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathOut)));
	       
//	       int cases = Integer.parseInt(fullList.get(0));
	       
	       for (int i = 1; i < fullList.size(); i++) {
		       String[] tmpStringArray = fullList.get(i).split(" ");
		       int[] tmpIntArray = new int[tmpStringArray.length];
		       for(int j = 0; j < tmpIntArray.length; j++) {
		    	   tmpIntArray[j] = Integer.parseInt(tmpStringArray[j]);
		       }
		       
//		       int player = tmpIntArray[0];
		       int suprisings = tmpIntArray[1];
		       int best = tmpIntArray[2];
		       
		       int checks = 0;
		       
		       for (int j = 3; j < tmpIntArray.length; j++) {
		    	   if (tmpIntArray[j] >= (best * 3) - 2) {
		    		   checks++;
		    	   } else if (tmpIntArray[j] >= (best * 3) - 4 && suprisings > 0 && (best * 3) - 4 > 0) {
		    		   checks++;
		    		   suprisings -= 1;
		    	   }
		       }
		       
		       output.write("Case #" + i +  ": " + checks + "\n");
	       }
	       output.close();
	       
	       
	    } catch (FileNotFoundException e1) {
		       System.err.println("File not found: ");
		    	} catch (IOException e2) {
		       e2.printStackTrace();
	    }
	}
}
