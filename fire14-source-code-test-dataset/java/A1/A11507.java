package DancingWithGooglers;

public class Googler implements Comparable {

	/**
	 * @param args
	 */
	private int base;
	private int remainder;
	private int max;
	private int total;
	private boolean mayBeSurprising;
	
	public Googler(int score){
		total = score;
		remainder = score %3 ;
		base = (score - remainder) /3;
		
	}
	
	
	public int getTotal(){
		return total;
	}
	
	public int getMax(boolean canbeSur){
		if(canbeSur){
			if(remainder <= 1){
				if(base !=0){
					return base + 1;
				}
				else{
					return base;
				}
			}
			else{
				return base + 2;
			}
		}
		else{
			if(remainder <= 1){
				return base + remainder;
			}
			else{
				return base+1;
			}
			
		}
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int otherTotal = ((Googler)o).getTotal();
		if(total < otherTotal){
			return -1;
		}
		else if (total == otherTotal){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
