package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

	public static void main (String[] arg) throws IOException{
		
		 Scanner sc;
	        
	        PrintWriter pWriter = null;
	        
	        try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("B.out"));
			pWriter = new PrintWriter(bw);
			
	        sc = new Scanner(new File("B-small-attempt0.in"));
	        
	        int T = sc.nextInt();
	        //System.out.println("T = " +T);
	        
	        int max = 30 , min , lim1 , lim2 ;
	        
	        for(int i=1; i<=T; i++){
	        	//Scanner sc2 = new Scanner(sc.nextLine());
	        	int N = sc.nextInt(), S = sc.nextInt(), P = sc.nextInt();
	        	//System.out.println("N = " +N+ "S = " +S+ "P = " +P);
	        	
	        	min = P * 3 - 2 ;
	        	lim1 = P * 3 - 3;
	        	lim2 = P * 3 - 4;
	        	int somme = 0;
	        	
	        	for(int j = 0 ; j < N ; j++){
	        		int t = sc.nextInt();
	        		if(t >= P){
		        		if(t <= max && t >= min)	somme++;
		        		if(t == lim1 && S > 0)		{	somme++;	S--;	}
		        		if(t == lim2 && S > 0)		{	somme++;	S--;	}
		        	}
	        	}
	        	
	        	//System.out.println("Case: #" +i+ " "+somme);
	        	pWriter.println("Case #" +i+ ": "+somme);
	        }
	        
	        /*
	        int i=0;
	        
	           while(sc.hasNext()){
	        	   String l = "", ligne = sc.nextLine();
	        	   
	        	   //System.out.println("in="+ligne);
	        	   
	        	   Scanner sc2 = new Scanner(ligne);
	        	   sc2.useDelimiter(" ");
	        	   
	        	   while(sc2.hasNext()){
	        		   if(!l.equals(""))
	        			   l = sc2.next() +" "+l;
	        		   else
	        			   l = sc2.next();
	        	   }
	        	   
	        	   //System.out.println("out="+l);
	        	   if(i != 0)
	        	   pWriter.println("Case #"+i+++": "+l);
	        	   else i++;
	        	   
	           }*/
	        } catch (FileNotFoundException e) {
	        		e.printStackTrace();

	        }finally{
	        	//System.out.println("out");
	        	pWriter.close() ;
	        }
		
	}
}
