import java.util.Scanner;


public class Googlers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		
		
		int b = Integer.parseInt(st);
		
		for(int a = 0; a< b; a++)
		{
			st = in.nextLine();
			String sp[] = st.split(" ");
			int n = Integer.parseInt(sp[0]);
			int s = Integer.parseInt(sp[1]);
			int p = Integer.parseInt(sp[2]);
			int g[] = new int[n];
			double gd[] = new double[n];
			int c = 0;
			for(int i = 0;i<n;i++)
			{
				g[i] =  Integer.parseInt(sp[i+3]);
				
				if(g[i] >= (p*3)-2)
					c++;
				else if((g[i] >= (p*3)-4) && s > 0 && g[i]!=0)
				{
					c++;
					s--;
				}
//				gd[i] = ((double)g[i])/3;
			}
			
//			java.util.Arrays.sort(gd);
////			java.util.Arrays.sort(g);
//			
//			for(int i = n-1;i>=0;i--)
//			{
//				if((gd[i] > p) || ((double)p - gd[i] < 1))
//				{
//					c++;
//				}
//				else if((s > 0) && (((double)p-gd[i]) <=1.333333333333334) && gd[i] != 0) 
//				{
//					c++;
//					s--;
//				}
//				else
//					break;
//			}
			
			System.out.println("Case #"+(a+1)+": " + c);
		}		
		
	}

}
