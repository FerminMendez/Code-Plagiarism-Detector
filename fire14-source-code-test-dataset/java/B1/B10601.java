import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader dat=new BufferedReader(new FileReader("input"));
		int BRCASE=Integer.parseInt(dat.readLine());
		for(int ic=1;ic<=BRCASE;ic++){
			String str[]= dat.readLine().split(" ");
			System.out.println("Case #"+ic+": "+test(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
		}
	}
	public static int test(int n, int m){
		boolean [] pominati= new boolean[m-n+10];
		int rez=0;
		for(int i=n;i<=m;i++){
			int ttl=0;
			int tmp=i;
			if(!pominati[tmp-n]){
				do{
					if(tmp>=n && tmp<=m){
						if(!pominati[tmp-n]){
							pominati[tmp-n]=true;
							ttl++;
						}
					}
					tmp=rotate(tmp);
				}while(tmp!=i);
			}
			rez+=(ttl>=2)?comb(ttl,2):0;
		}
		return rez;
		
	}
	public static int rotate(int x){
		int pow = (int)Math.log10(x);
		do{
			if(x%10!=0){
				x = (int) ((int)x%10*Math.pow(10, pow)+(int)x/10);
				break;
			}else{
				x = (int) ((int)x%10*Math.pow(10, pow)+(int)x/10);
			}
		}while(true);
		return x;
	}
	
	public static int fact(int x){
		int ret=1;
		for(int i=1;i<=x;i++){
			ret*=i;
		}
		return ret;
	}
	public static long comb(int n, int k){
		if(k>(n-k))
		k=n-k;
		long c=1;
		for(int i=0; i<k; i++)
		{
			c=c*(n-i);
			c=c/(i+1);   
		}
		return c;
	}
}
