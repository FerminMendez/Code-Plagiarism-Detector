import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class addy {
	public static int counter = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		
		for (int count = 0; count < lines; count++) {
			String inputLine = sc.nextLine();
			String input[] = inputLine.split(" ");
			int noOfDancers = Integer.parseInt(input[0]);
			int noOfSurprise = Integer.parseInt(input[1]);
			int minScore = Integer.parseInt(input[2]);
			List<Integer> dancerScore = new ArrayList<Integer>();

			for (int i = 0; i < noOfDancers; i++) {
				// System.out.println("dancer "+i+"score:"+Integer.parseInt(input[3+i]));
				dancerScore.add(Integer.parseInt(input[3 + i]));
			}
			int counting = 0;
			for (int dancer : dancerScore) {
				counter = 0;
				int temp = dancer % 3;
				int no = dancer / 3;
				if(dancer<minScore)
				{
					continue;
				}else if(dancer==0 && minScore==0)
				{
					counting++;
				}
				else if (minScore - no == 1 && temp > 0) {
					counting++;
					
				} else if (minScore - no == 0) {
					counting++;
					
				} else if (minScore - no == 2 && temp == 2) {
					if (noOfSurprise > 0) {
						counting++;
						noOfSurprise--;
					
					}
				} else if (minScore - no < 0) {
					counting++;
					
				} else if (minScore - no == 1 && temp == 0) {
					if (noOfSurprise > 0) {
						counting++;
						
						noOfSurprise--;
					}
				}
			}
			counter = counting;
			System.out.println("Case #" + (count + 1) + ": " + counter);
		}

	}

}
