import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
    static int power = 1;

	private static String filename;

	public static void main(String[] args) {
		if (args.length>0 && args[0].equals("f")) filename = "input.txt";
		else filename = "";
		new Thread(new Main()).start();
	}

    private static void debug(Object ... str) {
        for (Object s : str) System.out.print(s + ", ");
        System.out.println();
    }


    private void check(int x, int y, int ndig) {
        int temp = x;
        int[] digx = new int[ndig];
        int[] digy = new int[ndig];
        for (int i = 0; i < ndig; ++i, temp = temp / 10) {
            digx[i] = temp % 10;
        }
        temp = y;
        for (int i = 0; i < ndig; ++i, temp = temp / 10) {
            digy[i] = temp % 10;
        }
        boolean equal = false;   
        for (int sh = 1; !equal && sh < ndig; ++sh) {
            equal = true;
            for (int i = 0; equal && i < ndig; ++i) {
                if (digx[(i + sh) % ndig] != digy[i]) {
                    equal = false;
                }
            }
        }
        if (!equal || x >= y)
            System.out.println("HAHAHA " + x + " " + y);
    }

	public void run() {
		try{
            MyScanner in;
			Locale.setDefault(Locale.US);
			if (filename.length()>0) in = new MyScanner(filename);
			else in = new MyScanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
            int T = in.nextInt();
            for (int test = 0; test < T; ++test) {
                int a = in.nextInt();
                int b = in.nextInt();
                int temp = a;
                int ndig = 0;
                while (temp > 0) {
                    temp /= 10;
                    ndig++;
                }

                int[] dig = new int[ndig];

                power = 1;
                for (int i = 1; i<ndig; ++i) 
                    power *= 10;

                int ans = 0;

                boolean[] was = new boolean[2000001];
                int[] stack = new int[ndig];

                for (int x = a; x <= b; ++x) {
                    temp = x;
                    for (int c = 0; c < ndig; ++c, temp = temp / 10) {
                        dig[c] = temp % 10;
                        if (dig[c] == 0)
                            continue;
                    }

                    int stack_size = 0;
                    int y = x / 10 + dig[0] * power;
                    for (int c = 1; c < ndig; ++c) {
                        if ((x < y && y <= b) && !was[y]) {
                            ans++;
                            stack[stack_size++] = y;
                            was[y] = true;
                            //check(x, y, ndig);
                        }
                        y = y / 10 + dig[c] * power;
                    }

                    for (int i = 0; i < stack_size; ++i) {
                        was[stack[i]] = false;
                        stack[i] = 0;
                    }

                }
                out.println("Case #" + (1 + test) + ": " + ans);
            }
            out.close();
            in.close();
			                                              
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

class MyScanner {
	BufferedReader in;
	StringTokenizer st;

	MyScanner(String file){
	        try{
		in = new BufferedReader(new FileReader(new File(file)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	MyScanner(InputStream inp){
		try{                                   
                	in = new BufferedReader(new InputStreamReader(inp));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

    void skipLine(){
        st = null;
    }

	boolean hasMoreTokens(){
		String s = null;
		try{
			while ((st==null || !st.hasMoreTokens())&& (s=in.readLine()) != null) st = new StringTokenizer(s);
			if ((st==null || !st.hasMoreTokens())&& s==null) return false;
	        }catch(IOException e){
	        	e.printStackTrace();
	        }
		return true;
	}

	String nextToken(){
		if (hasMoreTokens()){
			return st.nextToken();
		}
		return null;
	}

	int nextInt(){
		return Integer.parseInt(nextToken());
	}

	long nextLong(){
		return Long.parseLong(nextToken());
	}

	double nextDouble(){
		return Double.parseDouble(nextToken());
	}


	String nextString(){
		return nextToken();
	}
	void close(){
		try{
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}





