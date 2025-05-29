import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Solver2 {
	public static void main(String[] args) {
		new Solver2();
	
	}
	private Scanner in;
	public Solver2(){
		try {
			in = new Scanner(new File("../Text/C-small-attempt0.in"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		solve();

		in.close();

	}
	public void solve() {
		int cases = in.nextInt();
		ArrayList<Integer> solutions=new ArrayList<Integer>();
		for (int i = 1; i <= cases; i++) {
			int lower=in.nextInt();
			int upper=in.nextInt();
			int amount=0;
			for(int k= lower;k<=upper;k++){//k van lower tot upper
				if(k>=10){
					String iString=String.valueOf(k);
					ArrayList<Integer> allreadyPaired=new ArrayList<Integer>();
					for (int l = 1; l < iString.length(); l++) {
						String shifted=move(l,iString);	
						int reverseInt=Integer.parseInt(shifted);
						if(reverseInt<=upper&&reverseInt>lower&&reverseInt>k){
							if(!allreadyPaired.contains(reverseInt))
								amount++;
							solutions.add(k);
						}
						allreadyPaired.add(reverseInt);
					}
				}
			}
			System.out.println("Case #"+i+": "+amount);
			solutions.clear();
		}
	}

	private String move(int i,String iString) {
		String result="";
		for (int j = 0; j < i; j++) {
			String letter=String.valueOf(iString.charAt(iString.length()-i+j));
			result+=letter;
		} 
		for (int j = 0; j < iString.length()-i; j++) {
			String letter=String.valueOf(iString.charAt(j));
			result+=letter;
		}
		return result;
			
		
		
	}
}
