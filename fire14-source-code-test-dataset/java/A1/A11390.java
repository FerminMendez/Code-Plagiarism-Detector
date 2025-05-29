
public class Googler implements Comparable<Googler> {
	int score1;
	int score2;
	int score3;
	int total;
	int id;
	int modulus;
	int added;
	
	public Googler(int id,int totalArg){
		this.id = id;
		total = totalArg;
		score1=score2=score3=total/3;
		modulus = total%3;
		if(modulus>0){
			score1++;
			modulus--;
		}
		if(modulus>0){
			score2++;
			modulus--;
		}
		added =0;
	}
	
	public boolean passes(int base){
		if(score1 >= base || score2 >= base || score3 >= base)
			return true;
		return false;
	}

	public void modify(){
		if(total>1 ){
			if(score1 == score2){
				score1++;
				score2--;
				added=1;
			}
		}
	}
	@Override
	public int compareTo(Googler arg0) {
		if(this.score1<arg0.score1){
			return 1;
		}else if(this.score1==arg0.score1){
			return 0;
		}else
			return -1;
	}
	
	public String toString(){
		return "id "+id +" scores " +score1 + " "+ score2 + " " + score3 +" total "+total+"\n"; 
		
	}
	
	public boolean checkState(){
		if(score1-score2>2){
			return false;
		}
		
		if(score1-score3>2){
			return false;
			
		}
		if(score2-score3>2){
			return false;
		}
		return true;
	}
}
