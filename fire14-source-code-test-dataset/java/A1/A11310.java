import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class dancing {
	
	public static int maxScore(int a){
		if(a==0) return 0;
		return ((a%3)==0)?(a/3)+1:(a%3)+a/3;
	}
	
	public static int maxScoreSanSurprise(int a){
		return (a/3)+Math.min(1, a%3);
	}
	
	public static int solveOne(Scanner scan){
		int n = scan.nextInt();
		int s = scan.nextInt();
		int p = scan.nextInt();
		int nbok =0;
		LinkedList<Integer> possible = new LinkedList<Integer>();
		for(int i=0; i<n; i++){
			int tmp = scan.nextInt();
			if(maxScoreSanSurprise(tmp)>=p){
			//	System.out.println("sans surprise"+tmp);
				nbok++;
			}
			else if(maxScore(tmp)>= p){
				//System.out.println("avec surprise"+tmp);
				possible.add(tmp);
			}
			else{
				//System.out.println("impossible"+tmp+" "+maxScore(tmp)+" "+maxScoreSanSurprise(tmp));
			}
		}
		return nbok+Math.min(s, possible.size());
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new File("input.txt"));
		int nbcas = s.nextInt();
		for(int i=0; i<nbcas; i++){
			System.out.println("Case #"+(i+1)+": "+solveOne(s));
		}
	}
}
