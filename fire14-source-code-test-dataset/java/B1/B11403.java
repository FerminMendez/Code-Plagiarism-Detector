import java.util.*;
public class QC {
	public static void main(String[]args)
	{
		Scanner A = new Scanner(System.in);
		int tc = A.nextInt();
		int tc1 = tc ;
		while(tc>0)
		{
			tc--;
			int res = 0 ;
			int f = A.nextInt();
			int s = A.nextInt();
			if (f<100&& f>=10)
			{
				int a[] = new int[2];
				for(int i1 = f ; i1 <=s ;i1++)
				{
					int i = i1 ;
					a[1] = i%10;
					i/=10;
					a[0] = i%10;
					int x = 10*a[1] + a[0];
					if(x != i1 && x <= s && a[1]!=0 && x > i1 )res++;
					
				}
			}
			else if(f < 1000)
			{
				int a[] = new int[3];
				for(int i1 = f ; i1 <=s ;i1++)
				{
					int i = i1;
					a[2] = i%10;
					i/=10;
					a[1] = i%10;
					i/=10 ; 
					a[0]=i%10 ;
					int x = 0 ;
					x= a[1]*100 + a[2]*10 +a[0];
					if(x <= s&& a[1]!=0&&x!=i&& x > i1) res++;
					
					x= a[2]*100 + a[0]*10 +a[1];
					if(x <= s&& a[2]!=0&&x!=i&& x > i1) res++;
				}
			}
			
			System.out.println("Case #"+(-tc+tc1)+": "+ res);
		}
	}
}
/*
50
149 921
174 911
815 985
10 99
163 981
10 10
110 989
1 2
123 991
135 986
116 971
107 931
187 951
142 954
163 935
188 991
154 950
186 916
173 936
122 936
158 993
6 9
154 991
182 943
112 950
18 66
120 933
105 925
149 943
463 814
190 980
118 973
551 551
182 981
143 919
125 936
125 993
110 950
139 990
59 77
163 978
103 954
10 99
6 6
135 964
187 983
214 879
133 953
189 968
177 948

*/