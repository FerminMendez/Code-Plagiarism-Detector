import java.io.*;
import java.util.*;

public class C2012 {
	public static void main(String[] args) throws IOException {
		PrintWriter out;
		BufferedReader f;

		try {
			f = new BufferedReader(new FileReader("C2012.in"));
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"C2012.out")));
		} catch (Exception e) {
			f = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}
		int n=Integer.parseInt(f.readLine());
		for(int i=1;i<=n;i++){
			StringTokenizer token = new StringTokenizer(f.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int numDigits=numDigits(a);
			int answer=0;
			int last=0;
			for(int j=a;j<=b;j++){
				int hm=j;
				int hm2=hm;
				int tenmultiply=0;
				for(int k=1;k<numDigits;k++){
					int right=hm2%10;
					if(right==0){
						tenmultiply++;
						hm2/=10;
						continue;
					}
					hm2/=10;
					hm2+=right*Math.pow(10,numDigits-1);
					tenmultiply=0;
					if(hm2<=b&&hm2>hm&&last!=hm2){
						last=hm2;
						answer++;
					}
				}
			}
			out.print("Case #");
			out.print(i+": ");
			out.println(answer);
		}
		out.close();
		System.exit(0);
	}
	public static int numDigits(int x){
		if (x >= 10000) {
	        if (x >= 10000000) {
	            if (x >= 100000000) {
	                if (x >= 1000000000)
	                    return 10;
	                return 9;
	            }
	            return 8;
	        }
	        if (x >= 100000) {
	            if (x >= 1000000)
	                return 7;
	            return 6;
	        }
	        return 5;
	    }
	    if (x >= 100) {
	        if (x >= 1000)
	            return 4;
	        return 3;
	    }
	    if (x >= 10)
	        return 2;
	    return 1;
	}
}