import java.io.*;
import java.util.Scanner;
public class Main3 {
	public static void main(String args[]) throws FileNotFoundException
	{
		//String test = "123400";
		//System.out.println(test.substring(2,4));
		Scanner in = new Scanner(new FileReader("input.in"));
		PrintWriter out = new PrintWriter("output.txt");
		int T = 0;
		String S1 = in.nextLine();
		T = Integer.parseInt(S1);
		for(int i=0;i<T;i++)
		{
			int answer = 0;
			S1 = in.nextLine();
			out.print("Case #"+ (i+1) +": ");
			int space = S1.indexOf(" ");
			String a1 = S1.substring(0, space);
			String a2 = S1.substring(space+1, S1.length());
			int A = Integer.parseInt(a1);
			int B = Integer.parseInt(a2);
//			System.out.println(A);
//			System.out.println(B);
			for(int n=A;n<=B;n++)
			{
				String str = String.valueOf(n);
//				System.out.println(str);
				int a[] = {0,0,0,0,0,0,0,0};
				for(int j=0;j<str.length()-1;j++)
				{
					
					if(str.charAt(j+1)!='0')
					{
						//System.out.println("chutiya");
						String str1 = str.substring(j+1).concat(str.substring(0, j+1));
						int m = Integer.parseInt(str1);
						a[j] = m;
//						System.out.println(j+ " " + m + " " + n);
						if (m>n && m<=B)
						{
							int repeat = 0;
							for(int k= 0;k<j;k++)
							{
								if(m == a[k])
									repeat = 1;
							}
							if(repeat == 0)
								answer++;
						}
//						System.out.println("answer = " +answer);
					}
				}
				
			}
			out.print(answer);
			out.println("");
		}
		out.close();
	}

}
