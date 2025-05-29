import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DancingWithGooglers {

	public int max(int s, int q, int[] score){
		int pass = 0, fail = 0, pos = 0;
		for(int sc : score){
			if(sc == 0){
				if(q == 0)
					pass++;
				else fail++;
			}
			else if(sc == 1){
				if(q <= 1)
					pass++;
				else fail++;	
			}
			else if( (sc + 2) / 3 >= q)
				pass++;
			else if( (sc +1) / 3 +1 < q)
				fail++;
			else 
				pos++;
		}
		
		return pass + Math.min(pos, s);
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		DancingWithGooglers d = new DancingWithGooglers();
//		int[] c1 = {15,13,11};
//		System.out.println(d.max(1,5,c1));
//		
//		int[] c2 = {23,22,21};
//		System.out.println(d.max(0,8,c2));
//		
//		int[] c3 = {8, 0};
//		System.out.println(d.max(1,1,c3));
//		
//		int[] c4 = {29,20, 8, 18, 18, 21};
//		System.out.println(d.max(2,8,c4));
		
		File f = new File(args[0]);
		Scanner sc = new Scanner(f);
		int l = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= l ;i++){
			String[] line = sc.nextLine().split(" ");
			int[] c = new int[Integer.parseInt(line[0])];
			int s = Integer.parseInt(line[1]);
			int q = Integer.parseInt(line[2]);
			for(int j = 0; j < c.length; j++)
				c[j] = Integer.parseInt(line[j+3]);
			System.out.printf("Case #%d: %s\n", i, d.max(s, q, c));
		}
	}

}
