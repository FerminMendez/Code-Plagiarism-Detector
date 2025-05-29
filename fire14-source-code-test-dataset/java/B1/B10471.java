import java.io.*;
import java.util.*;

public class Test_C {
        
    public static void main(String[] args) {
    	try{      
        FileReader fr = new FileReader("D:/codejam/C-small-attempt0.in");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("D:/codejam/C-small-attempt0-out.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        long c,a,b;
        int n;
        String line;
        String t[];
        long g[];
        long ans = 0;
        c = Integer.parseInt(br.readLine());
        //c = 1;
        String x,p,m,s,m1="";
                        
        for(int i=1;i<=c;i++) {
        	line = br.readLine();
        	ans = 0;
        	//line = "1111 2222";
        	t = line.split(" ");
        	n = t[0].length();
        	a = Long.parseLong(t[0]);
        	b = Long.parseLong(t[1]);
        	String temp[];
        	boolean oops = false;
        	for(long j=a;j<b;j++) {
        		s = j + "";
        		oops = false;
        		temp = new String[n-1];
        		for(int k=1;k<n;k++) {
        			x="";m="";       
        			//s=j+"";
        			if(s.charAt(k) >= line.charAt(0)){
        				
        			x = s.substring(k);        			
        			m = x + s.substring(0,k);    
        			temp[k-1] = m;
        			for(int y=0;y<k-1;y++)
        				if(m.equals(temp[y]))
        					oops = true;
        					 			
        			if(Long.parseLong(m)<=b && Long.parseLong(m)>j && Long.parseLong(m)>=a && oops == false) {
        				System.out.println(s + "     "+m);
        				ans++;
        			}
        			}       			       					 
        		}
        	}
        	
        	System.out.println("ans = "+ans);
        	String res = "Case #"+i+": "+ans;
        	bw.write(res,0,res.length());
        	bw.flush();
        	bw.newLine();
        }
        }
    	catch(Exception e){}
    }
}
