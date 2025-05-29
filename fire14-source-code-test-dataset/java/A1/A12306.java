import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class Googlers {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] minScoreWithSurprise = new int[11];
		int[] minScoreWithoutSurprise = new int[11];
		
		minScoreWithoutSurprise[0] = 0;
		minScoreWithSurprise[0] = 0;
		minScoreWithoutSurprise[1] = 1;
		minScoreWithSurprise[1] = 1;
		
		for(int i=2; i<minScoreWithoutSurprise.length; i++){
			int score = i * 3;
			minScoreWithoutSurprise[i] = score - 2 ; 
			minScoreWithSurprise[i] = score - 4 ;
			
		}
		
		Scanner sc = new Scanner(new File("B-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Output.txt")));
		StringBuilder sb = new StringBuilder(50);
		
		int numOfTestcase = sc.nextInt();
		int ans,p,googlers,minSWithoutS,minSwithS,numOfsurprisingTriplets,current;
		for(int i=0;i<numOfTestcase;i++){
			sb.setLength(0);
			googlers = sc.nextInt();
			numOfsurprisingTriplets = sc.nextInt();
			p = sc.nextInt();
			ans = 0;
			minSWithoutS = minScoreWithoutSurprise[p];
			minSwithS = minScoreWithSurprise[p];
			for(int j=0;j<googlers;j++){
				current = sc.nextInt();
				if(current >= minSWithoutS){
					ans++;
				}
				else if(numOfsurprisingTriplets > 0 && current>=minSwithS){
					ans++;numOfsurprisingTriplets--;
				}	
			}
			sb.append("Case #").append(i+1).append(": ").append(ans);
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.close();

	}

}
