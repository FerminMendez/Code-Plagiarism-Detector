import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Problem2 {
	BufferedReader br ;
	PrintWriter pw;

	public static void main (String [] args) throws IOException{
		new Problem2().startProcessing();
	}
	public void startProcessing () throws IOException {
		br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/tmp/codejam/A-small-practice.in"))));
		pw = new PrintWriter(new File("/home/peeyushk/tmp/output.ou"));
		startReading();
		pw.flush();
		pw.close();
		br.close();

	}

	void startReading() throws IOException {
		int numTestCase=0;
		int numPeople=0;
		int specialCases=0;
		int p=0;
		String numTestCaseLine = br.readLine().trim();
		numTestCase = Integer.parseInt(numTestCaseLine.trim());

		for( int i=0; i<numTestCase; i++) {
			int result=0;
			int specialCasesUsed=0;
			String testCaseLine = br.readLine().trim();
			String testCaseLineArray[] = testCaseLine.split(" ");

			numPeople = Integer.parseInt(testCaseLineArray[0].trim());
			specialCases = Integer.parseInt(testCaseLineArray[1].trim());
			p = Integer.parseInt(testCaseLineArray[2].trim());

			int lowerLimit= ((p-1)*3);

			for (int j=0;j<numPeople;j++) {
				int t = Integer.parseInt(testCaseLineArray[j+3].trim());
				if (p<=0) {
					result++;
				} else if (p==1) {
					if (t>=1) {
						result++;
					}
				} else if (p>1 ) {
					if ( t>lowerLimit ) {
						result++;
					} else if (t == lowerLimit || t==lowerLimit-1) {
						if (specialCasesUsed<specialCases) {
							result++;
							specialCasesUsed++;
						}
					}
				}
			}
			pw.println("Case #"+(i+1)+": "+result);
		}
	}
}