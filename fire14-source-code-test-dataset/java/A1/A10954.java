package codejam;

import java.io.*;
import java.util.*;

public class test {

	public static void main(String[] args) {

        try{
        	
	        int googlers=0;
	        int surprises=0;
	        double bestResult=0;
	        double score=0;
	        int possible=0;
	        
	
	
	        BufferedReader f = new BufferedReader(new FileReader("X:/programacion/codejam/2012/1B/B-small-attempt0.in"));
	        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("X:/programacion/codejam/2012/1B/B-small-attempt0.out")));

	        StringTokenizer st1 = new StringTokenizer(f.readLine());
	
	        long numCasosDePrueba=Integer.parseInt(st1.nextToken());
	
	        for (int i=1;i<=numCasosDePrueba;i++){
	            st1 = new StringTokenizer(f.readLine());
	            googlers = Integer.parseInt(st1.nextToken());
	            surprises = Integer.parseInt(st1.nextToken());
	            bestResult = Double.parseDouble(st1.nextToken());
	            possible=0;
	
	            for(int j=1;j<=googlers;j++){
	            	score=Double.parseDouble(st1.nextToken());
	            	score=score-bestResult;
	            	if(score>=0){
	                	if(bestResult-(score/2)<=1) possible++;
	                	else{
	                		if (surprises>0){
	                			if(bestResult-(score/2)<=2){
	                				possible++;
	                				surprises--;
	                			}
	                		}
	                	}
	            	}
	            }
	
	            out.print("Case #"+i+": "+possible);
	            if (i!=numCasosDePrueba) out.println();
	            
	        }
        out.close();
        System.exit(0);
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }

    }

}
