import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Math.*;
public class ProC {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("A-small-practice.in");
		Scanner scr = new Scanner(file);
		int i= scr.nextInt();
		int count =0;
		for (int a =1; a<= i; a++) {
			int j =scr.nextInt();
			int k =scr.nextInt();
			for (int b=j; b<=k;b++){
				for (int c =1; c<log(b)/log(10)+1; c++) {
					int last = (int) ((int)b%(Math.pow(10, c)));
					int rest = (int) ((int)b/Math.pow(10, c));
					
					int temp = (int)(log(b)/log(10)+1-c); 
					int temp2 =(int)Math.pow(10, temp);
					int num =  last*temp2 +rest;
					if (num<=k&&num>b){
						count ++;
//						System.out.println(b+" "+num);
					}
					
					
				}
				
			}
			System.out.println("Case #" +a+": "+count);
			count=0;
		}
	}

}
