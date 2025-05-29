
public class GooglersDance {
	
	boolean surprising = true;
	
	public int maxDancers(int n, int s,int p, int[] t) {
		
		int len = t.length;
		int winners = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(checkWinner(p,t[i],!surprising)) {
				
				winners++;
				continue;
				
			}
			if(s > 0 && checkWinner(p,t[i],surprising)) {
				
				winners++;
				s--;
				
			}
			
		}
		
		return winners;
		
	}

	private boolean checkWinner(int p, int t, boolean surprisingWanted) {
		
		if(!surprisingWanted) {
		
			if(((t-1) % 3) == 0) {
				
				int a = (t-1)/3;
				if(a >= 0 && a+1 >= p) {
					
					return true;
					
				}
				else {
					
					return false;
					
				}
				
			}
			else if(((t-2) % 3) == 0) {
				
				int a = (t-2)/3;
				if(a >= 0 && a+1 >= p) {
					
					return true;
					
				}
				else {
					
					return false;
					
				}
				
			}
			else {
				
				int a = t/3;
				if(a >= p) {
					
					return true;
					
				}
				else {
					
					return false;
					
				}
				
			}
			
		}
		else {
			
			int a = 0;
			switch(t % 3) {
			
			case 0 : 
				a = t/3 - 1;
				break;
			case 1 : 
				a = (t-4)/3;
				break;
			case 2 : 
				a = (t-2)/3;
				break;
			
			}
			if(a >= 0 && a+2 >= p) {
				
				return true;
				
			}
			else {
				
				return false;
				
			}
			
		}
		
		
	}

}
