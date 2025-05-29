import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecycledNumber {
	public static void main (String[] args) throws FileNotFoundException{

		Scanner scan = new Scanner (new File ("input.txt"));
		int caseNumber = scan.nextInt();
		scan.nextLine();
		
		for(int k=0; k<caseNumber; k++){
			int result = 0;
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			for (int i = A ; i <= B ; i++){
				for (int j = 1; j < numberOfDigits(i) ; j++){
					if (digit(i,j)>=digit(i,numberOfDigits(i))){
						if (A <= recycle(i,j) && B >= recycle(i,j) && i<recycle(i,j)){
							result++;
						}
					}

				}
			}
			System.out.println("Case #"+(k+1)+": "+result);
			if (scan.hasNextLine()){
				scan.nextLine();
			}
		}

	}
	
	static int numberOfDigits(int number){
		return ((int)Math.floor(Math.log10(number))) + 1;
	}
	
	static int recycle(int number, int digit){
		int newPrefix =  (((int)(number%Math.pow(10, digit)))*(int)Math.pow(10, (numberOfDigits(number)-digit)));
		int newSuffix = number/(int)(Math.pow(10, digit)) ;
		return newPrefix+newSuffix;
	}
	
	static int digit(int number, int digit){
		return (number/(int)(Math.pow(10,digit-1)))%10;
	}
}
