import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String argc[]){
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int t,n,s,p;
		t=sc.nextInt();
		for(int ca=1;ca<=t;ca++){
			n=sc.nextInt();
			s=sc.nextInt();
			p=sc.nextInt();
			int ti;
			int count=0;
			for(int i=0;i<n;i++){
				ti=sc.nextInt();
				if(p<=10){
					int a=ti/3;
					if(ti%3==0){
						if(a>=p)count++;
						else if(s>0&&a+1==p&&a-1>=0){
							s--;
							count++;
						}
					}
					else if(ti%3==1){
						if(a+1>=p)count++;
					}
					else {
						if(a+1>=p)count++;
						else if(a+2==p&&s>0){
							s--;
							count++;
						}
					}

				}
			}
			System.out.println("Case #"+ca+": "+count);
		}

	}
}
