import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/William/Desktop/B-small-attempt0.in"));
			String strLine;
			
			strLine = br.readLine();
			int numOfLine = Integer.parseInt(strLine);
			
//			ArrayList<String> inputs = new ArrayList<String>();
			for (int i=0;i<numOfLine;i++) {
				strLine = br.readLine();
				String splitedStr[] = strLine.split(" ");
				int numOfDancer = Integer.parseInt(splitedStr[0]);
				int suprise = Integer.parseInt(splitedStr[1]);
				int gap = Integer.parseInt(splitedStr[2]);
				
				int numSuccess = 0;
				for (int j=0;j<numOfDancer;j++) {
					int score = Integer.parseInt(splitedStr[j+3]);
					
					int average = score / 3;
					if (average >= gap) {
						numSuccess++;
					}
					else if (average == gap-1){
						switch (score%3) {
							case 0:
								if ((suprise>0) && (score>0)){
									numSuccess++;
									suprise--;
								}
								break;
							case 1:
								if (score>1) {
									numSuccess++;
								}
								break;
							case 2:
								if ((score==2) && (suprise>0)){
									numSuccess++;
									suprise--;
								}
								else {
									numSuccess++;
								}
								break;
						}		
					}
					else if (average == gap-2) {
						switch (score%3) {
							case 0:
							case 1:
								break;
							case 2:
								if (suprise>0) {
									numSuccess++;
									suprise--;
								}
								break;
						}
					}
				}
				
				int caseNum = i + 1;
				System.out.println("Case #" + caseNum + ": " + numSuccess);
			}
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
