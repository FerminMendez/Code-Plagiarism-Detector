import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dan {
	
	static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		sc=new Scanner(new File("input.txt"));
		int num_of_cases=sc.nextInt();
		int num_of_googlers;
		int num_of_surp_tup;
		int max_best_eval;
		int []scores;
		for (int i = 1; i <= num_of_cases; i++) {
			num_of_googlers=sc.nextInt();
			num_of_surp_tup=sc.nextInt();
			max_best_eval=sc.nextInt();
			scores=new int[num_of_googlers];
			for (int k = 0; k < scores.length; k++) {
				scores[k]=sc.nextInt();
			}
			compute(scores,num_of_googlers,num_of_surp_tup,max_best_eval,i);
		}
	}
	static void compute(int[] scores, int num_of_googlers,
			int num_of_surp_tup, int max_best_eval, int case_num) {
		int winners=0;
		for (int i = 0; i < scores.length; i++) {
			if((scores[i] >= max_best_eval*3-2)){//&&(max_best_eval*3-2 >0)){
				winners++;
			}
			else if(num_of_surp_tup>0){
				if((scores[i] >= max_best_eval*3-4)&&(max_best_eval!=1)){//(scores[i] > 0)){
					num_of_surp_tup--;
					winners++;
				}
			}
		}
		System.out.println("Case #"+case_num+": "+winners);
	}

}
