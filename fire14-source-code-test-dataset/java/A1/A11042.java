package fixjava;

/** Adapted from http://www.johndcook.com/standard_deviation.html */
public class RunningStats {

	int n = 0;
	double oldM, newM, oldS, newS, min, max;

	public void clear() {
		n = 0;
	}

	public void add(double x) {
		n++;

		// See Knuth TAOCP vol 2, 3rd edition, page 232
		if (n == 1) {
			oldM = newM = min = max = x;
			oldS = 0.0;
		} else {
			newM = oldM + (x - oldM) / n;
			newS = oldS + (x - oldM) * (x - newM);
			min = Math.min(min, x);
			max = Math.max(max, x);
			
			// set up for next iteration
			oldM = newM;
			oldS = newS;
		}
	}

	public int numValues() {
		return n;
	}

	public double mean() {
		return (n > 0) ? newM : 0.0;
	}

	public double variance() {
		return ((n > 1) ? newS / (n - 1) : 0.0);
	}

	public double stdDev() {
		return Math.sqrt(variance());
	}
	
	public double min() {
		return (n > 0) ? min : 0.0;
	}
	
	public double max() {
		return (n > 0) ? max : 0.0;
	}
}
