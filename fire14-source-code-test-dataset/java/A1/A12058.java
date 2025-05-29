import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("module/src/b.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("module/src/b.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		MyScanner in = new MyScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProblemB solver = new ProblemB();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class ProblemB {
    static int[] maxWhenSurprise;
    static int[] maxWhenNotSurprise;
	public void solve(int testNumber, MyScanner in, PrintWriter out) {
        if(maxWhenNotSurprise == null){
            maxWhenNotSurprise = new int[31];
            maxWhenSurprise = new int[31];
            Arrays.fill(maxWhenSurprise,-1);
            Arrays.fill(maxWhenNotSurprise,-1);
            for (int a = 0; a < 11; a++) for (int b = 0; b < 11; b++) for (int c = 0; c < 11; c++){
                int m = Math.max(Math.max(Math.abs(a - b), Math.abs(b - c)), Math.abs(c - a));
                int sum = a+b+c;
                if(m<=2){
                    if(m==2)maxWhenSurprise[sum] = Math.max(Math.max(Math.max(a,b),c),maxWhenSurprise[sum]);
                    else maxWhenNotSurprise[sum] = Math.max(Math.max(Math.max(a, b), c),maxWhenNotSurprise[sum]);
                }
            }
        }
        int N=in.nextInt();
        int S=in.nextInt();
        int p=in.nextInt();
        int[][] dp = new int[N+1][S+1];
        ArrayUtils.fill(dp,-1);
        dp[0][0] = 0;
        for(int i=0;i<N;i++){
            int score = in.nextInt();
            for(int j=0;j<S+1;j++)if(dp[i][j] >= 0){
                if(maxWhenNotSurprise[score]>=0){
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j] + (maxWhenNotSurprise[score]>=p ? 1 : 0));
                }
                if(maxWhenSurprise[score]>=0 && j+1<S+1){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j] + (maxWhenSurprise[score]>=p ? 1 : 0));
                }
            }
        }
        out.println("Case #"+testNumber+": "+dp[N][S]);
	}
}

class MyScanner {
    private final InputStream in;
    public MyScanner(InputStream in){
        this.in = in;
    }

    char[] buf = new char[2000000];
    int strLen;
	public String next() {
		try {
            strLen = 0;
            int c;
			do{
				c = in.read();
				if(c==-1)throw new NoSuchElementException();
			}while(Character.isWhitespace(c));
			do {
                buf[strLen++] = (char)c;
                c = in.read();
			} while (c!=-1 && !Character.isWhitespace(c));
            return new String(buf,0,strLen);
		} catch (IOException e) {
            throw new NoSuchElementException();
		}
	}

	public int nextInt(){
		try{
			int c=in.read();
			if(c==-1) return c;
			while(c!='-'&&(c<'0'||'9'<c)){
				c=in.read();
				if(c==-1) return c;
			}
			if(c=='-') return -nextInt();
			int res=0;
			do{
				res*=10;
				res+=c-'0';
				c=in.read();
			}while('0'<=c&&c<='9');
			return res;
		}catch(Exception e){
			return -1;
		}
	}


    }

class ArrayUtils {

    public static void fill(int[][] array, int value) {
        for (int[] a : array) Arrays.fill(a, value);
    }


    }

