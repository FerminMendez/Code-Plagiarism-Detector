import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Googlers {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new FileReader(new File("B-small-attempt1.in")));
		
		PrintWriter out = new PrintWriter(new File("B-small-attempt1.out"));
		
		int t = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			
			int r = 0;
			
			System.out.println("s="+s+", p="+p);
			
			for(int k=0; k<n; k++) {
				int c = in.nextInt();
				
				int v1 = (int)Math.round(c / 3.0);
				int v2 = v1;
				int v3 = c - v1 - v2;
			
				System.out.print(v1+"+"+v2+"+"+ v3 + " = " + c + "\t");
				if (v1>=p || v3>=p) { 
					System.out.println(" >=p");
					r++;
				}
				else {
					if (s>0) {
						if (v1+1>=p && v1-1>=0) {
							System.out.println(" special");
							
							r++;
							s--;
						} else {
							System.out.println(" can't make special");
						}
					} else {
						System.out.println(" no more spec");	
					}
				} 
			}

			System.out.println("------------");
			System.out.println("r=" + r);
			System.out.println("============");

			
			in.nextLine();
			
			out.println("Case #" + (i+1)+ ": " + r);
		}
		out.close();
	}
}
