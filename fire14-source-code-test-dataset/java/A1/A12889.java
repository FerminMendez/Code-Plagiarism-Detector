package second;

public class Triples {
	private int [] values;
	private int surprise=-1;
	private boolean Boolsurprise;
	int maxValue=-1;

	
	public Triples (int a,int b ,int c){
		values=new int [3];
		values[0]=a;
		values[1]=b;
		values[2]=c;
	}
	public int sum(){
		return values[0]+values[1]+values[2];
	}
	
	public boolean isSurprise(){
		if(surprise==-1)
			calculateSurprise();
		return Boolsurprise;
	}
	private void calculateSurprise() {
		surprise=1;
		if(Math.abs(values[0]-values[1])>=2)
			Boolsurprise=true;
		if(Math.abs(values[0]-values[2])>=2)
			Boolsurprise=true;
		if(Math.abs(values[1]-values[2])>=2)
			Boolsurprise=true;
		
	}
	public int getMaxValue() {
		if(maxValue>0)
			return maxValue;
		int max=values[0];
		for(int i=1;i<values.length;i++)
			if(values[i]>max)
				max=values[i];
		maxValue=max;
		return maxValue;
	}
	@Override
	public String toString() {
		String s="";
		for(int i=0;i<values.length;i++)
			s+=values[i]+" ";
		if(isSurprise())
			s+="(*)";
		return s;
			
	}
}
