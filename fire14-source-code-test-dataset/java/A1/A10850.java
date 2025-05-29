import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


public class pbB {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("test.in"));
		PrintWriter out= new PrintWriter("output.out");
		
		int k=sc.nextInt(), n,s,p,rep,sup,inf; Vector<Integer> scores;		
		for(int i=1;i<=k;i++){
			scores= new Vector<Integer>(); 
			n= sc.nextInt();s=sc.nextInt();p=sc.nextInt();
             for(int h= 0;h<n;h++) scores.add(sc.nextInt());
             Collections.sort(scores);
             rep=0; sup= p<1? p: 2*(p-1)+p; inf = p<2 ? p: 2*(p-2)+p;
             for(int h=scores.size()-1;h>=0;h--){
            	 if(scores.elementAt(h)>=sup) rep++;
            	 else if (scores.elementAt(h)>=inf && s>0){
            	    rep++;s--;
            	 }            	 
             }
		   out.print("Case #"+i+": "+rep);
		   if (i!=k) out.println();
		}
	out.close();
}
}
