import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class RecycledNumbers {
	
	static int[] p10 = {1,10,100,1000,10000,100000,1000000,10000000};
	
	public static int perm(int x, int n, int l){
		int y = x/p10[n];
		int z = x-y*p10[n];
		
		return z*p10[l-n] + y;
	}
	
	public static int longueur(int a){
		int i = 1;
		while(a / p10[i] != 0)
			i++;
		return i;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File( "C-small-attempt0.in" );
		FileWriter out=new FileWriter("output.txt");

		Scanner in = new Scanner(new FileReader(f));

		if(f.exists()){
			int T;
			int A, B;
			int r;
			int l;
			int y;
			Set<Integer> s = new LinkedHashSet<Integer>();
			
			T = in.nextInt();
			for(int i = 1; i <= T ; i++){
				A = in.nextInt();
				B = in.nextInt();
				l = longueur(A);
				r = 0;
				
				for(int x = A; x < B; x++){
					s.clear();
					for(int n = 1; n < l ; n++){
						y = perm(x, n, l);
						if(y > x && y <= B && !s.contains(y)){
							r++;
							s.add(y);
						}
					}
				}
				
				out.write("Case #" + i + ": " + r + "\n");
			}
	
		}

		in.close();
		out.close();

		
	}
	
	
}
