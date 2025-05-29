package Test1;


import java.io.BufferedReader;
import java.io.InputStreamReader;




public class Test1 {

	static String[] orig = {"ejp mysljylc kd kxveddknmc re jsicpdrysi", "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd","de kr kd eoya kw aej tysr re ujdr lkgc jv"};
	static String[] target = {"our language is impossible to understand","there are twenty six factorial possibilities","so it is okay if you want to just give up"};
	static int[] map = new int[26];
	static int[] hash = new int[26];
	public static void main(String[] args) {

    int n,s,p,T;
    int[] t = new int[31]; 
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
    try {
    	
    	String str = in.readLine();
    	int result,vaildp,tempmax;
    	n = Integer.parseInt(str.trim());
    	for (int i = 1; i <= n; i++) {
    		str = in.readLine();
    		String[] temp = str.split(" ");
    		T = Integer.parseInt(temp[0]);
    		s = Integer.parseInt(temp[1]);
    		p = Integer.parseInt(temp[2]);
    		result = 0;
    		vaildp = 0;
    		for (int j=3; j<temp.length;j++){
    			int numtemp = Integer.parseInt(temp[j]);
    			int max = numtemp / 3;
    			if (numtemp % 3 != 0) max++;
    			if (max >= p) result++;
    			else {
    				tempmax = numtemp / 3;
    				if (numtemp % 3 == 1) tempmax = tempmax +1;
    				else if (numtemp % 3 == 2) tempmax = tempmax +2;
    				else if (tempmax > 0) tempmax = tempmax + 1;
    				if (tempmax >= p) vaildp++;
    			}
    			//System.out.println("num="+numtemp+";max="+max+";vild="+vaildp);
    		}
    		if (vaildp > s) vaildp = s;
    		result = result + vaildp;
    		if (result > T) result = T;
    		System.out.println("Case #"+i+": "+result);
    		//System.out.println("");
    	}
    } catch (Exception e) {
    	
    }
	}
}

