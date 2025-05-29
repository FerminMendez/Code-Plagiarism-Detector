import java.io.*;
import java.util.StringTokenizer;

public class CodeJam1 {
	
	static BufferedReader br;
	static PrintWriter pw;
	
	static int a,b,count;
	
	public static void main(String[] args)throws Exception{
		br=new BufferedReader (new FileReader ("in.txt"));
		pw=new PrintWriter (new FileWriter("out.txt"));
		
		int n=Integer.parseInt( br.readLine() );
		for (int i=1;i<=n;i++){
			input();
			work();
			
			pw.printf("Case #%d: %d%n",i,count);
		}
		
		pw.close();
	}
	
	public static void input()throws Exception{
		StringTokenizer data=new StringTokenizer(br.readLine());
		
		a=Integer.parseInt( data.nextToken() );
		b=Integer.parseInt( data.nextToken() );
		count=0;
	}
	
	public static void work(){
		for (int i=a;i<=b;i++){
			StringBuffer sbuf=new StringBuffer(String.valueOf(i));
			
			int create;
			do{
				sbuf.append(sbuf.charAt(0));
				sbuf.deleteCharAt(0);
				create=Integer.parseInt( sbuf.toString() );
				
				if (create>i & create<=b)
					count++;
				
			}while(create!=i);
		}
	}
}