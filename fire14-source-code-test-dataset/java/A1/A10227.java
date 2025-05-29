import java.net.*;
import java.io.*;
import java.lang.*;

public class DancingWiththeGooglers {
    public static int highestStable(int x){
    	if(x == 0)
    		return 0;
    	else if(x % 3 == 0)
    		return x/3;
    	else
    		return x/3 + 1;
    }
    public static int highestUnstable(int x){
    	int temp = 0;
    	if(x == 0)
    		temp = 0;
    	else if(x % 3 == 0)
    		temp = x/3 + 1;
    	else if(x % 3 == 1)
    		temp = x/3 + 1;
			else
				temp = x/3 + 2;
			
			if(temp > 10)
				temp = 10;
			return temp;
    }
    public static void main(String[] args) throws IOException {
    String[] spl;
    int counter =1;
    int output;
    int n,s,p;
    int low=0, med=0, high=0;
    int[] nArr = new int[100];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = in.readLine()) != null){
			//int l = input.length();
			spl = input.split(" ");
			n = Integer.parseInt(spl[0]);
			s = Integer.parseInt(spl[1]);
			p = Integer.parseInt(spl[2]);
			//System.out.println("n:" + n + " s:" + s + " p:" + p  );
			for(int i=0; i<n; i++){
				nArr[i] =  Integer.parseInt(spl[3 + i]); //System.out.println(nArr[i]);
				if (highestStable(nArr[i]) >= p)
					high++;
				else if(highestUnstable(nArr[i]) < p)
					low++;
				else
					med++;
			}
		  //System.out.println("high:" + high + " low:" + low + " med:" + med + '\n' );
			if(s>=med){
				output = med + high; 
				System.out.println("Case #" + counter + ": " + output );
			}
			else{
				output = s + high; 
				System.out.println("Case #" + counter + ": " + output );
			}
			counter++;
			low=0; med=0; high=0;
		}
	}
}
    
