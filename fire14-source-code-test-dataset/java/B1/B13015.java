import java.util.*;
import java.io.*;

public class codejam1{

    public static void main(String [] args){
        HashMap<Integer, Integer> permuToPairs = new HashMap<Integer, Integer>();
        permuToPairs.put(1,0);
        permuToPairs.put(2,1);
        permuToPairs.put(3,3);
        permuToPairs.put(4,6);
        permuToPairs.put(5,10);
        permuToPairs.put(6,15);
        permuToPairs.put(7,21);
        //System.out.println(findRecycle(1111, 2222,permuToPairs));
        int count = 1;
        try{
            Scanner sc = new Scanner(new File("C-small-attempt0.in"));
            PrintStream ps = new PrintStream(new File("OutputFile"));
            sc.nextLine();
            while (sc.hasNextLine()){
                String line  = sc.nextLine();
                String[] numbers = line.split(" ");
                long low = Long.parseLong(numbers[0]);
                long high = Long.parseLong(numbers[1]);
                
                String s = "Case #"+count+": " + findRecycle(low, high,permuToPairs);
                if(sc.hasNextLine()){
                    s +="\n";
                }
                ps.print(s);
                count ++;
            }
        }catch(Exception e){
            
        }
    }   
    
    public static long findRecycle(long low, long high, HashMap<Integer, Integer> permuToPairs){
        Set<Long> numberSet = new HashSet<Long>();
        String numberString = low+"";
        int numWidth = numberString.length();
        long count = 0;
        for(long i = low; i<= high; i++){
            if(!numberSet.contains(i)){
                numberSet.add(i);
                long permuNumber = i;
                int numPermus = 1;
                for(int j = 0; j < numWidth; j++){
                    // permute the number
                    permuNumber = permuNumber % 10* (int)Math.pow(10, numWidth-1)+permuNumber/10;
                    if(permuNumber >= low && permuNumber <= high && !numberSet.contains(permuNumber)){
                        numPermus++;
                        numberSet.add(permuNumber);
                    }
                }
                count += permuToPairs.get(numPermus);
            }
        }
        return count;
        
    }
}