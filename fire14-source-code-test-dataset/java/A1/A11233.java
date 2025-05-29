import java.io.*;
import java.util.StringTokenizer;

public class CodeJam3 {
	
	static BufferedReader br;
	static PrintWriter pw;
	
	static int n,surp,p,total[],count;
	static Triplet scores[];
	
	public static void main(String[] args)throws Exception{
		br=new BufferedReader (new FileReader ("in.txt"));
		pw=new PrintWriter (new FileWriter("out.txt"));
		
		int t=Integer.parseInt( br.readLine() );
		for (int i=1;i<=t;i++){
			input();
			work(0,surp);
			
			pw.printf("Case #%d: %d%n",i,count);
		}
		
		pw.close();
	}
	
	public static void input()throws Exception{
		StringTokenizer data=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt( data.nextToken() );
		surp=Integer.parseInt( data.nextToken() );
		p=Integer.parseInt( data.nextToken() );
		
		total=new int[n];
		scores=new Triplet[n];
		for (int i=0;i<n;i++){
			total[i]=Integer.parseInt( data.nextToken() );
		}
		count=0;
	}
	
	public static void work(int iter,int surpLeft){
		if (surpLeft<0)
			return;
		if (iter>=n){
			if (surpLeft!=0)
				return;
			
			int c=0;
			for (Triplet t:scores){
				if (t.hasBest(p)) c++;
			}
			if (c>count)	count=c;
			return;
		}
		
		if (total[iter]==0 || total[iter]==1 || total[iter]==30 || total[iter]==29){
			scores[iter]=new Triplet( total[iter] , false);
			work(iter+1,surpLeft);
		} else {
			scores[iter]=new Triplet( total[iter] , false);
			work(iter+1,surpLeft);
			
			scores[iter]=new Triplet( total[iter] , true);
			work(iter+1,surpLeft-1);
		}
	}
		
	private static class Triplet {
		int a,b,c;
		
		public Triplet(int total,boolean surp){
			int rem=total%3;
			int x=total/3;
			switch(rem){
				case 0:
					if (surp){
						a=x-1; b=x; c=x+1;
					} else {
						a=b=c=x;
					} break;
				case 1:
					if (surp){
						a=x-1; b=x+1; c=x+1;
					} else {
						a=b=x; c=x+1;
					} break;
				case 2:
					if (surp){
						a=b=x; c=x+2;
					} else {
						a=x; b=c=x+1;
					} break;
			}
			
		}
		
		public boolean hasBest(int p){
			if (c>=p)
				return true;
			if (b>=p)
				return true;
			if (a>=p)
				return true;
			return false;
		}
	}
}