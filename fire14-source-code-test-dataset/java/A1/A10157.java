
public class Triplet {
    
    private int fFirst;
    private int fSecond;
    private int fThird;
    
    public Triplet( int aFirst, int aSecond, int aThird ) {
	fFirst = aFirst;
	fSecond = aSecond;
	fThird = aThird;
    }
    
    public boolean isSurprising() {
	if( Math.abs( fFirst - fSecond ) >= 2 ) {
	    return true;
	}
	if( Math.abs( fFirst - fThird ) >= 2 ) {
	    return true;
	}
	if( Math.abs( fSecond - fThird ) >= 2 ) {
	    return true;
	}
	return false;	
    }
    
    public int getBestResult() {
	return Math.max( Math.max( fFirst, fSecond), fThird );
    }
    

}
