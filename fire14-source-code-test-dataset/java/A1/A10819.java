import java.util.Scanner;


public class B {
	
	public static void main(String[] argv){
		Scanner in = new Scanner (System.in);
		int T=in.nextInt();
		
		for(int i=0; i<T; i++){
			int N=in.nextInt();int Surp=in.nextInt();int p=in.nextInt();
			int[] NS=new int[N];int[] S=new int[N];
			for(int k=0; k<N; k++){
				int t=in.nextInt();
				if(t==0){
					NS[k]=0; S[k]=0;
				}
				else if(t%3==0){
					NS[k]=t/3;  S[k]=t/3+1;
				}
				else if(t%3==1){
					NS[k]=(t-1)/3+1;  S[k]=NS[k];
				}
				else{
					NS[k]=(t-2)/3+1; S[k]=(t-2)/3+2;
				}
			}
			//prT(NS); prT(S);
			int Rep=0;
			int ind=0;
			
			while(Surp>0 & ind<N){
				if(S[ind]==p & NS[ind]==p-1){
					Rep++;
					S[ind]=-1;
					NS[ind]=-1;
					Surp--;
				}
				ind++;
			}
			
			ind =0;
			while(Surp>0 & ind<N){
				if(S[ind]>=p ){
					Rep++;
					NS[ind]=-1;
					Surp--;
				}
				ind++;
				
			}
			
			for(int k=0; k<N; k++){
				if(NS[k]>=p)
					Rep++;
			}
			
			
			System.out.println("Case #"+(i+1)+": "+Rep);
			//System.out.println();
		}
		
	}
	
	public static void prT(int[] t){
		System.out.println();
		for(int x:t)
			System.out.print(x+" ");
	}

}
