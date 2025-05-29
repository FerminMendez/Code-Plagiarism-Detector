import java.util.ArrayList;


public class Googler {
	
	private String total;
	private ArrayList<Triplet> triplets;
	
	public Googler(String _total,ArrayList<Triplet> _triplets){
		total=_total;
		triplets = _triplets;
	}
	
	public void setTriplets(ArrayList<Triplet> triplets) {
		this.triplets = triplets;
	}
	public ArrayList<Triplet> getTriplets() {
		return triplets;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal() {
		return total;
	}
	

}
