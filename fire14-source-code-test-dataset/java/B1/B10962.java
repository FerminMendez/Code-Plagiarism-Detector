package programminginjava;
import java.io.*;
import java.util.*;
import java.lang.Math;

class recycledNos {
    
    int factorial(int no){
        if (no == 1 || no == 0)
            return 1;
        else return (no*factorial(no-1));
    }
    
    public static void main(String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("recycledNos.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recycledNos.out")));
        
        recycledNos recycledNosRef = new recycledNos();
        
        int T = Integer.parseInt(f.readLine());
        
        for(int i=0; i<T; i++){
            String line = f.readLine();
            String [] lines = line.split(" ");
            int A = Integer.parseInt(lines[0]);
            int B = Integer.parseInt(lines[1]);
            
            HashMap hm = new HashMap();
            HashMap local = new HashMap();
            long totalPairs = 0;
            for(int j=A; j<=B; j++){
                int no = j;
                //System.out.print("no is : "+no);
                if(hm.containsKey(no))
                    continue;
                
                String noStr = Integer.toString(no);
                int len = noStr.length();
                
                int newPairs;
                int rem, quo, newQuo, tenPow, iterCount, firstDigit;
                tenPow = (int) Math.pow(10, len-1);
                iterCount = 1; 
                local.put(no, true);
                for(int k=0; k<len-1; k++){
                    quo = no/10; 
                    rem = no % 10;
                    newQuo = rem * tenPow;
                    //firstDigit = no/tenPow;
                    no = newQuo + quo;
                    
                    if(local.containsKey(no) || (rem==0) || no<A || no>B)
                        continue;
                    iterCount++; 
                    local.put(no, true);
                   // System.out.println(" and the iterCount is : "+iterCount);
                }
                
                long noOfCombinations = 0;
                if(iterCount > 1)
                  noOfCombinations = recycledNosRef.factorial(iterCount)/(recycledNosRef.factorial(iterCount-2)*2);
                
                hm.putAll(local);
                local.clear();
                totalPairs += noOfCombinations;
            }
            
            out.println("Case #"+(i+1)+": "+totalPairs);
            
        }
        
        out.close();
        System.exit(0);
    }
}