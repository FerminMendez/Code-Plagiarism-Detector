import java.io.*;
import java.util.*;

public class QualificationRoundC {
    public static int power(int i, int p){
        int k = 1;
        for(int j = 0; j < p; j++)
            k *= i;
        return k;
    }
    public static int recycle(int n, int k){
        int d = power(10, k);
        int e = power(10, numDigits(n) - k);
        int right = n % d;
        int left = n / d;
        return right * e + left;
    }
    public static int numDigits(int n){
        int i = 1, k = 0;
        while(n / i > 0){
            i *= 10;
            k++;
        }
        return k;
    }
    public static Set<Integer> getRecycledNumbers(int n){
        int digits = numDigits(n);
        Set<Integer> recycled = new HashSet<Integer>(digits - 1);
        for(int i = 0; i < digits; i++){
            int m = recycle(n, i);
            recycled.add(m);
        }
        return recycled;
    }
    public static void main(String[] args) throws IOException {
        String inFile = args[0];
        String outFile = args[0].replaceAll("\\.in$", ".out");

        FileInputStream fileInputStream = new FileInputStream(inFile);
        Scanner scanner = new Scanner(fileInputStream);
        FileWriter fileWriter = new FileWriter(outFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        int cases = scanner.nextInt();

        for(int i = 1; i <= cases; i++){
            int A = scanner.nextInt(), B = scanner.nextInt();
            int count = 0;

            for(int n = A; n < B; n++){
                Set<Integer> recycled = getRecycledNumbers(n);
                Iterator<Integer> it = recycled.iterator();
                while(it.hasNext()){
                    int m = it.next();
                    if(n < m && m <= B)
                        count++;
                }
            }

            String answer = String.format("Case #%d: %d\n", i, count);
            System.out.print(answer);
            bufferedWriter.write(answer);
        }

        bufferedWriter.close();
        fileWriter.close();
        scanner.close();
        fileInputStream.close();

    }
}
