package myPackage;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.*;
import java.math.*;
public class GooglersDance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int totalTestCases;
		int N,S,P,count=0,sCount=0;
		int[] scores;
		//TreeSet charTree = new TreeSet();
		//TreeSet <Integer> scores = new TreeSet <Integer>();
		try
		{
			File myInputFile =  new File("F:\\COEP\\Google\\CodeJam\\GooglersDance\\small.in");
			File myOutputFile =  new File("F:\\COEP\\Google\\CodeJam\\GooglersDance\\small.out");
			Scanner myScan = new Scanner (myInputFile);
			FileWriter myFw = new FileWriter(myOutputFile);
			
			totalTestCases = myScan.nextInt();
			String english = new String();
			english = myScan.nextLine();
			//System.out.println("Index of e : " + charMap.get("e") );
			
			for (int i=0 ; i<totalTestCases ; i++)
			{
				N = myScan.nextInt();
				S = myScan.nextInt();
				P = myScan.nextInt();
				scores = new int[N];
				count=0;
				sCount=S;
				for (int j=0 ; j<N ; j++)
				{
					scores[j] = (Integer)myScan.nextInt() - P;
					//scores.add((Integer)myScan.nextInt()-P);
				}
				
				
				System.out.println("N:" + N + ", S:" + S + ", P:" + P + ", initial sCount: " + sCount);
				//Iterator it = scores.descendingIterator();
				int currScore;
				//while(it.hasNext())
				for (int k=0 ; k<N ; k++)
				{
					//currScore = (Integer)it.next();
					currScore = scores[k];
					System.out.println("Score :" + currScore);
					if( currScore >=0 )
					{
						if(P - (currScore / 2) <= 1)
						{
							count++;
						}
						else
						if(P - (currScore / 2) == 2 && sCount>0)
						{
							//if((currScore % 2) == 0)
							//{
								sCount--;
							//}
							count++;
						}
					}
					//it.remove();
				}
				System.out.println("Case #" + (i+1) + ": " + count + ", final sCount : " + sCount);
				myFw.append("Case #" + (i+1) + ": "+ count + "\n");		
				myFw.flush();
			}
			
			
			
			myFw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	public void move(int currPeg, int finalPeg)
	{
		
	}

}
