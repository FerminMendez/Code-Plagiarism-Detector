
public class ValuePairs {

	int value1;
	int value2;
	
	public ValuePairs(int a,int b){
		value1 = a;
		value2 = b;
	}
	
	@Override
	public boolean equals(Object vp){
		
		if(!(vp instanceof ValuePairs))
			return false;
		
		return value1 == ((ValuePairs)vp).value1 && value2 == ((ValuePairs)vp).value2;
	}

	@Override
	public int hashCode(){
		
		return Integer.parseInt(""+value1+value2);
		
	}
}
