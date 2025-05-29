import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class googler {

	/**
	 * @param args
	 */
	static Scanner kb ;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
PrintWriter out = new PrintWriter("answergoogler.txt");
		 kb = new Scanner(System.in);
		int testcase = kb.nextInt();
		for(int i=0;i<testcase;i++){
			out.println("Case #"+(i+1)+": "+solve());
			//solve();
		}
		out.close();
	}
	private static int solve() {
		// TODO Auto-generated method stub
		String question ="";
		int answer = 0;
		int numberofpeople = kb.nextInt();
		question+=numberofpeople+" ";
		int surprise = kb.nextInt();
		int minimum = kb.nextInt();
		question+=surprise+" "+minimum+" ";
		int[] peoplearray = new int[numberofpeople];
	for(int i=0;i<numberofpeople;i++){
		peoplearray[i]= kb.nextInt();
		question+=peoplearray[i]+" ";
	}
	for(int i=0; i<numberofpeople;i++){
		int total = peoplearray[i];
		if(total==0){
			if(minimum==total){
				answer++;
			}
			continue;
		}
		int divided = total/3;
		int left = total%3;
		if(divided>=minimum){
			answer++;
			continue;
		}else if(left==0&&Math.abs(divided-minimum)==1&&surprise!=0){
			answer++;
			surprise--;
			continue;
		}else if(divided+left>=minimum){
			int first = minimum;
			
			left = left- (first-divided);
			int divided2 = (total-first)/2;
			if(first-divided==2){
				if(surprise>0){
					answer++;
					surprise--;
					
				}
			}else{
				
				answer++;
			}
			
		}
		
	}
	System.out.println(question+" and answer is "+ answer);
	return answer;
	//
	}

}
