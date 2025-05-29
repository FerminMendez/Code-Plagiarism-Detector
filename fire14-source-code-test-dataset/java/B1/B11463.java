
public class RecycleNumber {
	
	int count=0;
	public RecycleNumber(int A,int B){
		for(int n=A;n<B-1;n++){
			for(int m=n+1;m<=B;m++){
				if(isRecycledPair(n,m)){
					count++;
				}
			}
		}
	}
	
	public int getCount() {
		return count;
	}


	boolean isRecycledPair(int a,int b){
		String sA=a+"";
		String sB=b+"";
		//start from 
		int countB=sB.length();
		int countA=sA.length();
		if(countA!=countB)return false;
		for(int i=0;i<sA.length();i++){
			if(sA.charAt(i)==sB.charAt(0)){
				if(sA.charAt(i)=='0') continue;
				if(compare(sA,i,sB))
					return true;
			}
		}

		return false;
	}
	private boolean compare(String sA, int i, String sB) {
		// TODO Auto-generated method stub
		int count=0;
		int length=sB.length();
		for(int j=i,k=0;count<length;k++,count++,j=(j+1)%length){
			if(sA.charAt(j)!=sB.charAt(k)){
				return false;
			}
		}
		return true;
	}

}
