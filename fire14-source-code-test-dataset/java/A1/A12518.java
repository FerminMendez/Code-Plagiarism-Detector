import java.util.*;
public class Dance {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t = 1; t <= T; t++) {
	  int num = 0, ptp = 0; 
	  int n = sc.nextInt(), S = sc.nextInt(), p = sc.nextInt();
	  for(int i = 0; i < n; i++) {
	    int score = sc.nextInt();
		int k = score / 3, r = score % 3;
		if(r == 1) {if(k + 1 >= p) num++;}
        else if(r == 2) {if(k + 1 >= p) num++; else if(k == p - 2) ptp++;}
        else {if(k >= p) num++; else if(k == p - 1 && k != 0) ptp++;}		
	  } 	  
	  System.out.println("Case #" + t + ": " + (Math.min(ptp, S) + num));
    }
  }
}