import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeJam_B {
	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			String countString = reader.readLine();
			int count = Integer.parseInt(countString);
			for(int i=0;i<count;i++){
				String line = reader.readLine();
				StringTokenizer stringTokenizer = new StringTokenizer(line);
			
				int totalCount = stringTokenizer.countTokens();
				int n = -1;
				int p = -1;
				int s = -1;
				int scoreArray[] = null;
				for(int j=0;j<totalCount;j++){
					String temp = stringTokenizer.nextToken();
					int value = Integer.parseInt(temp);
					if(j == 0){
						n = value;
						scoreArray = new int[n];
					}else if(j == 1){
						s = value;
					}else if(j ==2){
						p = value;
					}else{
						scoreArray[j-3] = value;
					}
				}

				Arrays.sort(scoreArray);
				
				int usedSurprises = 0;
				int possibleResult  = 0;
				if(p == 0){
					possibleResult = scoreArray.length;
				}else{
					int minAcceptableValue = (p * 3) - 2;
					int minSurprisedAcceptableValue = minAcceptableValue -2;

					for(int k=scoreArray.length-1;k>=0;k--){
						int temp = scoreArray[k];
						if(temp >= minAcceptableValue){
							possibleResult++;
							continue;
						}else if(temp < minAcceptableValue && temp >= minSurprisedAcceptableValue){
							if(usedSurprises < s){
								if(minSurprisedAcceptableValue > 0){
									possibleResult++;
									usedSurprises++;
								}
							}else{
								//out of surprises
							}
						}else{
							//not possible to get a score here
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+possibleResult);
				//System.out.println("Total Possbile Triplets : "+possibleResult);

			}   			
		}	
		catch (IOException ioe){
			System.out.println("An unexpected error occured.");
		}
	}



}
