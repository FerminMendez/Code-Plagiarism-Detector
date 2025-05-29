import java.io.*;
import java.util.*;

public class Main {
   private static IO io;

   public static void main(String[] args) throws IOException {
       new Main().run();
   }

   private void run() throws IOException {
       io = new IO(System.getProperty("ONLINE_JUDGE")!=null);//false->files; true->console
       solve();
       io.flush();
   }

   private void solve() throws IOException {	   
	   int n = io.nI();
	   for(int z = 1; z<=n; z++){
		   int a = io.nI(), b = io.nI(), l = String.valueOf(a).length(), r = 0;
		   for(int i = a; i<=b; i++){
			   Set<String> L = new HashSet<String>(); String S = String.valueOf(i);
			   char c[] = S.toCharArray();
			   for(int j = 0; j<l; j++){
				   rev(c);
				   if(c[0]=='0')continue;
				   if(!L.add(S = String.valueOf(c)))continue;
				   int t = Integer.valueOf(S);
				   if(a<=t&&t<=b&&i<t)r++;
			   }
		   }
		   io.wln("Case #"+z+": "+r);
	   }
	   
   }//2.2250738585072012e-308
   
   private void rev(char a[]){
	   char t = a[0];
	   for(int i = 0; i<a.length-1; i++)a[i] = a[i+1]; a[a.length-1] = t;
   } 
   
   @SuppressWarnings("unused")
   private class IO{
       StreamTokenizer in; PrintWriter out; BufferedReader br; Reader reader; Writer writer;
       public IO(boolean oj) throws IOException{
           Locale.setDefault(Locale.US);
           reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
           writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
           br = new BufferedReader(reader);
           in = new StreamTokenizer(br);
           out = new PrintWriter(writer);
       }
       public void wln(){out.println();}
       public void wln(int arg){out.println(arg);}
       public void wln(long arg){out.println(arg);}
       public void wln(double arg){out.println(arg);}
       public void wln(String arg){out.println(arg);}
       public void wln(boolean arg){out.println(arg);}
       public void wln(char arg){out.println(arg);}
       public void wln(float arg){out.println(arg);}
       public void wln(Object arg){out.println(arg);}
       public void w(int arg){out.print(arg);}
       public void w(long arg){out.print(arg);}
       public void w(double arg){out.print(arg);}
       public void w(String arg){out.print(arg);}
       public void w(boolean arg){out.print(arg);}
       public void w(char arg){out.print(arg);}
       public void w(float arg){out.print(arg);}
       public void w(Object arg){out.print(arg);}
       public void wf(String format, Object...args){out.printf(format, args);}
       public void flush(){out.flush();}
       public int nI() throws IOException {in.nextToken(); return(int)in.nval;}
       public long nL() throws IOException {in.nextToken(); return(long)in.nval;}
       public String nS() throws IOException {in.nextToken(); return in.sval;}
       public double nD() throws IOException {in.nextToken(); return in.nval;}
       public float nF() throws IOException {in.nextToken(); return (float)in.nval;}
       public void wc(char...a){for(char c : a){in.ordinaryChar(c);in.wordChars(c, c);}}
       public void wc(char c1, char c2){in.ordinaryChars(c1, c2); in.wordChars(c1, c2);}
   }
}