import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class E2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = null;
		
		//sc = new Scanner(System.in);
		
		try {
			sc = new Scanner(new File("E2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int fases = sc.nextInt();
		
		
		for(int j=1; j<=fases; ++j){
			
			int N = sc.nextInt(); // players
			int S = sc.nextInt(); // surprising
			int P = sc.nextInt();
			
			int casos = 0;
			
			for(int i=0; i<N; ++i){
				int ti = sc.nextInt();
				
				int t = ti % 3;
				int base = ti / 3;

				
				if(t == 0){
					
					if(base >= P){
						casos++;
					}
					else if(S > 0 && base > 0 && base + 1 >= P){
						casos++;
						S--;
					}
					
				}
				else if(t == 1){
					if(base + 1 >= P){
						casos++;
					}
					else if(S > 0 && base + 1 >= P){
						casos++;
						S--;
					}
				}
				else{
					if(base + 1 >= P){
						casos++;
					}
					else if(S > 0 && base + 2 >= P){
						casos++;
						S--;
					}
				}
			}
			
			System.out.println("Case #" + j + ": " + casos);
		}
	}

}
