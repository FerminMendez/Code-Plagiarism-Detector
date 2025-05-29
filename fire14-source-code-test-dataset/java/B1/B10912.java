package Test1;


import java.io.BufferedReader;
import java.io.InputStreamReader;




public class Test1 {

	public static void main(String[] args) {

	String temp1 = null;
	String temp2 = null;
	int n,a,b; 
	
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
    try {
    	
    	String str = in.readLine();
    	int result;
    	n = Integer.parseInt(str.trim());
    	for (int i = 1; i <= n; i++) {
    		str = in.readLine();
    		String[] temp = str.split(" ");
    		a = Integer.parseInt(temp[0]);
    		b = Integer.parseInt(temp[1]);
    		result = 0;
    		for (int j=a; j<=b;j++){
    			temp1 = (new Integer(j)).toString();
    			for (int k=1; k<temp1.length(); k++) {

    				String newtemp = temp1.substring(k)+temp1.substring(0, k);
    				int currentnum = Integer.parseInt(newtemp);
    				if (currentnum <= j) continue;
    				temp2 = (new Integer(currentnum)).toString();
    				if (temp2.length() != newtemp.length()) continue;
    				if (currentnum < a || currentnum > b) continue;
    				//System.out.println("Case #"+i+": "+j+":"+currentnum+";;;;;;;"+temp1.substring(0, k)+"====="+temp1.substring(k));
    				result++;
    			    
    			}
    			
    		}
    		System.out.println("Case #"+i+": "+result);
    		//System.out.println("");
    	}
    } catch (Exception e) {
    	
    }
	}
}

