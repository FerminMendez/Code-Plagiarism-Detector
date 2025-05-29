import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try{
    	    FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
    	    DataInputStream in = new DataInputStream(fstream);
    	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    	    String strLine;
 
    	    
    	    
    	    
    	    strLine = br.readLine();
    	    int T = Integer.valueOf(strLine);
 //   	    System.out.println(T);
    	    int N[] = new int[T];
    	    int S[] = new int[T];
    	    int p[] = new int[T];
    	    
    	    int t[][] = new int[T][100];
    	    	    	    
    	    int j = 0;
    	    
    	    while ((strLine = br.readLine()) != null)   {
//    	    	N[j]=Integer.valueOf(strLine);
  //  	    	strLine = br.readLine();
	    	    String[] ss = strLine.split(" ");
    	    	
	   // 	    System.out.println(N[j]+ "-");
	    	    N[j] = Integer.valueOf(ss[0]);
	    	    S[j] = Integer.valueOf(ss[1]);
	    	    p[j] = Integer.valueOf(ss[2]);
	    	    
	    	    for (int i = 0; i < N[j]; i++) {
    	    		t[j][i] = Integer.valueOf(ss[i+3]);
    	//    		System.out.println(a[j][i]);
	    	    }

	    	    j++;
	    	     
    	    }
    	    
    	    
    	    
    	    
    	    
    	    
    	    for (int k=0; k<T; k++)
    	    {
    	    	
    	    	
    	    	int possible = 0;
    	    	int count = 0;
    	    	int res=0;
    	    	for (int i=0; i<N[k];i++){
    	    		Float f = new Float(t[k][i])/3;
    	    		int rounded = Math.round(f);
    	    		
    	    		if (t[k][i] % 3 == 1){
    	    			if (rounded+1 >= p[k]) count++;
    	    		}
    	    		else{
    	    			if (rounded >= p[k]) count++;
    	    			else if ((rounded+1 >= p[k]) && (t[k][i]>0)) possible ++;
       	    		}

    	    		
    	    		
    	    		
    	    		
    	    		if (possible < S[k]) {
    	    			res = count + possible;
    	    		}
    	    		else {
    	    			res = count + S[k];
    	    		}
    	    		
    	    	}
    	    		 
    	    		
    	    	
    	    	
    	    	System.out.print("Case #");
    	    	System.out.print(k+1);
    	    	System.out.print(": ");
    	    	System.out.print(res);
    	    	
    	    	
    	    	System.out.println();
   	    		
    	    	
    	    }
    	    
    	    
    	    //Close the input stream
    	    in.close();
    	    }catch (Exception e){//Catch exception if any
    	      System.err.println("Error: " + e.getMessage());
    	    }
	    
	    
	}

}
