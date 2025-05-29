import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {
	public static void main(String[] args){
		Scanner in;
		try {
			in = new Scanner(new File("C-small-attempt0.in"));
			solve(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void solve(Scanner in){
		int cases =in.nextInt();
		for(int i = 1; i<=cases; i++){
			int min = in.nextInt();
			int max = in.nextInt();
			int ans = 0;
			for(int j =min; j<=max; j++){
				ans+=combos(j, min, max);
			}
			System.out.println("Case #" +i+": "+(ans/2));
			
		}
		
	}
	public static int combos(int num, int min, int max){
		if(num<10){
			return 0;
		}
		HashSet<Integer> diffNums = new HashSet<Integer>();
		diffNums.add(num);
		int ans = 0;
		String numString = num+"";
		for(int i =0; i< numString.length(); i++){
			numString = numString.substring(1)+numString.charAt(0);
			int numTest = Integer.parseInt(numString);
			if(numTest<=max&&numTest>=min&&diffNums.add(numTest)){
				ans++;
			}
		}
		return ans;
		
		
	}
	
}
