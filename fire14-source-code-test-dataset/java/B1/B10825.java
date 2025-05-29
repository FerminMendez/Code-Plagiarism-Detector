import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
	
public class RecycledNumbers {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//read file
			FileReader filein = new FileReader(args[0]);
			BufferedReader in = new BufferedReader(filein);
			//write file 
			FileWriter fileout = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fileout);
			//process data
			int numcases = Integer.valueOf(in.readLine()).intValue();
			for(int i=0; i<numcases; i++){
				String[] casedata = in.readLine().split(" ");
				int minnum = Integer.valueOf(casedata[0]);
				int maxnum = Integer.valueOf(casedata[1]);
				int pos = casedata[0].length();
				int result = 0;
				for(int j=minnum; j<maxnum; j++){
					for(int k=j+1; k<=maxnum; k++){	
						if(j == k) result++;
						String numtest = String.valueOf(j);
						for(int l=0; l<pos; l++){
							char temp = numtest.charAt(0);
							numtest = numtest.substring(1)+temp;
							if(Integer.valueOf(numtest).intValue() == k){
								result++;
								break;
							}
						}
					}
				}
				out.write("Case #" + (i+1) + ": " + result + "\n");
			}
			//Close the output stream
			out.close();
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
