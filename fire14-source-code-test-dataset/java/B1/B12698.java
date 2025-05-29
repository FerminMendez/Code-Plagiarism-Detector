import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class recycle {
	static Scanner kb ;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
PrintWriter out = new PrintWriter("answerrecycle.txt");
		 kb = new Scanner(System.in);
		int testcase = kb.nextInt();
		for(int i=0;i<testcase;i++){
			out.println("Case #"+(i+1)+": "+solve());
		}
		out.close();
	}
	private static int solve() {
		// TODO Auto-generated method stub
		
		int minnumber = kb.nextInt();
		int maxnumber = kb.nextInt();
		int answer = 0;
		for(int i=minnumber;i<=maxnumber;i++){
			ArrayList<Integer> mem = new ArrayList<Integer>();
			String number = Integer.toString(i);
			int s = (int)number.charAt(0)-48;
			for(int k=1;k<number.length();k++){
			int n = (int)number.charAt(k)-48;
			
			if(n>=s){
				
				String news =  number.substring(k,number.length())+number.substring(0,k);
				int numbernew = Integer.parseInt(news);
				if(numbernew<=maxnumber&&(!(numbernew<=i))&&news.length()==number.length()&&!mem.contains(numbernew)){
					answer++;
					//System.out.println(number+"_n>s_"+news);
					mem.add(numbernew);
				}
				
			}
			
		}
		
	}
		return answer;
	}
}
