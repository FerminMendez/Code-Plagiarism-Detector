package codejam.suraj.quals2012.googledancers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TreeExpansionEvent;

import codejam.suraj.quals2012.CodeJamSkeleton;
import codejam.suraj.quals2012.googlerese.Googlerese;

public class GoogleDancers extends CodeJamSkeleton {

	@Override
	protected void handleTestCase(int testCaseNumber) throws IOException {
		// TODO Auto-generated method stub
		
		String line = readLine();
		String[] lineSplits = line.split("\\s+");
		
		int numberOfG = Integer.parseInt(lineSplits[0]);
		int surprises = Integer.parseInt(lineSplits[1]);
		int p = Integer.parseInt(lineSplits[2]);
		List<Integer> scores = new ArrayList<Integer>(lineSplits.length - 3);
		for (int i = 3; i < numberOfG + 3; ++i){
			scores.add(Integer.parseInt(lineSplits[i]));
		}
		
		Iterator<Integer> iter = scores.iterator();
		int requiredSurprises = 0;
		
		int bestAndRequired = 0;
		int numBestResults = 0;
		System.out.println("Test Case " + testCaseNumber);
		System.out.println(line);
		while(iter.hasNext()){
			int score = iter.next();
			int max = score/3;
			if(score > 0 && score%3 != 0)
				max = max + 1;
			
			if(p == max){
				++numBestResults;
			}
			else if(p > max){
				if(score == 2 || score > 2 && score%3 == 0 ||
						score > 2 && score%3 == 2){
					int possibleMax = max + 1;
					if(possibleMax == p){
						++requiredSurprises;
					}
					
				}
				
			}
			else if (p < max){
				int min = 0;
				if(score <= 2){
					min = 0;
					if(p == min){
						++numBestResults;
					}
					
				}
				else{
					if(score%3 == 0){
						min = max - 1;
						if(min == p){
							++requiredSurprises;
							++numBestResults;
							++bestAndRequired;
						}
						else{
							++numBestResults;
						}
					}
					else if (score%3 == 1 || score%3 == 2){
						min = max - 1;
						if(min == p){
							++numBestResults;
						}
						else if (min - 1 == p){
							++requiredSurprises;
							++numBestResults;
							++bestAndRequired;
						}
						else{
							++numBestResults;
						}
					}
				}
			}
			else if (p == max){
				++numBestResults;
			}
		}
		
		int result = numBestResults + Math.min(requiredSurprises - bestAndRequired, surprises);

		
		addOutput(testCaseNumber, ""+result);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodeJamSkeleton testCase = new GoogleDancers();
		testCase.handleAllTestCases(args[0], args[1]);
	}

}
