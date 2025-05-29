public class DancingWiththeGooglers {
	
	public static void main(String[] args) {
		//initialize();
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<testCases;i++){
			int s,p,n,upperBound,lowerBound;
			
			//int[][] triplet;
			int[] sum;
			//boolean[] processed;
			int count = 0;
			
			n = sc.nextInt();
			s = sc.nextInt();
			p = sc.nextInt();
			
			upperBound = 3*p;
			lowerBound = 3*p-5;
			if(lowerBound < 0)
				lowerBound = 0;
			sum = new int[n];
			//processed = new boolean[n];
			//triplet = new int[n][3];
			
			for(int i1=0;i1<n;i1++){
				sum[i1] = sc.nextInt();
				if(sum[i1] >= upperBound-2){ 
					count++;
					//processed[i1] = true;
				}
				else if(sum[i1] > lowerBound){
					//processed[i1] = true;
					if(s > 0){
						s--;
						count++;
					}		
				}
			}
			
			StringBuffer sb = new StringBuffer("Case #");
			sb.append(i+1);
			sb.append(": ");
			
			sb.append(count);
			System.out.println(sb);
		}
	}
	
}