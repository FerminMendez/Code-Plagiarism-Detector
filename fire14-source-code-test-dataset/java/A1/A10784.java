
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ProblemB {
 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new FileReader(new File("B-small-attempt4.in")));
  PrintWriter pw = new PrintWriter(new File("B-small-attempt4.out"));
  int n, s,p, count,   temp;
  int t= new Integer(br.readLine());
  for(int c=1; c<=t; c++)
  {
   pw.append("Case #"+c+": ");
   StringTokenizer st = new StringTokenizer(br.readLine());
   n = new Integer(st.nextToken());
   s= new Integer(st.nextToken());
   p = new Integer(st.nextToken());
   count=0;
   if(p==0)
	   count=n;
   else
	for(int i=0; i< n ; i++)
   {
	temp= new Integer(st.nextToken());
	if(temp< p )
		continue;
	
    temp = (temp-p)/2;
    
    if(temp >=p-1)
    	count++;
    else if (temp>=p-2 && s>0 && p>1)
    	{
    		count++;
    		s--;
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
