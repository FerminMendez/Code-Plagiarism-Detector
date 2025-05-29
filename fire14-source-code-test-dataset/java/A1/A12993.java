import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Stack;

public class TaskB implements Runnable {
    class Solver implements Runnable {
        int testId;
        boolean failed = false;

        Solver(int testId) {
            this.testId = testId;
        }

        int N;
        int s;
        int p;
        int[] t;
        private void readInput() {
            N=nextInt();
        	s=nextInt();
        	p=nextInt();
        	t=new int[N];
        	for(int i=0;i<N;i++)
        	{
        		t[i]=nextInt();
        	}
        	//System.out.println("done");
        }

 
        long res =0;
  
        public void run() {
          	//System.out.println("start");
        	int[] dp=new int[s+1];
        	//System.out.println("done");
        	for(int i=0;i<N;i++)
        	{
        		int[] ndp=new int[s+1];
        		for(int j=0;j<=s;j++)
        		{
        			ndp[j]=dp[j];
        		}
        		int temp=t[i]-p;
        		int mmin=Math.max(0, p-1)*2;
        	//	int mmax=Math.min(10, p+1)*2;
        		if((temp>=mmin))
        		{
            		for(int j=0;j<=s;j++)
            		{
            			ndp[j]=dp[j]+1;
            		}
        		}
        		mmin=Math.max(0, p-2)*2;
        		if((temp>=mmin)&&(t[i]<=28))
        		{
            		for(int j=0;j<=s-1;j++)
            		{
            			ndp[j+1]=Math.max(dp[j]+1,ndp[j+1]);
            		}
        		}
        		dp=ndp;
        	}
        	res=dp[s];
        	return;
        }
        

        private void printOutput() {
            if (failed) {
                writer.println("BAD!!!");
                System.out.println("BAD!!!");
            } else {
            	writer.print("Case #");
            	writer.print(testId+1);
            	writer.print(": ");
                writer.println(res);
            }
        }
    }

    private void solveSequential() {
        int numTests = nextInt();
        for (int testId = 0; testId < numTests; ++testId) {
            Solver solver = new Solver(testId);
            solver.readInput();
            solver.run();
            solver.printOutput();
        }
    }

    private void solveParallel() {
        int numTests = nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Solver[] solver = new Solver[numTests];
        for (int testId = 0; testId < numTests; ++testId) {
            solver[testId] = new Solver(testId);
            solver[testId].readInput();
        }
        Future[] res = new Future[numTests];
        for (int testId = 0; testId < numTests; ++testId) {
            res[testId] = executor.submit(new Thread(solver[testId]));
        }
        for (int testId = 0; testId < numTests; ++testId) {
            try {
                res[testId].get();
            } catch (InterruptedException e) {
                solver[testId].failed = true;
            } catch (ExecutionException e) {
                solver[testId].failed = true;
            }
        }
        for (int testId = 0; testId < numTests; ++testId) {
        //	writer.print("Case #");
        //	writer.print(testId+1);
        //	writer.print(": ");
            solver[testId].printOutput();
        }
        executor.shutdown();
    }

    static final String TASK_ID = "taskB";

    public static void main(String[] args) {
        new TaskB().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer = null;
    PrintWriter writer;

    public void run() {
        try {
            long now = System.currentTimeMillis();
            reader = new BufferedReader(new FileReader(TASK_ID + ".txt"));
            writer = new PrintWriter(TASK_ID + ".out");
            solveParallel();
            reader.close();
            writer.close();
            System.out.println(System.currentTimeMillis() - now + "ms");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }
    String nextLine()
    {
    	String res;
        try {
            res = reader.readLine();
        } catch (IOException e) {
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   	
        return res;
    }

    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
            	e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
}



