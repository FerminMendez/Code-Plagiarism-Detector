package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileHelper {

	private String path;
	private int totalSize;
	private List<String> inputList;
	private List<String> outputList;
	
	public FileHelper(String path) {
		this.path = path;
		this.inputList = readFile(path);
		this.totalSize = Integer.parseInt(inputList.get(0));
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}

	public List<String> getOutputList() {
		return outputList;
	}

	public void setOutputList(List<String> outputList) {
		this.outputList = outputList;
	}

	public static List<String> readFile(String filepath) {
        List<String> rstList = new ArrayList<String>();

        try {
                FileInputStream fstream = new FileInputStream(filepath);
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String strLine;

                // Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                        rstList.add(strLine);
                }

                // Close the input stream
                in.close();
        } catch (Exception e) {// Catch exception if any
                System.err.println("Error: " + e.getMessage());
        }

        return rstList;
	}
	
	 public static void writeFile(String filepath,
             List<String> resList) {
     try {

             FileWriter fstream = new FileWriter(filepath);
             BufferedWriter out = new BufferedWriter(fstream);
             for(int i = 0 ; i< resList.size();++i){
                     out.write(resList.get(i));
                     System.out.println(resList.get(i));
                     if( i != resList.size()  - 1)
                    	 out.newLine();
             }
             // Close the output stream
             out.close();

     } catch (Exception e) {// Catch exception if any
             System.err.println("Error: " + e.getMessage());
     }

}



	public int getInputTotalSize() {

		
		return 0;
	}

	public void init(String[] inputStr) {
		for(int i = 1; i< this.inputList.size(); ++i	){
			inputStr[i - 1] = inputList.get(i);
		}
	}


}
