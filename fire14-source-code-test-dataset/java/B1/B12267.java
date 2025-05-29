package cats;

import java.io.*;
import java.util.ArrayList;

public class Main {
	public Main() throws Exception{
		FileReader fr = new FileReader(new File("input.txt"));
		BufferedReader in = new BufferedReader(fr);
		
		File outFile = new File("output.txt");
		outFile.createNewFile();
		FileWriter fw = new FileWriter(outFile);
		BufferedWriter out = new BufferedWriter(fw);
		
		
		int numTests = Integer.parseInt(in.readLine());
		for(int x = 0; x<numTests; x++){
			String[] splitLine = in.readLine().split(" ");
			int min, max;
			min = Integer.parseInt(splitLine[0]);
			max = Integer.parseInt(splitLine[1]);
			
			int count = 0;
			ArrayList<String> found = new ArrayList<String>();
			for(int n = min; n <= max; n++){
				String num = n+"";
				found.clear();
				for(int d = 0; d<num.length()-1; d++){
					num = num.substring(1) + num.charAt(0);
					int value = Integer.parseInt(num);
					if(value > n && value <= max && (value+"").length() == num.length() && !found.contains(num)){
						//System.out.println(n + " " + value);
						found.add(num);
						count++;
					}
				}
				
			}
			
			out.write("Case #" + (x+1) + ": " + count + "\n");
			System.out.println(count);
		}
		
		
		
		in.close();
		out.close();
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		new Main();
	}
}
