import java.io.BufferedReader;
import java.io.BufferedWriter;
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
			
			int for_sure = 0;
			int if_surprise = 0;
			
			ArrayList<Integer> sa = new ArrayList<Integer>();
			for(String l : s.split(" ")){
				sa.add(Integer.parseInt(l));
			}
			int N = sa.get(0);
			int S = sa.get(1);
			int P = sa.get(2);
			
			for(int ii = 3; ii <= N+2; ii++){
				int v = sa.get(ii);
				if(Math.ceil((double)v/3) >= P){
					for_sure++;
					continue;
				}
				
				double d = v-2*Math.floor((double)v/3);
				if(d == Math.ceil((double)v/3) && d != 0){
					d++;
				}
				if(d >= P){
					if_surprise++;
				}
			}
			
			out.append("Case #"+(i+1)+": "+(for_sure+Math.min(S, if_surprise)));

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
