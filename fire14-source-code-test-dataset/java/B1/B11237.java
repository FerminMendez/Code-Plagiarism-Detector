import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Load file
		ArrayList<String> in = null;
		try {
			in = readFile("input.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = doit(Integer.parseInt(in.remove(0)), in);

		try {
			writeFile(result, "output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String> readFile(String filename) throws IOException{

		ArrayList<String> out = new ArrayList<String>();

		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream(filename);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null){
			// Print the content on the console
			out.add(strLine);
		}

		//Close the input stream
		in.close();

		return out;
	}

	public static String doit(int c, ArrayList<String> cases){
		// Main logic
		
		StringBuilder out = new StringBuilder();

		for(int i = 0; i < c; i++){
			String s = cases.get(i);		
			ArrayList<Integer> sa = new ArrayList<Integer>();
			for(String l : s.split(" ")){
				sa.add(Integer.parseInt(l));
			}
			
			int A = sa.get(0);
			int B = sa.get(1);
			int recycles = 0;
			
			String t = "";
			int size = (A+"").length();
			for(int n = A; n <= B; n++){				
				t = n+"";
				ArrayList<Integer> passed = new ArrayList<Integer>(); 
				for(int l = 1; l < size; l++){
					int m = Integer.parseInt(t.substring(l)+t.substring(0, l));
					if(n >= m || m > B){
						continue;
					}
					
					if(passed.contains(m)){
						continue;
					}
					recycles++;
					passed.add(m);
				}
			}
			
			out.append("Case #"+(i+1)+": "+recycles);

			if(i != c-1){
				out.append("\n");
			}
		}

		return out.toString();
	}

	public static void writeFile(String output, String file) throws IOException{
		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(output);
		out.close();
	}

}
