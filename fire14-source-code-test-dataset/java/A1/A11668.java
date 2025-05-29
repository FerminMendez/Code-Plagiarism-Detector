import java.io.*;
import java.util.ArrayList;


public class inpOutHandler {

	public testCase readInput(String fname, int linesInTestCase){
		testCase allCases;
		ArrayList<String> lineList = new ArrayList<String>();
		BufferedReader rd = null;
			try {
				rd = new BufferedReader(new FileReader(fname));
				while (true) {
					String line = rd.readLine();
					if (line == null) break;
					lineList.add(line);
				}
				rd.close();
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
			} 
			//for(int i=0;i<lineList.size();i++)
				//System.out.println("<" + lineList.get(i) + ">");
			
		int N = Integer.parseInt(lineList.get(0));
			//int N=100;
		allCases = new testCase(N);
		int index=1;
		for(int i=0;i<N;i++){
			String tempS="";
			for(int j=0;j<linesInTestCase;j++){
				if(j==linesInTestCase-1){
				tempS += lineList.get(index++);
				}else{
					tempS += lineList.get(index++) +"\n";
				}
			}
			allCases.addCase(tempS);
		}
		return allCases;
	}
	
	public void createOutput(String fname, String content){
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter(fname);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(content);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
}
