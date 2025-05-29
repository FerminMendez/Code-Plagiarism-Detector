import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner S = new Scanner(new File("B-small-attempt2.in"));

		//Scanner S = new Scanner(System.in);

		int t = S.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = S.nextInt();
			int surprise  = S.nextInt();
			int p = S.nextInt();
			int cases =0;

			for (int j = 0; j < n; j++) {
				int score = S.nextInt();
				int base = (int)score /3;
				
	            if(base*3 == score&& base>=p)
	                cases++;
	            else if(base*3 == score &&  surprise!=0 && base+1>=p && score > p){
	                cases++;
	                surprise--;
	            }
	            else if(score - (base*3) == 1 && base+1 >=p)
	                cases++;
	            else if((score - (base*3) == 2) && (base>=p || base+1>=p)){
	                cases++;
	            }else if((score - (base*3) == 2) && base+2 >=p && surprise!=0){
	                 cases++;
	                 surprise--;
	            }
			


			}

			System.out.println("Case #"+i+": "+cases);

		}

	}

}
