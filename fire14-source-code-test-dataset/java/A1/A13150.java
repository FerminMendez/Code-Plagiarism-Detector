import java.io.*;
import java.util.*;





public class CodeJamProblem implements Runnable {

	
	public int getRisultato(int n, int s, int p, int[] points) {
		// n=6 s=2 p=8 29 20 8 18 18 21
		int vincitori = 0;
		int suprise = s;
		//Arrays.sort(points);
		System.out.println("CASE:"+Arrays.toString(points));
		for(int i =0;i<points.length;i++) {
			int base = (int)(points[i] / 3);
			int resto = points[i]%3;
			System.out.print(" Resto: " + resto);
			System.out.println("");
			 switch (resto)
		     {
			 case 0:
				 if (base >=p)
		          {
					 vincitori++;
		          }
		          else
		          {
		            // check for surprise case:
		            if (suprise > 0 && base > 0 &&base + 1 >= p)
		            {     
		            	vincitori++;
		            	suprise--;
		            }            
		          }         
				 break;
			 case 1:
				 if (base >= p || base + 1 >= p)
		          {
		              vincitori++;
		          }
		          else
		          {
		            // surprise case:
		            if (suprise > 0 && base + 1 >= p)
		            {
		            	vincitori++;
		            	suprise--;
		            }
		          }
				 break;
			 case 2:
				 if (base + 1 >= p || base >= p)
		          {
					 vincitori++;
		          }
		          else
		          {
		            if (suprise > 0 && base + 2 >= p)
		            {
		            	System.out.println("Winner");
		              vincitori++;
		              suprise--;
		            }
		          }
				 
				 break;
		     }
		}
		System.out.println("Winner["+p+","+s+"]:"+ vincitori);
		return vincitori;
	}
	
	
	public void solve() throws IOException {
		String test = "small";
		//String test = "large";
		Scanner in = new Scanner(new File("B-small-attempt0.in")).useDelimiter(System.getProperty("line.separator")); 
        PrintWriter out = new PrintWriter(new File("B-small-attempt3.out"));
        
        int lineNum = 0;
        int testNum = 0;
        int totalTests = 0;
        
        /*
        3 1 5 15 13 11
		3 0 8 23 22 21
		2 1 1 8 0
		6 2 8 29 20 8 18 18 21
        */
        
        int n = 0;
        int s = 0;
        int p = 0;
        int[] points = new int[1];
        /*
        String[] x = ("3 1 5 15 13 11").split(" ");
        for(int i = 0;i<x.length;i++) {
        	if(i==0){
        		n = Integer.parseInt(x[i]);
        	}
        	if(i==1) {
        		s = Integer.parseInt(x[i]);
        	}
        	if(i==2) {
        		p = Integer.parseInt(x[i]);
        	}
        	if(i>2) {
        		if(i==3) points = new int[n];
        		points[i-3] = Integer.parseInt(x[i]);
        	}
        }
        int risultato = getRisultato(n,s,p,points);
        */
        
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
                for(int i = 0;i<x.length;i++) {
                	if(i==0){
                		n = Integer.parseInt(x[i]);
                	}
                	if(i==1) {
                		s = Integer.parseInt(x[i]);
                	}
                	if(i==2) {
                		p = Integer.parseInt(x[i]);
                	}
                	if(i>2) {
                		if(i==3) points = new int[n];
                		points[i-3] = Integer.parseInt(x[i]);
                	}
                }
        		
        		int risultato = getRisultato(n,s,p,points);
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
