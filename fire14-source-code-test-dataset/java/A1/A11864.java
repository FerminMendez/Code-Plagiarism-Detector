import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Utils {
	public static ArrayList<String> readFile(String filename){
		//replace local file with remote file from peerInfo address
		ArrayList<String> ret= new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(filename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		    //Read File Line By Line
		    while ((strLine = br.readLine()) != null)   {
		      // Print the content on the console
		      ret.add(strLine);
		    }
		    //Close the input stream
		    in.close();
				  
	    }
	   catch (Exception e) { e.printStackTrace(); }
	   return ret;
	}
	public static void writeFile(ArrayList<String> input, String filename){
		//replace local file with remote file from peerInfo address
		try{
		    // Create file 
		    FileWriter fstream = new FileWriter(filename);
		    BufferedWriter out = new BufferedWriter(fstream);
		    for (String string : input) {
		    	out.write(string+"\n");
			}
		    //Close the output stream
		    out.close();
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }
	}
	public static void compare(String filename1, String filename2){
		//replace local file with remote file from peerInfo address
		try {
			FileInputStream fstream1 = new FileInputStream(filename1);
		    // Get the object of DataInputStream
		    DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    String strLine1;
		    FileInputStream fstream2 = new FileInputStream(filename2);
		    // Get the object of DataInputStream
		    DataInputStream in2 = new DataInputStream(fstream2);
		    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
		    String strLine2;
		    boolean isDup=false;
		    //Read File Line By Line
		    while ((strLine1 = br1.readLine()) != null)   {
		    	strLine2 = br2.readLine();
		      // Print the content on the console
		      if(!strLine1.equals(strLine2)){
		    	  isDup=true;
		    	  System.out.println("1="+strLine1+", 2="+strLine2);
		      }
		    }
		    if(!isDup){
		    	System.out.println("same");
		    }
		    //Close the input stream
		    in1.close();
		    in2.close();
				  
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }
	}

	public static void sort(String input, String output){
		//replace local file with remote file from peerInfo address
		ArrayList<String> l= readFile(input);
		Collections.sort(l, new Comparator(){
			public int compare(Object arg0, Object arg1) {
				String st1=(String)arg0;
				String st2=(String)arg1;
				int i1=Integer.parseInt(st1.substring(st1.indexOf('#')+1, st1.indexOf(':')));
				int i2=Integer.parseInt(st2.substring(st2.indexOf('#')+1, st2.indexOf(':')));
				return i1-i2;
			}
			
		});
		writeFile(l, output);
	}
}
