

import java.io.*;
import java.util.*;

public class RecycledNumbers{
	
	
	int nCases,aa,bb,recycled,savei;
	String listString = "";
	int d=0;
	char c1,c2,c3;
	String a,b;
	ArrayList n=new ArrayList();
	ArrayList m=new ArrayList();
	List<Integer> digits1 = new ArrayList<Integer>();
	List<Integer> digits2 = new ArrayList<Integer>();
	int count=0;
	Integer i,j;
	Integer digitn[],digitm[];
	Integer ia[];
	
	public void recycle(){
		try{
			
	
			FileReader in = new FileReader("E:/C-small-attempt0.in");
		BufferedReader buff = new BufferedReader(in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("E:/C-small-attempt0.out")));
		nCases= Integer.parseInt(buff.readLine());
			 
			 for (Integer counter = 0; counter < nCases; counter++) {
			 	
			  String[] data = (buff.readLine()).split(" ");
                 a = data[0];
                 b = data[1];
                
                System.out.println(a+","+b);
                if(a.length()==b.length()){
                aa=Integer.parseInt(data[0]);
                bb=Integer.parseInt(data[1]);
                if(a.length()!=1 && b.length()!=1){
                
                for(i=aa;i<=bb;i++){
                	
                	//if(i==114){System.out.println("wherererererere "+i+j); }
                	
                	for(  j=i+1;(j<=bb && j>i);j++){
                		
                		//if(i==114){System.out.println("--------------------- "+i+j); }
                		
                		for(Integer o=0;o<(i.toString()).length();o++){
                			c3=(i.toString()).charAt(0);
                                         if(c3=='0') break;
                				for(Integer k=0;k<(j.toString()).length();k++){
                				
                			
                				 c1=(i.toString()).charAt(o);
                				
                				 
                				 c2=(j.toString()).charAt(k);
                				
                				if( Character.getNumericValue(c1)== Character.getNumericValue(c2)){
                			
                						count=count+1;
                						if(i==114 && j==411){System.out.println("count "+count); }
                					
                				}
                		
                			
                				}
                		
                		}
                		if(count>=(i.toString()).length()){
                		  
                		  savei=i;
                		 	while (i>0 ) {
                           digits1.add(0, i%10);
                            i=i/10;
                             }
                             i=savei;
                             for(int ro=0;ro<digits1.size();ro++){
                             	
                             if (ro==0)Collections.rotate(digits1, 1);
                             	
                             

                      for (Integer s : digits1)
                     {
                       listString += s.toString();
                     }  
                     	
                     	
                		 	 if(Integer.parseInt(listString)==j){
                		 	 	
                		 	 	//System.out.println("matched"+i+"==="+j);
                		 	 	recycled=recycled+1;
                		 	 	
                		 	 	digits1.clear();
                		 	 	listString="";
                		 	 	i=savei;
                		 	 
                		 	 	break;
                		 	 }
                		 	 else{
                		 	 	
                		 	 	listString="";
                		 	 	Collections.rotate(digits1, 1);
                		 	 		
                		 	 			i=savei;
                		 	 }
                		 	 
                		 	
                             }digits1.clear();
                		     
                		  	count=0;
                		} 
                		else count=0;
                		
                		
 

                		
                	} 
                }
               
			 
			 
	//	
		}
        }
        
        out.println("Case #" + (counter + 1) + ": "
					+ recycled);
					recycled=0;
		}
		in.close();
		out.close();
		} 
		catch(Exception e){
			System.out.println(e);			
		}
		
		
		
	}
	
	 

	
	public static void main(String arg[]){
		
		
		RecycledNumbers rc=new RecycledNumbers();
		rc.recycle();
	
		
	}
}