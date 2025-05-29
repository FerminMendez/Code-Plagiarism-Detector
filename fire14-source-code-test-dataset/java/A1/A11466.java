
public class Triplet implements Comparable<Triplet> {
	
	private int s1;
	private int s2;
	private int s3;
	
	public Triplet(int _s1,int _s2,int _s3){
		s1=_s1;
		s2=_s2;
		s3=_s3;
	}
	
	@Override
	public int compareTo(Triplet o) {
		return new Integer(o.getMax()).compareTo(this.getMax());
	}
	
	public boolean isSurprising(){
		if(Math.abs(s1-s2)==2 || Math.abs(s1-s3)==2 || Math.abs(s2-s3)==2) return true;
		return false;
	}
	
	public int getMax(){
		if(s1>s2 && s1>s3) return s1;
		else if (s2>s3) return s2;
		else return s3;
	}
	
	public void setS1(int s1) {
		this.s1 = s1;
	}
	public int getS1() {
		return s1;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}
	public int getS2() {
		return s2;
	}
	public void setS3(int s3) {
		this.s3 = s3;
	}
	public int getS3() {
		return s3;
	}
	
	

}
