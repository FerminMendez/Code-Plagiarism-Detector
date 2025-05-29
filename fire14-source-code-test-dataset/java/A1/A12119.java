import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.util.List;
import java.util.ArrayList;

public class GCJ_qr_b {
	
	public static void main(String[] args) {

		GCJReader in = new GCJReader(args[0]);
		GCJWriter out = new GCJWriter(args[1]);
		
		int numTestCases = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= numTestCases; i+=1) {
			String[] input = in.readLine().split(" ");

			//always  >= 1
			final int googlers =  Integer.parseInt(input[0]);
			final int surprisingScores = Integer.parseInt(input[1]);
			final int p = Integer.parseInt(input[2]);
			
			int maxGooglers = 0;
			int rSurprisingScores = surprisingScores;
			
			System.out.println("Googlers=" + googlers + ", surprisingScores=" + surprisingScores + ", p="+  p);
			
			for(int j = 3; j < 3 + googlers; j += 1) {
				int totalScore = Integer.parseInt(input[j]);
				int[] scores = getOrderedScores(totalScore);
				
				System.out.print("    From " + totalScore + " , got (" + scores[0] + "," + scores[1] + "," + scores[2] + ")");
				
				boolean gotMax = false;

				//The score in the final sorted position is >= p, so no more checks required.
				if (scores[2] >= p) {
					maxGooglers += 1;
					System.out.println(" | not surprising, satisfied");					
					continue;
				}
				
				//the largest score does not satisfy the maximum, but we might still have a chance if
				//we have some surprising scores remaining
				if(rSurprisingScores == 0) {
					System.out.println(" | no surprising scores left");					
					continue; 
				}
				
				//We have at least one surprising score to work with, which means that the scores as is
				//do not satisfy p, but if they are surprising they may
				//This scenario now breaks down into 3 cases, in general seeming to correspond to the situation where 
				//Algorithm could be greatly improved if we analyzed the properties of the score for 3-divisibily but who has time for that

				if(scores[0] == scores[1] && scores[0] == scores[2]) {
				//Case 1: The scores are equal					
					
					if(scores[0] == 0) {
					//edge case, if all scores are 0, then we can do nothing						
						gotMax = false;
						
					} else if((scores[2] + 1) >= p) {
					//if the scores are equal and >=1, then we can make these scores surprising by increasing
					//one score and decreasing another. For example (1,1,1) can become (1,0,2)
						gotMax = true;
					}
					
				} else if (scores[0] == scores[1]) {
				//Case 2: We have a triplet of two smaller scores and a larger score, as (1, 1, 2)
	            //        in this case we cannot adjust for a surprising score, as the gap between the largest score (i.e. 2) and the smaller score (i.e. 1)
				//	      will become too large (i.e. 1, 0, 3), and adjusting the smaller numbers is irrelevant (i.e. (0, 2, 2) )
				//        So, just continue on
					
					gotMax = false;
					
				} else if (scores[1] == scores[2]) {
				//Case 3: We have a triplet of two larger scores and a smaller score, as (1, 2, 2)
				//        We can adjust this number to be a surprising score in pretty much every case, i.e. (1, 1, 3)
					
					if((scores[2] + 1) >= p) {
						gotMax = true;
					}
				}
				
				//made the score surprising and see if we can satisfy p
				if (gotMax) {
					rSurprisingScores--;
					maxGooglers++;
					System.out.println(" | surprising, satisfied, remaining surprising=" + rSurprisingScores);					
				} else {
					System.out.println(" | can't be satisfied, remaining surprising=" + rSurprisingScores);					
				}
			}
			
			String outLine = "" + maxGooglers;
			out.writeLine(String.format("Case #%d: %s", i, outLine));
		}
	}
	
	//the neat part of this breakdown is that scores[3] will always contain the largest number regardless
	private static int[] getOrderedScores(int total) {
		int[] scores = new int[3];
		
		scores[0] = total / 3;
		scores[1] = (total - scores[0]) / 2;		
		scores[2] = (total - scores[0] - scores[1]);
		
		return scores;
	}
	
	private static class GCJWriter {
		private String outFile = null;		
		private BufferedWriter out = null;
		
		public GCJWriter(String outFile) {
			this.outFile = outFile; 
			
			try { 
				out = new BufferedWriter(new FileWriter(outFile));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public void writeLine(String output) {
			try {
				out.write(output + "\n");
				out.flush();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}			
	}
	
	private static class GCJReader {
		private String inFile = null;		
		private BufferedReader in = null;
		
		public GCJReader(String inFile) {
			this.inFile = inFile; 
			
			try { 
				in = new BufferedReader(new FileReader(inFile));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public String readLine() {
			try {
				return in.readLine();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}		
	}	
}