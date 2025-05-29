import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Dance {

	static int getMaxGooglers(int N,int S, int p, int[] t) {
		int count=0;
		int surpriseCount=0;
		
		int avg=p*3;
		for(int i=0;i<N;i++) {
			if(t[i]>=p) {
				if(t[i]>=avg-2)
			
				count++;
			
			else if(surpriseCount<S)
			{
				if(t[i]>=avg-4) {
					count++;
					surpriseCount++;
				}
			}
			}
		}
		return count;
	}

}
