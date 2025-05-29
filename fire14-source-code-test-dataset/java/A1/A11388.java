import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class problem2 {
	public static void main(String[] args){
		try{
			  // Create file 
			  FileWriter fstream1 = new FileWriter("E:/out.txt");
			  BufferedWriter outp = new BufferedWriter(fstream1);
		try{
		Scanner sc = new Scanner(new File("E:/B-small-attempt3.in"));
		int cnt1=sc.nextInt();
		cnt1=0;
	      while (sc.hasNextInt()) {
	    	  int ng = sc.nextInt();
	    	  int ns = sc.nextInt();
	    	  int p = sc.nextInt();
	    	  int cnt =0;
	    	  for(int i=0;i<ng;i++){
	    		  int gs = sc.nextInt();
	    		  if(gs==0){
	    			  if(p==0)
	    				  cnt++;
	    			  continue;
	    		  }
	    		  if(gs%3==0){
	    			  if(gs/3>=p){
	    				  cnt++;
	    			  }
	    			  else
	    				  if(gs/3+1==p){
	    					  if(ns>0){
	    						  cnt++;
	    						  ns--;
	    					  }
	    				  }
	    		  }
	    		  else
	    			  if(gs%3==1){
	    				  if(gs/3+1>=p)
	    					  cnt++;
	    			  }
	    			  else
	    				  if(gs/3+1>=p){
	    					  cnt++;
	    				  }
	    					  else{ 
	    						  if(gs/3+2==p){
	    							  if(ns>0){
	    								  cnt++;
	    								  ns--;
	    							  }
	    						  }
	    				  }
	    	  }
	    	 outp.write("Case #"+(cnt1+1)+": "+cnt+'\n');;
	    	 cnt1++;
	      }
		}catch(FileNotFoundException e){System.out.println("File not found");}
		outp.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  } 
	}
}
