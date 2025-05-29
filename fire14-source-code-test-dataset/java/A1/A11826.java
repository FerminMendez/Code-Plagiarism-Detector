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
   //googlein.txt C-small-attempt0.in
	Scanner sc =new Scanner(new File("B-small-attempt0.in"));
	  File file = new File("file.txt");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
	//	sc.useDelimiter("(\\s)+|[,]");
		 int T=sc.nextInt();
		
	 	for(int k=1; k<=T; k++){
	 	 int c=0,n=sc.nextInt(), s=sc.nextInt(),p =sc.nextInt();
	 	 
	 	 for(int t=0; t<n; t++){
	 	    
	 		int x=sc.nextInt(); 
	 		if(p==0){c++; continue;}
	 		
	 		if( 3*p<=x || p*3-2<=x){ c++;
	 			continue;
	 		}
	 		else if(0<p*3-4 && p*3-4<=x && 0<s){
	 			s--;
	 		c++;	
	 	 }
	 
	 		
		 }
	 db("Case #"+(k)+": "+c);
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
