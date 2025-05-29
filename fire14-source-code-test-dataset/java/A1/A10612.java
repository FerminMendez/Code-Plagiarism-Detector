import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class B{
public static void main(String []args) throws Exception {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t, x = 0, n, s, p, ans;
	t = Integer.parseInt(br.readLine());
	while(t>0) {t--; x++;
	ans = 0;
	String w = br.readLine();
	String arr1[] = w.split("[ ]+");
	n = Integer.parseInt(arr1[0]);
	s = Integer.parseInt(arr1[1]);
	p = Integer.parseInt(arr1[2]); 
	int a = 0, a1 = 1, r = 2;
	for(int i = 0; i < n; i++) {r++;
		a = Integer.parseInt(arr1[r]);
		int b = (a/3);
		int c = b*3;
		int d = (b+1)*3;
		int e = 0;
		 if(b >= p) { ans++; e = 1;}
		if(e == 0) { if((c+1) == a && (b+1) >= p) { ans++; e = 1;}
			else if((c+2) == a && (b+1) >= p){ans++; e = 1;}
		}
		if(e == 0 && a1 <= s) {
			if(c > 0 && (c) == a && (b+1) >= p) { ans++; a1++;}
			else if((c+1) == a && (b+1) >= p) { ans++; a1++;}
			else if((c+2) == a && (b+2) >= p) { ans++; a1++;}
		}
	}
			
		System.out.println("Case #"+x+": "+ans);
        	}
	}
}
