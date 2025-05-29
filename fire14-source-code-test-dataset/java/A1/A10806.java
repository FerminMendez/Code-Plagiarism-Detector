import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DancingGooglers {

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
					int numgooglers = Integer.valueOf(casedata[0]);
					int totalsurprises = Integer.valueOf(casedata[1]);
					int bestresult = Integer.valueOf(casedata[2]);
					int[][] googlers = new int[numgooglers][5];
					int surprises = 0;
					for(int j=0; j<numgooglers; j++){
						googlers[j][0] = Integer.valueOf(casedata[3+j])/3;
						int max = googlers[j][0];
						int min = googlers[j][0];
						googlers[j][1] = (Integer.valueOf(casedata[3+j])-googlers[j][0])/2;
						if(googlers[j][1] > max) max = googlers[j][1];
						if(googlers[j][1] < min) min = googlers[j][1];
						googlers[j][2] = Integer.valueOf(casedata[3+j])-googlers[j][0]-googlers[j][1];
						if(googlers[j][2] > max) max = googlers[j][2];
						if(googlers[j][2] < min) min = googlers[j][2];
						googlers[j][0] = max;
						googlers[j][1] = Integer.valueOf(casedata[3+j]) - max -min;
						googlers[j][2] = min;
						googlers[j][3] = max - min;
						if(max - min > 1) surprises++;
					}
					while(surprises < totalsurprises){
						int test = 0;
						for(int j=0; j<numgooglers; j++){
							if(googlers[j][3] < 2 && googlers[j][0] == bestresult - 1 && googlers[j][1] > 0 ){
								surprises++;
								googlers[j][0]++;
								googlers[j][1]--;
								googlers[j][3] = 2;
								test = 1;
								break;
							}
						}
						if(test == 0) break;
					}
					int result = 0;
					for(int j=0; j<numgooglers; j++){
						if(googlers[j][0] >= bestresult){
							result++;
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
