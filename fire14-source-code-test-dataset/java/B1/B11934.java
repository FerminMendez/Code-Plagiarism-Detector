import java.util.Scanner;


public class RecycledNumbers {
	
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine().trim();
		int totalCase = Integer.parseInt(line);
		
		for (int i = 1; i <= totalCase; i++)  {
			line = scanner.nextLine().trim();
			String parts[] = line.split(" +");
			int min = Integer.parseInt(parts[0]);
			int max = Integer.parseInt(parts[1]);
			
			int numOfDigits = ("" + min).length();
			
			int total = 0;
			for (int num = min; num <= max; num++)  {
				String numString = "" + num;
				

				for (int index = 1; index < numOfDigits; index++)  {
					String numPart1 = numString.substring(0, index);
					String numPart2 = numString.substring(index);
					String newNumString = numPart2 + numPart1;
					
					int newNum = Integer.parseInt(newNumString);
					if (newNum > num && newNum <= max && num >= min)  {
//						System.out.println("(" + num +"," + newNum + ")");
						
						total++;
					}
				}
				
			}
			
			
			String output = "Case #" + i + ": " + total;	
			System.out.println(output);
		}
		
		System.exit(0);
	}
	
}
