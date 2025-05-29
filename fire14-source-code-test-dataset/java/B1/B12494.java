import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class EasyNumbers { 
	public static void main(String[] args) throws Exception{
		PrintWriter out =new PrintWriter(new File("../easyNumbers/src/numberrr.out"));
		Scanner s =new Scanner(new File("../easyNumbers/src/number.in"));
		int ans,div,d,k,n1,n2,j,a,a1,b;
		int i,t;
		t = s.nextInt();
		for(int w = 1; w<=t; w++){
			a = s.nextInt();
			b = s.nextInt();
			ans=0;
			i=0;
			a1 = a;
			while(a1!=0){
				a1/=10;
				i++;
			}
			for(j=a;j<=b;j++){
				n2=j;
				for(k=0;k<i-1;k++){
					n1 = j;
					div = 1;
					while(n1 > 9){
						n1 = n1 / 10;
						div = div * 10;
					}
					d = n2 % 10;
					n2 = n2 / 10;
					n2 = n2 + d * div ;
					if(n2<=b && n2>=a && n2!=j && j<n2)
						ans++;                           
					if(n2==j)
						break;
				}
			}
		System.out.println("Case #"+ w +  ": " +ans);
		}
	}
}