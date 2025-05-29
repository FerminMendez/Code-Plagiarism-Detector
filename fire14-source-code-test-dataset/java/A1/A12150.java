import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Codejam2Test {
	static BufferedReader stdin;
	static BufferedWriter stdout;
	ArrayList<String> list;

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String fName = new String("B-small-attempt7.in");
		String foName = new String("B-small-attempt7.out");
		stdin = new BufferedReader(new FileReader(fName));
		ArrayList<String> list = new ArrayList<String>();
		stdout = new BufferedWriter(new FileWriter(foName));
		int n = Integer.parseInt(stdin.readLine());

		for (int i=0;i<n;i++){
			list.add(stdin.readLine());
		}
		stdin.close();
		for (int i =0; i<n;i++){
			String cases = list.get(i);
			int T,S,p;
			int answer =0;
			ArrayList<Integer> spaces = new ArrayList<Integer>();
			ArrayList<Integer> dancers = new ArrayList<Integer>();
			for (int j = 0; j<cases.length();j++){
				if(Character.isWhitespace(cases.charAt(j))){
					spaces.add(j);
				}
			}
			T = Integer.parseInt(cases.substring(0, spaces.get(0)));
			S = Integer.parseInt(cases.substring(spaces.get(0)+1, spaces.get(1)));
			p = Integer.parseInt(cases.substring(spaces.get(1)+1, spaces.get(2))); 
			for (int j =2; j<spaces.size()-1;j++){
				dancers.add(Integer.parseInt(cases.substring(spaces.get(j)+1, spaces.get(j+1))));
			}
			dancers.add(Integer.parseInt(cases.substring(spaces.get(spaces.size()-1)+1, cases.length())));
			dancers = check(T, dancers);
			//print test
//			System.out.print("Case #"+(i+1)+ ": " +T + ", ");
//			System.out.print(S+", ");
//			System.out.print(p+", ");
//			for (int k = 0; k< dancers.size();k++){
//				System.out.print(dancers.get(k)+", ");
//			}
//			System.out.println("");
			
				int minScoreWithoutSurprising = 3*p-2;
				int minScoreWithSurprising = 3*p-4;
			
			for (int j = 0; j<dancers.size();j++ ){
				int score = dancers.get(j);
				
				if (score > 3*p){
					answer++;
				} else if (score >= minScoreWithoutSurprising && p>1){
					answer++;
				} else if(score >= minScoreWithSurprising && S!=0 && p>1){
					answer++;
					S--;
				} else if(p==0){
					answer ++;
				} else if (p == 1 && score > 0){
					answer++;
				}
			}
			String out = new String("Case #" + (i+1) + ": " + answer);
			stdout.write(out);
			stdout.newLine();
		}
		stdout.close();
	}
	
	
	public static ArrayList<Integer> check(int t, ArrayList<Integer> list){
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i =0; i<t;i++){
			newList.add(list.get(i));
		}
		
		return newList;
		
	}
}
