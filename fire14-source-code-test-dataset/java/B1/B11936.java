package code.google.codejam2k12.qualfication;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycledNumbers {
	private static final BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
	private static final boolean TESTING = true;

	public static void main(String[] args) throws IOException {
		RecycledNumbers obj = new RecycledNumbers();
		obj.runTest();
	}

	private void runTest() throws IOException {
		int CASES = readInteger();

		int i = 1;
		FileWriter fw = new FileWriter("Output");
		do{
			List<Integer> list =  readIntegersInLine();
			int N = list.get(0), M = list.get(1);

			String o = "Case #" + i +": " + findCount(N, M);
			System.out.println(o);
			fw.write(o + '\n');
		}while(++i <= CASES);
		fw.close();
	}

	private int findCount(int A, int B) {
		int count = 0;
		Set<Pair> pairs = new HashSet<Pair>();

		for(int num = A;num<B;num++){
			byte[] bnum = getDigits(num); 
			for(int i=1;i<bnum.length;i++){
				int rotatedNumber = rotate(bnum);
				if(num < rotatedNumber && rotatedNumber <= B){
					trace("num: " + num + ", rotatedNumber: " + rotatedNumber);
					if(pairs.add(new Pair(num, rotatedNumber))){
						count++;
					}
				}
			}
		}

		return count;
	}

	private byte[] getDigits(int num) {
		int count = 0;
		for(int i=num;i>0;i/=10, count++);
		byte[] bnum =new byte[count];
		int tmpNum = num;
		for(int i=count-1;i>=0;i--){
			bnum[i] = (byte) (num % 10);
			num/=10;
		}
		trace("getDigits:: " + tmpNum + ": " + Arrays.toString(bnum));
		return bnum;
	}

	private int rotate(byte[] bnum){
		trace("rotate:: before: "+ Arrays.toString(bnum));
		byte tmp = bnum[bnum.length-1];
		for(int i=bnum.length-1;i>0;i--){
			bnum[i] = bnum[i-1];

		}
		bnum[0] = tmp;

		int result = 0;
		for(int i=0;i<bnum.length;i++){
			result = (result * 10) + bnum[i]; 
		}

		trace("rotate:: " + result + ": "+ Arrays.toString(bnum));
		return result;
	}

	private List<Integer> readIntegersInLine() throws IOException{
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer stok = new StringTokenizer(BR.readLine());
		while(stok.hasMoreTokens()){
			String token = stok.nextToken();
			list.add(Integer.parseInt(token));
		}

		return list;
	}

	private int readInteger() throws NumberFormatException, IOException{
		return Integer.parseInt(BR.readLine());
	}

	private void trace(String s){
		if(TESTING)System.out.println(s);
	}
}

class Pair{
	private int n;
	private int m;

	public Pair(int n, int m) {
		if(n>=m){
			throw new IllegalArgumentException("N not less than M: [" + n + ", " + m + "]");
		}
		this.n = n;
		this.m = m;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + m;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [n=" + n + ", m=" + m + "]";
	}
}
