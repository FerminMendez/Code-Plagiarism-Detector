/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


/**
 *
 * @author harit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) throws IOException {


       int normal[][]=          {{0,0,0},
                                {0,0,1},
                                {0,1,1},
                                {1,1,1},
                                {1,1,2},
                                {1,2,2},
                                {2,2,2},
                                {2,2,3},
                                {2,3,3},
                                {3,3,3},
                                {3,3,4},
                                {3,4,4},
                                {4,4,4},
                                {4,4,5},
                                {4,5,5},
                                {5,5,5},
                                {5,5,6},
                                {5,6,6},
                                {6,6,6},
                                {6,6,7},
                                {6,7,7},
                                {7,7,7},
                                {7,7,8},
                                {7,8,8},
                                {8,8,8},
                                {8,8,9},
                                {8,9,9},
                                {9,9,9},
                                {9,9,10},
                                {9,10,10},
                                {10,10,10}
                                };
       int surp[][]={   {-1,-1,-1},
                        {-1,-1,-1},
                        {0,0,2},
                        {0,1,2},
                        {0,2,2},
                        {1,1,3},
                        {1,2,3},
                        {1,3,3},
                        {2,2,4},
                        {2,3,4},
                        {2,4,4},
                        {3,3,5},
                        {3,4,5},
                        {3,5,5},
                        {4,4,6},
                        {4,5,6},
                        {4,6,6},
                        {5,5,7},
                        {5,6,7},
                        {5,7,7},
                        {6,6,8},
                        {6,7,8},
                        {6,8,8},
                        {7,7,9},
                        {7,8,9},
                        {7,9,9},
                        {8,8,10},
                        {8,9,10},
                        {8,10,10},
                        {-1,-1,-1},
                        {-1,-1,-1}
                        };
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           int t=Integer.parseInt(br.readLine());
           int t1=1;
           while(t1<=t){
		 String st=br.readLine();
		 //System.out.println(st); 
		 if(st!=null){
			//System.out.println("null");
	               String s[]=st.split(" ");
               //int n=Integer.parseInt(s[0]);
               		int sp=Integer.parseInt(s[1]);
               		int p=Integer.parseInt(s[2]);
               		int maxcount=0;
               		for(int i=3;i<s.length;i++){
                  		 int ttl=Integer.parseInt(s[i]);
                   		int p1=normal[ttl][2];
                   		if(p1>=p) maxcount++;
                   		else if(sp>0){
                     		  p1=surp[ttl][2];
                       		  if(p1>=p) {maxcount++;  sp--;}
                  	 	}
			}
			System.out.println("Case #"+t1+": "+maxcount);	
			
               }
		t1++;               

           }

    }

}
