/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2012/4/14
 */
 import java.io.*;

public class Main {
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt4.in"));
        FileWriter fstream = new FileWriter("B-small-attempt4.out");
        BufferedWriter out = new BufferedWriter(fstream);
        String in = br.readLine();
        int testCases = Integer.parseInt(in);
        int i = 1;
        
        while(testCases > 0) {
        	in = br.readLine();
        	out.write("Case #" + i + ": " + solve(in.split(" ")) + "\n");
        	testCases--;
        	i++;
        }
        out.close();
    }
    
    public static int solve(String[] in) {
    	int n = Integer.parseInt(in[0]);
    	int s = Integer.parseInt(in[1]);
    	int p = Integer.parseInt(in[2]);
    	int solution = 0;
    	
    	for(int i = 3; i < in.length; i++) {
    		int t = Integer.parseInt(in[i]);
    		switch(p) {
    			case 0:solution++;break;
    			case 1:if(t >= 1) solution++;break;
    			case 2:if(s > 0 && (t >= 2 && t <= 3)){solution++; s--;}else if(t > 3)solution++;break;
    			case 3:if(s > 0 && (t >= 5 && t <= 6)){solution++; s--;}else if(t > 6)solution++;break;
    			case 4:if(s > 0 && (t >= 8 && t <= 9)){solution++; s--;}else if(t > 9)solution++;break;
    			case 5:if(s > 0 && (t >= 11 && t <= 12)){solution++; s--;}else if(t > 12)solution++;break;
    			case 6:if(s > 0 && (t >= 14 && t <= 15)){solution++; s--;}else if(t > 15)solution++;break;
    			case 7:if(s > 0 && (t >= 17 && t <= 18)){solution++; s--;}else if(t > 18)solution++;break;
    			case 8:if(s > 0 && (t >= 20 && t <= 21)){solution++; s--;}else if(t > 21)solution++;break;
    			case 9:if(s > 0 && (t >= 23 && t <= 24)){solution++; s--;}else if(t > 24)solution++;break;
    			case 10:if(s > 0 && (t >= 26 && t <= 27)){solution++; s--;}else if(t > 27)solution++;break;
    		}
    	}
    	return solution;
    }
}
