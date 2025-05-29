package loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		read("test1.in");
		System.out.println(inputs);
	}

	int size;
	static List<String> inputs = new ArrayList<String>();

	public static void read(String path) {

		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(path));
			int a = Integer.parseInt(br.readLine()); 

			String s = br.readLine();
			while(s != null){
				inputs.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<String> getInputs() {
		return inputs;
	}
	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}


}
