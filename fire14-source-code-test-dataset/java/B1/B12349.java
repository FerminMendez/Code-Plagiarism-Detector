package googlecodejam;

import java.io.*;
import java.util.HashSet;

public class Qualification_C {

	private static String inFile = "C://CodeJam/QCin.txt";
	private static String outFile = "C://CodeJam/QCout.txt";
	private static BufferedWriter writer;

	public static void main(String[] args) {
		try{
			writer = new BufferedWriter(new FileWriter(outFile));
			readInput();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void readInput(){
		try{
			FileInputStream fstream = new FileInputStream(inFile);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			// test num
			strLine = br.readLine();
			int numTest = Integer.parseInt(strLine);
			
			for (int i = 0; i<numTest; i++){
				strLine = br.readLine();
				String[] num = strLine.split(" ");
				int a = Integer.parseInt(num[0]);
				int b = Integer.parseInt(num[1]);
				int count = 0;
				for (int j=a; j<b; j++){
					String str = Integer.toString(j);
					HashSet<Integer> list = swap(str);
					for (int x : list){
						if (x >j && x<=b){
							count ++;
						}
					}
				}
				println("Case #" + (i+1) + ": " + count);
			}
			
			//Close the input stream
			in.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static HashSet<Integer> swap(String str){
		HashSet<Integer> list = new HashSet<Integer>();
		for (int i=1; i<str.length(); i++){
			String x = str.substring(i, str.length()) + str.substring(0, i);
			list.add(Integer.parseInt(x));
		}
		return list;
	}

	public static void println(String msg) throws IOException {
		System.out.println(msg);
        writer.write(msg);
		writer.newLine();   // Write system dependent end of line.
    }
}
