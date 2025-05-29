
public class triplet {
	int judgea;
	int judgeb;
	int judgec;
	String status;
	//0 invalid
	//1 not surprising
	//2 surprising
	
	public triplet(int a, int b, int c){
		int minab, maxab;
		minab = Math.min(a, b);
		maxab = Math.max(a, b);
		
		//Reorganize judgea to have min
		
		judgea = Math.min(minab, c);
		judgeb = Math.min(maxab, c);
		judgec = Math.max(maxab, c);
		
		if(judgea < 0 || judgec > 10){
			status = "invalid";
		}
		else{
			if(judgec - judgea==2){
				status = "surprising";
			}
			else if((judgec - judgea)==1 || (judgec - judgea)==0){
				status = "not surprising";
			}
			else{
				status = "invalid";
			}
		}
	}
	public int score(){
		return Math.max(Math.max(judgea,judgeb),judgec);
	}
	public String toString(){
		if(status.matches("invalid")){
			return "invalid";
		}
		return "(" + judgea+ "," + judgeb + "," + judgec +")";
	}
	
	
	
}
