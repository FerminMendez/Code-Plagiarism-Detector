/**
 * 
 */
package google;

import hack.Tool;

import java.util.HashSet;
import java.util.List;

/**
 * http://code.google.com/codejam/contest/dashboard?c=1460488#s=p2 a pair of
 * distinct positive integers (n, m) is recycled if you can obtain m by moving
 * some digits from the back of n to the front without changing their order.
 * 
 * @author y
 */
public class RotateNumbers {

	/**
	 * Given integers A and B with the same number of digits and no leading
	 * zeros, how many distinct recycled pairs (n, m) are there with A ¡Ü n < m ¡Ü
	 * B?
	 * 
	 * @param min
	 * @param max
	 */
	static int pairsRotated  (int min, int max){
		if(max<10 || max<=min){return 0;}
		int ret = 0;
		
		for(int j=min; j<max; j++){
			String s = String.valueOf(j);

			HashSet<Integer> set = new HashSet<Integer>();
			
			for(int k=1; k<s.length(); k++){//iterate each digit
				
				//rotate from bigger digit
				if(s.charAt(k)>=s.charAt(0)){ //=212-> 221. ignore repeat, count (12, 21) once
					
					String rotateString = s.substring(k) + s.substring(0, k);	
					
					int rotate = Integer.valueOf(rotateString);
					
					if((j<rotate) && (rotate <=max)){ //rotate>=min
						if(!set.contains(rotate)){
							set.add(rotate);
							ret ++; 
						}						
						//System.out.println(j + "-> " + rotate);
					}
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		

		Tool.createOutput();

		List<String[]> input = Tool.readLine();

		for (int j = 0; j < input.size(); j++) {

			String[] line = input.get(j);
			int n =  Integer.parseInt(line[0]);
			int k =  Integer.parseInt(line[1]);
			int ret = pairsRotated(n, k);

			String outputLine = "Case #" + (j+1) + ": " + ret;
			System.out.println(outputLine);
			Tool.writeOutput(outputLine);
		}	


	}

}
