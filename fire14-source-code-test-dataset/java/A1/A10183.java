package codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileHandler {
	FileInputStream input;
	FileOutputStream output;
	BufferedReader buf;
	public fileHandler(String in, String out) {
		try {
			input = new FileInputStream(in);
			
			output = new FileOutputStream(out);
			buf = new BufferedReader(new InputStreamReader(input));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public String readLineFromInput(){
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public int readCase(){
		int i = -1;
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i = Integer.parseInt(str);
		return i;
	}
	
	public int[] readIntegers(){
		int temp[];
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String split[] = str.split(" ");
		temp = new int[split.length];
		for(int i=0;i<split.length;i++){
			temp[i] = Integer.parseInt(split[i]);
		}
		return temp;
	}
	
	public void writeToOutput(String str){
		byte buff[] = str.getBytes();
		try {
			output.write(buff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
