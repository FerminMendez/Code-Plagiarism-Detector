package jam2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test2 {
	public static void main(String argv[]){
		Test2 tb = new Test2();
		ArrayList<String> strin = tb.readFile("B-small-attempt0.in");
		ArrayList<ArrayList<Integer>> intin = tb.getInt(strin);
		
		tb.printInt(intin);
		
		ArrayList<String> strout = new ArrayList<String>();
		
		tb.computeDancer(intin, strout);
		
		tb.writeResult(strout, "outtest2_small.txt");
	}
	
	public void computeDancer(ArrayList<ArrayList<Integer>> intin, 
			ArrayList<String> strout){
		if(intin==null || strout==null || intin.size()==0) return;
		int nTest = intin.get(0).get(0);
		for(int i=1; i<=nTest; ++i){
			
			int ndancer = intin.get(i).get(0);
			if(ndancer!=(intin.get(i).size()-3)){
				System.out.println("dancer do not match!");
				return;
			}
			
			int nsurprise = intin.get(i).get(1);
			int thresh = intin.get(i).get(2);
			final int tri =3;
			
			int ng = 0; //the googlers have score above threshold
			for(int j=3; j<intin.get(i).size(); ++j){
				int score = intin.get(i).get(j);
				if(score > (tri*(thresh-1))){
					ng++;
				}else if(score>(tri*(thresh-2)+1)){
					int div = score/tri;
					int residule = score%tri;
					if(nsurprise > 0){
						if(residule <=1 && div==0) continue; //
						ng++;
						nsurprise --;
					}
				}
			}
			
			//write out the results
			String line = "Case #"+i+": "+ng;
			System.out.println(line);
			strout.add(line);
		}
		
		
	}
	
	public void printInt(ArrayList<ArrayList<Integer>> intin){
		if(intin==null ) return;
		for(ArrayList<Integer> arr:intin){
			for(Integer i: arr){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> getInt(ArrayList<String> strlist){
		if(strlist == null) return null;
		ArrayList<ArrayList<Integer>> intlist = new ArrayList<ArrayList<Integer>>();
		for(String s:strlist){
			ArrayList<Integer> tarr = new ArrayList<Integer>();
			String astr[] = s.split(" ");
			for(int i=0; i<astr.length; ++i){
				int itemp = Integer.parseInt(astr[i]);
				tarr.add(itemp);
			}
			intlist.add(tarr);
		}
		return intlist;
	}
	
	public ArrayList<String> readFile(String inname){
		if(inname == null) return null;
		
		ArrayList<String> arr = new ArrayList<String>();
		 try{
			 FileInputStream fstream = new FileInputStream(inname);
			 // Get the object of DataInputStream
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 String strLine;
			 //Read File Line By Line
			 while ((strLine = br.readLine()) != null)   {
				 arr.add(strLine);
			 	}
			 //Close the input stream
			 in.close();
		 }catch (Exception e){//Catch exception if any
			 System.err.println("Error: " + e.getMessage());
		 }
		 
		 return arr;
	}
	
	public void writeResult(ArrayList<String> res, String fname){
		if(res == null || res.size()==0) return;
		try{
			FileWriter fstream = new FileWriter(fname);
			BufferedWriter out = new BufferedWriter(fstream);

			for(int i=0; i<res.size()-1;++i){
				out.write(res.get(i));
				out.newLine();
			}
			out.write(res.get(res.size()-1));
			out.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		  }
	}

}
