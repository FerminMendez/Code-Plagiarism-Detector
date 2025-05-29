	public class MyPair 
	{
		public MyPair(String str) {
			
			lowerLimit = Integer.parseInt(str.split(" ")[0]);
			higherLimit = Integer.parseInt(str.split(" ")[1]);
		}
		
		public MyPair(int str, int str2) {
			
			lowerLimit = str;
			higherLimit = str2;
		}
		
		public boolean sameAs(MyPair other) {
			if ((other.lowerLimit == lowerLimit && other.higherLimit == higherLimit )||
				(other.lowerLimit == higherLimit && other.higherLimit == lowerLimit ) ) {
				return true;
			}
			return false;

		}
		public int lowerLimit;
		public int higherLimit;
	}