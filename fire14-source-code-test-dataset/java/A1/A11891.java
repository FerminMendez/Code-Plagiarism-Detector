import java.util.Scanner;


public class DancingWithTheGooglers {
	
	public static void main(String[] args)  {
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine().trim();
		int totalCase = Integer.parseInt(line);
		
		for (int i = 1; i <= totalCase; i++)  {
			line = scanner.nextLine().trim();
			String parts[] = line.split(" +");
			
			int numOfGooglers = Integer.parseInt(parts[0]);
			int numOfSuprises = Integer.parseInt(parts[1]);
			int bestResult = Integer.parseInt(parts[2]);

			String output = "Case #" + i + ": ";
			int possible = 0;
			int impoosible = 0;
			for (int count = 0; count < numOfGooglers; count++)  {
				int index = 3+count;
				int totalPoints = Integer.parseInt(parts[index]);
				if (totalPoints < bestResult)  {
					impoosible++;
					continue;
				}
				
				int sumOfTwo = totalPoints - bestResult;
				float avgOfTwo = sumOfTwo / 2.0f;
				
				int num2 = (int)Math.floor(avgOfTwo);
				int num3 = (int)Math.ceil(avgOfTwo);
				
				int diff1 = bestResult - num2;
				int diff2 = bestResult - num3;
				
				if (diff1 <= 1 && diff2 <= 1)  {
					possible++;
				}  else if (diff1 >= 3 || diff2 >= 3)  {
					impoosible++;
				}
			}
			
			int googlersLeft = numOfGooglers - possible;
			int possibleGooglers = (googlersLeft - impoosible > numOfSuprises ? numOfSuprises : googlersLeft - impoosible);
			
			int p = possible + possibleGooglers;

			output += p;
			System.out.println(output);
		}
		
		System.exit(0);
	}
	
}
