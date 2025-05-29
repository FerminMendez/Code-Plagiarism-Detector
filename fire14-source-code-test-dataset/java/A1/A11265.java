import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.*;

public class Dancing{
	static int bestScore(int s){
		int[] arr = {10, 10, 10};
		int idx = 0;
		for(int sum = 30; sum!=s; sum--, idx++){
			arr[idx%3]--;
		}
		return arr[2];
	}
	static int bestSurprisingScore(int s){
		int S = s-2;
		int a, b = 0;
		for(a=8; a>=0 ; a--){
			b = S-2*a;
			if(b>=a && b<=(a+2)){
				break;
			}
		}
		if(b<a || b>(a+2)){
			return -1;
		}
		return a+2;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int xx = Integer.parseInt(br.readLine());
		for(int yy=0; yy<xx; yy++){
			String[] ss = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ss[0]);
			int s = Integer.parseInt(ss[1]);
			int p = Integer.parseInt(ss[2]);
			int[] score = new int[n];
			for(int i=0; i<n; i++){
				score[i] = Integer.parseInt(ss[i+3]);
			}
			ArrayList<Googler> arr = new ArrayList<Googler>();
			for(int i=0; i<n; i++){
				arr.add(new Googler(bestScore(score[i]), bestSurprisingScore(score[i])));
			}
			// out.printf("p = %d\n", p);
			// out.printf("s = %d\n", s);
			// for(Googler g : arr){
				// out.println(g);
			// }
			int nbest = 0, nsbest = 0;
			for(int i=0; i<n; i++){
				if(arr.get(i).best>=p){
					nbest++;
				}else if(arr.get(i).sbest>=p){
					nsbest++;
				}
			}
			if(nsbest<=s){
				out.printf("Case #%d: %d\n", yy+1, nbest+nsbest);
			}else{
				out.printf("Case #%d: %d\n", yy+1, nbest+s);
			}
		}
	}
	static class Googler{
		int best;
		int sbest;
		Googler(int best, int sbest){
			this.best = best;
			this.sbest = sbest;
		}
		public String toString(){
			return String.format("Best: %d SBest: %d", best, sbest);
		}
	}
}