import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ProblemC {
	private String line = "";
	private String fileContents = "";
	private String delim = "\r\n";
	private String fileName = "C-small-attempt0.in";
	
	public void solve() {
		StringTokenizer st = new StringTokenizer(fileContents,delim);
		StringTokenizer lineToken = null;
		int count = 1;
		int testCases = 0;
		int lower = 0;
		int	upper = 0;
		int y = 0;
		
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		
		testCases = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			
			line = st.nextToken();
			
			System.out.print("Case #");
			System.out.print(count++);
			System.out.print(": ");
			
			lineToken = new StringTokenizer(line," ");
			
			lower = Integer.parseInt(lineToken.nextToken());
			upper = Integer.parseInt(lineToken.nextToken());

			y = 0;
			int numberLen = 0;
			for(int i=lower; i<upper; i++) {
				String number = String.valueOf(i);
				numberLen = number.length();
				for(int k = 1; k<numberLen; k++) {
					String newNumberBack = number.substring(0, numberLen-k);
					String newNumber = number.substring(numberLen-k);
					newNumber = newNumber + newNumberBack;
					if(!newNumber.startsWith("0") && newNumber.length() == number.length()) {
						Integer testNumber = Integer.parseInt(newNumber);
						if(lower <= i && i < testNumber && testNumber <= upper
//								&& !numbersList.contains(testNumber)
								) {
							numbersList.add(testNumber);
							y++;
							
/*							System.out.print("(");
							System.out.print(i);
							System.out.print(",");
							System.out.print(testNumber);
							System.out.print(")\t");
*/						}
					}
				}
			}
			System.out.println(y);
		}
	}
	
	public void readFile() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder sb = new StringBuilder();
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				sb.append(strLine);
				sb.append(delim);
			}
			// Close the input stream
			in.close();
			
			fileContents = sb.toString();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
