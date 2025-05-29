import java.util.Scanner;


public class GoogleNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int p = scan.nextInt();
		
		int n, m;
		for(int i = 1; i <= p; i++) {
			int total = 0;
			n = scan.nextInt();
			m = scan.nextInt();
			for( ; n < m; n++) {
				for(int j=n+1; j <= m; j++) {
					
					if(recycled(n+"",j+""))
						total++;
					
				}
			}
			System.out.println("Case #"+i+": "+total);
		}
		
		
	}
	public static boolean recycled(String n, String m) {
		char[] cN = n.toCharArray();
		char[] cM = m.toCharArray();
		
		int tot1 = 0;
		int tot2 = 0;
		for(int i = 0; i < cN.length; i++) {
			tot1+= cN[i];
			tot2+= cM[i];
		}
		if(tot1!=tot2)
			return false;
		
		
		for(int j=0; j < cN.length; j++) {
			boolean found = true;
			for(int k=0; k < cN.length; k++) {
				if(cN[k] != cM[(k+j)%cN.length]) {
					found = false;
					break;
				}
			}
			if(found)
				return true;
		}
		
		return false;
		
	}
}
