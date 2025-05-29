import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Round {
	private int num;
	private int strange;
	private int max;
	private List<Integer> dancers;
	private int best;
	
	public Round(Scanner data){
		best = 0;
		dancers = new ArrayList<Integer>();
		num = data.nextInt();
		strange = data.nextInt();
		max = data.nextInt();
		for(int i = 0; i < num; i++){
			dancers.add(data.nextInt());
		}
	}
	
	public int calculate(){
		for(int dancer: dancers){
			if(max * 3 <= dancer){
				best++;
			}else if(dancer >= max){
				int score1 = max;
				int temp = dancer - max;
				int score2 = temp / 2;
				if(score1 - score2 == 1){
					best++;
				}else if(score1 - score2 == 2 && strange > 0){
					best++;
					strange--;
				}
			}
		}
		return best;
	}
}
