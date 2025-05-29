import java.util.*;
import java.io.*;

public class DancingWithTheGooglers{
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Formatter formatter = new Formatter(System.out);
      int T = Integer.parseInt(br.readLine());
      String[] dataStr;
      int[] data;
      int lineNum=1;
      while(T-->0){
	 dataStr = br.readLine().split("\\s");
	 data=new int[dataStr.length-3];
	 for(int i=0;i<data.length;i++){
	    data[i]=Integer.parseInt(dataStr[i+3]);
	 }
	 formatter.format("Case #%d: %d\n",lineNum++, solve(Integer.parseInt(dataStr[0]),Integer.parseInt(dataStr[1]), Integer.parseInt(dataStr[2]),data));
      }
      formatter.close();
   }
   private static int solve(int N, int S,int p, int[] dances){
      int best=0;
      int maybe=0;
      int div3=0;
      for(int i=0;i<N;i++){
	 div3=dances[i]/3;
	 if(div3>=p || (div3==p-1 && dances[i] % 3>=1)) {
	    best++;
	    continue;
	 }
	 if((div3 == p - 1 && div3>=1) || (div3==p-2 && dances[i]%3==2)){
	    maybe++;
	    continue;
	 }
      }
      return best+Math.min(S,maybe);
   }
}
