package c2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecycledPairCalculator {
	
	private ArrayList<Integer> outputs ;
	
	public RecycledPairCalculator() {
		this.outputs = new ArrayList<Integer>();
	}
	
	public void perform(String path) throws NumberFormatException, IOException{
		String [] inputs = readInput(path);
		for (int i = 0; i < inputs.length; i++) {
			String s = inputs[i];
			String [] ab = s.split(" ");
			this.outputs.add(calculatePair(Integer.parseInt(ab[0]), Integer.parseInt(ab[1])));
		}
		writeOutput();
	}
	
	private int calculatePair(int a, int b){
		int pairsCount =0;
		for (int i = a; i <= b; i++) {
			int n = i;
			int m = n+1;
			while(m<=b){
				if(isRecycled(n, m)) pairsCount++;
				m++;
			}
		}
		return pairsCount;
	}
	
	private boolean isRecycled(int n, int m){
		String nn = String.valueOf(n) + String.valueOf(n);
		return nn.contains(String.valueOf(m));
	}
	
	

	
	private String[] readInput(String path) throws NumberFormatException, IOException{
		String [] inputs;
		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int numberOfTestCases = Integer.parseInt(br.readLine());
		inputs = new String[numberOfTestCases];
		for (int i = 0; i < numberOfTestCases; i++) {
			inputs[i] = br.readLine();
		}
		return inputs;
	}
	
	private void writeOutput() throws IOException{
		 FileWriter fstream = new FileWriter("output_files/out.txt");
		 BufferedWriter out = new BufferedWriter(fstream);
		for (int i = 0; i < this.outputs.size(); i++) {;
			String output = "Case #"+(i+1)+ ": " + this.outputs.get(i)+"\n";
			out.write(output);
		}
		 out.close();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		RecycledPairCalculator r = new RecycledPairCalculator();
		r.perform("input_files/C-small-attempt0.in");
	}

}
