import java.io.*;
import java.util.*;
import java.util.regex.*;

public class jam03 {

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
			int lowerLimit = sc.nextInt();
			int upperLimit = sc.nextInt();
			System.out.print("Case #" + j + ": ");
			action(lowerLimit,upperLimit);
//			System.out.println(sum);
		}
	}


	private static void action(int lowerLimit, int upperLimit ) {
		// TODO Auto-generated method stub
		// Iterating over the elements in the set
		int finalGuys = 0;
		int maxZeroes = 0;
		int oldNum=0;
//		System.out.println("lower"+ lowerLimit);
//		System.out.println("uper"+upperLimit);
		for(int i=lowerLimit;i<upperLimit;i++)
		{			
			for(int k=4;k>=1;k--)
			{//3422
				int temp = (int) (i/Math.pow(10, k));//34
				if(maxZeroes ==0 && temp > 0)
				{
					maxZeroes = k;
					//System.out.println("maxZeroes"+maxZeroes);
				}
				if(maxZeroes>0)
				{
					int temp1 = (int) (i - (temp*Math.pow(10, k)));//3422-3400
					int newNum = (int) ((temp1*Math.pow(10, maxZeroes-k+1))+temp);//4223
					if(newNum <= upperLimit && newNum > i && newNum != oldNum)
					{
						oldNum = newNum;
						finalGuys++;
					}
				}
			}
		}
		System.out.println(finalGuys);
			
	}
}
