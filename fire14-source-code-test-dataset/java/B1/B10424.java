import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String str = "";
		    
		    // Testcases
		    str = in.readLine();
		    int cases = Integer.valueOf(str);
		    List<String> output = new ArrayList<String>();
		    
		   for(int i = 1; i <= cases; i++){
		        
		        str = in.readLine();
		        
		        String[] numbers = str.split(" ");
		        
		        int a = Integer.valueOf(numbers[0]);
		        int b = Integer.valueOf(numbers[1]);

	        
		        output.add("Case #" + i+ ": " + calculate(a, b));
		    }
		   
		       for(String outputLine : output){
		        System.out.println(outputLine);
		    }
		       
		} catch (IOException e) {
		}
	}

	
	private static String calculateWithout(int a, int b) {
		int recycled = 0;
		Set<String> found = new HashSet<String>();
		// probably slow :/
		for(int i = a; i <= b; i++){
			
			String num = String.valueOf(i);
			int[] sortedPermu = new int[num.length()];
			for(int j = 0; j < num.length(); j++){
				sortedPermu[j] = Integer.valueOf((String)num.substring(j, j + 1));
			}
			
			
			for(int k = 0; k < sortedPermu.length; k++) {
				int[] shifted = new int[num.length()];
				
				for(int j = 0, index = 1; j < sortedPermu.length; j++, index++) {
					if(index >= sortedPermu.length) {
						index -= sortedPermu.length;
					}

					shifted[j] = sortedPermu[index];
				}
				sortedPermu = shifted;
				
				
				boolean foundLeadingZero = false;
				// remove numbers with leading 0
				for(int j = 0; j < sortedPermu.length && !foundLeadingZero; j++){
					if(sortedPermu[j] == 0){
						foundLeadingZero = true;
					}
					break;
				}
				
				if(foundLeadingZero){
					continue;
				}

				// remove numbers with the same number
				int oldNumber = sortedPermu[0];
				boolean noSimpleNum = false;;
				for(int j = 1; j < sortedPermu.length && !noSimpleNum; j++){
					if(oldNumber != sortedPermu[j]){
						noSimpleNum = true;
					}
				}
				if(!noSimpleNum){
					continue;
				}
				
				
				String newNum = intArrayToString(sortedPermu);
				
				if(i > Integer.valueOf(newNum)){
					recycled++;
					System.out.println(i + ": " + newNum);
				} else {
					found.add(newNum);
				}
			}
		}
		
		return String.valueOf(recycled);
	}
	
	
	private static String calculate(int a, int b) {
		int recycled = 0;
		Set<String> found = new HashSet<String>();
		// probably slow :/
		for(int i = a; i <= b; i++){
			
			String num = String.valueOf(i);
			int[] sortedPermu = new int[num.length()];
			for(int j = 0; j < num.length(); j++){
				sortedPermu[j] = Integer.valueOf((String)num.substring(j, j + 1));
			}
			
		
			Set<String> permChecked = new HashSet<String>();
			for(int k = 0; k < sortedPermu.length; k++) {
				int[] shifted = new int[num.length()];
				
				for(int j = 0, index = 1; j < sortedPermu.length; j++, index++) {
					if(index >= sortedPermu.length) {
						index -= sortedPermu.length;
					}

					shifted[j] = sortedPermu[index];
				}
				sortedPermu = shifted;
				
				if(permChecked.contains(intArrayToString(sortedPermu))) { 
					continue;
				} else {
					permChecked.add(intArrayToString(sortedPermu));
				}
				
				
				boolean foundLeadingZero = false;
				// remove numbers with leading 0
				for(int j = 0; j < sortedPermu.length && !foundLeadingZero; j++){
					if(sortedPermu[j] == 0){
						foundLeadingZero = true;
					}
					break;
				}
				
				if(foundLeadingZero){
					continue;
				}

				// remove numbers with the same number
				int oldNumber = sortedPermu[0];
				boolean noSimpleNum = false;;
				for(int j = 1; j < sortedPermu.length && !noSimpleNum; j++){
					if(oldNumber != sortedPermu[j]){
						noSimpleNum = true;
					}
				}
				if(!noSimpleNum){
					continue;
				}
				
				
				String newNum = intArrayToString(sortedPermu);
				
				if(found.contains(newNum) && i > Integer.valueOf(newNum) && a <= Integer.valueOf(newNum) && Integer.valueOf(newNum) <= b){
					recycled++;
				} else {
					found.add(newNum);
				}
			}
		}
		
		return String.valueOf(recycled);
	}

	private static String intArrayToString(int[] sortedPermu) {
		String newNum = "";
		for(int j = 0; j < sortedPermu.length; j++){
			newNum += String.valueOf(sortedPermu[j]); 
		}
		return newNum;
	}

}
