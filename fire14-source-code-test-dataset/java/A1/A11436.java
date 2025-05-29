import java.io.*;
import java.util.Scanner;


public class dance {


	private static int T,S,p,N,current,upper,lower, count;


	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("B-small-attempt0.out")); 
		T = sc.nextInt();

		for(int i=1;i<=T;i++){

			N = sc.nextInt();
			S = sc.nextInt();
			p = sc.nextInt();

			count = 0;
			
			for(int j=1;j<=N;j++){

				current = sc.nextInt();
				if (p<2){
					if(current>=p)
						count++;
				} else {

					upper = 3*p - 2;
					lower = upper -2;
					
					if(current>=upper)
						count++;
					else if((S>0)&&(current>=lower))
					{
						count++;
						S--;
					}}}
		
			out.println("Case #"+i+": "+count);
		}
		
		out.close();

}
}
