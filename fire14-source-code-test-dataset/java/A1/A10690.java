import java.util.*;

class dance{
	public static void main(String args[]){
		int t,n,s,p;
		int i,j;
		int score[];
		double average[];
		int sum;

		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();

		for(i=0;i<t;i++){
			n = sc.nextInt();
			s = sc.nextInt();
			p = sc.nextInt();

			//System.out.println(s+" "+p);

			score = new int[n];
			average = new double[n];
			for(j=0;j<n;j++){
				score[j] = sc.nextInt();
				average[j] = (double)score[j]/3.0;
			}
			//System.out.println(Arrays.toString(score));
			//System.out.println(Arrays.toString(average));

			sum=0;
			for(j=0;j<n;j++){
				if(average[j] > p-1) sum++;
				else if(average[j]!=0 && average[j]-0.5 >p-2){
					if(s>0) sum++;
					s--;
				}
			}
		System.out.println("Case #" + (i+1) + ": " + sum);
		}
	}
}
