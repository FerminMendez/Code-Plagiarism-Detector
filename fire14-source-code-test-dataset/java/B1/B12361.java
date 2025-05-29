package qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class RecycledNumbers {

	private static final String PATH = "D:\\EclipseWorkspace\\GoogleCodeJam\\inout_file2012\\qualification";
	private static final String IN_FILE = "C-small-attempt0.in";
	private static final String OUT_FILE = "A-large.out";
	
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	
	private void init() throws Exception {
		br = new BufferedReader(new FileReader(PATH + "\\" + IN_FILE));
		bw = new BufferedWriter(new FileWriter(PATH + "\\" + OUT_FILE));
	}
	
	private void end() throws Exception {
		br.close();
		bw.close();
	}
		
	private void execute() throws Exception {
		
		int t = 0;
		int n = 0;
		String line = null;
		int first = 0;
		int last = 0;
		
		// Read line
		t = Integer.parseInt(br.readLine());
//		t = 1;
		
		for (int i = 0; i < t; ++i){
			// Read line
			line = br.readLine();
			
			first = Integer.parseInt( line.split(" ")[0] );
			last = Integer.parseInt( line.split(" ")[1] );
			
//			test = "4 O 2 B 1 B 2 O 4";
//			test = "3 O 5 O 8 B 100";
//			test = "2 B 2 B 1";
						
			// Write to file
//			bw.write("Case #"+(i+1)+": " + timeSpent);
//			bw.newLine();
			System.out.println("Case #"+(i+1)+": " + countRecycledNo(first, last) );
		}
	}
	
	private int countRecycledNo(int first, int last) {
		
		String number = null;
		String newNumber = null;
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = first; i <= last; ++i) {
			number = Integer.toString(i);
			
			for (int j = 1; j < number.length(); ++j){
				newNumber = number.substring(j) + number.substring(0, j);
				int newNo = Integer.parseInt(newNumber);
				if ( newNo > i && newNo <= last && !list.contains(newNo)) {
//					System.out.println( "(" + i + ", " + newNo + ")");
					list.add(newNo);
					count++;
				}
			}
			
			list.clear();
		}
		
		return count;
	}

	public static void main(String[] args) {
		RecycledNumbers instance = new RecycledNumbers();
		try {
			instance.init();
			instance.execute();
			instance.end();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
