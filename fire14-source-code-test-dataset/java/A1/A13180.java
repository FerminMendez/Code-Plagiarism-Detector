import java.util.*;
public class reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int i;
		int j;
		for(i=1;i<=m;i++) {
			int n=sc.nextInt();
			int s=sc.nextInt();
			int p=sc.nextInt();
			int count=0;
			for(j=0;j<n;j++) {
				int a=sc.nextInt();
				if(3*p-2<=a && p<=a) {
					count++;
				}
				else if(3*p-4<=a && p<=a && s>0) {
					s--;
					count++;
				}
			}
			System.out.println("Case #"+i+": "+count);
		}
	}

}
