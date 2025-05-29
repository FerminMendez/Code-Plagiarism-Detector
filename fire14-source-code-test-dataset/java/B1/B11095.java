import java.util.*;
public class CodeJamC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A,B,tc;
		Scanner sc= new Scanner(System.in);
		tc=sc.nextInt();
		for(int TC=1; TC<=tc; TC++){
		A=sc.nextInt();
		B=sc.nextInt();
		int suma=0;
		Integer Ai= new Integer(A);
		String sA=Ai.toString();
		String rigth;
		String aux;
		Integer n;
		for(int i=A; i<=B; i++){
			
			Integer si= new Integer(i);
			String Ssi=si.toString();			
			for(int j=1; j<Ssi.length(); j++){				
				rigth=Ssi.substring(j);		
				aux= rigth + Ssi;				
				n=Integer.valueOf(aux.substring(0,Ssi.length()));				
				if (n<=B && n>=A && si<n){
					//System.out.println("( " + si + " , " + n + ")");
					suma++;
				}
			}				
		}
		System.out.println("Case #"+TC+": "+suma);
		}

	}

}
