package MyAllgoritmicLib;

public class CodeGray {
	
	public static int grayEncode (int n) {
		return n ^ (n >> 1);
	}
	
	public static int grayDecode (int g) {
		int n = 0;
		for (; g > 0; g>>=1)
			n ^= g;
		return n;
	}
}
