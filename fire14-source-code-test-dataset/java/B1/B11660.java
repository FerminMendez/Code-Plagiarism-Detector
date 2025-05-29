/*
 *	3rd task of this years google Code Jam, lets see what I can do 
 */

//Import of java classes and packages
import java.util.Locale;
import java.util.Scanner;

//Body class
public class RecycledNumbers {

	//main class start
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		int recycledCount = 0;
		
		int testCount = sc.nextInt();
		
		//This cycle will run for every test (why so obvious?)
		for(int i = 0; i < testCount; i++){
			int first = sc.nextInt();
			int second = sc.nextInt();
			recycledCount = 0;	
			
			for(int j = first; j <= second; j++){
				if(j < 10)
					continue;
				
				String numberString = new String("" + j);
				for(int k = 1; k < numberString.length(); k++){
					String newNumber = new String(numberString.substring(k, numberString.length()) + numberString.substring(0,k));
					//System.out.println(newNumber);
					int number = Integer.parseInt(newNumber);
					if((number > j) && (number <= second))
						recycledCount++;
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + recycledCount);			
		}
		
	}
	//main class end
}
