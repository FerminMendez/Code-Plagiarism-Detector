
public class possible {
	
	int Anom;
	int High;
	int count = 0;
	
	possible(int anom, int high){
		Anom = anom;
		High = high;
		
	}
	
	
	public void canDo(int score){
		int Score = score;
		if(High > 0 && Score - High - (2 * (High- 1 )) >= 0){
			++count;
		}else if( Anom > 0 && High > 1 && Score - High - (2 * (High- 2 )) >= 0 ){
			++count;
			--Anom;
		}else if( High == 0){
			++count;
		}
		
	}
	
	
	
	
	

}
