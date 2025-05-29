package practice;
import java.util.*;

public class Recycled {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i = 0; i<cases;i++){
			int caseCounter = i+1;
			int firstNum = sc.nextInt();
			int secondNum = sc.nextInt();
			int result=0;
			List<Integer> resultList = new ArrayList<Integer>();
			for(int j = firstNum;j<=secondNum;j++){
				String first = Integer.toString(j);
				for(int k = 0; k<first.length()-1; k++){
					String modified = first.substring(first.length()-k-1)+first.substring(0, first.length()-k-1);
					int newNumber = Integer.parseInt(modified);
					if(newNumber<=secondNum && newNumber>j && newNumber>=firstNum){
						result++;
					}
				}
			}
			System.out.println("Case #"+caseCounter+": "+result);
		}
	}
}
