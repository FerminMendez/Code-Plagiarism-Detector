import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
//		Scanner s = null;
//		try {
//			s = new Scanner(new FileInputStream("s.in"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		int lines = s.nextInt();
		for (int i = 1 ; i <= lines ;i++){
			int[] stat = new int[3];
			
			int N = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();
			int[] b = new int[]{
				3*p-4,3*p-2,3*p+2,3*p+4
			};
			
			for (int j = 0;j < N;j++){
				int a = s.nextInt();
				if (p == 0){
					stat[1] ++;
				}else if ( p == 1){
					if (a > 0){
						stat[1] ++;
					}
				}else if ( p== 10){
					if (a >=28){
						stat[1]++;
					}else if (a== 27 &&a == 26){
						stat[2]++;
					}
				}else{
					if (a >=b[1]){
						stat[1]++;
					}else if (a >=b[0]){
						stat[0]++;
					}
				}
			}
			int r = stat[1] + Math.min(S, stat[0]+stat[2]);
			System.out.printf("Case #%d: %d\n",i,r);
		}
	}

}
