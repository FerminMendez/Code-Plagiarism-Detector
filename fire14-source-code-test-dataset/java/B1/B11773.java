import java.util.ArrayList;
import java.util.List;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> inputList = FileIO.readFile("C-small-attempt0.in");
		List<String> outputList = new ArrayList<String>();
		
		int caseNo = 1 ; 
		int testCaseCount = Integer.parseInt(inputList.get(0));
		
		while (caseNo <= testCaseCount) {
			Number n = new Number(inputList.get(caseNo)); 
			outputList.add("Case #" +caseNo +": " +n.getRecycledPairCount());
			
			caseNo++;
		}
		
		FileIO.writeFile("C-small-attempt0.out", outputList);
	}

}
