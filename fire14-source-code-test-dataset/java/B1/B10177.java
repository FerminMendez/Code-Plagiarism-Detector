import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author rohitkg
 */
public class Task implements Runnable {
    private static final String TASK_ID = "C-small-attempt0";
    private static final String IN_FILE = TASK_ID + ".in";
    private static final String OUT_FILE = TASK_ID + ".out";

    private Scanner in;
    private PrintWriter out;
    int n,i,t,A,B;
    
    int res;
   

    private void init() {
        try {
            in = new Scanner(new File(IN_FILE));
        } catch (FileNotFoundException ignored) {}
        try {
            out = new PrintWriter(OUT_FILE);
        } catch (FileNotFoundException ignored) {}
        
        n = in.nextInt();
    }

    private void read() {
        A=in.nextInt();
        B=in.nextInt();
    }

    private void solve() {
		res=0;
		
		if(A<10)
			return;
			
		HashSet<String> set=new HashSet<String>();	
		
		for(int i=A;i<=B;i++){
			String num ="" + i;
			int length=num.length();
			for(int pos=1;pos<=length;pos++){
				String recNum=num.substring(pos) + num.substring(0,pos);
				int recInt=Integer.parseInt(recNum);
				if(recInt>i && recInt<= B){
					//res++;
					
					if(!(set.contains(i + ", " +recInt) || set.contains(recInt + ", " + i))){
						set.add(i + ", " +recInt);
					}
					//	System.out.println(i + ", " +recInt);
					//else
							
					
					//out.println("Pairs : " + i + ", " + recInt);
				}
					
			}	
		}       
			
		res=set.size();	
    }

    private void write() {
        out.println("Case #" + t + ": " + res);
    }

    public void run() {
        init();
        for (t = 1; t <= n; t++) {
            read();
            solve();
            write();
        }
        out.close();
    }
    public static void main(String[] args) {
        new Thread(new Task()).start();
    }
}
