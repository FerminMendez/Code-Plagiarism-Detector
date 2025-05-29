import java.io.BufferedReader;
import java.io.FileReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

    public class Test {
            static BufferedReader reader;
            static StringTokenizer tokenizer;
            static PrintWriter writer;

            static int nextInt() throws IOException {
                    return Integer.parseInt(nextToken());
            }

            static long nextLong() throws IOException {
                    return Long.parseLong(nextToken());
            }

            static double nextDouble() throws IOException {
                    return Double.parseDouble(nextToken());
            }

            static String nextToken() throws IOException {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                            tokenizer = new StringTokenizer(reader.readLine());
                    }
                    return tokenizer.nextToken();
            }

            public static void main(String[] args) throws IOException {
                    reader = new BufferedReader(new FileReader("txt.in"));
                    tokenizer = null;
                    writer = new PrintWriter("System.out");
                    solve();
                    reader.close();
                    writer.close();
            }

            private static void solve() throws IOException {
            	int T=nextInt();
            
            	for (int j=0;j<T;j++)
        		{
            		int N=nextInt();
            		int S=nextInt();
            		int p=nextInt();
            		int k=0;
            		String ans="Case #"+Integer.toString(j+1)+": ";
            		int an=0;
            		if (p>1)
            			k=3*p-4;
            		else
            			{
            			for (int i=0;i<N;i++)
                    		{
                    			int tt=nextInt();
                    			if (tt>=p)                    			
                    				an++;
                    		}
            			ans+=Integer.toString(an);
            			if(j!=T-1)
                    		writer.println(ans);
                    		else
                    			writer.print(ans);
            			continue;
            			}
            		
            		
            		for (int i=0;i<N;i++)
            		{
            			int tt=nextInt();
            			if (tt==k||tt==k+1)
            			if (S>0)
            			{
            				an++;
            				S--;
            			}
            			if (tt>k+1)
            			an++;
            		}
            		ans+=Integer.toString(an);
            		
            		if(j!=T-1)
            		writer.println(ans);
            		else
            			writer.print(ans);
        		}
            	
            }

    }