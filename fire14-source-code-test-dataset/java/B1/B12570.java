import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class RecycledNumbers{
	
	
	
	int getcount(int small,int large){
		int count = 0;
		for(int currnum = small; currnum < large; currnum++){
			int permut = currnum;
			int no_of_digits = 0;
			while(permut > 0){
				permut = permut/10;
				no_of_digits++;
			}
			int lastDigit = currnum % 10;
			permut = currnum / 10;
			permut = permut + lastDigit * (int)Math.pow(10, no_of_digits-1);
			while(permut != currnum){
				
				if(permut >= currnum && permut <= large){
					
					count++;
				}
				lastDigit = permut % 10;
				permut = permut / 10;
				permut = permut + lastDigit * (int)Math.pow(10, no_of_digits-1);
				
			}
			
		}
		
		return count;
	}
	
	public static void main(String args[]){
		RecycledNumbers d = new RecycledNumbers();
		
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
			
			StringTokenizer t =  new StringTokenizer(input);
			int small=0,large=0;
			if(t.hasMoreTokens()){
				small = Integer.parseInt(t.nextToken());
			}
			if(t.hasMoreTokens()){
				large = Integer.parseInt(t.nextToken());
			}
			System.out.println(d.getcount(small,large));
			
		}
		
		
		

	}
	
	
}