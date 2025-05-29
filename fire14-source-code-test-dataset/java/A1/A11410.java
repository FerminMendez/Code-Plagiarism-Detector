
public class Goggledance {
	private boolean isSurprising=false;
	private boolean isCandidate=false;
	int total,p;
	public Goggledance(int total,int p){
		this.total=total;
		this.p=p;
		determinesurprising();
	}
	private void determinesurprising() {
		// TODO Auto-generated method stub
		if(total/3>=p){
			isSurprising=false;
			isCandidate=true;
			return;
		}	
		int left=total-p;
		if(left<0){
			isSurprising=false;
			isCandidate=false;
			return;
		}
		int left1=left/2;
		int left2=left-left1;
        
		if(p-left1<=1 && p-left2<=1){
			isSurprising=false;
			isCandidate=true;
			return;			
		}
		if(p-left1<=2 && p-left2<=2){
			isSurprising=true;
			isCandidate=true;
			return;
		}

		isSurprising=false;
		isCandidate=false;
	}
	public boolean isSurprising() {
		return isSurprising;
	}

	public boolean isCandidate() {
		return isCandidate;
	}
	
	
}
