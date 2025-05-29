import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hossam Yasseen
 */
public class ProblemC {

	/**
	 * @param args
	 */
	static Integer startEdge , endEdge ;
	
	public static void main(String[] args) {
		
		int numberOfRecycledNumbers = 0;

		String[] result = null ;
		for (int counter0 = 1; counter0 < args.length; counter0++) {
			result = args[counter0].split("\\s");
			startEdge = Integer.parseInt(result[0]);
			endEdge = Integer.parseInt(result[1]);
			numberOfRecycledNumbers=0 ;
			
			for (int counterA = startEdge; counterA < endEdge; counterA++) {
				List<Integer> recycledNumber = recycledNumbers(counterA);
				for (int counter = 0; counter < recycledNumber.size(); counter++) {
					if (recycledNumber.get(counter) <= endEdge )
						numberOfRecycledNumbers++;
				}
			}
			System.out.println("Case #" + counter0 + ": "
					+ numberOfRecycledNumbers);
		}
	}

	private static List<Integer> recycledNumbers(Integer number) {

		Map<Integer,String> map = new HashMap<Integer, String>();
		String dummyValue = null ;
		String candidateNumber = "";

		char[] characters = number.toString().toCharArray();

		int index;
		for (int counter = 0; counter < characters.length; counter++) {
			index = counter ;
			int loops = 0 ;
			candidateNumber="";
			
			for ( ; loops < characters.length; index++) {
				candidateNumber += characters[index % characters.length];
				loops++ ;
			}
			
			if(Integer.parseInt(candidateNumber)>number.intValue())
				map.put(Integer.parseInt(candidateNumber),dummyValue);
			
		}
		
		List<Integer> recycledNumber =  new ArrayList<Integer>( map.keySet());
		return recycledNumber;
	}
}
