import java.io.*;
import java.util.*;

public class RecycledNumbers {
    
    private ArrayList<Integer> input = new ArrayList<Integer>();
    public static void main(String argz[]) throws IOException{
        RecycledNumbers r = new RecycledNumbers();
        r.readInput();
        r.generateAndCheck();
    }
    
    public void generateAndCheck(){
        int caseNo = 0;
        for(int i = 0; i < input.size(); i += 2){
            int count = 0;
            int A = input.get(i);
            int B = input.get(i + 1);
            for(int n = A; n <= B; n++){
                for(int m = n + 1; m <= B; m++){
                    if(check(n, m)) count++;
                }
            }
            System.out.print("Case #" + (++caseNo) + ": ");
            System.out.println(count);
        }
    }
    
    public boolean check(int n, int m){
        StringBuilder N = new StringBuilder(String.valueOf(n));
        do{
            N.insert(0, N.charAt(N.length() - 1));
            N.deleteCharAt(N.length() - 1);
            if(Integer.parseInt(N.toString()) == m){
                return true;
            }
        } while(Integer.parseInt(N.toString()) != n);
        
        return false;
    }
    
    private void readInput() throws IOException{
        FileReader file = new FileReader("in.in");
        try {
            Scanner reader = new Scanner(file);
            int testCases = reader.nextInt();
            while (testCases > 0){
                input.add(reader.nextInt());
				input.add(reader.nextInt());
                testCases--;
            }         
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}