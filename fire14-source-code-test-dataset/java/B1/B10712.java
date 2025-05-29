import java.io.*;
import java.util.*;

public class Main{

    String inputFile = "C-small-attempt0.in";
    String outputFile = "";
    PrintStream output;
    Scanner fileScanner;
    int outputLine = 0;
    double start = System.currentTimeMillis();

    public Main(){
        newCodeJam();

        fileScanner.nextLine();
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner scanner = new Scanner(line);
            
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            
            println(solve(A, B) +"");
        }

        output.close();
        System.out.println("Finished.");
        System.out.println("Time Taken: " + ((System.currentTimeMillis()-start)/1000) + " seconds.");
    }
    
    
    
    private int solve(int A, int B){
    	
    	int ans = 0;
    	
    	for (int n=A; n<=B-1; n++){
    		for (int m=n+1; m<=B; m++){
    			if (recycledPair(n, m)){
    				ans++;
    			}
    		}
    	}
    	
    	return ans;
    }

    
    private static boolean recycledPair(int n, int m){
    	String N = n + "";
    	String M = m + "";
    	int L = M.length();
    	
    	for (int i=1; i<=L; i++){
    		M = M.substring(1) + M.charAt(0); // rotate
    		if (N.equals(M)){
    			return true;
    		}
    	}
    	return false;
    }
   

    // CodeJam Utility Methods:
    
    public void newCodeJam(){
    	String outputFile = inputFile.substring(0, inputFile.length()-3) + "-OUTPUT.out";
        System.out.print("\f");
        // open input file
        try {
            fileScanner = new Scanner(new File(inputFile));
        }catch(IOException e) {}
        // open output file
        try {
            output = new PrintStream(new File(outputFile));
        }catch(IOException ex) {}
    }

    public void println(String s){
        outputLine++;
        output.println("Case #" + outputLine + ": " + s);
    }

    public static void main(String[] args){
    	new Main();
    }

}