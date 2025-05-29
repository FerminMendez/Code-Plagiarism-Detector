import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class GoogleDance{
	
	HashMap<Integer,Integer> nonSurpriseMax = new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> surpriseMax = new HashMap<Integer,Integer>();
	
	GoogleDance(){
		nonSurpriseMax.put(0, 0);
		nonSurpriseMax.put(1, 1);
		nonSurpriseMax.put(2, 1);
		nonSurpriseMax.put(3, 1);
		nonSurpriseMax.put(4, 2);
		nonSurpriseMax.put(5, 2);
		nonSurpriseMax.put(6, 2);
		nonSurpriseMax.put(7, 3);
		nonSurpriseMax.put(8, 3);
		nonSurpriseMax.put(9, 3);
		nonSurpriseMax.put(10, 4);
		nonSurpriseMax.put(11, 4);
		nonSurpriseMax.put(12, 4);
		nonSurpriseMax.put(13, 5);
		nonSurpriseMax.put(14, 5);
		nonSurpriseMax.put(15, 5);
		nonSurpriseMax.put(16, 6);
		nonSurpriseMax.put(17, 6);
		nonSurpriseMax.put(18, 6);
		nonSurpriseMax.put(19, 7);
		nonSurpriseMax.put(20, 7);
		nonSurpriseMax.put(21, 7);
		nonSurpriseMax.put(22, 8);
		nonSurpriseMax.put(23, 8);
		nonSurpriseMax.put(24, 8);
		nonSurpriseMax.put(25, 9);
		nonSurpriseMax.put(26, 9);
		nonSurpriseMax.put(27, 9);
		nonSurpriseMax.put(28, 10);
		nonSurpriseMax.put(29, 10);
		nonSurpriseMax.put(30, 10);
		
		surpriseMax.put(0, 0);
		surpriseMax.put(1, 1);
		surpriseMax.put(2, 2);
		surpriseMax.put(3, 2);
		surpriseMax.put(4, 2);
		surpriseMax.put(5, 3);
		surpriseMax.put(6, 3);
		surpriseMax.put(7, 3);
		surpriseMax.put(8, 4);
		surpriseMax.put(9, 4);
		surpriseMax.put(10, 4);
		surpriseMax.put(11, 5);
		surpriseMax.put(12, 5);
		surpriseMax.put(13, 5);
		surpriseMax.put(14, 6);
		surpriseMax.put(15, 6);
		surpriseMax.put(16, 6);
		surpriseMax.put(17, 7);
		surpriseMax.put(18, 7);
		surpriseMax.put(19, 7);
		surpriseMax.put(20, 8);
		surpriseMax.put(21, 8);
		surpriseMax.put(22, 8);
		surpriseMax.put(23, 9);
		surpriseMax.put(24, 9);
		surpriseMax.put(25, 9);
		surpriseMax.put(26, 10);
		surpriseMax.put(27, 10);
		surpriseMax.put(28, 10);
		surpriseMax.put(29, 10);
		surpriseMax.put(30, 10);
	}
	
	
	int getcount(String input){
		int p = 0,surprises=0;
		
		int no_of_score =0;
		int count=0;
		StringTokenizer t =  new StringTokenizer(input);
		
		if(t.hasMoreTokens()){
			no_of_score = Integer.parseInt(t.nextToken());
		}
		if(t.hasMoreTokens()){
			surprises = Integer.parseInt(t.nextToken());
		}
		if(t.hasMoreTokens()){
			p = Integer.parseInt(t.nextToken());
		}
		while(t.hasMoreTokens()){
			
			int inputsum = 	Integer.parseInt(t.nextToken());
			
			if(nonSurpriseMax.get(inputsum) >= p)
				count++;
			else if(surpriseMax.get(inputsum) >= p && surprises >0 ){
				surprises--;
				count++;
			
			}
		}
		return count;
	}
	
	
	public static void main(String args[]){
		
	GoogleDance d = new GoogleDance();
	
	int no_of_cases = 0;
	String input = "";
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try{
		no_of_cases = Integer.parseInt(br.readLine());
	}
	catch(Exception e){
		System.out.println("First line is not a number");
	}
	
	for(int i=1; i <= no_of_cases;i++){
		try{
			input = br.readLine();
		}
		catch(Exception e){
			System.out.println("Number of test cases different from the number mentioned in first line");
		}
		
		System.out.print("Case #" +i+": ");
		System.out.println(d.getcount(input));
		

		
	}
	
	
	}
}