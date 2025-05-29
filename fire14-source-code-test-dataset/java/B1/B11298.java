import java.io.*;
//import java.util.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class recyclednums {
  public static void main (String [] args) throws IOException {
	  
    BufferedReader f = new BufferedReader(new FileReader("recyclednums.in"));
    
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recyclednums.out")));
    
    int n = Integer.parseInt(f.readLine());

    int[][] testcase = new int[n][2];
    int[] answer = new int[n];
    
    for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(f.readLine());
    
        testcase[i][0] = Integer.parseInt(st.nextToken());
        testcase[i][1] = Integer.parseInt(st.nextToken());
        answer[i] = 0;
    }
    
    //System.out.println(qualify(Integer.toString(12345).toCharArray(),Integer.toString(34512).toCharArray()));
    
    for(int i=0; i<n; i++){
    	
    	//System.out.println("test case " + n);
    	
    	for(int j=testcase[i][0]; j<testcase[i][1]; j++){ //double check these indices
    		
    		for(int k=j+1; k<testcase[i][1]+1; k++){
    			
  			  String s1 = Integer.toString(j);
			  String s2 = Integer.toString(k);
			  
			  //System.out.println("testing " + j + " and " + k);
    			
    			if(!qualify(s1.toCharArray(),s2.toCharArray()))
    				continue;
    		
    			for(int si=1; si<s1.length(); si++){ //split the string in two then try to "recycle" the pieces
    				
    				String rec1 = s1.substring(0,si);
    				String rec2 = s1.substring(si);
    				
    				if ((rec2 + rec1).equals(s2)){
    					//System.out.println("Success!, " + rec2 + rec1 + " equals " + s2);
    					answer[i]++;
    					break;
    				}
    				
    				//System.out.println(rec1);
    				//System.out.println(rec2);
    				
    			}

    			
    			
    		}
    		
    	}
    	
    }

    for(int i=0; i<n; i++){
    	out.println("Case #" + (i+1) + ": " + answer[i]);
    }
    
    out.close();                                  
    
    System.exit(0);                             
  }
  
  public static boolean qualify(char[] a, char[] b){ //return false if these two numbers cannot POSSIBLY be recycled
	  
	  char[] arr1 = a;
	  char[] arr2 = b;
	  
	  int digit1 = arr1.length;
	  int digit2 = arr2.length;
	  
	  if (digit1 != digit2) //same num of digits
		  return false;
	  
	  Arrays.sort(arr1);
	  Arrays.sort(arr2);
	  
	  if (!Arrays.equals(arr1,arr2)){ //same usage of digits
		  return false;
	  }
	  
	  return true;
	  
  }
  
}
