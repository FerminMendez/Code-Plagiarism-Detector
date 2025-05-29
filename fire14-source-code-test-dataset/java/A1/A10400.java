import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DancingWithThegooglers {


	private static Map<Integer, Points> pointMap = new HashMap<Integer, Points>();
	public static void main(String[] args) {
		
		pointMap.put(0, new Points(0, 0));
		pointMap.put(1, new Points(1, 1));
		pointMap.put(2, new Points(4, 2));
		pointMap.put(3, new Points(7, 5));
		pointMap.put(4, new Points(10, 8));
		pointMap.put(5, new Points(13, 11));
		pointMap.put(6, new Points(16, 14));
		pointMap.put(7, new Points( 19, 17));
		pointMap.put(8, new Points( 22, 20));
		pointMap.put(9, new Points( 25, 23));
		pointMap.put(10, new Points( 28, 26));
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
		        
		        int googlers = Integer.valueOf(numbers[0]);
		        int surprising = Integer.valueOf(numbers[1]);
		        int points = Integer.valueOf(numbers[2]);
		        
		        Integer[] results = new Integer[googlers];
		        
		        
		        for(int j = 3; j < 3 + googlers; j++){
		        	results[j - 3] = Integer.valueOf(numbers[j]); 
		        }
		        
		     // sort the shit out of it
		        Arrays.sort(results, Collections.reverseOrder());
		        
		        
		        output.add("Case #" + i+ ": " + calculate(googlers, surprising, points, results));
		    }
		   
		       for(String outputLine : output){
		        System.out.println(outputLine);
		    }
		       
		} catch (IOException e) {
		}

	}

	private static String calculate(int googlers, int surprising, int points,
			Integer[] results) {
		String res = googlers + " : " + surprising + " : " + points + " anz: " + results.length + " first: " + results[0] + " last: " + results[results.length - 1];
		
		Points p = pointMap.get(points);
		int result = 0;
		int surleft = surprising;
		for(int i = 0; i < results.length; i++){
			if(results[i] >= p.minPoints){
				result++;
				continue;
			}
			if(results[i] >= p.surPoints && surleft > 0) {
				result++;
				surleft--;
				continue;
			}
			break;
		}
		return String.valueOf(result);
	}

}
