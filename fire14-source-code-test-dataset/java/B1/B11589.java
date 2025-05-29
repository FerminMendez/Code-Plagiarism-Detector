import java.util.Scanner;


public class RecycledNumbers {
	
	public static int countRecycledNumbers(int a,int b){
		int count=0;
		int t[][] = new int[(b-a)+1][(b-a)+1];
		for(int i=0; i<(b-a)+1; i++){
			for(int j=0; j<(b-a)+1; j++){
				t[i][j]=0;
			}
		}
		int max = String.valueOf(a).length();
		for(int j=a; j<=b; j++){
			int n = j;	
			for(int i=1; i<max; i++){
				int m = Integer.parseInt(String.valueOf(n).substring(max-i)+String.valueOf(n).substring(0,max-i));
				if(a<=n && n<m && m<=b){
					if(t[n-a][m-a]==0){
						t[n-a][m-a]=1;
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int count = countRecycledNumbers(A,B);
			System.out.println("Case #" + (i + 1) + ": "+count );
		}
	}
}
