import java.io.*;
import java.util.*;
public class Prob3 {
	public static PrintStream out;
	public static int caseNum;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("in.txt"));
		out = new PrintStream(new File("out.txt"));
		int numCases = Integer.parseInt(sc.nextLine());
		caseNum = 0;
		for(int i=0; i<numCases; i++)
			solve(sc.nextLine());
	}
	public static void solve(String input){
		StringTokenizer st = new StringTokenizer(input, " ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		int numDigits = (int) Math.floor(Math.log10(from)) + 1;
		int digitsPow10 = (int) Math.pow(10, numDigits-1);
		int numPairs = 0;
		for(int i=from; i<=to; i++){
			int recycled = recycle(i, digitsPow10);
			while(recycled != i){
				if(recycled>=from && recycled<=to)
					numPairs++;
				recycled = recycle(recycled, digitsPow10);
			}
		}
		caseNum++;
		out.println("Case #"+caseNum+": "+(numPairs/2));
	}
	public static int recycle(int num, int digitsPow10){
		while(true){
			int lastDigit = num%10;
			num = lastDigit*digitsPow10 + num/10;
			if(lastDigit!=0)
				break;
		}
		return num;
	}
}