import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author: Ahmad Medhat Othman
 * @codeJame: AMedOs
 * @topCoder: AMedOs
 * @email :amedhat.cs@gmail.com
 * */
public class B {
	
	
	public static void main(String[] args) throws Exception  {
		// Input file
		//A-small.in
		//A-large.in
		String in = "B-small-attempt2.in";
		
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		// Output file
		String out = "B.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
		
		int T=0;
		T = scn.nextInt();
		
		int t,i,k=0;
		int n,s,p,num,rem,res=0;
		for (t=1 ; t<= T ; t++) {
			res=0;
			n = scn.nextInt();
			s = scn.nextInt();
			p = scn.nextInt();
			for (i=0;i<n;i++){
				k = scn.nextInt();
				num = k/3;
				rem = k%3;
				if (num >=p){
					res++;
				} else{
					if (rem == 0){
						if (num+1 >= p && s>0 && num>0){
							res++;
							s--;
						}
					}
					if (rem == 1){
						if (num+1 >= p){
							res++;
						}
					}
					if (rem == 2){
						if (num+1 >=p){
							res++;
						} else if (num+2 >= p && s>0){
							res++;
							s--;
						}
					}
				}
			}
			ps.println("Case #" + t + ": " + res);
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
}
