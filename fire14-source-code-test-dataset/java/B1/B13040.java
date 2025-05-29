import java.util.*;
import java.io.*;

public class RecycledNumbers{
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Formatter formatter = new Formatter(System.out);
      int T = Integer.parseInt(br.readLine());
      int A,B;
      String[] lineParts;
      int lineNum=1;
      while(T-->0){
	 lineParts=br.readLine().split("\\s");
	 A=Integer.parseInt(lineParts[0]);
	 B=Integer.parseInt(lineParts[1]);
	 formatter.format("Case #%d: %d\n",lineNum++,cycles(A,B));
      }
      formatter.close();
   }
   private static int cycles(int A, int B){
      Set<String> pairs= new HashSet<String>();
      for(int n=A;n<B;n++){
	pairs.addAll(solve(n,B)); 
      }
      return pairs.size();
   }
   private static Set<String> solve(int n, int B){
      Set<String> pairs=new HashSet<String>();
      int m=n;
      int q,r;
      int nLen=(""+n).length();
      LinkedList<Integer> restQueue=new LinkedList<Integer>();
      for(int i=0;i<nLen;i++){
	 q=m/10;
	 r=m%10;
	 m=q;
	 restQueue.add(r);
	 if(r!=0){
	    int len=(""+m).length();
	    while(!restQueue.isEmpty()){
	       m+=restQueue.removeFirst()*Math.pow(10,len++);
	    }
	    if(m>n && m <=B) pairs.add(n+":"+m);
	 }
      }
      return pairs;
   }
}
