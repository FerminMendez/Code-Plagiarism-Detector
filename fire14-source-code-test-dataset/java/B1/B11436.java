import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


public class CodeJamC {
	
	
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int a;
		int b;
		int m;
		int n;
		String stra;
		String str;
		for(int i = 1; i <= t; i++){
			a = scn.nextInt();
			b = scn.nextInt();
			Set<String> set = new HashSet<String>();
			
			for(int j = a; j <= b; j++){
				
				stra = j+"";
				str = stra;
				for(int k = 1; k < stra.length();k++){
					str = str.charAt(str.length()-1) + str.substring(0,str.length()-1);
					n = Integer.parseInt(str);
					
					if(n <= a)
						continue;
					if(n<=j)
						continue;
					if(n>b)
						continue;
					
					if(j<n){
						set.add(j+""+n+"");
					}else{
						set.add(n+""+j+"");
					}
				}
			}
			
			System.out.println("Case #"+i+": "+set.size());
		}
	}
}
