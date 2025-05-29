import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DancingWiththeGooglers {
	public static void main(String[] args){
		Scanner in;
		try {
			in = new Scanner(new File("B-small-attempt1.in"));
			solve(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void solve(Scanner in){
		int caseNum = in.nextInt();
		for(int i =1; i<=caseNum; i++){
			int googlers = in.nextInt();
			int surpising = in.nextInt();
			int p =  in.nextInt();
			int ans =0;
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for(int j =0; j<googlers; j++){
				int score =in.nextInt();
				scores.add(score);
				if(score>=p*3-2){
					ans++;
				}
				else{
					int two = p*3-4;
					if(score<4){
						two+=(4-score);
					}
					if(score>=two){
						
						if(surpising>0){
							ans++;
							surpising--;
						}
					}
				}
				
			}
			System.out.println("Case #" +i+": "+ans);
			
		}
	}
}
