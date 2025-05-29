import java.util.HashMap;
import java.util.Scanner;


public class C1 {

	public static void main(String arg[]){
		
		Scanner in=new Scanner(System.in);
		
		
		int T= in.nextInt();
		
		for(int i=1;i<=T;i++){
			int A = in.nextInt();
			int B = in.nextInt();
			int count =0;
			//System.out.println(A);

			//System.out.println(B);
HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();

			int no=0;
			int temp=A;
			//int temp=0;
			while(temp>0){
				if((temp=temp/10)>0)
					no++;
			}
			//System.out.println(no);

			for(int n = A;n<=B;n++){
		     int a=1;
			while(a<=no){
				int m=(int) ((n/Math.pow(10,a)) + (n%Math.pow(10,a))*Math.pow(10,(no-a+1)));
				a++;
				if((m<=B)&&(m>n)){
					if(!(map.containsKey(n)&&(map.get(n)==m))){
					//System.out.println(n+" "+m);
				count++;
				map.put(n,m);
					}
					//else
						//System.out.println(n+" "+m);
			}
			}
		}
			System.out.println("Case #"+i+": "+count);
	
		}
}
}