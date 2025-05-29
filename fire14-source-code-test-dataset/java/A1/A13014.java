
package googleCodeJam;

import java.io.*;
import java.util.*;

public class ThirdExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FileInputStream fstream = new FileInputStream("B-small-attempt7.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fstream2 = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream2);
			
			String strLine;
			int j=0;
		
			strLine = br.readLine();
			
			while ((strLine = br.readLine()) != null)   {
				
				String[] st = strLine.split(" ");
				ArrayList<Integer> temp = new ArrayList<>();
				int i =0;
						
				for (i=3;i<st.length;i++)
					temp.add(Integer.parseInt(st[i]));
				
				int nr = 0;
				int nr_s = 0;
				int n = Integer.parseInt(st[0]);
				int s = Integer.parseInt(st[1]);
				int p = Integer.parseInt(st[2]);
				
				for (Integer tmp: temp)
					if (Math.ceil(((double)tmp)/3.0)>=p)
						nr++;
					else if (Math.ceil(((double)tmp)/3.0)>=p-1 && ((double)tmp)/3.0-0.5>=0)
						nr_s++;
				nr+=((s>nr_s)?nr_s:s);
				//shkrimi i rezultatit	
					
				out.write("Case #"+(++j)+": "+nr+" \n");
			}
		    in.close();
		    out.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}	
}
