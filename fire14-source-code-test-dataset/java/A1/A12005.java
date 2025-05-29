import java.util.Scanner;

//"c:\Program Files\Java\jdk1.6.0_25\bin\javac.exe"  a.java
//"c:\Program Files\Java\jdk1.6.0_25\bin\java.exe"  a <test.in >test.out
public class B {

	public static String meth1 (String s){
		String res = "";
		res=res+s;
		
	return res;	  
	}
	//"c:\Program Files\Java\jdk1.6.0_25\bin\javac.exe"  A.java
	//"c:\Program Files\Java\jdk1.6.0_25\bin\java.exe"  A <test.in >test.out
	 static Scanner sc = new Scanner(System.in);
	 public static void main(String[] args) {
	  int cases  ;
	  int res=0;
	   
	 // String [] inputs;
	
	  cases =  Integer.parseInt(sc.nextLine());  
	  int N=0;
	  int S = 0;
	  int P =0;
	  int p = 0;
	  int [] t;
	  for(int id = 1; id <= cases; id++){
		 res=0;
		  N = sc.nextInt();
		  S = sc.nextInt();
		  P = sc.nextInt();
		
		  p = 3*P;
		  t = new int[N];
		  for(int i=0;i<N;i++){
			  t[i] = sc.nextInt();
			  if (t[i]>=P){
				  if (t[i]+2>=p){
					  res++;
				  }
				  else{
					  if (t[i]+4>=p&&S>0){
						  res++;
						  S--;
					  }
				  }
			  }
		  }
		 // for (int i = 0;i<D;i++){}
		  
		  
		  System.out.printf("Case #%d: %d%n", id, res);
	 sc.nextLine();
	  }
	 }
}