import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Solution{
	protected Problem problem;
	private String problemFileName;
    
	abstract public StringBuffer solve();

    public Solution(String problemFileName){
		this.problemFileName = problemFileName;
		problem = new Problem(problemFileName);
	}
	
	public void saveToFile(StringBuffer buffer){
		try {
			File f = new File(problemFileName);
			String fileout = stripExtension(f.getName())+".out";
			BufferedWriter out = new BufferedWriter(new FileWriter(fileout));
			String outText = buffer.toString();
			System.out.println(outText);
			out.write(outText);
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}	
	
    static String stripExtension (String str) {
        if (str == null) return null;
        int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
        return str.substring(0, pos);
    }	
        
}

class Problem{
	private String[] cases; 

	public Problem(String filename){
		// TODO Auto-generated method stub
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(filename);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int totalCase = Integer.parseInt(br.readLine());
			int i = 0;
			cases = new String[totalCase];
			//Read File Line By Line
			while ( (i<totalCase) && (strLine = br.readLine()) != null)   {
				// Print the content on the console
				if(strLine.length()>0){
					cases[i] = strLine;
					i++;
				}
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public int count(){
		return cases.length;
	}
	
	public String getCase(int index){
		return cases[index];
	}
}