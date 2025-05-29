import java.util.*;
public class Recycle {
  public static int deg(int x) {
    int i = 0;
	while(x > 0) {x = x / 10; i++;}
    return i;
  }
  
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 1; t <= T; t++) {
      int A = sc.nextInt(), B = sc.nextInt(), num = 0;
	  for(int i = A; i < B; i++) {
	    int degree = deg(i); 
		long coeff = (long) Math.pow(10, degree), n = i * coeff + i;
		LinkedList<Long> lst = new LinkedList<Long>();
		for(int j = 0; j < degree; j++) {
		  n = n / 10;
		  long m = n % coeff;
		  if(m > i && m <= B && !lst.contains(m)) {
		    lst.add(m); num++;}
		}
	  }
	  System.out.println("Case #" + t + ": " + num);
	}	
  }
}
