import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class DancingWithTheGooglers {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("DancingWithTheGooglers.in"));
	    PrintWriter p = new PrintWriter("DancingWithTheGooglers.out");
	    int t = Integer.parseInt(in.nextLine());
	    int n;
	    int s;
	    int h;
	    int q;
	    int [] d = new int[100]; 
	    for(int c = 1; c < t+1; c++){
	    	q = 0;
	    	n = Integer.parseInt(in.next());
	    	s = Integer.parseInt(in.next());
	    	h = Integer.parseInt(in.next())-1;
	    	for (int i = 0; i < n; i++){
	    		d[i] = Integer.parseInt(in.next());
	    		if(d[i] > 3*h){
	    			q++;
	    		}else if((d[i]==3*h||d[i]==3*h-1)&&s > 0&& h!= 0){
	    			q++;
	    			s--;
	    		}
	    	}
	    	p.println("Case #"+c+": "+q);
	    	if(c!=t)in.nextLine();
	    }
	    in.close();
	    p.close();
	}

}