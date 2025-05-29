import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main2 {
	private static final String IN_FILE = "in.txt";
	private static final String OUT_FILE = "out.txt";
	
	private static List<Xxx> parseFile() throws IOException  {
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(IN_FILE)));
		
		int count = Integer.parseInt(r.readLine());
		List<Xxx> res = new ArrayList<Xxx>();
		for(int i = 0; i < count; i++){
			String line = r.readLine();
			String[] tupel = line.split(" ");
			Xxx d = new Xxx();
			d.min = Integer.parseInt(tupel[0]);
			d.max = Integer.parseInt(tupel[1]);
			
			res.add(d);
		}
		r.close();
		
		return res;
	}
	
	private static List<Integer> process(List<Xxx> dl){
		List<Integer> res = new ArrayList<Integer>();
		
		for(Xxx d : dl){
			int count = 0;
			
//			System.out.println("-----------------------------------------");
			List<String> xxx = new ArrayList<String>();
			for(int x = d.min; x < d.max; x++){
				String sx_orig = String.valueOf(x);
				int len = sx_orig.length();
				String sy = null;
				xxx.clear();
				
				if(len > 1){
					for(int y = x + 1; y <= d.max && (sy = String.valueOf(y)).length() == len; y++){
						String sx = sx_orig;
						
						for(int i = 1; i < sx.length(); i++){
							char c = sx.charAt(sx.length()-1);
							sx = c  + sx.substring(0, sx.length() - 1);
							
							if(sx.equals(sy)){
								
								if(!xxx.contains(sx)){
									xxx.add(sx);
//									System.out.println(sx_orig +"\t" +sx);
									count++;
									continue;
								}
							}
						}
					}
				}
			}
			
			res.add(count);
		}
		
		return res;
	}
	
	private static void writeOutput(List<Integer> data) throws IOException {
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_FILE)));
		
		for(int i = 0; i < data.size(); i++){
			if(i > 0){
				w.write("\n");
			}
			
			String s = "Case #" +(i+1) +": " +data.get(i);
			w.write(s);
		}
		w.close();
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<Xxx> l = parseFile();
		List<Integer> r = process(l);
		writeOutput(r);
		
		System.out.println("Done");
	}
	
	private static class Xxx {
		public int min;
		public int max;
	}
}