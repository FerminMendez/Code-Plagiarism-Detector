import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers {
	
	static String input;
	static int[][] data;
	static int length;
	static String output = "";
	
	public static String readInput(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = "";
		try {
			String line;
			while((line = in.readLine()) != null) {
				content = content.concat(line+"\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	public static void writeOutput(String output, String filename) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.print(output);
		try {
			out.write(output);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void parseInput(String in) {
		String[] lines = in.split("\\r?\\n");
		String[][] line_content = new String[lines.length][2];
		length = Integer.parseInt(lines[0]);
		for(int i=1;i<lines.length;i++) {
			line_content[i-1] = lines[i].split(" ");
		}
		data = new int[100][2];
		for(int i=0;i<line_content.length;i++) {
			for(int j=0;j<line_content[i].length;j++) {
				if(line_content[i][j]!=null)
					data[i][j] = Integer.parseInt(line_content[i][j].trim());
			}
		}
	}
	public static int calcOutput(int line) {
		int[] line_data = data[line];
		int lower = line_data[0];
		int upper = line_data[1];
		int count = 0;
		for(int i=lower;i<upper;i++) {
			for(int j=i+1;j<=upper;j++) {
				if(recycled(i,j)) {
					count++;
				}
			}
		}
		return count;		
	}
	public static boolean recycled(int i, int j) {
		int length = (int)(Math.log10(i)+1);
		for(int k=1;k<=length;k++) {
			int rem_length = length-(int)(Math.log10(i%(int)Math.pow(10.0,k))+1);
			if(i%(int)Math.pow(10.0,k)*(int)Math.pow(10.0,rem_length)+i/(int)Math.pow(10.0,k)==j && rem_length!=0 && (int)(Math.log10(i%(int)Math.pow(10.0,k))+1)==k)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		input = RecycledNumbers.readInput("C-small-attempt0.in");
		RecycledNumbers.parseInput(input);
		for(int i=0;i<length;i++) {
			output=output.concat("Case #"+(i+1)+": "+RecycledNumbers.calcOutput(i)+"\n");
		}
		RecycledNumbers.writeOutput(output, "c.out");
	}

}
