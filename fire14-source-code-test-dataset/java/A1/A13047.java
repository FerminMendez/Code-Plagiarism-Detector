package Q2;

import java.io.BufferedReader;
import java.io.IOException;

abstract public class Solver {
	protected BufferedReader input;
	protected final String nl = System.getProperty("line.separator");

	abstract public String solve() throws Exception;

	protected String readLine(){
		try {
			return input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	protected Long[] splitLineL(String line){
		return splitLineL(line, " ");
	}

	protected Long[] splitLineL(String line, String delim){
		String[] split = line.split(delim);
		Long[] $ = new Long[split.length];
		for(int i=0;i<split.length;i++){
			$[i] = Long.parseLong(split[i]);
		}
		return $;
	}

	protected Integer[] splitLine(String line){
		return splitLine(line, " ");
	}

	protected Integer[] splitLine(String line, String delim){
		String[] split = line.split(delim);
		Integer[] $ = new Integer[split.length];
		for(int i=0;i<split.length;i++){
			$[i] = Integer.parseInt(split[i]);
		}
		return $;
	}

	public void setInput(BufferedReader input) {
		this.input = input;
	}

	<T> void printArr(T[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	<T> void printArr(T[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
