import java.io.*;
import java.util.*;
import java.util.regex.*;

public class jam02 {

	/**
	 * @param args
	 */
	
	public static void main1(){
	// scalar product problem
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number_test;
		Scanner sc = new Scanner(System.in);
		number_test = sc.nextInt();
		for(int j=1;j<=number_test;j++) {
			int numOfGooglers = sc.nextInt();
			int numOfSurprises = sc.nextInt();
			int surPrisingNum = sc.nextInt();
			int[] googlers = new int[numOfGooglers];
			for(int i=0;i<numOfGooglers;i++)
			{
				googlers[i] = sc.nextInt();
			}
			System.out.print("Case #" + j + ": ");
			action(surPrisingNum,numOfSurprises,googlers);
//			System.out.println(sum);
		}
	}


	private static void action(int surPrisingNum, int numOfSurprises,
			int[] googlers) {
		// TODO Auto-generated method stub
		// Iterating over the elements in the set
		int finalGuys = 0;
		for(int i=0;i<googlers.length;i++)
		{
			if(googlers[i] >= (surPrisingNum*3)-2)
			{
				finalGuys++;
			}
			else if(numOfSurprises !=0 && googlers[i] !=0 && googlers[i] >= (surPrisingNum*3)-4)
			{
				finalGuys++;
				numOfSurprises--;
			}
		}
		System.out.println(finalGuys);
			
	}
}
