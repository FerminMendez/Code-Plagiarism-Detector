import java.io.*;
import java.util.*;
public class Prob2 {
	public static PrintStream out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("in.txt"));
		out = new PrintStream(new File("out.txt"));
		int numCases = Integer.parseInt(sc.nextLine());
		int caseNum = 1;
		while(caseNum<=numCases)
			solve(sc.nextLine(), caseNum++);
	}
	public static void solve(String input, int caseNum){
		StringTokenizer st = new StringTokenizer(input, " ");
		int numPeople = Integer.parseInt(st.nextToken());
		int numSurprising = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		LL scores = new LL();
		for(int i=0; i<numPeople; i++)
			scores.push(Integer.parseInt(st.nextToken()));
		Collections.sort(scores);
		int surePass = removeSurePassed(scores, p);
		removeSureUnsurprised(scores);
		int canPass = countCanPass(scores, p);
		int answer = surePass + Math.min(canPass, numSurprising);
		out.println("Case #"+caseNum+": "+answer);
		caseNum++;
	}
	public static void removeSureUnsurprised(LL scores){
		while(!scores.isEmpty() && scores.getFirst()<=1)
			scores.removeFirst();
	}
	public static int removeSurePassed(LL scores, int p){
		int surePassLimit = 3*p-2;
		int origLength = scores.size();
		while(!scores.isEmpty() && scores.getLast()>=surePassLimit)
			scores.removeLast();
		return origLength - scores.size();
	}
	public static int countCanPass(LL scores, int p){
		int canpass = 0;
		for(int i=0; i<scores.size(); i++){
			int cur = scores.get(i);
			if(cur%3==0){
				if(cur/3+1 >= p)
					canpass++;
			}else if(cur%3==2){
				if((cur-2)/3+2 >= p)
					canpass++;
			}
		}
		return canpass;
	}
	public static class LL extends LinkedList<Integer>{}
}
