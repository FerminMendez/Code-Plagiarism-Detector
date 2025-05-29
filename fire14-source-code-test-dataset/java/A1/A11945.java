import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class MaxGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new BufferedInputStream(new FileInputStream(".\\input\\B-small-attempt0.in")));
		System.setOut(new PrintStream(new File(".\\output\\B-small-attempt0.out")));
		Scanner in = new Scanner(System.in);
		int caseNum=in.nextInt();
		for(int i=0;i<caseNum;i++){
			int googlers=in.nextInt();
			int surprise=in.nextInt();
			int p=in.nextInt();
			int[] scores=new int[googlers];
			int maxNum=0;
			for(int j=0;j<googlers;j++){
				scores[j]=in.nextInt();
			}
			for(int j=0;j<googlers;j++){
				if(scores[j]>=p*3-2){
					maxNum++;
				}
				else if(scores[j]!=0 && scores[j]>=p*3-4){
					if(surprise!=0){
						surprise--;
						maxNum++;
					}
				}
				else if(scores[j]==0 && p==0){
					maxNum++;
				}
			}
			System.out.println("Case #"+(i+1)+": " +maxNum);
		}
	}

}
