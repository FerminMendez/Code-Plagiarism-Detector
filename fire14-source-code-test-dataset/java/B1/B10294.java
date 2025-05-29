package problemC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {
	
	public static void main(String[] args) throws Exception {
		
		Writer write = new FileWriter(new File("out.txt"));
		Writer writer = new BufferedWriter(write);
		
		Scanner scan = new Scanner(new File("C-small-attempt0.in.txt"));
		
		int num = scan.nextInt();
		for(int i = 1; i<=num; i++) {
			int lower = scan.nextInt();
			int upper = scan.nextInt();
			int count = 0;
			for(int j = lower; j<upper; j++) {
				Set<String> iterations = iterations(""+j);
				for(int k = j+1; k<=upper; k++) {
					String s = ""+k;
					if(iterations.contains(s)) count++;
				}
			}
			
			writer.write("Case #"+i+": "+count+"\n");
			
		}
		
		writer.close();
		write.close();
		
		
	}
	
	
	public static Set<String> iterations(String in) {
		Set<String> strings = new HashSet<String>();
		
		String current = new String(in);
		strings.add(current);
		for(int i = 0; i<current.length(); i++) {
			String start = current.substring(0, current.length()-1);
			String end = current.substring(current.length()-1);
			
			current = end+start;
			strings.add(current);
		}
		
		//System.out.println(strings);
		
		return strings;
	}

}
