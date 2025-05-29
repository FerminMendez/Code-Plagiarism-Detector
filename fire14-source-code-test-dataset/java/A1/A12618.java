package com.google.code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	public static int Case,N,S,p;
	public static int[] Ti = new int[102];
	
//	public static final String inputfileName = "B-small.in";
//	public static final String outputfileName = "B-small.out";
	public static final String inputfileName = "B-small-attempt6.in";
	public static final String outputfileName = "B-small-attempt6.out";
//	public static final String inputfileName = "B-large-attempt0.in";
//	public static final String outputfileName = "B-large-attempt0.out";

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner s = null;
		PrintWriter outputStream = null;
		
		try{
			s = new Scanner(new BufferedReader(
					new FileReader(inputfileName)));
			outputStream = new PrintWriter(
    				new BufferedWriter(new FileWriter(outputfileName)));
			Case = s.nextInt(); 
			for(int i=0;i<Case;i++){
				N=s.nextInt(); S=s.nextInt(); p=s.nextInt();
				for(int j=0;j<N;j++){
					Ti[j] = s.nextInt();
				}
				int rst = solve();
				System.out.format("Case #%d: %d\n" , i+1, rst);
				outputStream.format("Case #%d: %d\n" , i+1,rst);
			}		
		}finally{
			if (s != null) {
                s.close();
            }
            if (outputStream != null) {
            	outputStream.close();
            }
			
		}
		
	}
    private static int solve() {
    	// TODO Auto-generated method stub
    	int cntS,rst;
    	cntS=0; rst=0;
    	for(int i=0;i<N;i++){
    		int tmp = Ti[i]/3;
    		if(tmp==0){
    			if(Ti[i]>=p){
    				if(p==2){
    					cntS++;rst++;
    				}
    				else if(p<2){
    					rst++;
    				}
    			}
    			continue;
    		}
    		if(Ti[i]==5){
    			if(p<=2){
    				rst++;
    			}
    			else if(p==3){
    				rst++;cntS++;
    			}
    			continue;
    		}
    		if(Ti[i]==4){
    			if(p<=2){
    				rst++;
    			}
    			continue;
    		}
    		if(Ti[i]==3){
    			if(p<=1){
    				rst++;
    			}
    			else if(p==2){
    				rst++;cntS++;
    			}
    			continue;
    		}
    		if(Ti[i]%tmp==0){
    			if(tmp>=p){
    				rst++;
    			}
    			else if(tmp+1==p){
    				rst++;cntS++;
    			}
    		}
    		else if(Ti[i]%tmp==1){
    			if(tmp+1>=p){
    				rst++;
    			}
    		}else{
    			
    			if(tmp+1>=p){
    				rst++;
    			}
    			else if(tmp+2>=p){
    				rst++;cntS++;
    			}
    		}
    	}
    	//System.out.println(N);
    	if(cntS-S>0){    		
    		rst -= cntS-S;
    	}
    	return rst;
    }
}
