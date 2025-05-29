import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Problem3 {
	public static void main(String[] args) throws Exception {
		  BufferedReader br = new BufferedReader(new FileReader(new File("C-small-attempt0.in")));
		  PrintWriter pw = new PrintWriter(new File("C-small-attempt0.out"));
		  int a,b ,count, m, digitscount;
		  int t= new Integer(br.readLine());
		  for(int c=1; c<=t; c++)
		  {
		   pw.append("Case #"+c+": ");
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   a = new Integer(st.nextToken());
		   b= new Integer(st.nextToken());
		   
		   count=0; 
		   for (int n =a; n<b ; n++)
		   {
			   digitscount =1;
			   for(int i=n; i>0 ; i/=10)
				   digitscount*=10;
			   
			   HashSet<Integer> set = new HashSet<Integer>();
			   for(int i=10; i< n; i*=10)
			   {
				   m = n/i+ n%i*(digitscount)/i;
				   
				   //System.out.println(m);
				   if(m>n && m<=b && !set.contains(m))
				   {
					   set.add(m);
					   count++;
					  // System.out.println(n+" "+m);
				   }
			   }
			   
		   }
		   
		   pw.append(count+"");
		   pw.append('\n');
		  }
		  pw.flush();
		  pw.close();
		  br.close();
		 }
}
