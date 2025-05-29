import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Read {
	int noOfTestCases;
	
	
int []nums;
	

	public void Read(String name) {
		File file = new File(name);

		try {

			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			noOfTestCases = Integer.parseInt(line);
			nums =  new int[noOfTestCases*2];
			int i=0;
			while(i<noOfTestCases){
			line = scanner.nextLine();
			String []numS = line.split(" ");
			nums[2*i]=Integer.parseInt(numS[0]);
			nums[2*i+1]=Integer.parseInt(numS[1]);
			i++;
			}
		} catch (FileNotFoundException e) {

		}

	}
	public void write(String fname,String data)
	{
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter(fname);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(data);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
public static void main(String[] args) {
	Read r = new Read();
	r.Read("test");
	
}
}
