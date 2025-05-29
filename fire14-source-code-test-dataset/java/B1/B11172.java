import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


public class RecycleNum{
	private Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {
	//	new Thread(new Solution()).start();
		RecycleNum sol = new RecycleNum();
		sol.start();
	}

	public RecycleNum() {
	}

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter wStream=new BufferedWriter( new FileWriter("C-small_attempt0.out"));
		String input;
		StringTokenizer st=null;
		int T=0;
		if((input=br.readLine()) != null) {
			st=new StringTokenizer(input);
			T=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<T;i++)
		 {
			if((input=br.readLine()) != null) {
				st=new StringTokenizer(input);
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int recyclePair =0;
				for(int n=A;n<B;n++){
					for(int m=n+1;m<=B;m++){
						recyclePair += checkRecyclePair(n,m);
					}
				}
				
				System.out.println(recyclePair);
				wStream.write("Case #"+(i+1)+": "+recyclePair);
				wStream.newLine();
			//	out.print("Case #"+(testNumber+1)+": "+solve(mainList,oList,bList));
				}
			System.out.println("_________________");
			
		 }
		wStream.close();
	}
	
	public int checkRecyclePair(int n, int m){
		String nStr = Integer.toString(n);
		String mStr = Integer.toString(m);
		//System.out.println(nStr+"_"+mStr);
		String temp;
		if(nStr.length() == mStr.length()){
			for(int i=0;i<mStr.length();i++){
				if(mStr.charAt(i) == nStr.charAt(0)){
					temp = mStr.substring(i)+ mStr.substring(0, i);
					if(nStr.compareTo(temp) == 0){
					//	System.out.println(nStr+"_"+temp);
						return 1;
					}
				}
			}
			return 0;
		}
		else return 0;
	}
	
}