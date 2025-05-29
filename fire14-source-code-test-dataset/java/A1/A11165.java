package codezam.util;

import java.math.BigDecimal;

public class MathUtil {
	
	public static BigDecimal pow(int a, int b) {
		BigDecimal result = new BigDecimal(a);
		
		BigDecimal number = new BigDecimal(a);
		
		if (b==0) {
			result = new BigDecimal(1);
			
		} else {
			for (int i=1; i<b; i++) {
				result = result.multiply(number);
			}
		}
		
		return result;
	}
	

	
	public static final void main (String[] args) {
		
		MathUtil mathUtil = new MathUtil();
		System.out.println(mathUtil.pow(3, 3));
		
	}
	
}
