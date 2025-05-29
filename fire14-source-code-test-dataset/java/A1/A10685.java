import java.io.*;
import java.util.*;

public class Main{

    String inputFile = "B-small-attempt1.in";
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
            ArrayList<Integer> scores = new ArrayList<Integer>();
            
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int p = scanner.nextInt();
            while (scanner.hasNext()){
            	scores.add(scanner.nextInt()); 
            }
            
            println(solve(N, S, p, scores) +"");
        }

        output.close();
        System.out.println("Finished.");
        System.out.println("Time Taken: " + ((System.currentTimeMillis()-start)/1000) + " seconds.");
    }

   

    
    private int solve(int N, int S, int p, ArrayList<Integer> list){
    	
    	int ans = 0;
    	Collections.sort(list);
    	
    	for (int x=list.size()-1; x>=0; x--){
    		int num = list.get(x);
    		int normalBestResult = normalBestResult(num);
    		
    		if (normalBestResult >= p){
    			ans++;
    		}else{
    			if (surpriseWillAddOne(num) && S > 0){
    				if ((normalBestResult + 1) >= p){
    					ans++;
    					S = S - 1;
    				}
    			}
    		}
    	}
    	
    	return ans;
    }
    
    
    private int normalBestResult(int num){
    	if (num % 3 == 0){
    		return (num / 3);
    	}else {
    		return (num / 3) + 1;
    	}
    }
    
    
    private boolean surpriseWillAddOne(int num){
    	
    	if (num < 2 || num > 28){
    		return false;
    	}
    	
    	if (num % 3 == 1){
    		return false;
    	}else {
    		return true;
    	}
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