import java.io.*;
import java.util.*;
import java.util.ArrayList;





public class CodeJamProblem implements Runnable {
//Problem C
	public boolean InRisultati(ArrayList<String> array, String controllo) {
		for(int i =0; i<array.size();i++) {
			if(array.get(i)==controllo) {
				System.out.println("Risutlato gia contato");
				return true;
			}
		}
		return false;
	}
	
	public int getRisultato(int[] items, int caso) {
		// n=6 s=2 p=8 29 20 8 18 18 21
		int vincitori = 0;
		
		Arrays.sort(items);
		int A = items[0];
	    int B = items[1];
	    int current_n =-1;
	    int current_m =-1;
	    // 1 digit, no solution:
	    if (A<10 && B<10)
	    {
	      return 0;
	    }
	    int[] range = new int[B-A+1];
	    System.out.println("Range LEN:"+ range.length);
	    for(int i=0;i<range.length;i++) {
	    	range[i] = i+A;
	    	if(caso==3)
	    		System.out.print(range[i]+ " ");
	    }
	    int count = 0;
	    
	    ArrayList<String> risultati = new ArrayList<String>();
	    
	    if(caso==3)
	    System.out.println(" ");
	    for (int i = 0; i < range.length; i++)
	    {
	      current_n = range[i];
	      current_m = range[i];
	      String rot_m = ""+current_m;
	      if(caso==3)
	    	  System.out.println("Numero: " +current_m);
	      
	      int len = (range[i]+"").length();
	      for (int j = 0; j < len; j++)
	      {
	    	  if(caso==3)
	    		  System.out.print(" " + rot_m.substring(rot_m.length()-1) + 
	    			  rot_m.substring(0,len-1));
	    	  rot_m = (   
	    			  rot_m.substring(rot_m.length()-1) + 
	    			  rot_m.substring(0,len-1)
	    			  );
	        // A ² n < m ² B
	        if (Integer.parseInt(rot_m) <= B && Integer.parseInt(rot_m) > current_n && Integer.parseInt(rot_m) >= A)
	        {
	        	if(InRisultati(risultati,current_n+rot_m)==false) {
	        		risultati.add(current_n+rot_m);
	        		vincitori++;
	        		if(caso==3)
	        			System.out.println("Inversione Vincente: " + Integer.parseInt(rot_m));
	        	}
	        	
	        }
	      }
	      if(caso==3)
	    	  System.out.println(" ");
	    }
	    if(caso==3)
	    	System.out.println("Winner :"+ vincitori);
		return vincitori;
	}
	
	
	public void solve() throws IOException {
		String test = "small";
		//String test = "large";
		Scanner in = new Scanner(new File("C-small-attempt0.in")).useDelimiter(System.getProperty("line.separator")); 
        PrintWriter out = new PrintWriter(new File("C-small-attempt0.out"));
        
        int lineNum = 0;
        int testNum = 0;
        int totalTests = 0;
        int[] points = new int[1];
        while (in.hasNext()) {
        	String currentLine = in.next();
        	if(lineNum ==0 ) {
        		//Do Nothing!
        		totalTests = Integer.parseInt(currentLine);
        		lineNum++;
        		continue;
        	}
        	if(lineNum>0) {
        		String[] x = currentLine.split(" ");
        		points = new int[x.length];
                for(int i = 0;i<x.length;i++) {
               		points[i] = Integer.parseInt(x[i]);
                }
        		int risultato = getRisultato(points, testNum);
        		if(testNum==3)
        			System.out.println("Case #"+(testNum+1)+": "+ risultato);
        		out.println("Case #"+(testNum+1)+": "+ risultato);
        		testNum++;
        	}
            lineNum++;
        }
        in.close();
        out.close();
        
		
	}
	public void run() {
        try {
            solve();
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public static void main(String[] s) {
        new Thread(new CodeJamProblem()).start();
    }
	
	
	
}
