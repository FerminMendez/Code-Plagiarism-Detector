import java.util.Scanner;

//"c:\Program Files\Java\jdk1.6.0_25\bin\javac.exe"  a.java
//"c:\Program Files\Java\jdk1.6.0_25\bin\java.exe"  a <test.in >test.out
public class C {

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
	  int res;
	 int m=0;
	   
	  String tmp;
	
	  cases =  Integer.parseInt(sc.nextLine());  
	  int A,B;
	  String buff;
	  for(int id = 1; id <= cases; id++){
		  res=0;
		  buff="";
		   A = sc.nextInt();
		   B = sc.nextInt();sc.nextLine();
			  for (int i = A;i<=B;i++){
				tmp = i+"";
				for(int j =1;j<tmp.length();j++){
		 m = Integer.parseInt(tmp.substring(j,tmp.length() )+tmp.substring(0, j));
		
			if (m>i&&m<=B)
				if(!buff.contains( tmp+"#"+m)){
					res++;
					buff+= tmp+"#"+m+")(";
				}
				}

			  }
		  
		  
		  System.out.printf("Case #%d: %d%n", id, res);
	 
	  }
	 }
}