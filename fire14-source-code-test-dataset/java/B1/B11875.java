import java.util.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  Main  {
	
	//ArrayList<Integer> lis = new ArrayList<Integer>();
	//ArrayList<String> lis = new ArrayList<String>();
	//ArrayList<test> lis = new ArrayList<test>();
	static long sum=0;
	
public  static void main(String[] args) throws IOException {
   //googlein.txt
	Scanner sc =new Scanner(new File("C-small-attempt0.in"));
	  File file = new File("file.txt");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
	//	sc.useDelimiter("(\\s)+|[,]");
		 int T=sc.nextInt();
		
	 	for(int k=1; k<=T; k++){
	 	 int c=0, a=sc.nextInt(),b =sc.nextInt();
	 	 
	 	 for(int t=a;t<=b;t++){
	 		String s=String.valueOf(t);
	 		
	 		int l=s.length(),g=1; 
	 		ArrayList<Integer> lis = new ArrayList<Integer>();
	 		for(int u=0;u<l;u++)g*=10; 
	 		
	 		for(int u=0,p=10;u<l-1;u++,p*=10){
	 		 //  int h= Integer.parseInt(s.substring(l-u-1,l-u));
	 			//if( h<1  )continue;
	 		   
	 			int e=(t%p)*(g/p),f=t/p,y=e+f;
	 			//db(t,y);
	 		  if( a<=y && y<=b && t<y && !lis.contains(y)){c++; lis.add(y);// db(t,y);
	 		  }	
	 			
	 			
	 	 }
	 
	 		
		 }
	 
	 	pw.println("Case #"+(k)+": "+c);
	 	}
	 	

	 	pw.flush();
	 	pw.close();  }



 

    static int ni(Scanner in){
	return in.nextInt();  
 }


    static void db(Object... os){
	         System.err.println(Arrays.deepToString(os));
 
	}

}
