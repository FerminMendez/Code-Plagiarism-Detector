import java.io.*;
import java.util.StringTokenizer;


public class C {
	
	static boolean isrecycle (long n, long m){
		
		String a,b;
		char ac[],c;
		int k;
		boolean t=false;
		a=String.valueOf(n);
		b=String.valueOf(m);
		
		
		
		for(int j=1;j<b.length();j++){
			ac=a.toCharArray();
			c=ac[0];k=0;
			for(int i=0;i<ac.length-1;i++){
				ac[i]=ac[i+1];k++;
			}
			ac[k]=c;
			
			if(String.valueOf(ac).compareTo(b)==0) {t=true;break;}
			else a=String.valueOf(ac);
			
		}
		
		return t;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C.in"));
		PrintWriter out = new PrintWriter(new FileWriter("C.out"));
		String l;
		int p,count;
		long n,m;
		boolean esc=false;
		
	p=Integer.parseInt(in.readLine());
		
for(int j=1;j<=p;j++){
			
			l=in.readLine();
			StringTokenizer st = new StringTokenizer(l);
			n=Long.parseLong(st.nextToken());
			m=Long.parseLong(st.nextToken());
			count=0;
			
			for(long q=n;q<=m;q++)
				for(long r=q+1;r<=m;r++)
			{
				if(C.isrecycle(r, q)) count++;
			}
						
			if(esc==true) out.println();
			else esc=true;
			out.print("Case #"+j+": "+count);
			
			
}
in.close();
out.close();
		
	}

}
