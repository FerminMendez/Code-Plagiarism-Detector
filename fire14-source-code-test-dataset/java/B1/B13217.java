import java.util.*;
public class codejam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int i;
		int j;
		int k;
		int x;
		int y;
		int l;
		int z;
		for(i=1;i<=m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int count=0;
			
			for(j=a;j<=b;j++) {
				x=j;
				l=Integer.toString(j).length();
				int[] used=new int[l];
				for(k=1;k<=l-1;k++) {
					// shift k digits
					
					y=(int)Math.pow(10, k)*(x%(int)Math.pow(10, l-k))+x/(int)Math.pow(10,l-k);
					y=y+2-2;
					if(x<y && y<=b) {
					
						boolean neu=true;
						for(z=0;z<l;z++) {
							if(used[z]==y) {
								neu=false;
								break;
							}
						}
					
						if(neu) {
							count++;
							used[k]=y;
//							System.out.println(x+" "+y);
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+count);
		}
	}

}
