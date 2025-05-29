import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class GCJ2012QA
{

    public static <T> void main(String[] args) throws Exception
    {
        
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Scanner sc = new Scanner(new FileReader("A-input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("A-output.txt"));

        final int CASE_COUNT = sc.nextInt();
        for(int caseNum = 1; caseNum <= CASE_COUNT; caseNum++)
        {
            pw.print("Case #" + caseNum + ": ");
            int ans = 0;
            int A = sc.nextInt();
            int B = sc.nextInt();

            //int toGo = A + ((B - A) / 2);

            List<Future<Integer>> ress = new ArrayList<Future<Integer>>();
            for(int i = A; i <= B; i++)
            {
                Future<Integer> resf = executor.submit(new Calculate(A, B, i));
                ress.add(resf);
            }
            
            for(Future<Integer> aa : ress){
                ans += aa.get();
            }
            
            // PUT ANSWER HERE
            pw.println(ans);
        }
        executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        executor.shutdown();
        pw.flush();
        pw.close();
        sc.close();
    }

    private static class Calculate implements Callable<Integer>{

        
        final int A, B, num; 
        
        public Calculate(int A, int B, int i){
            this.A = A;
            this.B = B;
            this.num = i;
        }
        
        @Override
        public Integer call() throws Exception
        {
            return rotateCount(A, B, num);
        }
        
        
    }
    
    private static int rotateCount(int A, int B, int num)
    {

        Set<Integer> cache = new HashSet<Integer>();
        if(num < 10)
        {
            return 0;
        }
        int res = 0;

        char[] a = String.valueOf(num).toCharArray();
        int size = a.length;
        for(int i = 1; i < size; i++)
        {

            int kk = Integer.parseInt(rotate(a,1));
            //System.out.println(num + " (" + Thread.currentThread().getName() + ") " + kk);
            if(kk > num && kk <= B && !cache.contains(kk))
            {
                //System.out.println(num + "," + kk);
                res++;
                cache.add(kk);
            }
        }

        return res;
    }

    private static String rotate( final char[] a, final int n ) {
        for(int i = 0; i < n; i++) {
            char tmp = a[a.length-1];
            for(int j = a.length-1; j >= 0; j--) {
                a[j] = j == 0 ? tmp : a[(j-1+a.length)%a.length];
            }
        }
        return new String(a);
    }

}
