import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("module/src/C.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("module/src/C.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		MyScanner in = new MyScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProblemC solver = new ProblemC();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class ProblemC {
	public void solve(int testNumber, MyScanner in, PrintWriter out) {
        int A = in.nextInt(),B = in.nextInt();
        boolean[] visited=new boolean[B+1];
        long res = 0;
        for(int i=A;i<=B;i++){
            if(visited[i])continue;
            int num = i;
            String str = num+"";
            int cnt = 0;
            for(int j=0;j<str.length();j++){
                String nxtStr = str.substring(j) + str.substring(0,j);
                if(nxtStr.charAt(0)!='0'){
                    int nxt = Integer.valueOf(nxtStr);
                    if(A <= nxt && nxt <= B && !visited[nxt]){
                        cnt++;
                        visited[nxt]=true;
                    }
                }
            }
            res += cnt * (cnt-1) / 2;
        }
        out.printf("Case #%d: %d\n",testNumber,res);
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

