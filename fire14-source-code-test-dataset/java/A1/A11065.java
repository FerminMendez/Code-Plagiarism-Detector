import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class b {	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader bd= new BufferedReader(new InputStreamReader(System.in));
		int li= Integer.parseInt(bd.readLine());
		for (int i = 1; i <=li; i++) {
			String[] cadena=bd.readLine().split(" ");
			int n=Integer.parseInt(cadena[0]);
			int s=Integer.parseInt(cadena[1]);
			int p=Integer.parseInt(cadena[2]);
			int ps=p-s;
			int pss=p+s;
			
			int min=p+(2*(p-1));			
			int max=p+(2*(p+1));
			int mins=(p+(2*(p-2))<0)?1:(p+(2*(p-2)));
			int maxs=p+(2*(p+2));
			//System.out.println(min+" "+max+" "+mins+" "+maxs );
			int[] c = new int[n];
			int res=0;
			for (int j = 0; j < n; j++) {
				c[j]=Integer.parseInt(cadena[3+j]);
				if(c[j]>=min){
					res++;
					//System.out.println(c[j]);
				}
				else if((c[j]>=mins)&&s>0){
					res++;
					s--;
					//System.out.println(c[j]);
				}
				
			}		
			System.out.println("Case #"+i+": "+res);					
		}		
	}
	static boolean saleConP(int t,int p){
		
		
		return false;
	}
	static boolean saleConPS(int t,int p){
		
		
		return false;
	}
}
 