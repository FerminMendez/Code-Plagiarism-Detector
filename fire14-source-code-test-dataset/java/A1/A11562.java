import java.io.*;
import java.util.*;

public class Launcher {
	static int t, n, s, p, tcount, ncount, scount, pcount;
	static int a, b, num, ans;
	
	
	public static void main(String[] args){
		String c;
		int i,j;
		
		
		try {
			FileInputStream fin = new FileInputStream ("input.txt");
			System.out.println("Input file stream created");
			Scanner sc = new Scanner(fin);
			System.out.println("Scanner created");
			
			FileOutputStream fout = new FileOutputStream ("output.txt");
			DataOutputStream dout = new DataOutputStream (fout);
			
			t=sc.nextInt();
			tcount=0;
			
			
			while (tcount<t){
				tcount++;
				n=sc.nextInt();
				s=sc.nextInt();
				p=sc.nextInt();
				ncount=0;
				
				a=(p-1)*3;
				if (tcount==3){
					System.out.println ("a = " +a);
				
				}
				b=a-2;
				ans=0;
				scount=0;
				while (ncount < n){
					ncount++;
					num=sc.nextInt();
					if (p==0){
						ans = n;
					}
					else{
						if (p==1){
							if (num>0){
								ans++;
							}
						}
						else{
																			
							if (num>a) {
								ans++;
							}else {
									if (num>b && scount<s) {
										scount++;
										ans++;
									}
							}
						}
					}
				} //while ncount
					
				//Write output file
				dout.writeBytes("Case #");
				dout.writeBytes(Integer.toString(tcount));
				dout.writeBytes(": ");
				dout.writeBytes(Long.toString(ans));
				fout.write(13);
				fout.write(10);
			
			} //while tcount
		
			

		} catch (Exception e){
			System.out.println(e);
		}
	}//main
} //class