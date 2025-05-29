import java.util.ArrayList;
import java.util.List;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String> inputList = FileIO.readFile("B-small-practice.in");
		List<String> inputList = FileIO.readFile("B-small-attempt0.in");
		List<String> outputList = new ArrayList<String>();
		
		int caseNo = 1 ; 
		int testCaseCount = Integer.parseInt(inputList.get(0));
		
		while (caseNo <= testCaseCount) {
			Scores s = new Scores(inputList.get(caseNo)); 
			outputList.add("Case #" +caseNo +": " +s.getMaxNumberOfGooglerOverScore());
			
			caseNo++;
		}
		
		//FileIO.writeFile("B-small-practice.out", outputList);
		FileIO.writeFile("B-small-attempt0.out", outputList);
	}

}
