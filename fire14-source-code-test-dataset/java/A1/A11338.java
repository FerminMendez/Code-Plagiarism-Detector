package codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Util {
	public int testcases;
	BufferedReader br;
	public Util(String file) throws FileNotFoundException {
	      FileInputStream fstream = new FileInputStream(file);
	      Reader r = new BufferedReader(new InputStreamReader(fstream));
	      //while(st.nextToken())
	      DataInputStream in = new DataInputStream(fstream);
	      br = new BufferedReader(new InputStreamReader(in));
	      String str="";
	      try {
	    	  str = br.readLine();
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	      testcases = Integer.parseInt(str);
	}
	
	public String nextLine() throws IOException {
		return br.readLine();
	}
	
	protected void finalize() {
		try {br.close();}catch(IOException e){}
	}
}
