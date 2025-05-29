
package codejam;

import java.io.*;

public class RecycledNumbers {

    private BufferedReader br;
    private BufferedWriter wr;
    
    public RecycledNumbers(String filein,String fileout){
        try{
            br = new BufferedReader(new 
                    InputStreamReader(new FileInputStream(filein)));
            wr = new BufferedWriter(new FileWriter(fileout));
            
            int num = 0;
            num = Integer.parseInt(br.readLine());
            
            for (int i = 1;i<=num;i++){
                String buf = br.readLine();
                String[] bufarray = buf.split(" ");
                int num1 = Integer.parseInt(bufarray[0]);
                int num2 = Integer.parseInt(bufarray[1]);
                int pairs = 0;
                for (int n = num1;n <= num2;n++){
                    int digit = getDigits(n);
                    for (int d = 1;d < digit;d++){
                        if (isTwin(n,digit) && d == (digit/2)+1) break;
                        int pair = (n%((int)Math.pow(10, d)))*((int)Math.pow(10, digit-d))+
                                n/((int)Math.pow(10, d));
                        if (pair > n &&
                                pair <= num2){
                            if (num1 > 1000)
                            System.out.println(n+" "+pair);
                            pairs++;
                        }
                    }
                }
                String out = "Case #"+i+": "+pairs;
                wr.write(out);
                if (i != num)
                    wr.newLine();
            }
            
            br.close();
            wr.close();
        }catch (IOException e){
            System.out.println("IO failure");
        }
    }
    
    private boolean isTwin(int n,int digit){
        if (digit%2 == 1) return false;
        
        return (n%(int)Math.pow(10, digit/2) == n/(int)Math.pow(10, digit/2));
    }
    
    private int getDigits(int n){
        int digit = 1;
        while(n/10 != 0){
            digit++;
            n /= 10;
        }
        
        return digit;
    }
    
    public static void main(String[] args) {
        RecycledNumbers sp = new RecycledNumbers("C-small-attempt0.in","C-small-attempt0.out");
    }
}
