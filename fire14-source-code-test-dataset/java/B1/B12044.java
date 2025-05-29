package RecycledNumbers;

public class Pair {
		int low;
		int high;
		
		public Pair(int low, int high) {
			this.low =low;
			this.high=high;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair))
				return false;
			Pair other = (Pair)o;
			return ((low == other.getLow() && high == other.getHigh()) ||
					(low == other.getHigh() && high == other.getLow()));
		}
		
		@Override
		public int hashCode() {
			return 31 * low + high;
		}

		public int getLow() {
			return low;
		}

		public int getHigh() {
			return high;
		}
		
		

}
