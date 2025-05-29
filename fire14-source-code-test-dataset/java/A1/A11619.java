/**
 * 
 */
package com.sakthi.demo;

import java.io.File;
import java.util.Scanner;

/**
 * @author Balaji
 *
 */
public class GooglersDance {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	//	System.out.println("check");
		Scanner in = new Scanner(new File("myinput.in"));
	      int numCases = in.nextInt();
	      for (int i = 0; i < numCases; i++) {
	    	  googlersWithMaxScore(in,i+1);
	  //  	  findGooglersWithMaxScore(in,i+1);
	      }
	}
private static void googlersWithMaxScore(Scanner in,int t) {
	
	int noGooglers =in.nextInt();
	int surprises =in.nextInt();
	int pts[]=new int[noGooglers];
	int maxScore=in.nextInt();
	for(int i=0;i<pts.length;i++)
		pts[i]=in.nextInt();

	//int score1,score2,score3;
	//int noSurprisingCrossed=0;
	int noGooglerWithMaxScoreCrossed=0;
	//int tempScores[] =new int[3];
	//if(t==69 | t==55)
		//System.out.println("Check");
	for(int index=0;index<pts.length;index++) {
		int totalScore = pts[index];
	    int average = totalScore / 3;
	    int overflow = totalScore % 3;
	    
	    if (average >= maxScore) {
	    	noGooglerWithMaxScoreCrossed++;
	    } else if ((overflow != 0) && ((average+1) >= maxScore)) {
	    	noGooglerWithMaxScoreCrossed++;
	    } else if (surprises != 0) {
	            if ((overflow == 2) && ((average+overflow) >= maxScore)) {
	            	noGooglerWithMaxScoreCrossed++;
	            	surprises--;
	            } else if ((overflow == 0) && (average > 0) && ((average+1) >= maxScore)) {
	            	noGooglerWithMaxScoreCrossed++;
	            	surprises--;
	            }
	    }
	}
	System.out.println("Case #" + t + ": " + noGooglerWithMaxScoreCrossed);

	
	
	
	
	
}
private static void findGooglersWithMaxScore(Scanner in,int t) {
	int noGooglers =in.nextInt();
	int surprises =in.nextInt();
	int pts[]=new int[noGooglers];
	int maxScore=in.nextInt();
	for(int i=0;i<pts.length;i++)
		pts[i]=in.nextInt();

	int score1,score2,score3;
	int noSurprisingCrossed=0;
	int noGooglerWithMaxScoreCrossed=0;
	//int tempScores[] =new int[3];
	//if(t==69 | t==55)
		//System.out.println("Check");
	for(int index=0;index<pts.length;index++) {
		int totalScore=pts[index];
		if(totalScore==0) {
			if(totalScore==maxScore) {
				noGooglerWithMaxScoreCrossed++;
			}
			continue;
		}
		score1=maxScore;
		/*if((totalScore-score1)>=20) {
			noGooglerWithMaxScoreCrossed++;
			continue;
		}
		score2 = (totalScore-score1)/2;
		score3 = (totalScore-(score1+score2));
		if(((score1+score2+score3)>=totalScore) && Math.abs(score2-score1)<2) {
			noGooglerWithMaxScoreCrossed++;
			continue;
		}
		else if(Math.abs(score2-score3)<2) {
			noGooglerWithMaxScoreCrossed++;
		}*/
		
		int a[]=new int[3];
		for(int i=maxScore;i<=10;i++) {
			/*if(totalScore<=maxScore) {
				score1=i;
				score2=(totalScore-score1)/2;
				score3=(totalScore-(score1+score2));
				a[0]=score1;
				a[1]=score2;
				a[2]=score3;
				if((score1+score2+score3)>=totalScore) {
					
				}
				noGooglerWithMaxScoreCrossed++;
				break;
			}*/
			score1 = i;
			score2 =(totalScore-score1)/2;
			score3 = (totalScore-(score1+score2));
			a[0]=score1;
			a[1]=score2;
			a[2]=score3;
			//diffBtMinAndMax();
			if((score1+score2+score3)>=totalScore) {
				if(diffBtMinAndMax(a)==2) {
					if(noSurprisingCrossed>=surprises)
						continue;
					noSurprisingCrossed++;
					noGooglerWithMaxScoreCrossed++;
					break;
				}else if(diffBtMinAndMax(a)<2) {
					noGooglerWithMaxScoreCrossed++;
					break;
				}
				
			}
			
		}
	
		
	}
	//System.out.println("Googler "+noGooglerWithMaxScoreCrossed);
	//System.out.println("Check");
	System.out.println("Case #" + t + ": " + noGooglerWithMaxScoreCrossed);

	
}
private static int diffBtMinAndMax(int a[]) {
	for(int i=0;i<a.length-1;i++) {
		for(int j=1;j<=a.length-1;j++) {
			if(a[i]>a[j]) {
				int temp =a[i];
				a[i]=a[j];
				a[j]=temp;
				//a[i]=a[j];
			}
			
		}
	}
	
	return Math.abs(a[0]-a[2]);
}
}