package codejam2012.qualified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemB {

	static BufferedReader buffReader = null;
	static BufferedWriter buffWriter = null;
	static FileReader fileReader = null;
	static FileWriter fileWriter = null;
	static String input_test = "/home/qimeng/problemB.test";
	static String input_small =  "/home/qimeng/B-small-attempt1.in";
	static String input_large = "/home/qimeng/B-small-attempt1.out";

	public static final void main(String[] args){
		try {
			fileReader = new FileReader(input_small);
			buffReader = new BufferedReader(fileReader);
			fileWriter = new FileWriter("/home/qimeng/problemB.out");
			buffWriter = new BufferedWriter(fileWriter);

			int total_size = Integer.parseInt(buffReader.readLine());
			//iterate through every input line
			for(int i=1; i<=total_size; i++){
				String[] str = buffReader.readLine().split(" ");
				int strLen = str.length;
				
				int T = Integer.parseInt(str[0]);
				int s = Integer.parseInt(str[1]);
				int p = Integer.parseInt(str[2]);
				
				int[] scores = new int[T];
				
				int k = 0;
				for(int j=3; j<strLen; j++){					
					scores[k] =  Integer.parseInt(str[j]);
					k++;
				}
				
				
				System.out.println("Case #" +i+": " + danceAlgorithm(s, p, scores));
				buffWriter.write("Case #" +i+": " + danceAlgorithm(s, p, scores));
				buffWriter.newLine();
				buffWriter.flush();
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffWriter.flush();		
				buffWriter.close();
				buffReader.close();
				fileReader.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static int danceAlgorithm(int s, int p, int[] scores){		
		int result = 0;
		
		int i = 0;
		while(i < scores.length){
			int score = scores[i];
			if(score == 0 && p != 0){
				i++;
				continue;
			}
			
			int avg = score / 3;
			int rem = scores[i] % 3;
			
			//System.out.println("p:"+ p +"  avg: "+avg+"  rem: "+rem);
			if(avg >= p){
				result++;
			}		
			else {
				if(rem == 0){
					if(avg + 1 >= p) { 
						if(s>0){
							result++;
							s--;
						}
					}
				}
				else if(rem == 1){
					if(avg + 1 >= p) { result++; }
				}
				else if(rem == 2){
					if(avg + 2 >= p) { 
						if(avg+1>=p){ result++;}
						else{
							if(s>0){
								result++;
								s--;
							}
						}
					}
				}
			}
			i++;
		}
		
		return result;
	}
}
