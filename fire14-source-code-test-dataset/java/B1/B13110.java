package com.vp.impl;

import java.util.Arrays;

import com.vp.common.CommonUtility;
import com.vp.iface.Problem;

public class DancingWithGooglers implements Problem {

	private static int currentNoOfSurprises;
	private static int eligibleGooglers;
	private static final int noOfJudges = 3;
	private static int noOfGooglers;
	private static int noOfSurprises;
	private static int bestScore;
	
	@Override
	public String solve(String[] dataset) {
		String strReturnValue ="";
		String strDanceData = dataset[0];
		String strDanceDataArr[] = strDanceData.split(" ");
		 int iDanceDataArr[] = CommonUtility.convertStringArraytoIntArray(strDanceDataArr);
		 
		  noOfGooglers = iDanceDataArr[0];
		  noOfSurprises = iDanceDataArr[1];
		  bestScore = iDanceDataArr[2];
		  eligibleGooglers = 0;
		  currentNoOfSurprises =0;
		  
		 int totalScore;
		 int googlers[] = new int [noOfGooglers];
		 int index =0 ;
		 int scoreSplit[] = new int[noOfJudges];
		 
		 CommonUtility.print(iDanceDataArr);
		 for (int i = 3; i < iDanceDataArr.length; i++ )
		 {
			 googlers[index] = iDanceDataArr[i];
			 index++;
		 }
		 
		 Arrays.sort(googlers);
		 
		 for (int i = 0; i < googlers.length; i++ )
		 {
			  totalScore = googlers[i];
			  if(isEligible(totalScore))
			  {
				  scoreSplit= split(totalScore);
				  if(isEligibleAfterConversion(scoreSplit))
				  {
					  eligibleGooglers++;
					  CommonUtility.printWithoutExtrLine(scoreSplit);
					  System.out.println("Eligible Googler #" + eligibleGooglers);
				  }
			  }
		 }

		 System.out.println("Output: " + strReturnValue + eligibleGooglers);
		 
		return strReturnValue + eligibleGooglers;
	}
	
	private boolean isEligibleAfterConversion(int[] scoreSplit)
	{
		boolean bReturn = false;
		
		if(currentNoOfSurprises == noOfSurprises)
		{
			return true;
		}
		
		int surpriseScore[]=  convertToSurpriseScore(scoreSplit);
		
		for(int i=0;i<surpriseScore.length;i++)
		{
			if(surpriseScore[i] >= bestScore)
			{
				bReturn = true;
				break;
			}
		}
		
		return bReturn;
	}
	
	private int[] convertToSurpriseScore(int[] scoreSplit)
	{
		int diff = scoreSplit[1] - scoreSplit[0];
		int diff1 = scoreSplit[2] - scoreSplit[1];
		int diff2 = scoreSplit[2] - scoreSplit[0];
		
		String strDiff = diff+""+diff1+""+diff2;
		
		//System.out.println("strDiff: " + strDiff);
		
		if (strDiff.equals("000"))
		{
			if ((scoreSplit[2] - 1) >= 0)
			{
				scoreSplit[0] = scoreSplit[0] + 1;
				scoreSplit[2] = scoreSplit[2] - 1;
			}
		}
		else if(strDiff.equals("011"))
		{
			if((scoreSplit[0] - 1) >= 0)
			{			
				scoreSplit[0] = scoreSplit[0] - 1;
				scoreSplit[1] = scoreSplit[1] + 1;
			}
		}
		else if(strDiff.equals("101"))
		{
			if((scoreSplit[1] - 1) >= 0)
			{			
				scoreSplit[1] = scoreSplit[1] - 1;
				scoreSplit[2] = scoreSplit[2] + 1;
			}
		}
		
		Arrays.sort(scoreSplit);
		
		if(isSurpriseScore(scoreSplit))
		{
			currentNoOfSurprises ++;
			CommonUtility.printWithoutExtrLine(scoreSplit);
			System.out.println(" Surprise#: "+currentNoOfSurprises);
			
		}

		return scoreSplit;
	}

	private boolean isSurpriseScore(int[] scoreSplit)
	{
		int diff = scoreSplit[1] - scoreSplit[0];
		int diff1 = scoreSplit[2] - scoreSplit[1];
		int diff2 = scoreSplit[2] - scoreSplit[0];
		
	//	System.out.println("isSurprise diff" + diff + " " + diff1 + " "+ diff2);
		
		return ((diff + diff1 + diff2) == 4);
		
	}
	
	private static int [] split(int totalScore)
	{
		int avgScore = totalScore / 3;
		int remScoreAvg = (totalScore - avgScore) / 2;
		
		int remScore = remScoreAvg;
		int remScore1 = remScoreAvg;
		int iReturn[] = new int[3];
		int mod = (totalScore - avgScore) % 2;
		
		if(mod == 1)
		{
			remScore++;
		}
		
		iReturn[0] = avgScore;
		iReturn[1] = remScore;
		iReturn[2] = remScore1;
		
		Arrays.sort(iReturn);
		
		CommonUtility.printWithoutExtrLine(iReturn);
		//System.out.println(" : Total Score :" + totalScore);
		
		return iReturn;
	}
	
	/*private boolean isSurprisingScore(int totalScore)
	{
		boolean bReturn = false;
		
		int bs1 = bestScore;
		int bs2 = bestScore -1;
		int bs3 = bestScore -2;
		
		if(bs1 >=0 && bs2 >=0 && bs3>=0 )
		{
		bReturn = (bestScore + ( bestScore -1 ) + (bestScore -2)) == totalScore;
		if(bReturn)
			System.out.println("Eligible Googler : [" + bestScore +", "+ ( bestScore -1 )+", " + (bestScore -2) +"] = " + totalScore + " (Surprise#" + (currentNoOfSurprises + 1)+")" );
		
		if(!bReturn)
		{
			bReturn = (bestScore + (( bestScore -2 ) * 2)) == totalScore;
			if (bReturn)
			System.out.println("Eligible Googler : [" + bestScore +", "+ ( bestScore -2 )+", " + (bestScore -2) +"] = " + totalScore + " (Surprise#" + (currentNoOfSurprises + 1)+")" );
		}
		}
		
		int bs4 = bestScore;
		int bs5 = bestScore +1;
		int bs6 = bestScore +2;
		
		if(bs1 <=10 && bs2 <=10 && bs3<=10 && !bReturn)
		{
			bReturn = (bestScore + ( bestScore +1 ) + (bestScore +2)) == totalScore;
			if(bReturn)
				System.out.println("Eligible Googler : [" + bestScore +", "+ ( bestScore +1 )+", " + (bestScore +2) +"] = " + totalScore + " (Surprise#" + (currentNoOfSurprises + 1)+")" );
			
			if(!bReturn)
			{
				bReturn = (bestScore + (( bestScore +2 ) * 2)) == totalScore;
				if (bReturn)
				System.out.println("Eligible Googler : [" + bestScore +", "+ ( bestScore +2 )+", " + (bestScore +2) +"] = " + totalScore + " (Surprise#" + (currentNoOfSurprises + 1)+")" );
			}
		}
		
		if (bReturn)
		{
			currentNoOfSurprises++;
		}
		return bReturn;
	}
*/
	private boolean isEligible(int totalScore)
	{
		boolean bReturn = false;
		
		if(noOfSurprises == 0 || currentNoOfSurprises >= noOfSurprises)
		{
		//	System.out.println("isEligibleIn: " + (bestScore + ((bestScore -1) * 2)) + " : " + totalScore);
			bReturn = (bestScore + ((bestScore -1) * 2)) <= totalScore;
		}
		else
		{
		//	System.out.println("isEligibleOut: " + (bestScore + ((bestScore -2) * 2)) + " : " + totalScore);
			bReturn = (bestScore + ((bestScore -2) * 2)) <= totalScore;
		}
		
		//System.out.println("isEligible: " + bReturn);
		
		return bReturn;
	}
	
}
