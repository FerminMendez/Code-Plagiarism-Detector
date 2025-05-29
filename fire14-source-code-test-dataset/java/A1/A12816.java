import java.io.*;
import java.util.*;

public class dancing {
	public static void main(String[] args)throws Exception{
		Scanner f = new Scanner(new File(args[0]));
		int count=0;//# tuples >= limit
		int res=0;	//mult result
		int rem=0;	//remainder
		int N=0;	//# tuples
		int S=0;	//# surprising tuples (t%r==2)
		int s=0;	//current count of surprising tuples
		int l=0;	//the limit
		int minT=0,maxT=10;	//minmum & maximum T values;
		ArrayList<Integer> al=new ArrayList<Integer>();	//list of tuples
		int C=0;	//# cases
		
		C = f.nextInt(); //get # of test cases
		for (int c=1;c<=C;c++){ //for each test case
			N=f.nextInt();S=f.nextInt();l=f.nextInt();//get params
			count=0;	//reset # good tuples count
			s=0;		//reset surprising tuple count
			al.clear();	//reset t list
			for(int i=1;i<=N;i++)al.add(f.nextInt());//build t list
			Collections.sort(al);	//sort lowest to highest
			Collections.reverse(al);//sort highest to lowest
			/*for (Integer x: al)System.out.print(x + " ");*/
			for (Integer t:al) {
				res=t/3; rem=t%3;
				if (res >= l)
					count++;
				else if (res == l-1)
					if (rem != 0)
						count++;
					else {// rem==0
						if (s<S && res>minT) {
							count++;
							s++;
						}
					}
				else if (res == l-2)
					if (rem == 2) {
						if (s < S) {
							count++;
							s++;
						}
					}
			}
			
			System.out.println("Case #"+c+": "+count);//display result
		}
	}
}