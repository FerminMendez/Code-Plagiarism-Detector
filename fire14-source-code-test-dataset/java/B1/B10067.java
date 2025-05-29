/**
 * @(#)RecycledNumbers.java
 *
 *
 * @author CristianDumitruPopov
 * @version 1.00 2012/4/14
 */
import java.io.*;
import java.util.*;

public class RecycledNumbers {
	
	public static int lengthOf(int x) {
		int c = 0;
		while(x!=0) {
			x = x/10;
			c++;
		}
		return c;
	}
	public static int recycle(int z,int y) {
		return (((z%((int)Math.pow(10,y)))*((int)Math.pow(10,lengthOf(z)-y))) + z/((int)Math.pow(10,y)));
	}
	public static int trailing(int z) {
		int c = 1;
		while(z%10 == 0) {
			c++;
			z=z/10;
		}
		return c;
	}

    public static void write(String s) {
   		try{
  		FileWriter fstream = new FileWriter("out3.txt",true);
 		 BufferedWriter out = new BufferedWriter(fstream);
 		 out.write(s);

 		 out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
   }
   
   public static void main(String [] args) {
   	  int T,A,B;
   	  int contor = 0;
   	  
  	/*  T = 12305;
   	  System.out.println(lengthOf(T));
   	  int q = recycle(T,trailing(T));
   	  System.out.println(q);
   	   q = recycle(q,trailing(q));
   	  System.out.println(q);
   	   q = recycle(q,trailing(q));
   	  System.out.println(q);
   	  q = recycle(q,trailing(q));
   	  System.out.println(q);
   	  q = recycle(q,trailing(q));
   	  System.out.println(q);
   	  q = recycle(q,trailing(q));
   	  System.out.println(q);*/
	  
  		try{

  FileInputStream fstream = new FileInputStream("C-small-attempt0.in");

  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String s;
    	T = Integer.parseInt(br.readLine());
   		for(int i = 0 ; i < T;i++) {
   			s = br.readLine();
   			StringTokenizer st = new StringTokenizer(s," ");
   			A = Integer.parseInt(st.nextToken());
   			B = Integer.parseInt(st.nextToken());
   			contor = 0;
   			for(int j = A;j<B;j++) {
   				for(int k = j+1;k<=B;k++) {
   					int q = k;
   				
   					if((lengthOf(j) == lengthOf(k)) )
   					for(int z = 1 ; z<lengthOf(q)-(trailing(q)-1);z++) {
   							q = recycle(q,trailing(q));
   						if(q == j) 
   							contor ++;
   						

   					}
   				}
   			}
   			write("Case #"+(i+1)+": "+contor+System.getProperty("line.separator"));
   		}	
  
  	in.close();
    }catch (Exception e){
  	System.err.println("Error: " + e.getMessage());
    }
    
    
}
}