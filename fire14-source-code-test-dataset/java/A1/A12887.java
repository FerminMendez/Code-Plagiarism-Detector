package second;

import java.util.ArrayList;
import java.util.Iterator;

public class GooglerResult implements Iterable<Triples>{
	private int id;
	private int sum;
	private ArrayList<Triples> possibleTriples;

	public GooglerResult(int id, int sum) {
		super();
		this.id = id;
		this.sum = sum;
		
		initPossiblesTriples();
	}


	private void initPossiblesTriples() {
		possibleTriples=new ArrayList<Triples>(1000);
		
		for(int i=0;i<=10;i++)
			for(int j=0;j<=10;j++)
				for(int k=0;k<=10;k++){
					if(i+j+k==sum){
						if(Math.abs(i-j)<=2 && Math.abs(k-j)<=2 && Math.abs(i-k)<=2)
						possibleTriples.add(new Triples(i, j, k));
					}
				}
		
	}




	@Override
	public Iterator<Triples> iterator() {
		return possibleTriples.iterator();
	}
	public ArrayList<Triples> getPossibleTriples() {
		return possibleTriples;
	}





}
