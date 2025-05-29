import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class P2 {
	static Scanner sc;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		try {
			sc = new Scanner(new FileInputStream("B.in"));
			System.setOut(new PrintStream(new FileOutputStream("B.out.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		new P2().run();
		
		System.out.flush();
	}
	
	
	public void run(){
		int T = sc.nextInt();
		
		for(int t=1; t<=T;t++){
			
			int R = 0;
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			
			
			for(int n = 0; n < N ; n++){
				int i = sc.nextInt();
				int r =  i - p*2;
				if(r>=0)
					if(r>=p-2){
						R++;
					}else if(r>=p-4 && S>0){
						S--;
						R++;
					}
			}
			
			System.out.printf("Case #%d: %d%n", t, R);
			
		}

	}

}
