import java.util.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			int N = in.nextInt();
			int S = in.nextInt();
			int P = in.nextInt();
			int answer = 0;
			//int[] ti = new int[N];
			
			for(int i = 0; i < N;i++){
				int ti = in.nextInt();
				int median = ti/3;
				int mod = ti % 3;
				if(ti>0){
				switch (mod) {
	            case 0:  
	            		if(median >=P)
	            		{
	            			answer++;
	            		}
	            		else if(median + 1 >= P && S>0)
	            		{
	            			answer++;
	            			S--;
	            		}
	                     break;
	            case 1: 
	            	if(median + 1 >=P)
            		{
            			answer++;
            		}
	            	
	            	break;
	            case 2:  
	            	if(median+1 >=P)
            		{
            			answer++;
            		}
	            	else if(median + 2 >= P && S>0)
	            		{
	            			answer++;
	            			S--;
	            		}
	                     break;
	            default: break;
				}
				}
				else 
				{
					if(P == 0)
						answer++;
				}
			}
			System.out.format("Case #%d: %d\n", zz, answer);
		}
	}
}
