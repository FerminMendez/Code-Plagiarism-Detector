package recyclednumbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Input ip = new Input("C-small-attempt4.in");
		ip.setInputData();
		int number = 0;
		StringBuffer sb = new StringBuffer();
		for (TestCase tc : ip.getCases()){
			number++;
			sb.append("Case #" +number+": " +executeTestCase(tc).getM().size()+"\n");
		}
		Writer output = null;
		  
		  File file = new File("out.txt");
		  output = new BufferedWriter(new FileWriter(file));
		  output.write(sb.toString());
		  output.close();
	}

	private static ListRecycledNumbers executeTestCase(TestCase tc) {
		List<Integer> n = new ArrayList<Integer>();
		List<Integer> m = new ArrayList<Integer>();
		ListRecycledNumbers recycledNumbers = new ListRecycledNumbers();
		boolean recycledPairAlreadyPresent = false;
		for (int i = tc.A; i <= tc.B; i++) {
			for (int j = 1; j < Integer.toString(tc.B).length(); j++) {
				int newInt = Helper.rotateDigits(i, j, true);
				if (i != newInt) {
					if (newInt < tc.B && newInt > tc.A) {
						recycledPairAlreadyPresent = false;
						for(int k = 0; k < recycledNumbers.getM().size(); k++){
							if((recycledNumbers.getN().get(k) == newInt && recycledNumbers.getM().get(k) == i) || (recycledNumbers.getM().get(k) == newInt && recycledNumbers.getN().get(k) == i)){
								recycledPairAlreadyPresent = true;
								break;
							}
						}
						if(!recycledPairAlreadyPresent)
						recycledNumbers.add(newInt, i);
					}
				}
			}
		}
		return recycledNumbers;
		//removeRepetitiveRecycledNumbers(recycledNumbers);
	}
	/*public static ListRecycledNumbers finalList = new ListRecycledNumbers();
	private static void removeRepetitiveRecycledNumbers(
			ListRecycledNumbers recycledNumbers) {
		
		for (int i = 0; i < recycledNumbers.getM().size(); i++) {
			for (int j = 0; j < recycledNumbers.getM().size(); j++) {
				if ((recycledNumbers.getM().get(i) != recycledNumbers.getM()
						.get(j)
						&& recycledNumbers.getN().get(i) != recycledNumbers
								.getN().get(j) && i != j)
						|| (recycledNumbers.getM().get(i) != recycledNumbers
								.getN().get(j)
								&& recycledNumbers.getN().get(i) != recycledNumbers
										.getM().get(j) && i != j)) {
					finalList.add(recycledNumbers.getN().get(i), recycledNumbers.getM().get(i));
				}
			}
		}
	}
*/
}
