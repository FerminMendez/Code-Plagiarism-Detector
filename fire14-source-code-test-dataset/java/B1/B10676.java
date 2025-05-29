import java.io.*;
import java.util.*;
import static java.lang.Integer.*;


public class RecycledNumbers {
	

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(
				System.in));
		int n = parseInt(scan.readLine());
		for (int i = 0; i < n; i++) {
			String[] line = scan.readLine().split(" ");
			int inf = parseInt(line[0]);
			int sup = parseInt(line[1]);
			int res = 0;
			for(int j = inf;j<=sup;j++){
				for (int j2 = j+1; j2 <= sup; j2++) {
					res+=check(j,j2);
				}
			}
			System.out.println("Case #"+(i+1)+": "+res);
		}
	}
	
	public static int check(int a,int b){
		int res = 0;
		int tama = count(a);
		int tamb = count(b);
		String sa = (a+"");
		String sb = (b+"");
		if(tama==tamb){
			for (int i = 0; i <tama; i++) {
				if(sa.charAt(i)==sb.charAt(0)){
					String aux = sa.substring(i,sb.length())+sa.substring(0,i);
					if(sb.equals(aux)){
						return 1;}
				}
			}
		}
		return res;
	}
	
	public static int count(int a){
		int res = 0;
		while(a!=0){
			a=a/10;
			res++;
		}
		return res;
	}
}
