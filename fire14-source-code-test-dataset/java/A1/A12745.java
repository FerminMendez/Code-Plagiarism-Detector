import java.util.List;
import java.util.Map;


public class Dwtg {
	List<List<List<String>>> input;
	
	public Dwtg(List<List<List<String>>> input){
		this.input = input;
	}
	
	public void solve(){
		int googlers;
		int surprise;
		int p;
		int res;
		
		int scoreOk;
		int nbOk;
		int potentialSurp;
		int nbSurp;
		for(int i = 0; i < input.size(); i++){
			googlers = Integer.parseInt(input.get(i).get(0).get(0));
			surprise = Integer.parseInt(input.get(i).get(0).get(1));
			p = Integer.parseInt(input.get(i).get(0).get(2));
			res = 0;
			scoreOk = p*3;
			
			nbOk = 0;
			potentialSurp = 0;
			nbSurp = 0;
			if(p == 0){
				System.out.println("Case #" + (i+1) + ": " + googlers);
			}
			else{
				for(int x = 3; x < googlers + 3; x++){
					int score = Integer.parseInt(input.get(i).get(0).get(x));
					if( (score > 0) && (score >= (scoreOk - 2)) ){
						nbOk++;
					}
					else if( (score > 0) && (score >= (scoreOk - 4)) ){
						potentialSurp++;
					}
				}
				nbSurp = Math.min(potentialSurp, surprise);
				res = nbOk + nbSurp;
				System.out.println("Case #" + (i+1) + ": " + res);
			}
		}
	}
}
