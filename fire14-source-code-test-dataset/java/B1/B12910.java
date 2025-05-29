package er.dream.codejam.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {

	BufferedReader read;
	BufferedWriter write;
	
	public File[] listFiles(){
		return new File("data").listFiles();
	}
	
	public void loadFile(File file){
		try {
			read = new BufferedReader(new FileReader(file));
			write = new BufferedWriter(new FileWriter(new File("output/"+file.getName().replace(".in", ".out"))));
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't load file: "+file.getName(),e);
		}
	}
	
	public void closeConnection(){
		try {
			read.close();
			write.close();
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't close connection",e);
		}
	}
	
	public void writeOutput(List<String> outputData){
		int line = 1;
		for(String entry:outputData){
			try {
				write.write("Case #"+line+": "+entry+"\n");
			} catch (IOException e) {
				throw new IllegalStateException("Error while writing output",e);
			}
			line++;
		}
	}
	
	public String readString(){
		try {
			return read.readLine();
		} catch (IOException e) {
			throw new IllegalStateException("Error while reading input",e);
		}
	}
	
	public int readInt(){
		return Integer.parseInt(readString());
	}
	
	public long readLong(){
		return Long.parseLong(readString());
	}
	
	public double readDouble(){
		return Double.parseDouble(readString());
	}
	
	public String[] readStringArray(){
		return readString().split(" ");
	}
	
	public int[] readIntArray(){
		String[] strings = readStringArray();
		int[] ints = new int[strings.length];
		for(int i=0;i<ints.length;i++)
			ints[i] = Integer.parseInt(strings[i]);
		return ints;
	}
	
	public long[] readLongArray(){
		String[] strings = readStringArray();
		long[] longs = new long[strings.length];
		for(int i=0;i<longs.length;i++)
			longs[i] = Integer.parseInt(strings[i]);
		return longs;
	}
	
	public double[] readDoubleArray(){
		String[] strings = readStringArray();
		double[] doubles = new double[strings.length];
		for(int i=0;i<doubles.length;i++)
			doubles[i] = Integer.parseInt(strings[i]);
		return doubles;
	}
	
}
