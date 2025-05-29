import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ProblemC {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File(args[0]));
		int numberOfLines = Integer.parseInt(sc.nextLine());
		Scanner lineScan;
		int lowerBound, upperBound;
		String line;
		String number;
		String movingPart;
		String newNumber;
		int count;
		
		for (int i = 0; i< numberOfLines; i++)
		{
			line = sc.nextLine();
			lineScan = new Scanner(line);
			lowerBound = lineScan.nextInt();
			upperBound = lineScan.nextInt();
			count = 0;
			
			if (upperBound < 10)
			{
				System.out.println("Case #" + (i+1) + ": " + 0);
			}
			else
			{
				for (int j = lowerBound; j<= upperBound; j++)
				{
					number = Integer.toString(j);

					for (int k = 1; k< number.length(); k++)
					{
						if (number.charAt(k) != '0')
						{
							movingPart = number.substring(k, number.length());

							newNumber = movingPart + number.substring(0,k);

							if (Integer.parseInt(newNumber) <= upperBound && 
									Integer.parseInt(newNumber) > Integer.parseInt(number))
							{
								count ++;
								//System.out.println("Number " + number + " New number " + newNumber + "counter" + count);
							}
						}
					}


				}

				System.out.printf("Case #%d: %d\n",(i+1), count);

			}
		}
	}
}
