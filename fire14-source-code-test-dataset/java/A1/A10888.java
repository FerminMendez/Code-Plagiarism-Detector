import java.util.*;
import java.io.*;

public class Dancing{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("d.in"));
		int a = Integer.parseInt(in.nextLine());
		for(int i = 1; i <= a; i++){
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int q = 0;
			for(int j = 0; j < n; j++){
				int c = in.nextInt();
				if(p*3-2 <= c){
					q++;
				}
				else if((s > 0) && (p*3-4 > 0) && p*3-4 <= c){
					q++;
					s--;
				}
			}
			in.nextLine();
			System.out.printf("Case #%d: %d\n",i,q);
		}
	}
}
